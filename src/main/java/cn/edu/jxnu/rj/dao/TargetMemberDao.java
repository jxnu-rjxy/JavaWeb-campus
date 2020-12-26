package cn.edu.jxnu.rj.dao;

import java.util.List;
import cn.edu.jxnu.rj.domain.Clock_in_member;


public interface TargetMemberDao {
    List<Clock_in_member> findByTargetId(int clock_in_target_id);//查找所有打卡成员
    int Insert(Clock_in_member clock_in_member);//添加打卡成员
    void delete(int user_id, int clock_in_target_id);//删除打卡成员
}
