package cn.edu.jxnu.rj.service.Impl;

import cn.edu.jxnu.rj.dao.FriendDao;
import cn.edu.jxnu.rj.dao.UserDao;
import cn.edu.jxnu.rj.dao.impl.FriendDaoImpl;
import cn.edu.jxnu.rj.dao.impl.UserDaoImpl;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.FriendService;

import java.util.List;
import java.util.Set;

public class FriendServiceImpl implements FriendService {
    FriendDao friendDao = new FriendDaoImpl();
    UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> getFriends(String userId) {
        Set<String> friends = friendDao.getFriends(userId);
        return userDao.findUsers(friends);
    }

    @Override
    public List<User> getFollows(String userId) {
        Set<String> friends = friendDao.getFollows(userId);
        return userDao.findUsers(friends);
    }

    @Override
    public List<User> getFollowers(String userId) {
        Set<String> friends = friendDao.getFollowers(userId);
        return userDao.findUsers(friends);
    }

    @Override
    public void follow(String userId, String friendId) {
        friendDao.follow(userId,friendId);
        userDao.updateFollows(Integer.parseInt(userId),true);
        userDao.updateFollowers(Integer.parseInt(friendId),true);
        //判断关注后是否为好友，如果是则好友数加一
        if(friendDao.isFriend(userId,friendId)){
            userDao.updateFriend(Integer.parseInt(userId),true);
        }
    }

    @Override
    public void cancelFollow(String userId, String followId) {
        //判断取消关注前是否为好友，如果是则好友数减一
        if(friendDao.isFriend(userId,followId)){
            userDao.updateFriend(Integer.parseInt(userId),false);
        }
        friendDao.cancelFollow(userId, followId);
        userDao.updateFollows(Integer.parseInt(userId),false);
        userDao.updateFollowers(Integer.parseInt(followId),false);
    }

    @Override
    public void removeFollowers(String userId, String followerId) {
        friendDao.removeFollowers(userId, followerId);
        userDao.updateFollows(Integer.parseInt(followerId),false);
        userDao.updateFollowers(Integer.parseInt(userId),false);
        //判断移除粉丝前是否为好友，如果是则好友数减一
        if(friendDao.isFriend(userId,followerId)){
            userDao.updateFriend(Integer.parseInt(userId),false);
        }
    }

    @Override
    public boolean isFriend(String userId, String friendId) {
        return friendDao.isFriend(userId, friendId);
    }

    @Override
    public boolean isFollow(String userId, String friendId) {
        return friendDao.isFollow(userId, friendId);
    }
}
