package cn.edu.jxnu.rj.serlvet.targetMemberServlet;

import cn.edu.jxnu.rj.domain.Clock_in_member;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.Impl.TargetServiceImpl;
import cn.edu.jxnu.rj.service.TargetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//添加打卡成员
@WebServlet(name = "InsertTargetMemberServlet",urlPatterns = "/insertTargetMember")
public class InsertTargetMemberServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从session中获取用户信息
        HttpSession session = req.getSession();
        User user1 = new User(2);
        session.setAttribute("user", user1);

        //添加打卡成员
        int user_id = Integer.parseInt(req.getParameter("user_id"));
        int clock_in_target_id = Integer.parseInt(req.getParameter("clock_in_target_id"));
        TargetService targetService = new TargetServiceImpl();
        targetService.insertmember(new Clock_in_member(user_id,clock_in_target_id));

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
