package cn.edu.jxnu.rj.service.Impl;

import cn.edu.jxnu.rj.dao.DynamicDao;
import cn.edu.jxnu.rj.dao.impl.DynamicDaoImpl;
import cn.edu.jxnu.rj.domain.Dynamic;
import cn.edu.jxnu.rj.service.DynamicService;

import java.io.File;
import java.util.List;

public class DynamicServiceImpl implements DynamicService {
    DynamicDao dynamicDao = new DynamicDaoImpl();

    @Override
    public Dynamic post(Dynamic dynamic) {
        int id = dynamicDao.InsertDynamic(dynamic);//用户发表动态
        System.out.println("刚刚插入的记录id是"+id);
        return dynamicDao.findById(id);
    }
    @Override
    public List<Dynamic> check(int user_id) {
        return dynamicDao.findByUserId(user_id);
    }

    @Override
    public void delete(int dynamicId,String path) {
        Dynamic dynamic = dynamicDao.findById(dynamicId);
        String image_path = dynamic.getImage_path();
        System.out.println("图片路径"+image_path);
        if(image_path!=null){
            System.out.println(image_path);
            File file = new File(path+"\\"+image_path.substring(6));
            System.out.println("要删除的文件是:"+path+"\\"+image_path);
            if(file.exists()){
                file.delete();
            }else {
                System.out.println("文件不存在！");
            }
        }
        dynamicDao.deleteDynamic(dynamicId);
        System.out.println("删除成功！");
    }
}
