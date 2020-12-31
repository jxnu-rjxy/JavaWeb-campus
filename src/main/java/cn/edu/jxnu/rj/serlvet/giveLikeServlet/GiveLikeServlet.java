package cn.edu.jxnu.rj.serlvet.giveLikeServlet;

import cn.edu.jxnu.rj.domain.Givelike;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.GiveLikeService;
import cn.edu.jxnu.rj.service.Impl.GiveLikeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GiveLikeServlet",urlPatterns = "/giveLike")
public class GiveLikeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //模拟用户登录
        request.getSession().setAttribute("user",new User(2));

        User user = (User) request.getSession().getAttribute("user");
        int workType = Integer.parseInt(request.getParameter("workType"));
        int workId = Integer.parseInt(request.getParameter("workId"));

        GiveLikeService giveLikeService = new GiveLikeServiceImpl();
        giveLikeService.like(new Givelike(workId,workType,user.getUser_id()));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
