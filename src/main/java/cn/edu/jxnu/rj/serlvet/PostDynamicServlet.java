package cn.edu.jxnu.rj.serlvet;

import cn.edu.jxnu.rj.domain.Dynamic;
import cn.edu.jxnu.rj.domain.Media;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.DynamicService;
import cn.edu.jxnu.rj.service.Impl.DynamicServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//发表动态
@WebServlet(name = "PublishDynamicServlet",urlPatterns = "postDynamic")
public class PostDynamicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String dynamic_content;
        int media_id;
        int dynamic_status;
        //获取动态内容及上传图片
        DiskFileItemFactory factory = new DiskFileItemFactory();//创建工厂
        ServletFileUpload upload = new ServletFileUpload(factory);//创建解析器
        try {
            List<FileItem> fileItems = upload.parseRequest(request);//使用解析器解析request对象
            for (FileItem item : fileItems){
                item.getName();
                if(item.isFormField()){//如果是普通表单，即文字非图片
                    String itemString = item.getString();
                    String itemFieldName = item.getFieldName();

                    if (itemFieldName.equals("dynamic_content")){
                        dynamic_content = itemString;
                    }else if(itemFieldName.equals(dynamic_status)){
                        dynamic_status = Integer.parseInt(itemString);
                    }

                }else {//如果是图片
                    String itemName = item.getName();
                    Media media = new Media();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }


//        int user_id,
        //从session中获取用户信息
        HttpSession session = request.getSession();
//      测试：登录存入用户数据
//      User user1 = new User(2);
//      session.setAttribute("user", user1);
        User user = (User) session.getAttribute("user");

        DynamicService dynamicService = new DynamicServiceImpl();
        dynamicService.post(new Dynamic(user.getUser_id(),dynamic_content,media_id,dynamic_status));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
