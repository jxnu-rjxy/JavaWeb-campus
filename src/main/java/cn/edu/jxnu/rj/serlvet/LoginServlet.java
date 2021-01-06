package cn.edu.jxnu.rj.serlvet;

import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.Impl.UserServiceImpl;
import cn.edu.jxnu.rj.service.UserService;
import cn.edu.jxnu.rj.util.TokenUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从前端表单获取的账号密码
        String user_phone = request.getParameter("user_phone");
        String user_password =  request.getParameter("user_password");
        System.out.println("手机号："+user_phone+"密码："+user_password);
        //调用业务层代码进行登录
        UserService userService = new UserServiceImpl();
        User user = userService.login(user_phone,user_password);

        if(user==null){
            System.out.println("错误");
        }else {//向前端回传
            String token = TokenUtils.token(user.getUser_phone(),user_password);
//            response.getWriter().write(token);
            Map<String,Object> map = new HashMap<>();
            map.put("token",token);
            map.put("user",user);
            Gson gson = new Gson();
            String json = gson.toJson(map);
            response.getWriter().write(json);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
