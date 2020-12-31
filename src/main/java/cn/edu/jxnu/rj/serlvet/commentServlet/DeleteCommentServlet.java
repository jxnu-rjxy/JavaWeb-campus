package cn.edu.jxnu.rj.serlvet.commentServlet;

import cn.edu.jxnu.rj.service.CommentService;
import cn.edu.jxnu.rj.service.Impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户删除评论
 */
@WebServlet(name = "DeleteCommentServlet",urlPatterns = "/deleteComment")
public class DeleteCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int commentId = Integer.parseInt(request.getParameter("commentId"));

        CommentService commentService = new CommentServiceImpl();
        commentService.delete(commentId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
