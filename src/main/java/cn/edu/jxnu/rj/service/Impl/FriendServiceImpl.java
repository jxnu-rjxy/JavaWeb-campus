package cn.edu.jxnu.rj.service.Impl;

import cn.edu.jxnu.rj.dao.FriendDao;
import cn.edu.jxnu.rj.dao.impl.FriendDaoImpl;
import cn.edu.jxnu.rj.domain.Friend;
import cn.edu.jxnu.rj.service.FriendService;

import java.util.List;

public class FriendServiceImpl implements FriendService {
    FriendDao friendDao = new FriendDaoImpl();
    @Override
    public void add(Friend friend) {
        friendDao.add(friend);
    }

    @Override
    public List<Friend> query(int friendType, int userId) {
        List<Friend> friendList = friendDao.query(friendType, userId);
        return friendList;
    }

    @Override
    public void delete(int friendType, int userId) {
        friendDao.delete(friendType,userId);
    }
}
