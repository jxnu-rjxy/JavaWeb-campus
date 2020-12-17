package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.ClockInTargetDao;
import cn.edu.jxnu.rj.domain.Clock_in_target;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockInTargetImpl implements ClockInTargetDao {
    @Override
    public Clock_in_target findByTarget(int clock_in_target_id) {
        String sql = "select * from db_campus_Clock_in_target where clock_in_target_id = ?";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql, clock_in_target_id);
            //处理结果集
            try {
                if (resultSet.next()) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    SimpleDateFormat birthdayDate = new SimpleDateFormat("yyyy-MM-dd");
                    int targetId = Integer.parseInt(resultSet.getString("clock_in_target_id"));
                    String clock_in_target_title = resultSet.getString("clock_in_target_title");
                    String clock_in_target_content = resultSet.getString("clock_in_target_content");
                    Date gmt_create = simpleDateFormat.parse(resultSet.getString("gmt_create"));
                    Date gmt_modified = simpleDateFormat.parse(resultSet.getString("gmt_modified"));
                    int user_id = Integer.parseInt(resultSet.getString("user_id"));
                    //存入Clock_in_target表中
                    Clock_in_target clock_in_target = new Clock_in_target(clock_in_target_id,
                            clock_in_target_title,
                            clock_in_target_content,
                            gmt_create,
                            gmt_modified,
                            user_id);
                    return clock_in_target;
                }
            } catch (SQLException | ParseException throwables) {
                throwables.printStackTrace();
            }
        return null;
    }

    @Override
    public void insertClockTarget(Clock_in_target clock_in_target) {
        String sql = "INSERT INTO db_campus_clock_in_target(clock_in_target_id,clock_in_target_title,clock_in_target_content,user_id) VALUES(?,?,?,?)";
        Jdbc jdbc = new Jdbc();
        jdbc.execute(sql,
                clock_in_target.getClock_in_target_id(),
                clock_in_target.getClock_in_target_title(),
                clock_in_target.getClock_in_target_content(),
                clock_in_target.getUser_id()
               );
    }
}
