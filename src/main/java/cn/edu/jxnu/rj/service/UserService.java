package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.User;

public interface UserService {
    public User login(String user_phone, String user_password);
}
