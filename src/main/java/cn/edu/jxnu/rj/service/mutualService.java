package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.Dynamic;
import cn.edu.jxnu.rj.domain.Mutual;

import java.util.List;

public interface MutualService {
    void post(Mutual mutual);//发起互助项目
    List<Mutual> check(int user_id);//查看文章
    List<Mutual> apply(int user_id, int mutual_id);//用户申请加入互助项目

}
