package cn.edu.jxnu.rj.serlvet.dynamicServlet;

import cn.edu.jxnu.rj.domain.Dynamic;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.DynamicService;
import cn.edu.jxnu.rj.service.Impl.DynamicServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 查找动态
 */
@WebServlet(name = "CheckDynamicServlet",urlPatterns = "/checkDynamic")
public class CheckDynamicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        response.setContentType("text/html;charset=UTF-8");

        //从session中获取用户信息
        HttpSession session = request.getSession();
//      测试：登录存入用户数据
        User user1 = new User(2);
        session.setAttribute("user", user1);
        User user = (User) session.getAttribute("user");
        DynamicService dynamicService = new DynamicServiceImpl();
        //调用DAO查询该用户发布的动态
        List<Dynamic> dynamicList = dynamicService.check(user.getUser_id());
        //将动态集合以json形式传给前端
        Gson gson = new Gson();
        String json = gson.toJson(dynamicList);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
