package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Dynamic;

import java.util.List;

public interface DynamicDao {
    List<Dynamic> findByUserId(int user_id);//查找某一用户的所有动态
    List<Dynamic> findAll(int num);//查看最近num条动态
    boolean isLike(int userId,int dynamicId);//查看是否点赞
    Dynamic findById(int DynamicId);//查看单条动态
    int InsertDynamic(Dynamic dynamic);//发表动态
    void deleteDynamic(int dynamic_id);//删除动态
}
