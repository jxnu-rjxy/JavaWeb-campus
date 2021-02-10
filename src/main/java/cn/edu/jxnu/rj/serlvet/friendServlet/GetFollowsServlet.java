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
/*关注好友*/
@WebServlet(name = "GetFollowsServlet",urlPatterns = "/getFollow")
public class GetFollowsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId1 = Integer.parseInt(request.getParameter("userId1"));
        int userId2 = Integer.parseInt(request.getParameter("userId2"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
