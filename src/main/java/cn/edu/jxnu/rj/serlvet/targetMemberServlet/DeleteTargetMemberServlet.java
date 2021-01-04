package cn.edu.jxnu.rj.serlvet.targetMemberServlet;

import cn.edu.jxnu.rj.service.Impl.TargetServiceImpl;
import cn.edu.jxnu.rj.service.TargetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//删除打卡成员
@WebServlet(name = "DeleteTargetMemberServlet",urlPatterns = "/deleteTargetMember")
public class DeleteTargetMemberServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int user_id = Integer.parseInt(req.getParameter("user_id"));
        int clock_in_target_id = Integer.parseInt(req.getParameter("clock_in_target_id"));
        TargetService targetService = new TargetServiceImpl();
        targetService.deletemember(user_id,clock_in_target_id);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

}
