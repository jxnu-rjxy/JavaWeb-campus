package cn.edu.jxnu.rj.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class FileUploadUtilImpl implements FileUploadUtil {
    HttpServletRequest request = null;
    DiskFileItemFactory factory = null;
    ServletFileUpload upload = null;
    List<FileItem> fileItems = null;
    public FileUploadUtilImpl(HttpServletRequest request) {
        this.request = request;
        factory = new DiskFileItemFactory();
        upload = new ServletFileUpload(factory);
        try {
            fileItems = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> saveImage(String path) {
        List<String> list = new ArrayList<>();
        try {
            for (FileItem fileItem : fileItems){
                if(!fileItem.isFormField()){
                    String suffix = fileItem.getName().substring(fileItem.getName().lastIndexOf("."));//获取文件后缀名
                    String fileName = UUID.randomUUID().toString()+suffix;//设置文件随机名

                    //获取项目路径
                    String prefix = request.getSession().getServletContext().getRealPath("/");
                    //完整文件路径，不包括文件名
                    String absolutePath = prefix + path;

                    //如果文件夹不存在则创建
                    File file = new File(absolutePath);
                    if(!file.exists()){
                        file.mkdirs();
                    }
                    list.add(path+fileName);
                    System.out.println("完整图片路径："+absolutePath+fileName);
                    fileItem.write(new File(absolutePath,fileName));
                }
            }
            return list;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<String, Object> getItems() {
        Map<String, Object> map = new HashMap<>();
        System.out.println("开始遍历表单项：=======================》");
        try {
            for (FileItem fileItem : fileItems){
                if(fileItem.isFormField()){
                    String name = fileItem.getFieldName();//获取表单项的name
                    String value = fileItem.getString("utf-8");//获取表单项的value
                    System.out.println(name+":"+value);
                    map.put(name,value);
                }
            }
            System.out.println("遍历完成：=======================》");
            return map;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
