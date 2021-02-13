package cn.edu.jxnu.rj.serlvet.friendServlet;

import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.FriendService;
import cn.edu.jxnu.rj.service.Impl.FriendServiceImpl;
import cn.edu.jxnu.rj.service.Impl.UserServiceImpl;
import cn.edu.jxnu.rj.service.UserService;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FollowServlet",urlPatterns = "/follow")
public class FollowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String followId = request.getParameter("followId");

        FriendService friendService = new FriendServiceImpl();
        friendService.follow(userId,followId);

        UserService userService = new UserServiceImpl();
        User user = userService.findById(Integer.parseInt(userId));

        response.getWriter().write(new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(user));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
