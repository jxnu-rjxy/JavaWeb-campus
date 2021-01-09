package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Message;

import java.util.List;

public interface MessageDao {
        void insert(Message message);  //插入消息
        List<Message>findByMessageType(int message_id,int message_type);  //查找两个用户之间的的关系关注，回复点赞，评论，回复
}
