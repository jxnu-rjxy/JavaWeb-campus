package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.ClockInTargetDao;
import cn.edu.jxnu.rj.domain.Clock_in_target;
import cn.edu.jxnu.rj.util.Jdbc;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ClockInTargetImpl implements ClockInTargetDao {

    @Override
    public List<Clock_in_target> findByUserId(int userId) {
        String sql = "select * from db_campus_clock_in_target where user_id=? order by gmt_create desc";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql, userId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Clock_in_target> list = new ArrayList<>();
        //处理
        try {
            while (resultSet.next()) {

                //封装对象
                int clock_in_target_id = Integer.parseInt(resultSet.getString("clock_in_target_id"));
                int user_id = Integer.parseInt(resultSet.getString("user_id"));
                String clock_in_target_title = resultSet.getString("clock_in_target_title");
                String clock_in_target_content = resultSet.getString("clock_in_target_content");
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
                Clock_in_target clock_in_target = new Clock_in_target(clock_in_target_id, user_id, clock_in_target_title, clock_in_target_content, gmt_create, gmt_modified);
                list.add(clock_in_target);
            }return list;
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.close();
        } return null;
    }

    @Override
    public Clock_in_target findById(int targetId) {

        String sql = "select * from db_campus_clock_in_target where clock_in_target_id = ?";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql, targetId);
        //处理
        try {
            while (resultSet.next()) {

                //封装对象
                int clock_in_target_id = Integer.parseInt(resultSet.getString("clock_in_target_id"));
                int user_id = Integer.parseInt(resultSet.getString("user_id"));
                String clock_in_target_title = resultSet.getString("clock_in_target_title");
                String clock_in_target_content = resultSet.getString("clock_in_target_content");
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
                Clock_in_target clock_in_target = new Clock_in_target(clock_in_target_id, user_id, clock_in_target_title, clock_in_target_content, gmt_create, gmt_modified);
                return clock_in_target;
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.close();
        } return null;
    }

    @Override
    public int insertClockTarget(Clock_in_target clock_in_target) {
        String sql  = "insert into db_campus_clock_in_target(user_id,clock_in_target_id,clock_in_target_title,clock_in_target_content) values(?,?,?,?);";
        Jdbc jdbc = new Jdbc();
        return jdbc.executeUpdate(sql, clock_in_target.getUser_id(), clock_in_target.getClock_in_target_id(), clock_in_target.getClock_in_target_title(),clock_in_target.getClock_in_target_content());
    }


    @Override
    public void deleteTarget(int clock_in_target_id) {
        String sql  = "delete from db_campus_clock_in_target where clock_in_target_id=?;";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,clock_in_target_id);
    }


}
