package cn.edu.jxnu.rj.service.Impl;

import cn.edu.jxnu.rj.dao.GroupChatDao;
import cn.edu.jxnu.rj.dao.MutualDao;
import cn.edu.jxnu.rj.dao.MutualGroupRecardDao;
import cn.edu.jxnu.rj.dao.MutualMemberDao;
import cn.edu.jxnu.rj.dao.impl.GroupChatDaoImpl;
import cn.edu.jxnu.rj.dao.impl.MutualDaoImpl;
import cn.edu.jxnu.rj.dao.impl.MutualGroupRecardDaoImpl;
import cn.edu.jxnu.rj.dao.impl.MutualMemberDaoImpl;
import cn.edu.jxnu.rj.domain.Group_chat;
import cn.edu.jxnu.rj.domain.Mutual;
import cn.edu.jxnu.rj.domain.Mutual_group_recard;
import cn.edu.jxnu.rj.domain.Mutual_member;
import cn.edu.jxnu.rj.service.MutualService;

import java.util.List;

public class MutualServiceImpl implements MutualService {
    MutualDao mutualDao = new MutualDaoImpl();
    @Override
    public Mutual post(Mutual mutual) {
        int id = mutualDao.InsertMutual(mutual);
        System.out.println("刚刚插入的记录id是"+id);

        return  mutualDao.findById(id);
    }

    @Override
    public List<Mutual> check(int user_id) {
        return mutualDao.findByUserId(user_id);
    }

    @Override
    public void delete(int mutual_Id) {
        mutualDao.deleteMutual(mutual_Id);
        System.out.println("删除成功！");
    }

    @Override
    public List<Mutual> apply(int user_id, int mutual_id) {
        return null;
    }

//组队记录
    MutualGroupRecardDao mutualGroupRecardDao = new MutualGroupRecardDaoImpl();

    @Override
    public List<Mutual_group_recard> checkallrecard(int user_id) {
        return mutualGroupRecardDao.findByUserId(user_id);
    }

    @Override
    public Mutual_group_recard postgrouprequest(Mutual_group_recard mutual_group_recard) {
        int id = mutualGroupRecardDao.Insert(mutual_group_recard);
        System.out.println("刚刚插入的记录id是"+id);

        return mutualGroupRecardDao.findById(id);
    }

//组队成员
    MutualMemberDao mutualMemberDao = new MutualMemberDaoImpl();
    @Override
    public List<Mutual_member> checkMutualmember(int mutual_id) {
        return mutualMemberDao.findByMutualId(mutual_id);
    }

    @Override
    public void deletemember(int user_id,int mutual_id) {
        mutualMemberDao.delete(user_id,mutual_id);
        System.out.println("删除成功！");
    }

    @Override
    public int insertmember(Mutual_member mutual_member) {
       return mutualMemberDao.Insert(mutual_member);
    }


//群聊记录
    GroupChatDao groupChatDao = new GroupChatDaoImpl();
        @Override
        public List<Group_chat> checkGroupchat(int mutual_id) {
            return groupChatDao.findByMutualId(mutual_id);
        }

        @Override
        public int insertchat(Group_chat group_chat) {
            return groupChatDao.InsertGroupchat(group_chat);
        }
}
