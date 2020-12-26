package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.Clock_in_member;
import cn.edu.jxnu.rj.domain.Clock_in_target;

import java.util.List;

public interface TargetService {
    int post(Clock_in_target clock_in_target);//发起打卡目标
    List<Clock_in_target> check(int user_id);//查看某一用户所有打卡目标
    void delete(int clock_in_target_id);//删除打卡目标
    Clock_in_target checkone(int clock_in_target_id);//查看某一打卡目标

    List<Clock_in_member> checkTargetmember (int clock_in_target_id);//查看打卡成员
    void deletemember(int user_Id,int clock_in_target_id);//删除打卡成员
    int insertmember(Clock_in_member clock_in_member);//添加打卡成员
}
