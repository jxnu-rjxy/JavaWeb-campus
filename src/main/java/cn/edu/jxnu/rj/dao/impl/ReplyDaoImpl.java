package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.ReplyDao;
import cn.edu.jxnu.rj.domain.Reply;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReplyDaoImpl implements ReplyDao {
    @Override
    public Reply insert(Reply reply) {
        String sql = "insert into db_campus_reply(comment_id,reply_content,user_id) values(?,?,?)";
        Jdbc jdbc = new Jdbc();
        int i = jdbc.executeUpdate(sql, reply.getComment_id(), reply.getReply_content(), reply.getUser_id());
        return null;
    }

    @Override
    public List<Reply> getAllByCommentId(int commentId) {
        String sql = "select * from db_campus_reply where comment_id = ?";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql, commentId);
        List<Reply> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                int replyId = resultSet.getInt("reply_id");
                int commentId1 = resultSet.getInt("comment_id");
                String commentContent = resultSet.getString("reply_content");
                int userId = resultSet.getInt("user_id");
                Timestamp gmtCreate = resultSet.getTimestamp("gmt_create");
                Timestamp gmtModified = resultSet.getTimestamp("gmt_modified");
                int replyLikes = resultSet.getInt("reply_likes");
                list.add(new Reply(replyId,commentId1,commentContent,userId,gmtCreate,gmtModified,replyLikes));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbc.close();
        }
        return null;
    }

    @Override
    public void delete(int replyId) {
        String sql = "delete from db_campus_reply where reply_id = ?";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,replyId);
    }
}
