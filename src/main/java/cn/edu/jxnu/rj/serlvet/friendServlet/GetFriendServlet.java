package cn.edu.jxnu.rj.serlvet.friendServlet;

import cn.edu.jxnu.rj.domain.Follow;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.FriendService;
import cn.edu.jxnu.rj.service.Impl.FriendServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetFriendServlet",urlPatterns = "/getFriend")
public class GetFriendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");

        FriendService friendService = new FriendServiceImpl();
        List<User> friends = friendService.getFriends(userId);
        System.out.println(friends);
        response.getWriter().write(new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(friends));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
