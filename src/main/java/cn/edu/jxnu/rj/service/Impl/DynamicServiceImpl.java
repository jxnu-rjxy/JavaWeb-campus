package cn.edu.jxnu.rj.service.Impl;

import cn.edu.jxnu.rj.dao.CommentDao;
import cn.edu.jxnu.rj.dao.DynamicDao;
import cn.edu.jxnu.rj.dao.MessageDao;
import cn.edu.jxnu.rj.dao.impl.CommentDaoImpl;
import cn.edu.jxnu.rj.dao.impl.DynamicDaoImpl;
import cn.edu.jxnu.rj.dao.impl.MessageDaoImpl;
import cn.edu.jxnu.rj.domain.Comment;
import cn.edu.jxnu.rj.domain.Dynamic;
import cn.edu.jxnu.rj.domain.Message;
import cn.edu.jxnu.rj.service.DynamicService;

import java.io.File;
import java.util.List;

public class DynamicServiceImpl implements DynamicService {
    DynamicDao dynamicDao = new DynamicDaoImpl();

    @Override
    public Dynamic post(Dynamic dynamic) {
        int id = dynamicDao.InsertDynamic(dynamic);//用户发表动态
        System.out.println("刚刚插入的记录id是"+id);
        return dynamicDao.findById(id,0);
    }
    @Override
    public List<Dynamic> check(int user_id) {
        return dynamicDao.findByUserId(user_id);
    }

    @Override
    public List<Dynamic> checkAll(int toNum,int fromNum,int userId) {
        return dynamicDao.findAll(toNum,fromNum,userId);
    }

    @Override
    public void delete(int dynamicId,String path) {
        Dynamic dynamic = dynamicDao.findById(dynamicId,0);
        List<String> image_path = dynamic.getImagePath();
        System.out.println("图片路径"+image_path);
        for (int i = 0; i < image_path.size() ; i++) {
            if(image_path.get(i)!=null){
                System.out.println(image_path.get(i));
                File file = new File(path+"\\"+image_path.get(i).substring(6));
                System.out.println("要删除的文件是:"+path+"\\"+image_path);
                if(file.exists()){
                    file.delete();
                }else {
                    System.out.println("文件不存在！");
                }
            }
        }

        dynamicDao.deleteDynamic(dynamicId);
        System.out.println("删除成功！");
    }

    @Override
    public Dynamic findById(int DynamicId,int userId) {
        return dynamicDao.findById(DynamicId,userId);
    }
}
