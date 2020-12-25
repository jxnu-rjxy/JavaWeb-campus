package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Dynamic;
import cn.edu.jxnu.rj.domain.Mutual;

import java.util.List;

public interface MutualDao {
    List<Mutual> findByUserId(int user_id);//查找某一用户的所有互助项目
    Mutual findById(int mutual_id);//查看某一互助项目
    int InsertMutual(Mutual mutual);//发表互助项目
    void deleteMutual(int mutual_id);//删除互助项目

}
