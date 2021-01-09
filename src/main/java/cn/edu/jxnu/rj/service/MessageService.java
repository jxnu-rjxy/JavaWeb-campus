package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.Message;

import java.util.List;

public interface MessageService {
    List<Message>query(int message_id,int message_type);  //查询两个用户之间的信息如：关注，评论，点赞，回复
}
