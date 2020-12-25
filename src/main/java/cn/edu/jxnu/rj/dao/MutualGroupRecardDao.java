package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Mutual;
import cn.edu.jxnu.rj.domain.Mutual_group_recard;

import java.util.List;

public interface MutualGroupRecardDao {
    List<Mutual_group_recard> findByUserId(int user_id);//查找某一用户的所有组队申请
    int Insert(Mutual_group_recard mutual_group_recard);//发起组队申请
    Mutual_group_recard findById(int user_id);
}
