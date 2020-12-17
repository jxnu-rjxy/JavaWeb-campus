package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.Clock_in_recard;
import cn.edu.jxnu.rj.domain.Clock_in_target;

import java.util.List;

public interface ClockInService {
    void post(Clock_in_target clock_in_target);//发起打卡目标
    List<Clock_in_target> show(int user_id);//查询用户的所有打卡目标
    void invite(int user_id1,int user_id2);//邀请用户
    void clockIn(Clock_in_recard clock_in_recard);//用户打卡
    
}
