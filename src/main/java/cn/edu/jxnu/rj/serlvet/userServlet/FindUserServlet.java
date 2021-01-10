package cn.edu.jxnu.rj.serlvet.userServlet;

import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.Impl.UserServiceImpl;
import cn.edu.jxnu.rj.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 查找用户
 */
@WebServlet(name = "FindUserServlet",urlPatterns = "/findUser")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        UserService userService = new UserServiceImpl();
        User user = userService.findById(userId);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String json = gson.toJson(user);
        response.getWriter().write(json);
        System.out.println(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
