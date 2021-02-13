package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Dynamic;

import java.util.List;
import java.util.Set;

public interface DynamicDao {
    List<String> getLatest(int start,int nums);//查找最新的动态id
    List<Dynamic> getByIdSet(List<String> ids);//通过id set集合获得这些id的动态信息
    List<Dynamic> findByUserId(int userId);//查找某一用户的所有动态
    List<String> getImages(int dynamicId);//查询某动态的图片
    List<Boolean> isLike(int userId,List<String> ids);//查看是否点赞
    Dynamic findById(int DynamicId,int userId);//查看单条动态
    int InsertDynamic(Dynamic dynamic);//发表动态
    void deleteDynamic(int dynamicId);//删除动态
}
