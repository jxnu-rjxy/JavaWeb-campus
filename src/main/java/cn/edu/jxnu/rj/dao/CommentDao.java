package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Comment;

public interface CommentDao {
    void insert(Comment comment);//评论作品
    Comment findByWorkId(String workId);//通过作品id查询该作品下所有的评论
}
