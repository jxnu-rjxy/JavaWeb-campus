package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.Reply;

import java.util.List;

public interface ReplyService {
    void reply(Reply reply);//回复
    void deleteReply(int replyId);//删除回复；
    List<Reply> getAllInComment(int commentId);
}
