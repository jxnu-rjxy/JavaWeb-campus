package cn.edu.jxnu.rj.service.Impl;

import cn.edu.jxnu.rj.dao.CommentDao;
import cn.edu.jxnu.rj.dao.ConfessionDao;
import cn.edu.jxnu.rj.dao.GiveLikeDao;
import cn.edu.jxnu.rj.dao.impl.CommentDaoImpl;
import cn.edu.jxnu.rj.dao.impl.ConfessionDaoImpl;
import cn.edu.jxnu.rj.dao.impl.GiveLikeDaoImpl;
import cn.edu.jxnu.rj.domain.Confession;
import cn.edu.jxnu.rj.service.ConfessionService;

import java.util.List;

public class ConfessionServiceImpl implements ConfessionService {
    private ConfessionDao confessionDao = new ConfessionDaoImpl();
    @Override
    public Confession insert(Confession confession) {
        return confessionDao.insert(confession);
    }

    @Override
    public List<Confession> getAllByUser(int userId) {
        return confessionDao.getAllByUser(userId);
    }

    @Override
    public Confession findById(int ConfessionId) {
        return confessionDao.findById(ConfessionId);
    }

    @Override
    public void delete(int ConfessionId) {
        confessionDao.delete(ConfessionId);//删除单条表白
        GiveLikeDao giveLikeDao = new GiveLikeDaoImpl();
        giveLikeDao.deleteAllByWork(1,ConfessionId);//同时删除该表白下的所有点赞

        CommentDao commentDao = new CommentDaoImpl();
        commentDao.deleteAllByWork(1,ConfessionId);//同时删除该表白下的所有评论
    }
}
