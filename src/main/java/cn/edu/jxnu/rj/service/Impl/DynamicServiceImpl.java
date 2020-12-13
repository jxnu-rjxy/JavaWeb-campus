package cn.edu.jxnu.rj.service.Impl;

import cn.edu.jxnu.rj.dao.DynamicDao;
import cn.edu.jxnu.rj.dao.impl.DynamicDaoImpl;
import cn.edu.jxnu.rj.domain.Dynamic;
import cn.edu.jxnu.rj.service.DynamicService;

import java.util.List;

public class DynamicServiceImpl implements DynamicService {
    DynamicDao dynamicDao = new DynamicDaoImpl();

    @Override
    public void post(Dynamic dynamic) {
        dynamicDao.InsertDynamic(dynamic);//用户发表动态
    }

    @Override
    public List<Dynamic> check(int user_id) {
        return dynamicDao.findByUserId(user_id);
    }
}
