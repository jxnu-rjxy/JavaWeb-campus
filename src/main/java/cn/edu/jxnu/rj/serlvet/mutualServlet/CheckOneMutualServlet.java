package cn.edu.jxnu.rj.serlvet.mutualServlet;

import cn.edu.jxnu.rj.domain.Mutual;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.Impl.MutualServiceImpl;
import cn.edu.jxnu.rj.service.MutualService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//查看某一互助项目
@WebServlet(name = "CheckOneMutualServlet",urlPatterns = "/checkOneMutual")
public class CheckOneMutualServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int mutual_id = Integer.parseInt(req.getParameter("mutual_id"));
        MutualService mutualService = new MutualServiceImpl();
        //调用DAO查询该用户发布的互助项目
        Mutual mutual = mutualService.checkone(mutual_id);

        //将动态集合以json形式传给前端
        Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd HH:mm:ss").create();
        String json = gson.toJson(mutual);
        resp.getWriter().write(json);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
