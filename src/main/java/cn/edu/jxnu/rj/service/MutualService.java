package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.Group_chat;
import cn.edu.jxnu.rj.domain.Mutual;
import cn.edu.jxnu.rj.domain.Mutual_group_recard;
import cn.edu.jxnu.rj.domain.Mutual_member;

import java.util.List;

public interface MutualService {
    Mutual post(Mutual mutual);//发起互助项目
    List<Mutual> check(int user_id);//查看互助项目
    void delete(int mutual_Id);//删除互助项目
//    List<Mutual> apply(int user_id, int mutual_id);//用户申请加入互助项目

    List<Mutual_group_recard> checkallrecard (int user_id);//查看用户所有组队记录
    int postgrouprequest (int user_id ,int mutual_id);//发起组队申请

    List<Mutual_member> checkMutualmember (int mutual_id);
    void deletemember(int user_Id,int mutual_id);//删除互助成员
    int insertmember(Mutual_member mutual_member);//添加互助成员

    List<Group_chat> checkGroupchat (int mutual_id);//查看项目所有聊天记录
    int insertchat (Group_chat group_chat);//发送聊天记录
}
