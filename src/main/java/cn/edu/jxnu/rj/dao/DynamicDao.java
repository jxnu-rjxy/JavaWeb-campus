package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Dynamic;

import java.util.List;

public interface DynamicDao {
    List<Dynamic> findByUserId(int user_id);//查找某一用户的所有动态
    void InsertDynamic(Dynamic dynamic);//发表动态
    void deleteDynamic(int dynamic_id);//删除动态
}
