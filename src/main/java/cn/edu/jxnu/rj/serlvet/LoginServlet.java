package cn.edu.jxnu.rj.serlvet;

import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.Impl.UserServiceImpl;
import cn.edu.jxnu.rj.service.UserService;
import cn.edu.jxnu.rj.util.TokenUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "LoginServlet",urlPatterns = "/login")
/**
 * 登录
 * 获取账户密码
 * 回传token和用户基本信息
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从前端表单获取的账号密码
        String user_phone = request.getParameter("userPhone");
        String user_password =  request.getParameter("userPassword");
        System.out.println("手机号："+user_phone+"密码："+user_password);
        //调用业务层代码进行登录
        UserService userService = new UserServiceImpl();
        User user = userService.login(user_phone,user_password);
        if(user==null){
            response.setStatus(401);
        }else {//向前端回传
            String token = TokenUtils.token(user.getUserPhone());
            user.setUserPassword("");
            user.setUserRealName("");
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
            String json = gson.toJson(user);
            response.setHeader("Authorization",token);
            System.out.println("用户："+json);
            response.getWriter().write(json);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
