package cn.edu.jxnu.rj.service.Impl;

import cn.edu.jxnu.rj.dao.DynamicDao;
import cn.edu.jxnu.rj.dao.impl.DynamicDaoImpl;
import cn.edu.jxnu.rj.domain.Dynamic;
import cn.edu.jxnu.rj.domain.Mutual;
import cn.edu.jxnu.rj.service.DynamicService;
import cn.edu.jxnu.rj.service.MutualService;

import java.util.List;

public class DynamicServiceImpl implements DynamicService {
    DynamicDao dynamicDao = new DynamicDaoImpl();

    @Override
    public Dynamic post(Dynamic dynamic) {
        int id = dynamicDao.InsertDynamic(dynamic);//用户发表动态
        System.out.println("刚刚插入的记录id是"+id);
        return dynamicDao.findById(id);
    }
    @Override
    public List<Dynamic> check(int user_id) {
        return dynamicDao.findByUserId(user_id);
    }

    @Override
    public void delete(int dynamicId) {
        dynamicDao.deleteDynamic(dynamicId);
        System.out.println("删除成功！");
    }
}
