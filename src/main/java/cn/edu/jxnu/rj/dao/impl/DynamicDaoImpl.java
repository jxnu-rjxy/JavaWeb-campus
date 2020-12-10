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
                Dynamic dynamic = new Dynamic(dynamic_id,user_id,dynamic_content,media_id,dynamic_status,gmt_create,gmt_modified);

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
    public void InsertDynamic(Dynamic dynamic) {
//        String sql  = "insert into db_"
//        Jdbc jdbc = new Jdbc();
//        jdbc.execute();
    }

    @Override
    public void deleteDynamic(int dynamic_id) {

    }
}
