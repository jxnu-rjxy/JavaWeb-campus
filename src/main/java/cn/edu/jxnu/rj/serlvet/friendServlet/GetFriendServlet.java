package cn.edu.jxnu.rj.serlvet.friendServlet;

import cn.edu.jxnu.rj.domain.Follow;
import cn.edu.jxnu.rj.domain.Friend;
import cn.edu.jxnu.rj.service.FriendService;
import cn.edu.jxnu.rj.service.Impl.FriendServiceImpl;
import com.google.gson.Gson;

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
        int friendType = Integer.parseInt(request.getParameter("friendType"));
        int userId = Integer.parseInt(request.getParameter("userId"));

        FriendService friendService = new FriendServiceImpl();
        List<Follow> follow = friendService.query(friendType, userId);

        response.getWriter().write(new Gson().toJson(follow));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
