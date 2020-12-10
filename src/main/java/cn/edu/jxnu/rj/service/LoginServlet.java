package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.dao.UserDao;
import cn.edu.jxnu.rj.dao.impl.UserDaoImpl;
import cn.edu.jxnu.rj.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //从前端表单获取的账号密码
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String user_password =  request.getParameter("user_password");
        User user = new User(user_id,user_password);

        //调用userDao查询用户
        UserDao userDao = new UserDaoImpl();
        User userById = userDao.findById(user_id);
        //判断
        if(userById.getUser_id()==0){//是否存在账号
            System.out.println("账号或密码错误！m");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else {
            if(userById.getUser_password().equals(user_password)){//密码正确
                System.out.println("密码正确");
                //将信息存入session
                HttpSession session = request.getSession();
                session.setAttribute("user",user);

                //跳转到主页
                request.getRequestDispatcher("home.jsp").forward(request,response);
            }else {//密码错误
                System.out.println("账号或密码错误!");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
