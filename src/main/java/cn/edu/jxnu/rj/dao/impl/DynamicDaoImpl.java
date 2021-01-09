package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.DynamicDao;
import cn.edu.jxnu.rj.dao.GiveLikeDao;
import cn.edu.jxnu.rj.domain.Dynamic;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DynamicDaoImpl implements DynamicDao {
    GiveLikeDao giveLikeDao = new GiveLikeDaoImpl();
    @Override
    public List<Dynamic> findByUserId(int userId) {
        //jdbc查询动态集合
        Jdbc jdbc = new Jdbc();
        String sql = "select * from db_campus_dynamic where user_id=? order by gmt_create desc";
        ResultSet resultSet = jdbc.executeQuery(sql, userId);

        List<Dynamic> list = new ArrayList<>();
        //处理
        try {
            while(resultSet.next()){

                Dynamic dynamic = null;
                //封装对象
                int dynamic_id = Integer.parseInt(resultSet.getString("dynamic_id"));
                int user_id = Integer.parseInt(resultSet.getString("user_id"));
                String userName = resultSet.getString("user_name");
                String userSchool = resultSet.getString("user_school");
                String dynamic_content = resultSet.getString("dynamic_content");
                int media_id = Integer.parseInt(resultSet.getString("media_id"));
                int dynamic_status = Integer.parseInt(resultSet.getString("dynamic_status"));
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
                String image_path = resultSet.getString("image_path");
                int dynamicComments = resultSet.getInt("dynamic_comments");
                int dynamicLikes = resultSet.getInt("dynamic_likes");
                int dynamicForwards = resultSet.getInt("dynamic_forwards");
                dynamic = new Dynamic(dynamic_id,
                        user_id,
                        userName,
                        userSchool,
                        dynamic_content,
                        media_id,
                        dynamic_status,
                        gmt_create,
                        gmt_modified,
                        image_path,
                        dynamicLikes,
                        dynamicForwards,
                        dynamicComments);

                boolean like = giveLikeDao.isLike(dynamic_id, 0, userId);
                dynamic.setLike(like);
                //将对象加入集合
                list.add(dynamic);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Dynamic> findAll(int toNum,int fromNum,int userId) {
        String sql = "select * from db_campus_dynamic order by dynamic_id desc limit ?,?";
        Jdbc jdbc = new Jdbc();
        System.out.println("查询前"+fromNum+"~"+toNum+"条记录");
        ResultSet resultSet = jdbc.executeQuery(sql,fromNum,toNum);
        List<Dynamic> list = new ArrayList<>();
        //处理
        try {
            while(resultSet.next()){
                Dynamic dynamic = null;
                //封装对象
                int dynamic_id = Integer.parseInt(resultSet.getString("dynamic_id"));
                int user_id = Integer.parseInt(resultSet.getString("user_id"));
                String userName = resultSet.getString("user_name");
                String userSchool = resultSet.getString("user_school");
                String dynamic_content = resultSet.getString("dynamic_content");
                int media_id = Integer.parseInt(resultSet.getString("media_id"));
                int dynamic_status = Integer.parseInt(resultSet.getString("dynamic_status"));
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
                String image_path = resultSet.getString("image_path");
                int dynamicComments = resultSet.getInt("dynamic_comments");
                int dynamicLikes = resultSet.getInt("dynamic_likes");
                int dynamicForwards = resultSet.getInt("dynamic_forwards");
                dynamic = new Dynamic(dynamic_id,
                        user_id,
                        userName,
                        userSchool,
                        dynamic_content,
                        media_id,
                        dynamic_status,
                        gmt_create,
                        gmt_modified,
                        image_path,
                        dynamicLikes,
                        dynamicForwards,
                        dynamicComments);

                boolean like = giveLikeDao.isLike(dynamic_id, 0, userId);
                dynamic.setLike(like);
                //将对象加入集合
                list.add(dynamic);
            }
            System.out.println(list);
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.close();
        }
        return null;
    }

    @Override
    public boolean isLike(int userId, int dynamicId) {
        String sql = "select 1 from db_campus_giveLike where user_id=? abd work_type = ? and work_id = ? limit 1";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql, userId, 0, dynamicId);
        try {
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            jdbc.close();
        }
        return false;
    }

    @Override
    public Dynamic findById(int DynamicId,int userId) {
        Jdbc jdbc = new Jdbc();
        String sql = "select * from db_campus_dynamic where dynamic_id=?";
        ResultSet resultSet = jdbc.executeQuery(sql,DynamicId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //处理
        try {
            Dynamic dynamic = null;
            while(resultSet.next()){
                //封装对象
                int dynamic_id = Integer.parseInt(resultSet.getString("dynamic_id"));
                int user_id = Integer.parseInt(resultSet.getString("user_id"));
                String userName = resultSet.getString("user_name");
                String userSchool = resultSet.getString("user_school");
                String dynamic_content = resultSet.getString("dynamic_content");
                int media_id = Integer.parseInt(resultSet.getString("media_id"));
                int dynamic_status = Integer.parseInt(resultSet.getString("dynamic_status"));
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
                String image_path = resultSet.getString("image_path");
                int dynamicComments = resultSet.getInt("dynamic_comments");
                int dynamicLikes = resultSet.getInt("dynamic_likes");
                int dynamicForwards = resultSet.getInt("dynamic_forwards");
                dynamic = new Dynamic(dynamic_id,
                        user_id,
                        userName,
                        userSchool,
                        dynamic_content,
                        media_id,
                        dynamic_status,
                        gmt_create,
                        gmt_modified,
                        image_path,
                        dynamicLikes,
                        dynamicForwards,
                        dynamicComments);
                boolean like = giveLikeDao.isLike(dynamic_id, 0, userId);
                dynamic.setLike(like);
            }
            return dynamic;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.close();
        }
        return null;
    }

    @Override
    public int InsertDynamic(Dynamic dynamic) {
        String sql  = "insert into db_campus_dynamic(user_id,user_name,user_school,dynamic_content,media_id,dynamic_status,image_path) values(?,?,?,?,?,?,?);";
        Jdbc jdbc = new Jdbc();
        System.out.println("准备插入的数据是："+dynamic);
        return jdbc.executeUpdate(sql, dynamic.getUser_id(), dynamic.getUserName(),dynamic.getUserSchool(),dynamic.getDynamic_content(), dynamic.getMedia_id(), dynamic.getDynamic_status(), dynamic.getImage_path());
    }

    @Override
    public void deleteDynamic(int dynamic_id) {
        String sql  = "delete from db_campus_dynamic where dynamic_id=?;";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,dynamic_id);
    }
}
