package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.*;
import cn.edu.jxnu.rj.domain.*;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements MessageDao {

    @Override
    public int insert(Message message) {
        String sql = "insert into db_campus_message(user_id1,user_id2,message_type,message_content,message_linkId,message_linkType,user_name1,user_name2) values(?,?,?,?,?,?,?,?);";
        Jdbc jdbc=new Jdbc();
        int messageId = jdbc.executeUpdate(sql,message.getUserId1(),message.getUserId2(),message.getMessageType(),message.getMessageContent(),message.getMessageLinkId(),message.getMessageLinkType(),message.getUserName1(),message.getUserName2());
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
                int messageLinkId = resultSet.getInt("message_linkId");
                int messageLinkType = resultSet.getInt("message_linkType");
                String userName1 = resultSet.getString("user_name1");
                String userName2 = resultSet.getString("user_name2");
                System.out.println(resultSet.getTimestamp("gmt_create"));
                System.out.println(gmt_create);
                Message message=new Message(messageId,userId1,userId2,messageType2,messageContent,gmt_create,messageLinkId,messageLinkType,userName1,userName2);
                if(messageLinkType == 0){
                    DynamicDao dynamicDao = new DynamicDaoImpl();
                    Dynamic dynamic = dynamicDao.findById(messageLinkId, userId1);
                    message.setObject(dynamic);
                }else if(messageLinkType == 1){
                    CommentDao commentDao = new CommentDaoImpl();
                    Comment comment = commentDao.findById(messageLinkId);
                    message.setObject(comment);
                }else if(messageLinkType == 2){
                    ReplyDao replyDao = new ReplyDaoImpl();
                    Reply reply = replyDao.findByid(messageLinkId);
                    message.setObject(reply);
                }else{
                    ConfessionDao confessionDao = new ConfessionDaoImpl();
                    Confession confession = confessionDao.findById(messageLinkId);
                    message.setObject(confession);
                }
                System.out.println("message"+message);
                list.add(message);
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
    public List<Message> selectComment(int userId) {
        String sql = "select * from db_campus_message where user_id2=? and ( message_type = 1 or message_type =  2)";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql, userId);
        List<Message> list = new ArrayList<>();
        try {
            while(resultSet.next()){
                int messageId=resultSet.getInt("message_id");
                int userId1=resultSet.getInt("user_id1");
                int userId2=resultSet.getInt("user_id2");
                int messageType2=resultSet.getInt("message_type");
                String messageContent=resultSet.getString("message_content");
                Timestamp gmt_create = resultSet.getTimestamp("gmt_create");
                int messageLinkId = resultSet.getInt("message_linkId");
                int messageLinkType = resultSet.getInt("message_linkType");
                String userName1 = resultSet.getString("user_name1");
                String userName2 = resultSet.getString("user_name2");
                System.out.println(resultSet.getTimestamp("gmt_create"));
                System.out.println(gmt_create);
                Message message=new Message(messageId,userId1,userId2,messageType2,messageContent,gmt_create,messageLinkId,messageLinkType,userName1,userName2);

                if(messageLinkType == 0){
                    DynamicDao dynamicDao = new DynamicDaoImpl();
                    Dynamic dynamic = dynamicDao.findById(messageLinkId, userId1);
                    message.setObject(dynamic);
                }else if(messageLinkType == 1){
                    CommentDao commentDao = new CommentDaoImpl();
                    Comment comment = commentDao.findById(messageLinkId);
                    message.setObject(comment);
                    System.out.println("comment:"+comment);
                }else if(messageLinkType == 2){
                    ReplyDao replyDao = new ReplyDaoImpl();
                    Reply reply = replyDao.findByid(messageLinkId);
                    message.setObject(reply);
                }else{
                    ConfessionDao confessionDao = new ConfessionDaoImpl();
                    Confession confession = confessionDao.findById(messageLinkId);
                    message.setObject(confession);
                }
                System.out.println("message"+message);
                list.add(message);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbc.close();
        }
        return null;
    }


}
