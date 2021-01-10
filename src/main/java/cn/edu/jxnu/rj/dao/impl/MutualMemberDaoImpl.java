package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.MutualMemberDao;
import cn.edu.jxnu.rj.domain.Mutual_member;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MutualMemberDaoImpl implements MutualMemberDao {
    public List<Mutual_member> findByMutualId(int mutual_Id) {
        //jdbc查询动态集合
        Jdbc jdbc = new Jdbc();
        System.out.println(mutual_Id);
        String sql = "select * from db_campus_mutual_member where mutual_id=?";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ResultSet resultSet = jdbc.executeQuery(sql, mutual_Id);
        List<Mutual_member> list = new ArrayList<>();
        //处理
        try {
            while(resultSet.next()){

                //封装对象
                int mutual_id = Integer.parseInt(resultSet.getString("mutual_id"));
                int user_id = Integer.parseInt(resultSet.getString("user_id"));
                String group_card = resultSet.getString("group_card");
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
               Mutual_member mutual_member = new Mutual_member(mutual_id,user_id,group_card,gmt_create,gmt_modified);
                System.out.println(mutual_member);
                //将对象加入集合
                list.add(mutual_member);
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
    public int Insert(Mutual_member mutual_member) {
        String sql  = "insert into db_campus_mutual_member(user_id,mutual_id,group_card) values(?,?,?);";
        Jdbc jdbc = new Jdbc();
        return jdbc.executeUpdate(sql,mutual_member.getUser_id(),mutual_member.getMutual_id(), mutual_member.getGroup_card());
    }

    @Override
    public void delete(int user_id, int mutual_id) {
        String sql  = "delete from db_campus_mutual_member where user_id=? and mutual_id=?";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,user_id,mutual_id);
    }
}
