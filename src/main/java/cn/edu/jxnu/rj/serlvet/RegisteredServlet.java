package cn.edu.jxnu.rj.serlvet;

import cn.edu.jxnu.rj.dao.UserDao;
import cn.edu.jxnu.rj.dao.impl.UserDaoImpl;
import cn.edu.jxnu.rj.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

@javax.servlet.annotation.WebServlet(name = "RegisteredServlet",urlPatterns = "/register")
public class RegisteredServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //从表单获取用户输入数据
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat borthdayDate = new SimpleDateFormat("yyyy-MM-dd");
        String user_name = request.getParameter("user_name");
        String user_phone = request.getParameter("user_phone");
        int user_gender = Integer.parseInt(request.getParameter("user_gender"));
        String user_password = request.getParameter("user_password");
        int user_province = Integer.parseInt(request.getParameter("user_province"));
        int user_city = Integer.parseInt(request.getParameter("user_city"));
        int user_emotion_status = Integer.parseInt(request.getParameter("user_emotion_status"));
        String user_realname = request.getParameter("user_realname");
        String user_school = request.getParameter("user_school");
        String user_dept = request.getParameter("user_dept");
        String user_major = request.getParameter("user_major");
        String user_grade = request.getParameter("user_grade");
        User user = new User(user_name,user_phone,user_gender,null,user_password,user_province,
        user_city,
        user_emotion_status,
        user_realname,
        user_school,
        user_dept,
        user_major,
        user_grade);
        //调用userDao查询用户
        UserDao userDao = new UserDaoImpl();
        User userPhone = userDao.findByPhone(user_phone);
        //判断
        if (userPhone==null){ //该手机号未注册
              userDao.insertUser(user);
              System.out.println("注册成功,请输入用户名密码登录");
              request.getRequestDispatcher("index.jsp").forward(request,response);
        }else{//该用户已经存在
            System.out.println("注册失败，请重新登录");
            request.getRequestDispatcher("registered.jsp");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

    }
}
