package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.UserDao;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User selectUserById(int user_id) {
        Jdbc jdbc = new Jdbc();
        Connection con = jdbc.getCon();
        String sql = "select * from db_campus_user where user_id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = new User();
            if(resultSet.next()){
                int userId = Integer.parseInt(resultSet.getString("user_id"));
                String userPassword = resultSet.getString("user_password");
                user.setUser_id(userId);
                user.setUser_password(userPassword);
            }
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
