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
import java.io.IOException;
import java.util.List;

//查看邀请记录
@WebServlet(name = "CheckTargetInviteServlet",urlPatterns = "/checkTargetInvite")
public class CheckTargetInviteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //      测试：登录存入用户数据
        User user = new User(2);
        int clock_in_target_id = Integer.parseInt(req.getParameter("clock_in_target_id"));

        TargetService targetService = new TargetServiceImpl();
        //调用DAO
        List<Clock_in_invite> inviteList = targetService.checkTargetInvite(clock_in_target_id);
        //将动态集合以json形式传给前端
        Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd HH:mm:ss").create();
        String json = gson.toJson(inviteList);
        resp.getWriter().write(json);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
