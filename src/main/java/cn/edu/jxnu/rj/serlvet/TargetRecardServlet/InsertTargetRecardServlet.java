package cn.edu.jxnu.rj.serlvet.TargetRecardServlet;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;

//添加打卡记录
@WebServlet(name = "InsertTargetRecardServlet",urlPatterns = "/insertTargetRecard")
public class InsertTargetRecardServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从session中获取用户信息
        HttpSession session = req.getSession();
        User user1 = new User(2);
        session.setAttribute("user", user1);

        User user = (User) session.getAttribute("user");
        int user_id = Integer.parseInt(req.getParameter("user_id"));
        int clock_in_target_id = Integer.parseInt(req.getParameter("clock_in_target_id"));

        TargetService targetService = new TargetServiceImpl();
        int recard = targetService.insertrecard(user_id,clock_in_target_id);
        /*将发表的动态传给前端显示*/
        Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd HH:mm:ss").create();
        String json = gson.toJson(recard);
        resp.getWriter().write(json);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

}
