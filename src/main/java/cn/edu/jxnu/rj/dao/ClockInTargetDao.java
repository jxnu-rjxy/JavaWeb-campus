package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Clock_in_target;

public interface ClockInTargetDao {
        Clock_in_target findById(int clock_in_target_id); //通过id查询打卡标题
}
