package cn.edu.jxnu.rj.serlvet.dynamicServlet;

import cn.edu.jxnu.rj.dao.UserDao;
import cn.edu.jxnu.rj.dao.impl.UserDaoImpl;
import cn.edu.jxnu.rj.domain.Dynamic;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.DynamicService;
import cn.edu.jxnu.rj.service.Impl.DynamicServiceImpl;
import cn.edu.jxnu.rj.util.FileUpload;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

//发表动态
@WebServlet(name = "PublishDynamicServlet",urlPatterns="/postDynamic")
public class PostDynamicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        String dynamicContent = null;
        int mediaId = 0;
        int dynamicStatus = 0;
        System.out.println("正在发布。。。。");
        //      测试：登录存入用户数据
        //从session中获取用户信息
        HttpSession session = request.getSession();
        User user1 = new User(2);
        session.setAttribute("user", user1);

        //获取动态内容
        FileUpload fileUpload = new FileUpload(request);
        Map<String, Object> formText = fileUpload.getFormText();
        for(Map.Entry<String,Object> entry : formText.entrySet()){
            if(entry.getKey().equals("dynamicContent")){
                dynamicContent = (String) entry.getValue();
            }
            if(entry.getKey().equals("dynamicStatus")){
                if(entry.getValue().toString().equals("on")){
                    dynamicStatus = 1;
                }
            }
        }
        System.out.println(dynamicContent+"===="+dynamicStatus);
        User user = (User) session.getAttribute("user");
        DynamicService dynamicService = new DynamicServiceImpl();
        Dynamic dynamic = dynamicService.post(new Dynamic(user.getUser_id(), dynamicContent, 0, dynamicStatus, fileUpload.getImagePath()));
        UserDao userDao = new UserDaoImpl();
        User userDaoById = userDao.findById(user.getUser_id());
        /*将发表的动态传给前端显示*/
        Gson gson = new Gson();
        String json = gson.toJson(dynamic);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
