package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.CommentDao;
import cn.edu.jxnu.rj.domain.Comment;
import cn.edu.jxnu.rj.util.Jdbc;

public class CommentDaoImpl implements CommentDao {
    @Override
    public void insert(Comment comment) {
        String sql = "insert into db_campus_comment(work_id,work_type,user_id,comment_content) values(?,?,?,?);";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,comment.getWork_id(),comment.getWork_type(),comment.getUser_id(),comment.getComment_content());
    }

    @Override
    public Comment findByWorkId(String workId) {
        String sql = "select * from db_campus_comment where word_id = ?";
        Jdbc jdbc = new Jdbc();
        jdbc.executeQuery(sql,workId);
        return null;
    }
}
