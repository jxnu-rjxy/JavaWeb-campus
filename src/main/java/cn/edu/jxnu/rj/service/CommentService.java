package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.Comment;

import java.util.List;

public interface CommentService {
    Comment add(Comment comment);//评论
    void delete(Comment comment);//删除评论
    List<Comment> getAllByWorkId(int workType,int WorkId);//查询某作品的所有评论
}
