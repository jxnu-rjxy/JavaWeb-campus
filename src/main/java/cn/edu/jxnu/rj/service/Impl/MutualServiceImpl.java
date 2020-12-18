package cn.edu.jxnu.rj.service.Impl;

import cn.edu.jxnu.rj.dao.MutualDao;
import cn.edu.jxnu.rj.dao.impl.MutualDaoImpl;
import cn.edu.jxnu.rj.domain.Mutual;
import cn.edu.jxnu.rj.service.MutualService;

import java.util.List;

public class MutualServiceImpl implements MutualService {
    MutualDao mutualDao = new MutualDaoImpl();
    @Override
    public Mutual post(Mutual mutual) {
        int id = mutualDao.InsertMutual(mutual);
        System.out.println("刚刚插入的记录id是"+id);
        return  mutualDao.findById(id);
    }

    @Override
    public List<Mutual> check(int user_id) {
        return mutualDao.findByUserId(user_id);
    }

    @Override
    public void delete(int mutual_Id) {
        mutualDao.deleteMutual(mutual_Id);
        System.out.println("删除成功！");
    }

    @Override
    public List<Mutual> apply(int user_id, int mutual_id) {
        return null;
    }
}
