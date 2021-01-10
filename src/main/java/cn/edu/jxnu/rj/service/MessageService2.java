package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.Message;

import java.util.List;

public interface MessageService2 {
    void addMessage(Message message);   //用户之间的信息
    List<Message> query(int userId, int messageType);      //通过用户id和消息类型来查询消息
}
