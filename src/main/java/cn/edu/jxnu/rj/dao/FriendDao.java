package cn.edu.jxnu.rj.dao;

import java.util.Set;

public interface FriendDao {
    Set<String> getFriends(String userId);//查看某用户的好友
    Set<String> getFollows(String userId);//查询某用户的关注
    Set<String> getFollowers(String userId);//查看某用户的粉丝
    void follow(String userId,String friendId);//用户关注好友
    void cancelFollow(String userId,String followId);//用户取消关注
    void removeFollowers(String userId,String followerId);//移除关注
    boolean isFriend(String userId,String friendId);//判断两个用户是否为好友关系
    boolean isFollow(String userId,String friendId);//判断是否关注该用户
}
