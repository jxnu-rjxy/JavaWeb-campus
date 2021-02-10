package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.FriendDao;
import cn.edu.jxnu.rj.domain.Follow;
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
        String sql = "insert into db_campus_friend(user_id1,user_id2,friend_type,is_friend) values(?,?,?,?)";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,friend.getUser_id1(),friend.getUser_id2(),friend.getFriend_type(),friend.getIs_friend());
    }

    @Override
    public List<Follow> getFriends(int userId) {
        String sql = "select * from v_friend_follow where user1 = ? ";
        return null;
    }

    @Override
    public List<Follow> getFollows(int userId) {
        return null;
    }

    @Override
    public List<Follow> getFollowers(int userId) {
        return null;
    }

    @Override
    public void delete(int friendType, int userId) {
        String sql = "delete from db_campus_friend where friend_type = ? and user_id1 = ?";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,friendType,userId);
    }
}
