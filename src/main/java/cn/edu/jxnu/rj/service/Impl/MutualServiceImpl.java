package cn.edu.jxnu.rj.service.Impl;

import cn.edu.jxnu.rj.dao.MutualDao;
import cn.edu.jxnu.rj.dao.impl.MutualDaoImpl;
import cn.edu.jxnu.rj.domain.Mutual;
import cn.edu.jxnu.rj.service.MutualService;

import java.util.List;

public class MutualServiceImpl implements MutualService {
    MutualDao mutualDao = new MutualDaoImpl();
    @Override
    public void post(Mutual mutual) {
        mutualDao.InsertMutual(mutual);//用户发布互助项目
    }

    @Override
    public List<Mutual> check(int user_id) {
        return mutualDao.findByUserId(user_id);
    }

    @Override
    public List<Mutual> apply(int user_id, int mutual_id) {
        return null;
    }
}
