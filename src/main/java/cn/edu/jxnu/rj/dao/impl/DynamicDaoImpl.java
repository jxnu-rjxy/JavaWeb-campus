package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.DynamicDao;
import cn.edu.jxnu.rj.domain.Dynamic;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DynamicDaoImpl implements DynamicDao {
    @Override
    public List<Dynamic> findByUserId(int userId) {
        //jdbc查询动态集合
        Jdbc jdbc = new Jdbc();
        String sql = "select * from db_campus_dynamic where user_id=?";
        ResultSet resultSet = jdbc.executeQuery(sql, userId);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Dynamic> list = new ArrayList<>();
        //处理
        try {
            while(resultSet.next()){

                //封装对象
                int dynamic_id = Integer.parseInt(resultSet.getString("dynamic_id"));
                int user_id = Integer.parseInt(resultSet.getString("user_id"));
                String dynamic_content = resultSet.getString("dynamic_content");
                int media_id = Integer.parseInt(resultSet.getString("media_id"));
                int dynamic_status = Integer.parseInt(resultSet.getString("dynamic_status"));
                Date gmt_create = simpleDateFormat.parse(resultSet.getString("gmt_create"));
                Date gmt_modified = simpleDateFormat.parse(resultSet.getString("gmt_modified"));
                String image_path = resultSet.getString("image_path");
                Dynamic dynamic = new Dynamic(dynamic_id,user_id,dynamic_content,media_id,dynamic_status,gmt_create,gmt_modified,image_path);
                //将对象加入集合
                list.add(dynamic);
            }
            return list;
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Dynamic findById(int DynamicId) {
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
                String dynamic_content = resultSet.getString("dynamic_content");
                int media_id = Integer.parseInt(resultSet.getString("media_id"));
                int dynamic_status = Integer.parseInt(resultSet.getString("dynamic_status"));
                Date gmt_create = simpleDateFormat.parse(resultSet.getString("gmt_create"));
                Date gmt_modified = simpleDateFormat.parse(resultSet.getString("gmt_modified"));
                String image_path = resultSet.getString("image_path");
                dynamic = new Dynamic(dynamic_id,user_id,dynamic_content,media_id,dynamic_status,gmt_create,gmt_modified,image_path);
                //将对象加入集合
            }
            return dynamic;
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int InsertDynamic(Dynamic dynamic) {
        String sql  = "insert into db_campus_dynamic(user_id,dynamic_content,media_id,dynamic_status,image_path) values(?,?,?,?,?);";
        Jdbc jdbc = new Jdbc();
        return jdbc.executeUpdate(sql, dynamic.getUser_id(), dynamic.getDynamic_content(), dynamic.getMedia_id(), dynamic.getDynamic_status(), dynamic.getImage_path());
    }

    @Override
    public void deleteDynamic(int dynamic_id) {

    }
}
