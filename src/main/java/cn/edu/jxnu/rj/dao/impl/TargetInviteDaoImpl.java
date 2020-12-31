package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.TargetInviteDao;
import cn.edu.jxnu.rj.dao.TargetRecardDao;
import cn.edu.jxnu.rj.domain.Clock_in_invite;
import cn.edu.jxnu.rj.domain.Mutual_group_recard;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TargetInviteDaoImpl implements TargetInviteDao {
    @Override
    public List<Clock_in_invite> findByInviteId(int clock_in_target_Id) {
        //jdbc查询动态集合
        Jdbc jdbc = new Jdbc();
        String sql = "select * from db_campus_clock_in_invite where clock_in_target_id=?";
        ResultSet resultSet = jdbc.executeQuery(sql, clock_in_target_Id);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Clock_in_invite> list = new ArrayList<>();
        //处理
        try {
            while(resultSet.next()){

                //封装对象
                int user_id1 = Integer.parseInt(resultSet.getString("user_id1"));
                int user_id2 = Integer.parseInt(resultSet.getString("user_id2"));
                int clock_in_target_id = Integer.parseInt(resultSet.getString("clock_in_target_id"));
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
                Clock_in_invite clock_in_invite = new Clock_in_invite(user_id1,user_id2,clock_in_target_id,gmt_create,gmt_modified);
                //将对象加入集合
                list.add(clock_in_invite);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int Insert(Clock_in_invite clock_in_invite) {
        String sql  = "insert into db_campus_clock_in_invite(user_id1,user_id2,clock_in_target_id) values(?,?,?);";
        Jdbc jdbc = new Jdbc();
        return jdbc.executeUpdate(sql,clock_in_invite.getUser_id1(),clock_in_invite.getUser_id2(),clock_in_invite.getClock_in_target_id());
    }
}
