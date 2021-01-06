package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.FriendDao;
import cn.edu.jxnu.rj.domain.Friend;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FriendDaoImpl implements FriendDao {
    @Override
    public void add(Friend friend) {
        String sql = "insert into db_campus_friend(user_id1,user_id2,friend_type,is_friend) vaules(?,?,?,?)";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,friend.getUser_id1(),friend.getUser_id2(),friend.getFriend_type(),friend.getIs_friend());
    }

    @Override
    public List<Friend> query(int friendType, int userId) {
        String sql = "select * from db_campus_friend where friend_type = ? and userId = ?";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql, friendType, userId);
        List<Friend> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                int userId1 = resultSet.getInt("user_id1");
                int userId2 = resultSet.getInt("user_id2");
                int friendType1 = resultSet.getInt("friend_type");
                int isFriend = resultSet.getInt("is_friend");
                String friendName1 = resultSet.getString("friend_name1");
                String friendName2 = resultSet.getString("friend_name2");
                Timestamp gmtCreate = resultSet.getTimestamp("gmt_create");
                Timestamp gmtModified = resultSet.getTimestamp("gmt_modified");
                Friend friend = new Friend(userId1,userId2,friendType1,isFriend,friendName1,friendName2,gmtCreate,gmtModified);
                list.add(friend);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int friendType, int userId) {
        String sql = "delete from db_campus_friend where friend_type = ? and user_id1 = ?";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,friendType,userId);
    }
}
