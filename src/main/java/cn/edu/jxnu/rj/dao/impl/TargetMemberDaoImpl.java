package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.TargetMemberDao;
import cn.edu.jxnu.rj.domain.Clock_in_member;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TargetMemberDaoImpl implements TargetMemberDao {
    @Override
    public List<Clock_in_member> findByTargetId(int clock_in_target_Id) {
        //jdbc查询动态集合
        Jdbc jdbc = new Jdbc();
        System.out.println(clock_in_target_Id);
        String sql = "select * from db_campus_clock_in_member where clock_in_target_id=?";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ResultSet resultSet = jdbc.executeQuery(sql, clock_in_target_Id);
        List<Clock_in_member> list = new ArrayList<>();
        //处理
        try {
            while(resultSet.next()){

                //封装对象
                int clock_in_target_id = Integer.parseInt(resultSet.getString("clock_in_target_id"));
                int user_id = Integer.parseInt(resultSet.getString("user_id"));
                int clock_in_times = Integer.parseInt(resultSet.getString("clock_in_times"));
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
                Clock_in_member clock_in_member = new Clock_in_member(clock_in_target_id,user_id,clock_in_times,gmt_create,gmt_modified);
                System.out.println(clock_in_member);
                //将对象加入集合
                list.add(clock_in_member);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.close();
        }
        return null;
    }

    @Override
    public int Insert(Clock_in_member clock_in_member) {
        String sql  = "insert into db_campus_clock_in_member(user_id,clock_in_target_id) values(?,?);";
        Jdbc jdbc = new Jdbc();
        return jdbc.executeUpdate(sql,clock_in_member.getUser_id(),clock_in_member.getClock_in_target_id());
    }

    @Override
    public void delete(int user_id, int clock_in_target_id) {
        String sql  = "delete from db_campus_clock_in_member where user_id=? and clock_in_target_id=?";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,user_id,clock_in_target_id);
    }
}
