package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.ClockInTargetDao;
import cn.edu.jxnu.rj.domain.Clock_in_target;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class ClockInTargetImpl implements ClockInTargetDao {
    @Override
    public Clock_in_target findById(int clock_in_target_id) {
        String sql = "select * from db_campus_Clock_in_target where clock_in_target_id = ?";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql, clock_in_target_id);

            try {
                if (resultSet.next()) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    SimpleDateFormat borthdayDate = new SimpleDateFormat("yyyy-MM-dd");
                    int targetId = Integer.parseInt(resultSet.getString("clock_in_target_id"));
                    String clock_in_target_title = resultSet.getString("clock_in_target_title");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }
}
