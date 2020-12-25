package cn.edu.jxnu.rj.serlvet.MutualMemberServlet;

import cn.edu.jxnu.rj.domain.Mutual_member;
import cn.edu.jxnu.rj.service.Impl.MutualServiceImpl;
import cn.edu.jxnu.rj.service.MutualService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//删除组队成员
@WebServlet(name = "DeleteMutualMemberServlet",urlPatterns = "/deleteMutualMember")
public class DeleteMutualMemberServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int user_id = Integer.parseInt(req.getParameter("user_id"));
        int mutual_id = Integer.parseInt(req.getParameter("mutual_id"));
        MutualService mutualService = new MutualServiceImpl();
        mutualService.deletemember(user_id,mutual_id);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
