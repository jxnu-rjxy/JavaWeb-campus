package cn.edu.jxnu.rj.serlvet.replyServlet;

import cn.edu.jxnu.rj.service.ReplyService;
import cn.edu.jxnu.rj.service.Impl.ReplyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteReplyServlet",urlPatterns = "/deleteReply")
public class DeleteReplyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int replyId = Integer.parseInt(request.getParameter("replyId"));

        ReplyService replyService = new ReplyServiceImpl();
        replyService.deleteReply(replyId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
