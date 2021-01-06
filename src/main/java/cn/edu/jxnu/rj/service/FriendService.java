package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.Friend;

import java.util.List;

public interface FriendService {
    void add(Friend friend);//添加好友
    List<Friend> query(int friendType, int userId);//查看某用户的好友/关注/粉丝
    void delete(int friendType,int userId);//删除好友
}
