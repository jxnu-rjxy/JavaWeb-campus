package cn.edu.jxnu.rj.serlvet.replyServlet;

import cn.edu.jxnu.rj.domain.Reply;
import cn.edu.jxnu.rj.service.Impl.ReplyServiceImpl;
import cn.edu.jxnu.rj.service.ReplyService;

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
        int userId = Integer.parseInt(request.getParameter("userId"));

        ReplyService replyService = new ReplyServiceImpl();
        replyService.reply(new Reply(commentId,replyContent,userId));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
