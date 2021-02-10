package cn.edu.jxnu.rj.service.Impl;

import cn.edu.jxnu.rj.dao.UserDao;
import cn.edu.jxnu.rj.dao.impl.UserDaoImpl;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.UserService;

import java.util.Date;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    public User login(String user_phone, String user_password) {
        User user = userDao.findByPhone(user_phone);
        //判断
        if (user == null) {//是否存在账号
            return null;
        } else {
            System.out.println("登录时输入的账号："+user_phone+"输入的密码："+user_password+"正确密码："+user.getUserPassword());
            if (user.getUserPassword().equals(user_password)) {//密码正确
                return user;
            } else {//密码错误
                return null;
            }
        }
    }

    @Override
    public void logout(int user_id) {

    }

    @Override
    public User findById(int userId) {
        return userDao.findById(userId);
    }

    @Override
    public User update(User user) {
        userDao.update(user);
        if(user.getUserImage()!=null){
            userDao.updateImage(user.getUserId(),user.getUserImage());
        }

        return userDao.findById(user.getUserId());
    }


}
