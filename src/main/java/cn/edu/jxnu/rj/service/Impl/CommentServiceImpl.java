package cn.edu.jxnu.rj.service.Impl;

import cn.edu.jxnu.rj.dao.CommentDao;
import cn.edu.jxnu.rj.dao.impl.CommentDaoImpl;
import cn.edu.jxnu.rj.domain.Comment;
import cn.edu.jxnu.rj.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    CommentDao commentDao = new CommentDaoImpl();
    @Override
    public Comment add(Comment comment) {
        int i = commentDao.insert(comment);
        System.out.println("评论id:"+i);
        return commentDao.findById(i);
    }

    @Override
    public void delete(int commentId) {
        commentDao.delete(commentId);
    }

    @Override
    public List<Comment> getAllByWorkId(int workType, int WorkId) {
        commentDao.findByWorkId(workType,WorkId);
        return null;
    }
}
