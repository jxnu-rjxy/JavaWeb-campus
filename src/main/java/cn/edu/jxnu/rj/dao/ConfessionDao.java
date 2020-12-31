package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Confession;

import java.util.List;

public interface ConfessionDao {
    Confession insert(Confession confession);//发布表白
    List<Confession> getAllByUser(int userId);//查询某用户所有表白
    Confession findById(int ConfessionId);//根据id查询
    void delete(int ConfessionId);//删除表白
}
