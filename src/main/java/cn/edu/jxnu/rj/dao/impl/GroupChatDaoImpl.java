package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.GroupChatDao;
import cn.edu.jxnu.rj.domain.Group_chat;
import cn.edu.jxnu.rj.domain.Mutual;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GroupChatDaoImpl implements GroupChatDao {

    @Override
    public List<Group_chat> findByMutualId(int mutualId) {
        //jdbc查询动态集合
        Jdbc jdbc = new Jdbc();
        String sql = "select * from db_campus_group_chat where mutual_id=?";
        ResultSet resultSet = jdbc.executeQuery(sql, mutualId);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Group_chat> list = new ArrayList<>();
        //处理
        try {
            while (resultSet.next()) {

                //封装对象
                int mutual_id = Integer.parseInt(resultSet.getString("mutual_id"));
                int user_id = Integer.parseInt(resultSet.getString("user_id"));
                int group_chat_id = Integer.parseInt(resultSet.getString("group_chat_id"));
                String group_chat_conent = resultSet.getString("group_chat_conent");
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
                Group_chat group_chat = new Group_chat(mutual_id, user_id, group_chat_id, group_chat_conent, gmt_create, gmt_modified);
                //将对象加入集合
                list.add(group_chat);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;


    }

    @Override
    public int InsertGroupchat(Group_chat group_chat) {
        String sql  = "insert into db_campus_group_chat(mutual_id,user_id,group_chat_conent) values(?,?,?);";
        Jdbc jdbc = new Jdbc();
        return jdbc.executeUpdate(sql,group_chat.getMutual_id(),group_chat.getUser_id(),group_chat.getGroup_chat_conent());
    }
}