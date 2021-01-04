package cn.edu.jxnu.rj.serlvet.mutualMemberServlet;

import cn.edu.jxnu.rj.domain.Mutual_member;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.Impl.MutualServiceImpl;
import cn.edu.jxnu.rj.service.MutualService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//添加组队成员
@WebServlet(name = "InsertMutualMemberServlet",urlPatterns = "/insertMutualMember")
public class InsertMutualMemberServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //从session中获取用户信息
        HttpSession session = req.getSession();
        User user1 = new User(2);
        session.setAttribute("user", user1);

        //添加组队成员
        int user_id = Integer.parseInt(req.getParameter("user_id"));
        int mutual_id = Integer.parseInt(req.getParameter("mutual_id"));
        MutualService mutualService = new MutualServiceImpl();
        mutualService.insertmember(new Mutual_member(user_id,mutual_id));

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
