package cn.edu.jxnu.rj.serlvet.targetServlet;

import cn.edu.jxnu.rj.service.Impl.TargetServiceImpl;
import cn.edu.jxnu.rj.service.TargetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//删除打卡目标
@WebServlet(name = "DeleteTargetServlet",urlPatterns = "/deleteTarget")
public class DeleteTargetServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int clock_in_target_id = Integer.parseInt(req.getParameter("clock_in_target_id"));
        System.out.println("准备删除mutual_id为"+clock_in_target_id+"的项目。。。。。。。。。。。。");
        TargetService targetService = new TargetServiceImpl();
        targetService.delete(clock_in_target_id);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
