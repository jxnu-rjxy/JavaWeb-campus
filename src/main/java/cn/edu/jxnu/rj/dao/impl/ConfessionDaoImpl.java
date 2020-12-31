package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.ConfessionDao;
import cn.edu.jxnu.rj.domain.Confession;

import java.util.List;

public class ConfessionDaoImpl implements ConfessionDao {
    @Override
    public Confession insert(Confession confession) {
        String sql = "insert into db_campus_confession(,confession_content) values(?,?,?)";
        return null;
    }

    @Override
    public List<Confession> getAllByUser(int userId) {
        return null;
    }

    @Override
    public Confession findById(int ConfessionId) {
        return null;
    }

    @Override
    public void delete(int ConfessionId) {

    }
}
