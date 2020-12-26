package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Clock_in_target;

import java.util.List;


public interface ClockInTargetDao {
        List<Clock_in_target> findByUserId(int user_id);//查找某一用户的所有打卡目标;
        Clock_in_target findById(int clock_in_target_id);//查看某一打卡目标
        int insertClockTarget(Clock_in_target clock_in_target);//发布打卡目标
        void deleteTarget(int clock_in_target_id);//删除打卡目标


}
