package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.Mutual;
import sun.rmi.transport.Target;

import java.util.List;

public interface TargetService {
    Target post(Target target);//发布打卡目标
    List<Target> check(int clock_in_target_id);//查看打卡目标
    void delete(int clock_in_target_id);//删除打卡目标
}
