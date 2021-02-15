package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.*;
import cn.edu.jxnu.rj.domain.*;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class GiveLikeDaoImpl implements GiveLikeDao{
    @Override
    public void insert(Givelike givelike) {
        MessageDao messageDao =new MessageDaoImpl();
        String sql = "insert into db_campus_giveLike(work_id,work_type,user_id) values(?,?,?);";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,givelike.getWork_id(),givelike.getWork_type(),givelike.getUser_id());
        String likesNum = null;
        if(givelike.getWork_type()==0){//如果点赞的是动态
            likesNum = "update db_campus_dynamic set dynamic_likes = dynamic_likes + 1 where dynamic_id = ?";
            DynamicDao dynamicDao = new DynamicDaoImpl();
            System.out.println("点赞作品id："+givelike.getWork_id()+givelike.getUser_id());
            Dynamic dynamic = dynamicDao.findById(givelike.getWork_id(),givelike.getUser_id());
            if(dynamic.getUserId() != givelike.getUser_id()){
                UserDao userDao = new UserDaoImpl();
                User user = userDao.findById(givelike.getUser_id());
                messageDao.insert(new Message(givelike.getUser_id(),dynamic.getUserId(),3,"",dynamic.getDynamicId(),0,user.getUserName(),dynamic.getUserName()));
            }
        }else if(givelike.getWork_type()==1){//如果点赞的是表白
            likesNum = "update db_campus_confession set confession_likes = confession_likes + 1 where confession_id = ?";
            ConfessionDao confessionDao = new ConfessionDaoImpl();
            Confession confession = confessionDao.findById(givelike.getWork_id());
            if(confession.getConfessionUserId1() != givelike.getUser_id()){

                messageDao.insert(new Message(givelike.getUser_id(),confession.getConfessionUserId1(),3,"",confession.getConfessionId(),3,"",""));
            }
        }else if(givelike.getWork_type()==2) {//如果点赞的是问题
            likesNum = "update db_campus_puzzle    set puzzle_likes = puzzle_likes + 1 where puzzle_id = ?";
        }else if(givelike.getWork_type()==3) {//如果点赞的是评论
            likesNum = "update db_campus_comment set comment_likes = comment_likes + 1 where comment_id = ?";
            CommentDao commentDao = new CommentDaoImpl();
            Comment comment = commentDao.findById(givelike.getWork_id());
            if(comment.getUserId() != givelike.getUser_id()){
                UserDao userDao = new UserDaoImpl();
                User user = userDao.findById(givelike.getUser_id());
                messageDao.insert(new Message(givelike.getUser_id(),comment.getUserId() ,3,"",comment.getCommentId() ,1,user.getUserName(),comment.getUserName()));
            }
        }else{
            likesNum = "update db_campus_reply set reply_likes = reply_likes + 1 where reply_id = ?";
            ReplyDao replyDao = new ReplyDaoImpl();
            Reply reply = replyDao.findByid(givelike.getUser_id());
            if(reply.getUserId1() != givelike.getUser_id()){
                UserDao userDao = new UserDaoImpl();
                User user = userDao.findById(givelike.getUser_id());
                messageDao.insert(new Message(givelike.getUser_id(),reply.getUserId1() ,3,"",reply.getReplyId() ,1,user.getUserName(),reply.getUserName1()));
            }
        }
        Jdbc jdbc1 = new Jdbc();
        jdbc1.executeUpdate(likesNum,givelike.getWork_id());
    }

    @Override
    public void delete(Givelike givelike) {
        String sql = "delete from db_campus_giveLike where giveLike_id = ? ";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql, givelike.getGivelike_id());
        String likesNum = null;
        if(givelike.getWork_type()==0){//如果点赞的是动态
            likesNum = "update db_campus_dynamic set dynamic_likes = dynamic_likes - 1 where dynamic_id = ?";
        }else if(givelike.getWork_type()==1){//如果点赞的是表白
            likesNum = "update db_campus_confession set confession_likes = confession_likes - 1 where confession_id = ?";
        }else if(givelike.getWork_type()==2) {//如果点赞的是问题
            likesNum = "update db_campus_puzzle    set puzzle_likes = puzzle_likes - 1 where puzzle_id = ?";
        }else if(givelike.getWork_type()==3) {//如果点赞的是评论
            likesNum = "update db_campus_comment set comment_likes = comment_likes - 1 where comment_id = ?";
        }else{
            likesNum = "update db_campus_reply set reply_likes = reply_likes - 1 where reply_id = ?";
        }
        Jdbc jdbc1 = new Jdbc();
        jdbc1.executeUpdate(likesNum,givelike.getWork_id());
    }

    @Override
    public void deleteAllByWork(int workType, int workId) {
        String sql = "delete from db_campus_giveLike where work_type = ? and  work_id = ? ";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql, workType,workId);
    }

    @Override
    public Givelike select(int workId,int workType,int userId) {
        String sql = "select * from db_campus_giveLike where user_id = ? and work_id = ? and work_type = ?";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql,userId,workId,workType);
        try {
            while (resultSet.next()){
                int likeId = resultSet.getInt("giveLike_id");
                int workId2 = resultSet.getInt("work_id");
                int workType2 = resultSet.getInt("work_type");
                int userId2 = resultSet.getInt("user_id");
                Timestamp gmtCreate = resultSet.getTimestamp("gmt_create");
                Timestamp gmtModified = resultSet.getTimestamp("gmt_modified");
                System.out.println(new Givelike(likeId,workId,workType,userId,gmtCreate,gmtModified));
                return new Givelike(likeId,workId2,workType2,userId2,gmtCreate,gmtModified);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbc.close();
        }
        return null;
    }

    @Override
    public boolean isLike(int workId, int workType, int userId) {
        String sql = "select 1 from db_campus_giveLike where user_id = ? and work_id = ? and work_type = ? limit 1";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql,userId,workId,workType);
        try {
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            jdbc.close();
        }
        return false;
    }
}
