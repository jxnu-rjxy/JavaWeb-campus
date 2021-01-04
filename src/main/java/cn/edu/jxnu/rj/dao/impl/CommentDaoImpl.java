package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.CommentDao;
import cn.edu.jxnu.rj.domain.Comment;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl implements CommentDao {
    @Override
    public int insert(Comment comment) {
        String sql = "insert into db_campus_comment(work_id,work_type,user_id,comment_content) values(?,?,?,?);";
        Jdbc jdbc = new Jdbc();
        int commentId = jdbc.executeUpdate(sql, comment.getWork_id(), comment.getWork_type(), comment.getUser_id(), comment.getComment_content());
        String commentsNum = null;
        if(comment.getWork_type()==0){
            //动态中的评论数加1
            commentsNum = "update db_campus_dynamic set dynamic_likes = dynamic_likes - 1 where dynamic_id = ?";
        }else if(comment.getWork_type()==1){
            commentsNum = "update db_campus_comment set comment_likes = comment_likes - 1 where comment_id = ?";
        }
        Jdbc jdbc1 = new Jdbc();
        jdbc1.executeUpdate(commentsNum,comment.getWork_id());
        return commentId;
    }

    @Override
    public List<Comment> findByWorkId(int work_type,int workId) {
        String sql = "select * from db_campus_comment where work_type = ? and work_id = ?";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql,work_type,workId);
        List<Comment> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                int commentId = resultSet.getInt("comment_id");
                int workType = resultSet.getInt("work_type");
                int userId = resultSet.getInt("user_id");
                String commentContent = resultSet.getString("comment_content");
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
                int commentLikes = resultSet.getInt("comment_likes");
                Comment comment = new Comment(commentId,workId,workType,userId,commentContent,gmt_create,gmt_modified,commentLikes);
                list.add(comment);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Comment findById(int findCommentId) {
        String sql = "select * from db_campus_comment where comment_id=?";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql, findCommentId);
        try {
            while (resultSet.next()){
                int commentId = resultSet.getInt("comment_id");
                int workId = resultSet.getInt("work_id");
                int workType = resultSet.getInt("work_type");
                int userId = resultSet.getInt("user_id");
                String commentContent = resultSet.getString("comment_content");
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                System.out.println(resultSet.getTimestamp("gmt_create"));
                System.out.println(gmt_create);
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
                int commentLikes = resultSet.getInt("comment_likes");
                Comment comment = new Comment(commentId,workId,workType,userId,commentContent,gmt_create,gmt_modified,commentLikes);
                return comment;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Comment comment) {
        String sql = "delete from db_campus_comment where comment_id = ?";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql, comment.getComment_id());
        String commentsNum = null;
        if(comment.getWork_type()==0){
            //动态中的评论数减1
            commentsNum = "update db_campus_dynamic set dynamic_likes = dynamic_likes - 1 where dynamic_id = ?";
        }else if(comment.getWork_type()==1){
            commentsNum = "update db_campus_comment set comment_likes = comment_likes - 1 where comment_id = ?";
        }
        Jdbc jdbc1 = new Jdbc();
        jdbc1.executeUpdate(commentsNum,comment.getWork_id());
    }
}
