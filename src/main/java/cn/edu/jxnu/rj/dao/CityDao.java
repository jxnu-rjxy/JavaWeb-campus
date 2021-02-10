package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.City;

import java.util.List;

public interface CityDao {
    List<City> getAll(int pid);//根据省份获取该省份的所有城市
}
