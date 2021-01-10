package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Givelike;

public interface GiveLikeDao {
    void insert(Givelike givelike);
    void delete(Givelike givelike);
    void deleteAllByWork(int workType,int workId);//根据作品id删除其下的所有点赞记录
    Givelike select(int workId,int workType,int userId);//查询
    boolean isLike(int workId,int workType,int userId);//查询用户是否点赞
}
