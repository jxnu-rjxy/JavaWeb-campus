package cn.edu.jxnu.rj.service.Impl;

import cn.edu.jxnu.rj.dao.UserDao;
import cn.edu.jxnu.rj.dao.impl.UserDaoImpl;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    public User login(String user_phone,String user_password){
        User user = userDao.findByPhone(user_phone);
        //判断
        if(user.getUser_phone()==null){//是否存在账号

            return user;
        }else {
            if(user.getUser_password().equals(user_password)){//密码正确
                return user;
            }else {//密码错误
                return user;
            }
        }
    }
}
