package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Friend;

public interface FriendDao {
    void add(Friend friend);//添加好友
    void query(int friendType,int userId);//查看某用户的好友/关注/粉丝
    void delete(int friendType,int userId);
}
