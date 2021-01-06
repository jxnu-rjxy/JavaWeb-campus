package cn.edu.jxnu.rj.serlvet.friendServlet;

import cn.edu.jxnu.rj.domain.Friend;
import cn.edu.jxnu.rj.service.FriendService;
import cn.edu.jxnu.rj.service.Impl.FriendServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "followServlet",urlPatterns = "/follow")
public class FollowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId1 = Integer.parseInt(request.getParameter("userId1"));
        int userId2 = Integer.parseInt(request.getParameter("userId2"));
        FriendService friendService = new FriendServiceImpl();
        friendService.add(new Friend(userId1,userId2,1,0));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
