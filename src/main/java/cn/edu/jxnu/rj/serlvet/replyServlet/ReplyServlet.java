package cn.edu.jxnu.rj.serlvet.replyServlet;

import cn.edu.jxnu.rj.domain.Reply;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.Impl.ReplyServiceImpl;
import cn.edu.jxnu.rj.service.Impl.UserServiceImpl;
import cn.edu.jxnu.rj.service.ReplyService;
import cn.edu.jxnu.rj.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReplyServlet",urlPatterns = "/reply")
public class ReplyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取数据
        int commentId = Integer.parseInt(request.getParameter("commentId"));
        String replyContent = request.getParameter("replyContent");
        int userId1 = Integer.parseInt(request.getParameter("userId1"));
        int userId2 = Integer.parseInt(request.getParameter("userId2"));

        UserService userService = new UserServiceImpl();
        User user1 = userService.findById(userId1);
        User user2 = userService.findById(userId2);
        System.out.println(user1);
        System.out.println(user2);
        ReplyService replyService = new ReplyServiceImpl();
        replyService.reply(new Reply(commentId,replyContent,userId1,userId2,user1.getUserName(),user2.getUserName()));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
