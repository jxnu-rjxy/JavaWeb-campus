package cn.edu.jxnu.rj.serlvet.targetRecardServlet;


import cn.edu.jxnu.rj.domain.Clock_in_recard;
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

//查看所有打卡记录
@WebServlet(name = "CheckTargetRecardServlet",urlPatterns = "/checkTargetRecard")
public class CheckTargetRecardServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //      测试：登录存入用户数据
        User user = new User(2);
        TargetService targetService = new TargetServiceImpl();
        //调用DAO
        List<Clock_in_recard> targetrecardList = targetService.checkTargetrecard(user.getUserId());
        //将动态集合以json形式传给前端
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String json = gson.toJson(targetrecardList);
        resp.getWriter().write(json);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
