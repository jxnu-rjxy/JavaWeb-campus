package cn.edu.jxnu.rj.serlvet.commentServlet;

import cn.edu.jxnu.rj.domain.Comment;
import cn.edu.jxnu.rj.service.CommentService;
import cn.edu.jxnu.rj.service.Impl.CommentServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 查找某条动态/表白墙下的所有评论
 */
@WebServlet(name = "CheckCommentServlet",urlPatterns = "/checkComment")
public class CheckCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //获取评论信息
        int workId = Integer.parseInt(request.getParameter("workId"));
        int workType = Integer.parseInt(request.getParameter("workType"));
        CommentService commentService = new CommentServiceImpl();
        List<Comment> comments = commentService.getAllByWorkId(workType,workId);

        //将以json形式传给前端
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String json = gson.toJson(comments);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
