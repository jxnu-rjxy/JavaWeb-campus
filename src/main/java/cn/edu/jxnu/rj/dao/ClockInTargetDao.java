package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Clock_in_target;
import cn.edu.jxnu.rj.domain.User;

public interface ClockInTargetDao {
        Clock_in_target findByTarget(int clock_in_target_id); //通过id查询打卡标题
        void insertClockTarget(Clock_in_target clock_in_target);//插入用户
}
