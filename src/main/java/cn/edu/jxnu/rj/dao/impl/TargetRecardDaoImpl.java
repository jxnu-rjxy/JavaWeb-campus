package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.TargetRecardDao;
import cn.edu.jxnu.rj.domain.Clock_in_recard;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TargetRecardDaoImpl implements TargetRecardDao {

    @Override
    public List<Clock_in_recard> findbyuserid(int user_Id) {
        //jdbc查询动态集合
        Jdbc jdbc = new Jdbc();
        String sql = "select * from db_campus_clock_in_recard where user_id=?";
        ResultSet resultSet = jdbc.executeQuery(sql, user_Id);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Clock_in_recard> list = new ArrayList<>();
        //处理
        try {
            while(resultSet.next()){

                //封装对象
                int clock_in_recard_id = resultSet.getInt("clock_in_recard_id");
                int clock_in_target_id = Integer.parseInt(resultSet.getString("clock_in_target_id"));
                int user_id = Integer.parseInt(resultSet.getString("user_id"));
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
                Clock_in_recard clock_in_recard = new Clock_in_recard(clock_in_recard_id,clock_in_target_id,user_id,gmt_create,gmt_modified);
                //将对象加入集合
                list.add(clock_in_recard);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int Insert(int user_id, int clock_in_target_id) {
        String sql  = "insert into db_campus_clock_in_recard(user_id,clock_in_target_id) values(?,?);";
        Jdbc jdbc = new Jdbc();
        int i =jdbc.executeUpdate(sql,user_id,clock_in_target_id);
        String addnum = "update db_campus_clock_in_member set clock_in_times = clock_in_times + 1 where clock_in_target_id = ? and user_id = ?";
        Jdbc jdbc1 = new Jdbc();
        jdbc1.executeUpdate(addnum,clock_in_target_id,user_id);
        return i;
    }


    @Override
    public int findbyid(int clock_in_target_id) {
        String sql  = "select * from db_campus_clock_in_recard where clock_in_target_id=?";
        Jdbc jdbc = new Jdbc();
        return jdbc.executeUpdate(sql,clock_in_target_id);
    }
}
