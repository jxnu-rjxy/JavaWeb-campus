package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.User;

public interface UserDao {
    User findById(int user_id);//通过id查询用户
}
