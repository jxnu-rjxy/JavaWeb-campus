package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Message;

import java.util.List;

public interface MessageDao {
        int insert(Message message);  //插入消息
        List<Message> select(int userId,int messageType);  //查看用户的点赞/评论/回复/关注/通知
        List<Message> selectComment(int userId);
}
