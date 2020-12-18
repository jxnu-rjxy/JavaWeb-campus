package cn.edu.jxnu.rj.serlvet;

import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.Impl.UserServiceImpl;
import cn.edu.jxnu.rj.service.UserService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符编码
        System.out.println("这是登录验证");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //从前端表单获取的账号密码
        String user_phone = request.getParameter("user_phone");
        String user_password =  request.getParameter("user_password");
        User user = new User(user_phone,user_password);

        //调用业务层代码进行登录
        UserService userService = new UserServiceImpl();
        User user1 = userService.login(user_phone,user_password);
        if(user1==null){
            System.out.println("错误");
        }else {//向前端回传
            Gson gson = new Gson();
            String json = gson.toJson(user1);
            response.getWriter().write(json);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
