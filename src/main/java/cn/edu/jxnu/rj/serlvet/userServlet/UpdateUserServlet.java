package cn.edu.jxnu.rj.serlvet.userServlet;

import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.Impl.UserServiceImpl;
import cn.edu.jxnu.rj.service.UserService;
import cn.edu.jxnu.rj.util.FileUploadUtil;
import cn.edu.jxnu.rj.util.FileUploadUtilImpl;
import com.google.gson.GsonBuilder;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UpdateUserServlet",urlPatterns = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileUploadUtil fileUploadUtil = new FileUploadUtilImpl(request);
        Map<String, Object> items = fileUploadUtil.getItems();
        int userId = Integer.parseInt(items.get("userId").toString());

        //保存图片
        String path = "user/headImage/"+userId+"/";
        List<String> pathList = fileUploadUtil.saveImage(path);
        String imageName = null;
        if(pathList.size()>0){
            imageName = pathList.get(0);
        }

        //从解析出的表单项中提取信息
        String userName = items.get("userName").toString();
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date userBirthday = null;
        try {
            userBirthday = simpleDateFormat.parse(items.get("userBirthday").toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String userProvince = items.get("userProvince").toString();
        String userCity = items.get("userCity").toString();
        int userEmotionStatus = Integer.parseInt(items.get("userEmotionStatus").toString());
        String userSignature = items.get("userSignature").toString();
        String userDept = items.get("userDept").toString();
        String userMajor = items.get("userMajor").toString();
        //封装成user对象
        User user = new User(userId, userName , userBirthday , userProvince , userCity ,userEmotionStatus  ,userSignature ,userDept, userMajor,imageName);

        UserService userService = new UserServiceImpl();
        User updateUser = userService.update(user);

        //将最新的数据返回给前端
        response.getWriter().write(new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(updateUser));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
