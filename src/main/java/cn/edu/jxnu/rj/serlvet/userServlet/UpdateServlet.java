package cn.edu.jxnu.rj.serlvet.userServlet;

import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.Impl.UserServiceImpl;
import cn.edu.jxnu.rj.service.UserService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//更新用户部分信息
@WebServlet(name = "UpdateServlet",urlPatterns = "/updateUser")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int user_id = Integer.parseInt(req.getParameter("user_id"));
        String user_name = req.getParameter("user_name");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date user_birthday = null;
        try {
            user_birthday = simpleDateFormat.parse(req.getParameter("user_birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String user_province = req.getParameter("user_province");
        String user_city = req.getParameter("user_city");
        int user_emotion_status = Integer.parseInt(req.getParameter("user_emotion_status"));
        String user_signature = req.getParameter("user_signature");
        String user_dept = req.getParameter("user_dept");
        String user_major = req.getParameter("user_major");

        User user = new User(user_id,user_name,user_birthday,user_province,user_city,user_emotion_status,user_signature,user_dept,user_major);

        UserService userService = new UserServiceImpl();
        userService.update(user);
        Gson gson = new Gson();
        String json = gson.toJson(user);
        resp.getWriter().write(json);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
