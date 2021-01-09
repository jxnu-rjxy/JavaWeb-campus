package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.MessageDao;
import cn.edu.jxnu.rj.domain.Comment;
import cn.edu.jxnu.rj.domain.Message;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements MessageDao {

    @Override
    public int insert(Message message) {
        String sql = "insert into db_campus_message(user_id1,user_id2,message_type,message_content) values(?,?,?,?);";
        Jdbc jdbc=new Jdbc();
        int messageId = jdbc.executeUpdate(sql,message.getUser_id1(),message.getUser_id2(),message.getMessage_type(),message.getMessage_content());
        return messageId;
    }

    @Override
    public List<Message> select(int userId,int messageType) {
        String sql = "select * from db_campus_message where user_id2=? and message_type = ?";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql, userId,messageType);
        List<Message> list = new ArrayList<>();
        try {
            while(resultSet.next()){
                int messageId=resultSet.getInt("message_id");
                int userId1=resultSet.getInt("user_id1");
                int userId2=resultSet.getInt("user_id2");
                int messageType2=resultSet.getInt("message_type");
                String messageContent=resultSet.getString("message_content");
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                System.out.println(resultSet.getTimestamp("gmt_create"));
                System.out.println(gmt_create);
                Message message=new Message(messageId,userId1,userId2,messageType2,messageContent,gmt_create);
                list.add(message);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
