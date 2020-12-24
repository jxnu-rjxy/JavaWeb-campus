package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.MutualGroupRecardDao;
import cn.edu.jxnu.rj.domain.Clock_in_target;
import cn.edu.jxnu.rj.domain.Mutual;
import cn.edu.jxnu.rj.domain.Mutual_group_recard;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MutualGroupRecardDaoImpl implements MutualGroupRecardDao {

    public List<Mutual_group_recard>  findByUserId(int userId){
        //jdbc查询动态集合
        Jdbc jdbc = new Jdbc();
        String sql = "select * from db_campus_mutual_group_recard where user_id=?";
        ResultSet resultSet = jdbc.executeQuery(sql, userId);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Mutual_group_recard> list = new ArrayList<>();
        //处理
        try {
            while(resultSet.next()){

                //封装对象
                int mutual_id = Integer.parseInt(resultSet.getString("mutual_id"));
                int user_id = Integer.parseInt(resultSet.getString("user_id"));
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                Timestamp gmt_modified = resultSet.getTimestamp("gmt_modified");
                Mutual_group_recard mutual_group_recard = new Mutual_group_recard(mutual_id,user_id,gmt_create,gmt_modified);
                //将对象加入集合
                list.add(mutual_group_recard);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int Insert(Mutual_group_recard mutual_group_recard) {
        String sql  = "insert into db_campus_mutual_group_recard(user_id,mutual_id) values(?,?);";
        Jdbc jdbc = new Jdbc();
        return jdbc.executeUpdate(sql, mutual_group_recard.getUser_id(), mutual_group_recard.getMutual_id());
    }


}