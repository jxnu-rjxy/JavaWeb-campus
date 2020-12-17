package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.User;

public interface UserService {
    User login(String user_phone, String user_password);//登录
    void logout(int user_id);//注销
    void updateSchool(int user_id,String user_school,String user_dept,String user_major,String user_grade);//更新学校信息
    void updateSignature(int user_id,String user_signature);//更新个性签名
    void updateEmotion(int user_id,int user_emotion_status);//更新感情状态
    void updateMatch(int user_id,int user_match_status);//
}
