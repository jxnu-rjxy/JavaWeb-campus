package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.UserDao;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

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
                String userImage = resultSet.getString("user_image");
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
                int userFriendsNum = resultSet.getInt("user_friendsNum");
                int userFollowsNum = resultSet.getInt("user_followsNum");
                int userFollowersNum = resultSet.getInt("user_followersNum");

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
                        userImage,
                        gmt_create,
                        gmt_modified,
                        userFriendsNum,
                        userFollowsNum,
                        userFollowersNum);
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
    public List<User> findUsers(Set<String> ids) {
        List<User> list = new ArrayList<>();
        Iterator<String> iterator = ids.iterator();
        while (iterator.hasNext()){
            int id = Integer.parseInt(iterator.next());
            User user = findById(id);
            list.add(user);
        }
        return list;
    }

    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO db_campus_user(user_name,user_phone,user_gender,user_birthday,user_password,user_province,user_city,user_emotion_status,user_realname,user_school,user_dept,user_major,user_grade) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,
                user.getUserName(),
                user.getUserPhone(),
                user.getUserGender(),
                user.getUserBirthday(),
                user.getUserPassword(),
                user.getUserProvince(),
                user.getUserCity(),
                user.getUserEmotionStatus(),
                user.getUserRealName(),
                user.getUserSchool(),
                user.getUserDept(),
                user.getUserMajor(),
                user.getUserGrade());
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
                String userImage = resultSet.getString("user_image");
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
                int userFriendsNum = resultSet.getInt("user_friendsNum");
                int userFollowsNum = resultSet.getInt("user_followsNum");
                int userFollowersNum = resultSet.getInt("user_followersNum");

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
                        userImage,
                        gmt_create,
                        gmt_modified,
                        userFriendsNum,
                        userFollowsNum,
                        userFollowersNum);
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
        jdbc.executeUpdate(sql,user.getUserName(),user.getUserBirthday(),user.getUserProvince(),user.getUserCity(),user.getUserEmotionStatus(),user.getUserSignature(),user.getUserDept(),user.getUserMajor(),user.getUserId());
    }

    @Override
    public void updateImage(int userId, String path) {
        String sql = "update db_campus_user set user_image = ? where user_id = ?";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,path,userId);
    }
}

