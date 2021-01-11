package cn.edu.jxnu.rj.serlvet.giveLikeServlet;

import cn.edu.jxnu.rj.domain.Givelike;
import cn.edu.jxnu.rj.service.GiveLikeService;
import cn.edu.jxnu.rj.service.Impl.GiveLikeServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GiveLikeServlet",urlPatterns = "/giveLike")
public class GiveLikeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("userId"));
        int workType = Integer.parseInt(request.getParameter("workType"));
        int workId = Integer.parseInt(request.getParameter("workId"));

        GiveLikeService giveLikeService = new GiveLikeServiceImpl();
        Givelike givelike = new Givelike(workId, workType, userId);
        System.out.println("点赞："+givelike);
        boolean like = giveLikeService.like(givelike);
        System.out.println("like:"+like);
        response.getWriter().write(new Gson().toJson(like));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
