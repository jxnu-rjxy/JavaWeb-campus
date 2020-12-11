package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.dao.ClockInTargetDao;
import cn.edu.jxnu.rj.dao.DynamicDao;
import cn.edu.jxnu.rj.dao.impl.ClockInTargetImpl;
import cn.edu.jxnu.rj.dao.impl.DynamicDaoImpl;
import cn.edu.jxnu.rj.domain.Clock_in_target;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ClockInTargetServlet")
public class ClockInTargetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //从表单获取用户输入数据
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat borthdayDate = new SimpleDateFormat("yyyy-MM-dd");
        int clock_in_target_id= Integer.parseInt(request.getParameter("clock_in_target_id"));
        String clock_in_target_title =request.getParameter("clock_in_target_title");
        String clock_in_target_content =request.getParameter("clock_in_target_content");
        int user_id =Integer.parseInt(request.getParameter("user_id"));
        //获取当前用户信息
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        DynamicDao dynamicDao = new DynamicDaoImpl();
        List<Dynamic> dynamicList = dynamicDao.findByUserId(user.getUser_id());
        //调用插入的方法
        ClockInTargetDao clockInTargetDao =new ClockInTargetImpl();

        Clock_in_target clock_in_target=new Clock_in_target(clock_in_target_id,
                clock_in_target_title,
                clock_in_target_content
                );
        clockInTargetDao.insertClockTarget(clock_in_target);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
