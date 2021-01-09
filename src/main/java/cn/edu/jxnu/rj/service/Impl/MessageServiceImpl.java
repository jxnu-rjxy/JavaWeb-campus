package cn.edu.jxnu.rj.service.impl;

import cn.edu.jxnu.rj.dao.MessageDao;
import cn.edu.jxnu.rj.dao.impl.MessageDaoImpl;
import cn.edu.jxnu.rj.domain.Message;
import cn.edu.jxnu.rj.service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    MessageDao messageDao=new MessageDaoImpl();
    @Override
    public List<Message> query(int message_id, int message_type) {
        List<Message> messages= messageDao.findByMessageType(message_id,message_type);
        return messages;
    }
}
