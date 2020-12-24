package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Reply;

import java.util.List;

public interface ReplyDao {
    Reply insert(Reply reply);//插入回复
    List<Reply> getAllByCommentId(int commentId);//查询某条评论下的所有回复
}
