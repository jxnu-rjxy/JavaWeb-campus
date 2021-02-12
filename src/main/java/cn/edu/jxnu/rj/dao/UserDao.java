package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.User;

import java.util.List;
import java.util.Set;

/**
 * 
 */
public interface UserDao {
    User findById(int user_id);//通过id查询用户
    List<User> findUsers(Set<String> ids);//根据id集合获取用户集合
    void insertUser(User user);//插入用户
    User findByPhone(String user_phone);//查询表中用户手机号
    void update(User user);//更改个人部分资料
    void updateImage(int userId,String path);//更新头像
    void updateFriend(int userId,boolean isAdd);//更新好友数
    void updateFollows(int userId,boolean isAdd);//更新关注数
    void updateFollowers(int userId,boolean isAdd);//更新粉丝数
}
