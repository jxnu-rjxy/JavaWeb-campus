package cn.edu.jxnu.rj.service;

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

@WebServlet(name = "SelectDynamicServlet",urlPatterns = "/selectDynamic")
public class CheckDynamicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< Updated upstream:src/main/java/cn/edu/jxnu/rj/service/SelectDynamicServlet.java
        HttpSession session = request.getSession();
        User user1 = new User(2,"123456");
        session.setAttribute("user", user1);
        User user = (User) session.getAttribute("user");
        DynamicDao dynamicDao = new DynamicDaoImpl();
        List<Dynamic> dynamicList = dynamicDao.findByUserId(user.getUser_id());
=======
        //设置编码
        response.setContentType("text/html;charset=UTF-8");

        //从session中获取用户信息
        HttpSession session = request.getSession();
//      测试：登录存入用户数据
//      User user1 = new User(2);
//      session.setAttribute("user", user1);
        User user = (User) session.getAttribute("user");

        DynamicService dynamicService = new DynamicServiceImpl();
        //调用DAO查询该用户发布的动态
        List<Dynamic> dynamicList = dynamicService.check(user.getUser_id());
        //将动态集合以json形式传给前端
>>>>>>> Stashed changes:src/main/java/cn/edu/jxnu/rj/service/CheckDynamicServlet.java
        Gson gson = new Gson();
        String json = gson.toJson(dynamicList);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
