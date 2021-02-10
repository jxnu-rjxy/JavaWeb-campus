package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.User;

import java.util.Date;

public interface UserService {
    User login(String user_phone, String user_password);//登录
    void logout(int user_id);//注销
    User findById(int userId);//查找用户
    User update(User user);//更新部分个人信息

}
