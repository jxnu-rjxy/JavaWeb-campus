package cn.edu.jxnu.rj.util;

import cn.edu.jxnu.rj.domain.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileUpload {
    private DiskFileItemFactory factory;
    private ServletFileUpload upload;
    List<FileItem> fileItems;
    Map<String,Object> textItem = new HashMap<>();
    String path = null;
    public FileUpload(HttpServletRequest request) {
         factory = new DiskFileItemFactory();//创建工厂
         upload = new ServletFileUpload(factory);//创建解析器
        User user = (User) request.getSession().getAttribute("user");
        try {
            fileItems = upload.parseRequest(request);//使用解析器解析request对象
            System.out.println("开始循环遍历文件============》");
            for (FileItem item : fileItems) {
                String itemName = item.getName();//获取字段名
                System.out.println("当前字段名"+itemName);
                String itemString = item.getString("utf-8");//获取字段内容
                if (item.isFormField()) {//如果是普通表单，即文字非图片
                    System.out.println(item.getFieldName()+"==========>"+itemString);
                    textItem.put(item.getFieldName(),itemString);//将内容存入map
                } else {//如果是图片
                    String suffix = itemName.substring(itemName.lastIndexOf("."));//获取文件后缀名
                    itemName = UUID.randomUUID().toString()+suffix;//设置文件随机名
                    String uploadPath = request.getSession().getServletContext().getRealPath("/upload");//获取项目路径
                    Calendar calendar = Calendar.getInstance();
                    int year = calendar.get(Calendar.YEAR);
                    int day = calendar.get(Calendar.DATE);
                    int month = calendar.get(Calendar.MONTH)+1;
                    String filePath = year+"\\"+year+"."+month+"\\"+year+"."+month+"."+day+"\\"+user.getUser_id();//设置文件路径
                    File file = new File(filePath);
                    //是否存在/upload/2020/2020.12/2020.12.17这个文件夹
                    if(!file.exists()) file.mkdirs();
                    item.write(new File(uploadPath+"\\"+filePath,itemName));//写入文件到磁盘
                    int dynamicId =0;
                    path = filePath+"\\"+itemName;
                    System.out.println(path);
                }
            }
        } catch (FileUploadException | IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Map<String, Object> getFormText(String...name){
        return textItem;
    }
    public String getImagePath(){
        return path;
    }
}
