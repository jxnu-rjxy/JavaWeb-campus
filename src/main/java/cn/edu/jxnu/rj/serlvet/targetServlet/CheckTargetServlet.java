package cn.edu.jxnu.rj.serlvet.targetServlet;

import cn.edu.jxnu.rj.domain.Clock_in_target;
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

//查看某一用户的所有打卡目标
@WebServlet(name = "CheckTargetServlet",urlPatterns = "/checkTarget")
public class CheckTargetServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //      测试：登录存入用户数据
        User user = new User(2);
        TargetService targetService = new TargetServiceImpl();
        //调用DAO查询该用户发布的互助项目
        List<Clock_in_target> targetList = targetService.check(user.getUser_id());
        //将动态集合以json形式传给前端
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String json = gson.toJson(targetList);
        resp.getWriter().write(json);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
