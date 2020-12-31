package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.GiveLikeDao;
import cn.edu.jxnu.rj.domain.Givelike;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.Timestamp;

public class GiveLikeDaoImpl implements GiveLikeDao{
    @Override
    public void insert(Givelike givelike) {
        String sql = "insert into db_campus_giveLike(work_id,work_type,user_id) values(?,?,?);";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,givelike.getWork_id(),givelike.getWork_type(),givelike.getUser_id());
        String likesNum = null;
        if(givelike.getWork_type()==0){
            likesNum = "update db_campus_dynamic set dynamic_likes = dynamic_likes + 1 where dynamic_id = ?";
        }else if(givelike.getWork_type()==1){
            likesNum = "update db_campus_comment set comment_likes = comment_likes + 1 where comment_id = ?";
        }
        Jdbc jdbc1 = new Jdbc();
        jdbc1.executeUpdate(likesNum,givelike.getWork_id());
    }

    @Override
    public void delete(Givelike givelike) {
        String sql = "delete from db_campus_giveLike where giveLike_id = ? ";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql, givelike.getGivelike_id());
        String likesNum = null;
        if(givelike.getWork_type()==0){
            likesNum = "update db_campus_dynamic set dynamic_likes = dynamic_likes - 1 where dynamic_id = ?";
        }else if(givelike.getWork_type()==1){
            likesNum = "update db_campus_comment set comment_likes = comment_likes - 1 where comment_id = ?";
        }
        Jdbc jdbc1 = new Jdbc();
        jdbc1.executeUpdate(likesNum,givelike.getWork_id());
    }

    @Override
    public Givelike select(int workId,int workType,int userId) {
        String sql = "select * from db_campus_giveLike where user_id = ? and work_id = ? and work_type = ?";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql,userId,workId,workType);
        try {
            while (resultSet.next()){
                int likeId = resultSet.getInt("giveLike_id");
                int workId2 = resultSet.getInt("work_id");
                int workType2 = resultSet.getInt("work_type");
                int userId2 = resultSet.getInt("user_id");
                Timestamp gmtCreate = resultSet.getTimestamp("gmt_create");
                Timestamp gmtModified = resultSet.getTimestamp("gmt_modified");
                System.out.println(new Givelike(likeId,workId,workType,userId,gmtCreate,gmtModified));
                return new Givelike(likeId,workId2,workType2,userId2,gmtCreate,gmtModified);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
