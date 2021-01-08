package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Message;

import java.util.List;

public interface MessageDao {
        void insert(Message message);  //插入消息
        List<Message>findByMessageType(int message_id,int message_type);  //按照消息的类型查找该类型的所有消息
}
