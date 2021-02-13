package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.FriendDao;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class FriendDaoImpl implements FriendDao {
    static String FOLLOW_PREFIX = "campus:follow:";
    static String FOLLOWER_PREFIX = "campus:follower:";

    Jedis jedis = new Jedis("118.31.173.242",6379);

    @Override
    public Set<String> getFriends(String userId) {
            Long zinterstore = jedis.zinterstore("friendOut", FOLLOW_PREFIX + userId, FOLLOWER_PREFIX + userId);
            Set<String> friendOut = jedis.zrange("friendOut", 0, -1);
            jedis.expire("friendOut",60*30);//失效时间半小时
            jedis.close();
            return friendOut;
    }

    @Override
    public Set<String> getFollows(String userId) {
        Set<String> follows = jedis.zrange(FOLLOW_PREFIX + userId, 0, -1);
        jedis.close();
        return follows;
    }

    @Override
    public Set<String> getFollowers(String userId) {
        Set<String> followers = jedis.zrange(FOLLOWER_PREFIX + userId, 0, -1);
        jedis.close();
        return  followers;
    }

    @Override
    public void follow(String userId, String friendId) {//关注
        //用户userId的关注列表增加用户friendId
        jedis.zadd(FOLLOW_PREFIX+userId,System.currentTimeMillis(),friendId);
        //用户friendId的粉丝列表增加用户userId
        jedis.zadd(FOLLOWER_PREFIX+friendId,System.currentTimeMillis(),userId);
        jedis.close();
    }

    @Override
    public void cancelFollow(String userId, String followId) {
        jedis.zrem(FOLLOW_PREFIX+userId,followId);
        jedis.zrem(FOLLOWER_PREFIX+followId,userId);
        jedis.close();
    }

    @Override
    public void removeFollowers(String userId, String followerId) {
        jedis.zrem(FOLLOW_PREFIX+followerId,userId);
        jedis.zrem(FOLLOWER_PREFIX+userId,followerId);
        jedis.close();
    }

    @Override
    public boolean isFriend(String userId, String friendId) {
        boolean isFriend = getFriends(userId).contains(friendId);
        jedis.close();
        return isFriend;
    }

    @Override
    public boolean isFollow(String userId, String friendId) {
        return getFollows(userId).contains(friendId);
    }
}
