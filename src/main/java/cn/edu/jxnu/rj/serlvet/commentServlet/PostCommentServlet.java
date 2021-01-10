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

@WebServlet(name = "PostCommentServlet",urlPatterns = "/postComment")
public class PostCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取数据
        int workId = Integer.parseInt(request.getParameter("workId"));
        int workType = Integer.parseInt(request.getParameter("workType"));
        String commentContent = request.getParameter("commentContent");
        int userId = Integer.parseInt(request.getParameter("userId"));

        //插入评论
        CommentService commentService = new CommentServiceImpl();
        Comment c  = new Comment(workId, workType,userId, commentContent);
        System.out.println("评论内容："+c);
        Comment comment = commentService.add(c);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String json = gson.toJson(comment);
        System.out.println(json);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
