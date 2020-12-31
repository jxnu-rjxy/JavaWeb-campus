package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.Clock_in_invite;
import cn.edu.jxnu.rj.domain.Clock_in_member;
import cn.edu.jxnu.rj.domain.Clock_in_recard;
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

    List<Clock_in_recard> checkTargetrecard (int user_id);//查看用户所有打卡记录
    int insertrecard(int user_id,int clock_in_target_id);//添加打卡记录

    List<Clock_in_invite> checkTargetInvite (int clock_in_target_id);//查看邀请记录
    int insertinvite(Clock_in_invite clock_in_invite);//邀请
}
