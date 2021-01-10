package cn.edu.jxnu.rj.service.Impl;

import cn.edu.jxnu.rj.dao.GiveLikeDao;
import cn.edu.jxnu.rj.dao.impl.GiveLikeDaoImpl;
import cn.edu.jxnu.rj.domain.Givelike;
import cn.edu.jxnu.rj.service.GiveLikeService;

public class GiveLikeServiceImpl implements GiveLikeService {
    GiveLikeDao giveLikeDao = new GiveLikeDaoImpl();
    @Override
    public void like(Givelike like) {
        Givelike givelike = giveLikeDao.select(like.getWork_id(),like.getWork_type(),like.getUser_id());
        if(givelike==null){//如果没有点赞，则插入
            System.out.println("给评论点个赞");
            giveLikeDao.insert(like);

        }else {//如果已经点赞，则删除该条记录
            System.out.println("这条动态已经点赞了，现在取消点赞");
            giveLikeDao.delete(givelike);
        }
    }
}
