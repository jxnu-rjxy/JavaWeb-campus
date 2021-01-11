package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.UserDao;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class UserDaoImpl implements UserDao {
    @Override
    public User findById(int user_id) {
        //调用jdbc查询
        String sql = "select * from db_campus_user where user_id = ?";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql,user_id);

        //处理结果集
        try {
            if(resultSet.next()){
                int userId = resultSet.getInt("user_id");
                String user_name = resultSet.getString("user_name");
                String userPhone = resultSet.getString("user_phone");
                int user_gender = resultSet.getInt("user_gender");
                Date user_birthday = resultSet.getDate("user_birthday");
                String user_password = resultSet.getString("user_password");
                String user_province = resultSet.getString("user_province");
                String user_city = resultSet.getString("user_city");
                int user_emotion_status = resultSet.getInt("user_emotion_status");
                int user_match_status = resultSet.getInt("user_match_status");
                String user_signature = resultSet.getString("user_signature");
                String user_realname = resultSet.getString("user_realname");
                String user_school = resultSet.getString("user_school");
                String user_dept = resultSet.getString("user_dept");
                String user_major = resultSet.getString("user_major");
                String user_grade = resultSet.getString("user_grade");
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
                //将记录存入User对象
                User user = new User(userId,
                        user_name,
                        userPhone,
                        user_gender,
                        user_birthday,
                        user_password,
                        user_province,
                        user_city,
                        user_emotion_status,
                        user_match_status,
                        user_signature,
                        user_realname,
                        user_school,
                        user_dept,
                        user_major,
                        user_grade,
                        gmt_create,
                        gmt_modified);
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.close();
        }
        return null;
    }

    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO db_campus_user(user_name,user_phone,user_gender,user_birthday,user_password,user_province,user_city,user_emotion_status,user_realname,user_school,user_dept,user_major,user_grade) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,
                user.getUser_name(),
                user.getUser_phone(),
                user.getUser_gender(),
                user.getUser_birthday(),
                user.getUser_password(),
                user.getUser_province(),
                user.getUser_city(),
                user.getUser_emotion_status(),
                user.getUser_realname(),
                user.getUser_school(),
                user.getUser_dept(),
                user.getUser_major(),
                user.getUser_grade());
    }

    public User findByPhone(String user_phone){
        String sql = "select * from db_campus_user where user_phone = ?";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql,user_phone);
        System.out.println("查询的手机号："+user_phone);
        //处理结果集
        try {
            if(resultSet.next()){
                int userId = resultSet.getInt("user_id");
                String user_name = resultSet.getString("user_name");
                String userPhone = resultSet.getString("user_phone");
                int user_gender = resultSet.getInt("user_gender");
                Date user_birthday = resultSet.getDate("user_birthday");
                String user_password = resultSet.getString("user_password");
                String user_province = resultSet.getString("user_province");
                String user_city = resultSet.getString("user_city");
                int user_emotion_status = resultSet.getInt("user_emotion_status");
                int user_match_status = resultSet.getInt("user_match_status");
                String user_signature = resultSet.getString("user_signature");
                String user_realname = resultSet.getString("user_realname");
                String user_school = resultSet.getString("user_school");
                String user_dept = resultSet.getString("user_dept");
                String user_major = resultSet.getString("user_major");
                String user_grade = resultSet.getString("user_grade");
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
                System.out.println("创建时间："+gmt_create);
                //将记录存入User对象

                User user = new User(userId,
                        user_name,
                        userPhone,
                        user_gender,
                        user_birthday,
                        user_password,
                        user_province,
                        user_city,
                        user_emotion_status,
                        user_match_status,
                        user_signature,
                        user_realname,
                        user_school,
                        user_dept,
                        user_major,
                        user_grade,
                        gmt_create,
                        gmt_modified);
                System.out.println(user);
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.close();
        }
        return null;
    }

    @Override
    public void update(User user) {
        String sql = "update db_campus_user set user_name=? , user_birthday=? , user_province=? , user_city=? , user_emotion_status=? , user_signature=? , user_dept=? , user_major=? where user_id = ?";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,user.getUser_name(),user.getUser_birthday(),user.getUser_province(),user.getUser_city(),user.getUser_emotion_status(),user.getUser_signature(),user.getUser_dept(),user.getUser_major(),user.getUser_id());
    }
}

