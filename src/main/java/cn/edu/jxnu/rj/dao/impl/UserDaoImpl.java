package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.UserDao;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat birthdayDate = new SimpleDateFormat("yyyy-MM-dd");
                int userId = Integer.parseInt(resultSet.getString("user_id"));
                String userPassword = resultSet.getString("user_password");
                String user_name = resultSet.getString("user_name");
                String user_phone = resultSet.getString("user_phone");
                int user_gender = Integer.parseInt(resultSet.getString("user_gender"));

                Date user_birthday = birthdayDate.parse(resultSet.getString("user_birthday"));
                String user_password = resultSet.getString("user_password");
                int user_province = Integer.parseInt(resultSet.getString("user_province"));
                int user_city = Integer.parseInt(resultSet.getString("user_city"));
                int user_emotion_status = Integer.parseInt(resultSet.getString("user_emotion_status"));
                int user_match_status = Integer.parseInt(resultSet.getString("user_match_status"));
                String user_signature = resultSet.getString("user_signature");
                String user_realname = resultSet.getString("user_realname");
                String user_school = resultSet.getString("user_school");
                String user_dept = resultSet.getString("user_dept");
                String user_major = resultSet.getString("user_major");
                String user_grade = resultSet.getString("user_grade");
                Date gmt_create = simpleDateFormat.parse(resultSet.getString("gmt_create"));
                Date gmt_modified = simpleDateFormat.parse(resultSet.getString("gmt_modified"));

                //将记录存入User对象
                User user = new User(user_id,
                        user_name,
                        user_phone,
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
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO db_campus_user(user_name,user_phone,user_gender,user_birthday,user_password,user_province,user_city,user_emotion_status,user_realname,user_school,user_dept,user_major,user_grade) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Jdbc jdbc = new Jdbc();
        jdbc.execute(sql,
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

        //处理结果集
        try {
            if(resultSet.next()){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat birthdayDate = new SimpleDateFormat("yyyy-MM-dd");
                int userId = Integer.parseInt(resultSet.getString("user_id"));
                String userPassword = resultSet.getString("user_password");
                String user_name = resultSet.getString("user_name");
                String userPhone = resultSet.getString("user_phone");
                int user_gender = Integer.parseInt(resultSet.getString("user_gender"));
                Date user_birthday = birthdayDate.parse(resultSet.getString("user_birthday"));
                String user_password = resultSet.getString("user_password");
                int user_province = Integer.parseInt(resultSet.getString("user_province"));
                int user_city = Integer.parseInt(resultSet.getString("user_city"));
                int user_emotion_status = Integer.parseInt(resultSet.getString("user_emotion_status"));
                int user_match_status = Integer.parseInt(resultSet.getString("user_match_status"));
                String user_signature = resultSet.getString("user_signature");
                String user_realname = resultSet.getString("user_realname");
                String user_school = resultSet.getString("user_school");
                String user_dept = resultSet.getString("user_dept");
                String user_major = resultSet.getString("user_major");
                String user_grade = resultSet.getString("user_grade");
                Date gmt_create = simpleDateFormat.parse(resultSet.getString("gmt_create"));
                Date gmt_modified = simpleDateFormat.parse(resultSet.getString("gmt_modified"));

                //将记录存入User对象

                User user = new User(userId,
                        user_name,
                        user_phone,
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
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.close();
        }
        return null;
    }
}

