package cn.edu.jxnu.rj.service.Impl;

import cn.edu.jxnu.rj.dao.MessageDao;
import cn.edu.jxnu.rj.dao.impl.MessageDaoImpl;
import cn.edu.jxnu.rj.domain.Message;
import cn.edu.jxnu.rj.service.MessageService2;

import java.util.List;

public class MessageServiceImpl2 implements MessageService2 {
    MessageDao messageDao = new MessageDaoImpl();
    @Override
    public void addMessage(Message message) {
        messageDao.insert(message);
    }

    @Override
    public List<Message> query(int userId, int messageType) {
        return messageDao.select(userId, messageType);
    }


}
