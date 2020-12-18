package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.MutualDao;
import cn.edu.jxnu.rj.domain.Mutual;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MutualDaoImpl implements MutualDao {
    @Override
    public List<Mutual> findByUserId(int userId) {
        //jdbc查询动态集合
        Jdbc jdbc = new Jdbc();
        String sql = "select * from db_campus_mutual where user_id=?";
        ResultSet resultSet = jdbc.executeQuery(sql, userId);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Mutual> list = new ArrayList<>();
        //处理
        try {
            while(resultSet.next()){

                //封装对象
                int mutual_id = Integer.parseInt(resultSet.getString("mutual_id"));
                int user_id = Integer.parseInt(resultSet.getString("user_id"));
                String mutual_title = resultSet.getString("mutual_title");
                String mutual_content = resultSet.getString("mutual_content");
                Date gmt_create = simpleDateFormat.parse(resultSet.getString("gmt_create"));
                Date gmt_modified = simpleDateFormat.parse(resultSet.getString("gmt_modified"));
                Mutual mutual = new Mutual(mutual_id,user_id,mutual_title,mutual_content,gmt_create,gmt_modified);
                //将对象加入集合
                list.add(mutual);
            }
            return list;
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Mutual findById(int mutual_id) {
        return null;
    }

    @Override
    public int InsertMutual(Mutual mutual) {
        String sql  = "insert into db_campus_mutual(user_id,mutual_id,mutual_title,mutual_content) values(?,?,?,?);";
        Jdbc jdbc = new Jdbc();
        return jdbc.executeUpdate(sql, mutual.getUser_id(), mutual.getMutual_id(), mutual.getMutual_title(),mutual.getMutual_content());
    }

    @Override
    public void deleteMutual(int mutual_id) {
        String sql  = "delete from db_campus_mutual where mutual_id=?;";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,mutual_id);
    }

}
