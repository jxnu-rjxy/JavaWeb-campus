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

//查看某一打卡目标
@WebServlet(name = "CheckOneTargetServlet",urlPatterns = "/checkOneTarget")
public class CheckOneTargetServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int clock_in_target_id = Integer.parseInt(req.getParameter("clock_in_target_id"));
        TargetService targetService = new TargetServiceImpl();
        //调用DAO查询该用户发布的互助项目
        Clock_in_target target = targetService.checkone(clock_in_target_id);

        //将动态集合以json形式传给前端
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String json = gson.toJson(target);
        resp.getWriter().write(json);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
