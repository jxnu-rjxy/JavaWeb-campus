package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Clock_in_invite;
import cn.edu.jxnu.rj.domain.Mutual_member;

import java.util.List;

public interface TargetInviteDao {
    List<Clock_in_invite> findByInviteId(int clock_in_target_Id);//查找邀请记录
    int Insert (Clock_in_invite clock_in_invite);//邀请
}
