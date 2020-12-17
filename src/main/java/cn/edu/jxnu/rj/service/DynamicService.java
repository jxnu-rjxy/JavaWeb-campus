package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.Dynamic;

import java.util.List;

public interface DynamicService {
    void post(Dynamic dynamic);//发表
    List<Dynamic> check(int user_id);//查看文章
}
