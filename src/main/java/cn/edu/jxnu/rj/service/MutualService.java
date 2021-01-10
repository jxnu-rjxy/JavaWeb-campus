package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.*;

import java.util.List;

public interface MutualService {
    int post(Mutual mutual);//发起互助项目
    List<Mutual> check(int user_id);//查看某一用户所有互助项目
    void delete(int mutual_Id);//删除互助项目
    Mutual checkone(int mutual_id);//查看某一互助项目
    List<Mutual> checkAll(int toNum, int fromNum);//查询最近num条互助项目

    List<Mutual_group_recard> checkallrecard (int user_id);//查看用户所有组队记录
    int postgrouprequest (int user_id ,int mutual_id);//发起组队申请

    List<Mutual_member> checkMutualmember (int mutual_id);
    void deletemember(int user_Id,int mutual_id);//删除互助成员
    int insertmember(Mutual_member mutual_member);//添加互助成员

    List<Group_chat> checkGroupchat (int mutual_id);//查看项目所有聊天记录
    int insertchat (Group_chat group_chat);//发送聊天记录
}
