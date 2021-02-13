package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.FriendDao;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class FriendDaoImpl implements FriendDao {
    static String FOLLOW_PREFIX = "follow_";
    static String FOLLOWER_PREFIX = "follower_";

    Jedis jedis = new Jedis("118.31.173.242",6379);

    @Override
    public Set<String> getFriends(String userId) {
        try{
            Set<String> followers = getFollowers(userId);
            Set<String> follows = getFollows(userId);
            Long zinterstore = jedis.zinterstore("friendOut", FOLLOW_PREFIX + userId, FOLLOWER_PREFIX + userId);
            return jedis.zrange("friendOut", 0, -1);
        }finally {
            jedis.close();
        }

    }

    @Override
    public Set<String> getFollows(String userId) {
        try{
            return jedis.zrange(FOLLOW_PREFIX+userId,0,-1);
        }finally {
            jedis.close();
        }

    }

    @Override
    public Set<String> getFollowers(String userId) {
        try{
            return jedis.zrange(FOLLOWER_PREFIX+userId,0,-1);
        }finally {
            jedis.close();
        }

    }

    @Override
    public void follow(String userId, String friendId) {//关注
        try{
            //用户userId的关注列表增加用户friendId
            jedis.zadd(FOLLOW_PREFIX+userId,System.currentTimeMillis(),friendId);
            //用户friendId的粉丝列表增加用户userId
            jedis.zadd(FOLLOWER_PREFIX+friendId,System.currentTimeMillis(),userId);
        }finally {
            jedis.close();
        }

    }

    @Override
    public void cancelFollow(String userId, String followId) {
        try{
            jedis.zrem(FOLLOW_PREFIX+userId,followId);
            jedis.zrem(FOLLOWER_PREFIX+followId,userId);
        }finally {
            jedis.close();
        }

    }

    @Override
    public void removeFollowers(String userId, String followerId) {
        try{
            jedis.zrem(FOLLOW_PREFIX+followerId,userId);
            jedis.zrem(FOLLOWER_PREFIX+userId,followerId);
        }finally {
            jedis.close();
        }

    }

    @Override
    public boolean isFriend(String userId, String friendId) {
        try{
            return getFriends(userId).contains(friendId);
        }finally {
            jedis.close();
        }
    }

    @Override
    public boolean isFollow(String userId, String friendId) {
        return getFollows(userId).contains(friendId);
    }
}
