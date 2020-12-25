package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Clock_in_target;
import cn.edu.jxnu.rj.domain.User;

public interface ClockInTargetDao {
        Clock_in_target findByTarget(int clock_in_target_id); //通过id查询打卡标题
        void insertClockTarget(Clock_in_target clock_in_target);//发布打卡目标
        void deleteTarget(int clock_in_target_id);//删除打卡目标
}
