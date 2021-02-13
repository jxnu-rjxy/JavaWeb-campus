package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.Dynamic;

import java.util.List;
import java.util.Map;

public interface DynamicService {
    Dynamic post(Dynamic dynamic);//发表动态
    List<Dynamic> getUsers(int user_id);//查看用户所有文章
    Map<String,Object> getLatest(int start, int nums,int userId);//查询最近nums条动态
    void delete(int dynamicId,String path);//删除动态
    Dynamic findById(int DynamicId,int userId);//查看单条动态
}
