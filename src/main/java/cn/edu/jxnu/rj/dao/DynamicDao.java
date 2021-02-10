package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Dynamic;

import java.util.List;

public interface DynamicDao {
    List<Dynamic> findByUserId(int userId);//查找某一用户的所有动态
    List<Dynamic> findAll(int toNum,int fromNum,int userId);//查看最近num条动态
    List<String> getImages(int dynamicId);//查询某动态的图片
    boolean isLike(int userId,int dynamicId);//查看是否点赞
    Dynamic findById(int DynamicId,int userId);//查看单条动态
    int InsertDynamic(Dynamic dynamic);//发表动态
    void deleteDynamic(int dynamicId);//删除动态
}
