package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.dao.UserDao;
import cn.edu.jxnu.rj.dao.impl.UserDaoImpl;
import cn.edu.jxnu.rj.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从前端表单获取的账号密码
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String user_password =  request.getParameter("user_password");

        User user = new User(user_id,user_password);
        UserDao userDao = new UserDaoImpl();
        User userById = userDao.selectUserById(user_id);
        request.setCharacterEncoding("utf-8");
        if(userById.getUser_id()==0){
            System.out.println("账号或密码错误！mima cuo wu");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else {
            if(userById.getUser_password()==user_password){
                System.out.println("cheng gong "+userById.getUser_password());
                request.getRequestDispatcher("home.jsp").forward(request,response);
            }else {
                System.out.println("账号或密码错误！dsdsdsdsds");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
