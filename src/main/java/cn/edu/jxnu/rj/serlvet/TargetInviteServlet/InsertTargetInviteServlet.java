package cn.edu.jxnu.rj.serlvet.targetInviteServlet;

import cn.edu.jxnu.rj.domain.Clock_in_invite;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.Impl.TargetServiceImpl;
import cn.edu.jxnu.rj.service.TargetService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "InsertTargetInviteServlet",urlPatterns = "/insertTargetInvite")
public class InsertTargetInviteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从session中获取用户信息
        HttpSession session = req.getSession();
        User user1 = new User(2);
        session.setAttribute("user", user1);

        //发起组队
        User user = (User) session.getAttribute("user");
        int user_id1 = Integer.parseInt(req.getParameter("user_id1"));
        int user_id2 = Integer.parseInt(req.getParameter("user_id2"));
        int clock_in_target_id = Integer.parseInt(req.getParameter("clock_in_target_id"));

        TargetService targetService = new TargetServiceImpl();
        int invite = targetService.insertinvite(new Clock_in_invite(user_id1,user_id2,clock_in_target_id));


        /*将发表的动态传给前端显示*/
        Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd HH:mm:ss").create();
        String json = gson.toJson(invite);
        resp.getWriter().write(json);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

}
