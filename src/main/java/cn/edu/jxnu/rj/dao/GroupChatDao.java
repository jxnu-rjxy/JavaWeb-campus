package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Group_chat;

import java.util.List;

public interface GroupChatDao {
    List<Group_chat> findByMutualId(int mutual_id);//查找项目所有聊天记录
    int InsertGroupchat(Group_chat group_chat);//发送聊天信息
}
