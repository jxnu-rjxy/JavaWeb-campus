package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.User;

public interface UserDao {
    User findById(int user_id);//通过id查询用户
    void insertUser(User user);//插入用户
    User findByPhone(String user_phone);//查询表中用户手机号
    void update(User user);//更改个人部分资料
}
