package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Follow;
import cn.edu.jxnu.rj.domain.Friend;
import cn.edu.jxnu.rj.domain.User;

import java.util.List;

public interface FriendDao {
    void add(Friend friend);//关注用户
    List<Follow> getFriends(int userId);//查看某用户的好友
    List<Follow> getFollows(int userId);//查询某用户的关注
    List<Follow> getFollowers(int userId);//查看某用户的粉丝
    void delete(int friendType,int userId);//删除好友
}
