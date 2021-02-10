package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.CityDao;
import cn.edu.jxnu.rj.domain.City;
import cn.edu.jxnu.rj.domain.Province;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements CityDao {
    @Override
    public List<City> getAll(int pid) {
        String sql = "select * from db_campus_city where pid = ? order by cid";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql,pid);
        List<City> list = new ArrayList<>();
        try{
            while (resultSet.next()){
                int cid = resultSet.getInt("cid");
                String cityName = resultSet.getString("city");
                City city = new City(cid,cityName,pid);
                list.add(city);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.close();
        }
        return null;
    }
}
