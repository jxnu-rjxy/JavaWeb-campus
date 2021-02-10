package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Province;

import java.util.List;

public interface ProvinceDao {
    List<Province> getAll();//获取所有城市
    int getId(String provinceName);
}
