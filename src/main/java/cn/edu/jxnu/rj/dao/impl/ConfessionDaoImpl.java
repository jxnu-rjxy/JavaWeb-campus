package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.ConfessionDao;
import cn.edu.jxnu.rj.domain.Confession;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ConfessionDaoImpl implements ConfessionDao {
    @Override
    public Confession insert(Confession confession) {
        String sql = "insert into db_campus_confession(confession_user_id1,confession_user_id2,confession_content) values(?,?,?)";
        Jdbc jdbc = new Jdbc();
        int i = jdbc.executeUpdate(sql, confession.getConfessionUserId1(), confession.getConfessionUserId2(), confession.getConfessionContent());
        Confession confession1 = findById(i);

        return confession1;
    }

    @Override
    public List<Confession> getAllByUser(int userId) {
        String sql = "select * from db_campus_confession where confession_user_id1 = ? ";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql, userId);
        List<Confession> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                int confessionId = resultSet.getInt("confession_id");
                int confessionUserId1 = resultSet.getInt("confession_user_id1");
                int confessionUserId2 = resultSet.getInt("confession_user_id2");
                String confessionContent = resultSet.getString("confession_content");
                Timestamp gmtModified = resultSet.getTimestamp("gmt_modified");
                Timestamp gmtCreate = resultSet.getTimestamp("gmt_create");
                int confessionLikes = resultSet.getInt("confession_likes");
                int confessionComments = resultSet.getInt("confession_comments");
                Confession confession = new Confession(confessionId, confessionUserId1, confessionUserId2, confessionContent, gmtCreate, gmtModified, confessionLikes,confessionComments);
                list.add(confession);
            }
            return list;
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Confession findById(int ConfessionId) {
        String sql = "select * from db_campus_confession where confession_id = ? ";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql,ConfessionId);
        try {
            while (resultSet.next()){
                int confessionId = resultSet.getInt("confession_id");
                int confessionUserId1 = resultSet.getInt("confession_user_id1");
                int confessionUserId2 = resultSet.getInt("confession_user_id2");
                String confessionContent = resultSet.getString("confession_content");
                Timestamp gmtModified = resultSet.getTimestamp("gmt_modified");
                Timestamp gmtCreate = resultSet.getTimestamp("gmt_create");
                int confessionLikes = resultSet.getInt("confession_likes");
                int confessionComments = resultSet.getInt("confession_comments");
                Confession confession = new Confession(confessionId, confessionUserId1, confessionUserId2, confessionContent, gmtCreate, gmtModified, confessionLikes,confessionComments);
                return confession;
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int ConfessionId) {
        String sql = "delete from db_campus_confession where confession_id = ?";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,ConfessionId);
    }
}
