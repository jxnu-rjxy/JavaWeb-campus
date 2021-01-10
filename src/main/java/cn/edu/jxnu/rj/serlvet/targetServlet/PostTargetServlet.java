package cn.edu.jxnu.rj.serlvet.targetServlet;

import cn.edu.jxnu.rj.domain.Clock_in_target;
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

@WebServlet(name = "PostTargetServlet",urlPatterns = "/postTarget")
public class PostTargetServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从表单获取用户输入数据
        String clock_in_target_title = req.getParameter("clock_in_target_title");
        String clock_in_target_content = req.getParameter("clock_in_target_content");
        int userId = Integer.parseInt(req.getParameter("userId"));


        //发表打卡目标
        TargetService targetService = new TargetServiceImpl();
        int target= targetService.post(new Clock_in_target(userId,clock_in_target_title,clock_in_target_content));

        /*将发表的打卡目标传给前端显示*/
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String json = gson.toJson(target);
        resp.getWriter().write(json);
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
