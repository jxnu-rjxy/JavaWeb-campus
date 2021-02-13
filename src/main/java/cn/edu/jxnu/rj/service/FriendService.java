package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.User;

import java.util.List;

public interface FriendService {
    List<User> getFriends(String userId);//查看某用户的好友
    List<User> getFollows(String userId);//查询某用户的关注
    List<User> getFollowers(String userId);//查看某用户的粉丝
    void follow(String userId,String friendId);//用户关注好友
    void cancelFollow(String userId,String followId);//用户取消关注
    void removeFollowers(String userId,String followerId);//移除关注
    boolean isFriend(String userId,String friendId);//判断两个用户是否为好友关系
    boolean isFollow(String userId,String friendId);//判断是否关注该用户
}
