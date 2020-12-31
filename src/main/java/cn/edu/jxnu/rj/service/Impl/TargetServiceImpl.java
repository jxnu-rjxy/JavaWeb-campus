package cn.edu.jxnu.rj.service.Impl;

import cn.edu.jxnu.rj.dao.ClockInTargetDao;
import cn.edu.jxnu.rj.dao.TargetInviteDao;
import cn.edu.jxnu.rj.dao.TargetMemberDao;
import cn.edu.jxnu.rj.dao.TargetRecardDao;
import cn.edu.jxnu.rj.dao.impl.ClockInTargetImpl;
import cn.edu.jxnu.rj.dao.impl.TargetInviteDaoImpl;
import cn.edu.jxnu.rj.dao.impl.TargetMemberDaoImpl;
import cn.edu.jxnu.rj.dao.impl.TargetRecardDaoImpl;
import cn.edu.jxnu.rj.domain.Clock_in_invite;
import cn.edu.jxnu.rj.domain.Clock_in_member;
import cn.edu.jxnu.rj.domain.Clock_in_recard;
import cn.edu.jxnu.rj.domain.Clock_in_target;
import cn.edu.jxnu.rj.service.TargetService;

import java.util.List;

public class TargetServiceImpl implements TargetService {
    //打卡目标
    ClockInTargetDao clockInTargetDao = new ClockInTargetImpl();
    //发布打卡目标
    @Override
    public int post(Clock_in_target clock_in_target) {
        return clockInTargetDao.insertClockTarget(clock_in_target);
    }
    //查看某一用户所有打卡目标
    @Override
    public List<Clock_in_target> check(int user_id) {
        return clockInTargetDao.findByUserId(user_id);
    }
    //删除打卡目标
    @Override
    public void delete(int clock_in_target_id) {
        clockInTargetDao.deleteTarget(clock_in_target_id);
    }
    //查看某一打卡目标
    @Override
    public Clock_in_target checkone(int clock_in_target_id) {
        return clockInTargetDao.findById(clock_in_target_id);
    }


    //打卡成员
    TargetMemberDao targetMemberDao = new TargetMemberDaoImpl();
    @Override
    public List<Clock_in_member> checkTargetmember(int clock_in_target_id) {
        return targetMemberDao.findByTargetId(clock_in_target_id);
    }

    @Override
    public void deletemember(int user_Id, int clock_in_target_id) {
        targetMemberDao.delete(user_Id,clock_in_target_id);
    }

    @Override
    public int insertmember(Clock_in_member clock_in_member) {
        return targetMemberDao.Insert(clock_in_member);
    }

    //打卡记录
    TargetRecardDao targetRecardDao = new TargetRecardDaoImpl();
    @Override
    public List<Clock_in_recard> checkTargetrecard(int user_id) {
        return targetRecardDao.findbyuserid(user_id);
    }

    @Override
    public int insertrecard(int user_id, int clock_in_target_id) {
        return targetRecardDao.Insert(user_id,clock_in_target_id);
    }

    //邀请记录
    TargetInviteDao targetInviteDao = new TargetInviteDaoImpl();
    @Override
    public List<Clock_in_invite> checkTargetInvite(int clock_in_target_id) {
        return targetInviteDao.findByInviteId(clock_in_target_id);
    }

    @Override
    public int insertinvite(Clock_in_invite clock_in_invite) {
        return targetInviteDao.Insert(clock_in_invite);
    }


}
