package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Comment;

import java.util.List;

public interface CommentDao {
    int insert(Comment comment);//插入评论
    List<Comment> findByWorkId(int workType,int workId);//通过作品id查询该作品下所有的评论
    Comment findById(int commentId);//根据id查询具体一个评论
    void delete(Comment comment);//删除评论
}
