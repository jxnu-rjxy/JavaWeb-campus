package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.Dynamic;

import java.util.List;

public interface DynamicService {
    Dynamic post(Dynamic dynamic);//发表
    List<Dynamic> check(int user_id);//查看文章
    List<Dynamic> checkAll(int num);//查询最近num条动态
    void delete(int dynamicId,String path);//删除动态
}
