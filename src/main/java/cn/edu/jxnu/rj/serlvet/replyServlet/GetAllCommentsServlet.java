package cn.edu.jxnu.rj.serlvet.replyServlet;

import cn.edu.jxnu.rj.domain.Reply;
import cn.edu.jxnu.rj.service.Impl.ReplyServiceImpl;
import cn.edu.jxnu.rj.service.ReplyService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllCommentsServlet",urlPatterns = "/getAllReply")
public class GetAllCommentsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int commentId = Integer.parseInt(request.getParameter("commentId"));

        ReplyService replyService = new ReplyServiceImpl();
        List<Reply> replyList = replyService.getAllInComment(commentId);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd hh:mm:ss").create();
        String json = gson.toJson(replyList);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
