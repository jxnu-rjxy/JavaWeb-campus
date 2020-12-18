package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.Mutual;

import java.util.List;

public interface MutualService {
    Mutual post(Mutual mutual);//发起互助项目
    List<Mutual> check(int user_id);//查看互助项目
    void delete(int mutual_Id);
    List<Mutual> apply(int user_id, int mutual_id);//用户申请加入互助项目

}
