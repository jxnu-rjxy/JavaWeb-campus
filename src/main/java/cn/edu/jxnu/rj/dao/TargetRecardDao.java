package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Clock_in_recard;

import java.util.List;

public interface TargetRecardDao {
    List<Clock_in_recard> findbyuserid (int user_Id);//查看用户所有打卡记录
    int Insert (int user_id,int clock_in_target_id);//添加打卡记录
    int findbyid (int clock_in_target_id);//查看某条打卡记录
}
