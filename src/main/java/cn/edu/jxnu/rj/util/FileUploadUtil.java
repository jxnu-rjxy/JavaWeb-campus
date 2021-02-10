package cn.edu.jxnu.rj.util;

import java.util.List;
import java.util.Map;

public interface FileUploadUtil {
    List<String> saveImage(String path);//保存图片到指定位置,并返回包含文件名的路径
    Map<String,Object> getItems();//获取普通表单数据
}
