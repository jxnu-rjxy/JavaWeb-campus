package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.dao.DynamicDao;
import cn.edu.jxnu.rj.dao.impl.DynamicDaoImpl;
import cn.edu.jxnu.rj.domain.Dynamic;
import cn.edu.jxnu.rj.domain.User;
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
public class SelectDynamicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user1 = new User(2,"123456");
        session.setAttribute("user", user1);
        User user = (User) session.getAttribute("user");
        DynamicDao dynamicDao = new DynamicDaoImpl();
        List<Dynamic> dynamicList = dynamicDao.findByUserId(user.getUser_id());
        Gson gson = new Gson();
        String json = gson.toJson(dynamicList);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
