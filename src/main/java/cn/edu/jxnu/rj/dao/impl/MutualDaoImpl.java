package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.MutualDao;
import cn.edu.jxnu.rj.domain.Dynamic;
import cn.edu.jxnu.rj.domain.Mutual;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MutualDaoImpl implements MutualDao {
    @Override
    public List<Mutual> findByUserId(int userId) {
        //jdbc查询动态集合
        Jdbc jdbc = new Jdbc();
        String sql = "select * from db_campus_mutual where user_id=? order by gmt_create desc";
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
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
                Mutual mutual = new Mutual(mutual_id,user_id,mutual_title,mutual_content,gmt_create,gmt_modified);
                list.add(mutual);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.close();
        }
        return null;
    }

    @Override
    public List<Mutual> findAll(int toNum, int fromNum) {  String sql = "select * from db_campus_mutual order by mutual_id desc limit ?,?";
        Jdbc jdbc = new Jdbc();
        System.out.println("查询前"+fromNum+"~"+toNum+"条记录");
        ResultSet resultSet = jdbc.executeQuery(sql,fromNum,toNum);
        List<Mutual> list = new ArrayList<>();
        //处理
        try {
            while(resultSet.next()){

                //封装对象
                int mutual_id = Integer.parseInt(resultSet.getString("mutual_id"));
                int user_id = Integer.parseInt(resultSet.getString("user_id"));
                String mutual_title = resultSet.getString("mutual_title");
                String mutual_content = resultSet.getString("mutual_content");
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
                Mutual mutual = new Mutual(mutual_id,user_id,mutual_title,mutual_content,gmt_create,gmt_modified);

                //将对象加入集合
                list.add(mutual);
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
    public Mutual findById(int mutualId) {
        String sql = "select * from db_campus_mutual where mutual_id=?";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql, mutualId);
        //处理
        try {
            while (resultSet.next()) {

                //封装对象
                int mutual_id = Integer.parseInt(resultSet.getString("mutual_id"));
                int user_id = Integer.parseInt(resultSet.getString("user_id"));
                String mutual_title = resultSet.getString("mutual_title");
                String mutual_content = resultSet.getString("mutual_content");
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
                Mutual mutual = new Mutual(mutual_id, user_id, mutual_title, mutual_content, gmt_create, gmt_modified);
                return mutual;
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.close();
        } return null;
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
