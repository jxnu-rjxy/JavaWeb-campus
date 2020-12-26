package cn.edu.jxnu.rj.serlvet.TargetMemberServlet;

import cn.edu.jxnu.rj.domain.Clock_in_member;
import cn.edu.jxnu.rj.domain.Mutual_member;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.Impl.MutualServiceImpl;
import cn.edu.jxnu.rj.service.Impl.TargetServiceImpl;
import cn.edu.jxnu.rj.service.MutualService;
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

//查看打卡成员
@WebServlet(name = "CheckTargetMemberServlet",urlPatterns = "/checkTargetMember")
public class CheckTargetMemberServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //      测试：登录存入用户数据
        User user = new User(2);
        int clock_in_target_id = Integer.parseInt(req.getParameter("clock_in_target_id"));
        TargetService targetService = new TargetServiceImpl();
        //调用DAO
        List<Clock_in_member> targetmemberList = targetService.checkTargetmember(clock_in_target_id);
        System.out.println(targetmemberList);
        //将动态集合以json形式传给前端
        Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd HH:mm:ss").create();
        String json = gson.toJson(targetmemberList);
        resp.getWriter().write(json);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
