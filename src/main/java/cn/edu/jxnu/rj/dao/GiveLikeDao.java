package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Givelike;

public interface GiveLikeDao {
    void insert(Givelike givelike);
    void delete(int giveLikeId);
    Givelike select(int workId,int workType,int userId);
}
