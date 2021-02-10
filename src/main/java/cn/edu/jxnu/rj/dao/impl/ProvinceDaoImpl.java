package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.ProvinceDao;
import cn.edu.jxnu.rj.domain.Province;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
    @Override
    public List<Province> getAll() {
        String sql = "select * from db_campus_province order by pid";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql);
        List<Province> list = new ArrayList<>();
        try{
            while (resultSet.next()){
                int pid = resultSet.getInt("pid");
                String provinceName = resultSet.getString("province");
                Province province = new Province(pid,provinceName);
                list.add(province);
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
    public int getId(String provinceName) {
        String sql = "select pid from db_campus_province where province = ?";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql, provinceName);
        try{
            while (resultSet.next()){
                int pid = resultSet.getInt("pid");
                return pid;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.close();
        }
        return 0;
    }
}
