package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.Mutual;

public interface mutualService {
    void post(Mutual mutual);//发起互助项目
    void apply(int user_id,int mutual_id);//用户申请加入互助项目

}
