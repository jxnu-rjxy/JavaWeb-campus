package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.MutualMemberDao;
import cn.edu.jxnu.rj.domain.Group_member;
import cn.edu.jxnu.rj.domain.Mutual;
import cn.edu.jxnu.rj.domain.Mutual_member;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MutualMemberDaoImpl implements MutualMemberDao {
    public List<Group_member> findByUserId(int userId) {
        //jdbc查询动态集合
        Jdbc jdbc = new Jdbc();
        String sql = "select * from db_campus_mutual_member where user_id=?";
        ResultSet resultSet = jdbc.executeQuery(sql, userId);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Group_member> list = new ArrayList<>();
        //处理
        try {
            while(resultSet.next()){

                //封装对象
                int mutual_id = Integer.parseInt(resultSet.getString("mutual_id"));
                int user_id = Integer.parseInt(resultSet.getString("user_id"));
                String group_card = resultSet.getString("group_card");
                Date gmt_create = simpleDateFormat.parse(resultSet.getString("gmt_create"));
                Date gmt_modified = simpleDateFormat.parse(resultSet.getString("gmt_modified"));
               Group_member group_member = new Group_member(mutual_id,user_id,group_card,gmt_create,gmt_modified);
                //将对象加入集合
                list.add(group_member);
            }
            return list;
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Mutual findById(int mutual_id) {
        return null;
    }

    @Override
    public int Insert(Mutual_member mutual_member) {
        String sql  = "insert into db_campus_mutual_member(user_id,mutual_id,mutual_title,mutual_content) values(?,?,?);";
        Jdbc jdbc = new Jdbc();
        return jdbc.executeUpdate(sql,mutual_member.getUser_id(),mutual_member.getMutual_id(), mutual_member.getGroup_card());
    }

    @Override
    public void delete(int user_id) {
        String sql  = "delete from db_campus_mutual_member where user_id=?;";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,user_id);
    }
}
