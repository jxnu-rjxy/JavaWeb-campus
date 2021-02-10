package cn.edu.jxnu.rj.serlvet.dynamicServlet;

import cn.edu.jxnu.rj.domain.Dynamic;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.DynamicService;
import cn.edu.jxnu.rj.service.Impl.DynamicServiceImpl;
import cn.edu.jxnu.rj.service.Impl.UserServiceImpl;
import cn.edu.jxnu.rj.service.UserService;
import cn.edu.jxnu.rj.util.FileUpload;
import cn.edu.jxnu.rj.util.FileUploadUtil;
import cn.edu.jxnu.rj.util.FileUploadUtilImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * 用户发表动态,动态表插入记录
 *p
 */
@WebServlet(name = "postDynamicServlet",urlPatterns="/postDynamic")
public class PostDynamicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileUploadUtil fileUploadUtil = new FileUploadUtilImpl(request);//解析文件流
        Map<String, Object> items = fileUploadUtil.getItems();//获取表单字段
        int userId = Integer.parseInt(items.get("userId").toString());

        //获取当前时间
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH)+1;

        //设置文件夹径2020/2020.12/2020.12.17/userId
        String filePath = year+"/"+year+"."+month+"/"+year+"."+month+"."+day+"/"+userId;

        //保存图片并获取图片路径
        String path = "upload/"+filePath+"/";
        List<String> pathList = fileUploadUtil.saveImage(path);

        //解析表单字段数据
        int dynamicStatus = Integer.parseInt(items.get("dynamicStatus").toString());
        String dynamicContent = items.get("dynamicContent").toString();

        //封装成dynamic对象并插入
        UserService userService = new UserServiceImpl();
        User user = userService.findById(userId);
        DynamicService dynamicService = new DynamicServiceImpl();
        dynamicService.post(new Dynamic(userId,user.getUserName(),user.getUserSchool(),dynamicContent,dynamicStatus,pathList));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
