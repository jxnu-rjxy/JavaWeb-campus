package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.ReplyDao;
import cn.edu.jxnu.rj.domain.Reply;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReplyDaoImpl implements ReplyDao {
    @Override
    public Reply insert(Reply reply) {
        String sql = "insert into db_campus_reply(comment_id,reply_content,user_id1,user_id2,user_name1,user_name2) values(?,?,?,?,?,?)";
        Jdbc jdbc = new Jdbc();
        int i = jdbc.executeUpdate(sql, reply.getCommentId(),reply.getReplyContent(),reply.getUserId1(),reply.getUserId2(),reply.getUserName1(),reply.getUserName2());
        return null;
    }

    @Override
    public List<Reply> getAllByCommentId(int commentId) {
        String sql = "select * from db_campus_reply where comment_id = ?";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql, commentId);
        List<Reply> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                int replyId2 = resultSet.getInt("reply_id");
                int commentId1 = resultSet.getInt("comment_id");
                String commentContent = resultSet.getString("reply_content");
                int userId1 = resultSet.getInt("user_id1");
                int userId2 = resultSet.getInt("user_id2");
                Timestamp gmtCreate = resultSet.getTimestamp("gmt_create");
                Timestamp gmtModified = resultSet.getTimestamp("gmt_modified");
                int replyLikes = resultSet.getInt("reply_likes");
                String userName1 = resultSet.getString("user_name1");
                String userName2 = resultSet.getString("user_name2");
                Reply reply = new Reply(replyId2,commentId1,commentContent,userId1,userId2,gmtCreate,gmtModified,replyLikes,userName1,userName2);
                list.add(reply);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbc.close();
        }
        return null;
    }

    @Override
    public Reply findByid(int replyId) {
        String sql = "select * from db_campus_reply where reply_id = ?";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql, replyId);
        try {
            while (resultSet.next()){
                int replyId2 = resultSet.getInt("reply_id");
                int commentId1 = resultSet.getInt("comment_id");
                String commentContent = resultSet.getString("reply_content");
                int userId1 = resultSet.getInt("user_id1");
                int userId2 = resultSet.getInt("user_id2");
                Timestamp gmtCreate = resultSet.getTimestamp("gmt_create");
                Timestamp gmtModified = resultSet.getTimestamp("gmt_modified");
                int replyLikes = resultSet.getInt("reply_likes");
                String userName1 = resultSet.getString("userName1");
                String userName2 = resultSet.getString("userName2");
                Reply reply = new Reply(replyId2,commentId1,commentContent,userId1,userId2,gmtCreate,gmtModified,replyLikes,userName1,userName2);
                return reply;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbc.close();
        }
        return null;
    }

    @Override
    public void delete(int replyId) {
        String sql = "delete from db_campus_reply where reply_id = ?";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,replyId);
    }
}
