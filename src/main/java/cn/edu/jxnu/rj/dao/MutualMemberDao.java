package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Group_member;
import cn.edu.jxnu.rj.domain.Mutual;
import cn.edu.jxnu.rj.domain.Mutual_member;

import java.util.List;

public interface MutualMemberDao {
    List<Group_member> findByUserId(int user_id);//查找所有组队成员
    Mutual findById(int mutual_id);
    int Insert(Mutual_member mutual_member);//发表组队成员
    void delete(int mutual_id);//删除组队成员
}
