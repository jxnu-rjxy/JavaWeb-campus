package cn.edu.jxnu.rj.service.Impl;

import cn.edu.jxnu.rj.dao.ReplyDao;
import cn.edu.jxnu.rj.dao.impl.ReplyDaoImpl;
import cn.edu.jxnu.rj.domain.Reply;
import cn.edu.jxnu.rj.service.ReplyService;

public class ReplyServiceImpl implements ReplyService {
    ReplyDao replyDao = new ReplyDaoImpl();
    @Override
    public void reply(Reply reply) {
        replyDao.insert(reply);
    }
}
