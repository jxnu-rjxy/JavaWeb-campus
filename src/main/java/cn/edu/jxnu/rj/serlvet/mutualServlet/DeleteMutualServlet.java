package cn.edu.jxnu.rj.serlvet.mutualServlet;

import cn.edu.jxnu.rj.service.Impl.MutualServiceImpl;
import cn.edu.jxnu.rj.service.MutualService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteMutualServlet",urlPatterns = "/deleteMutual")
public class DeleteMutualServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println("准备删除id为"+id+"的项目。。。。。。。。。。。。");
        MutualService mutualService = new MutualServiceImpl();
        mutualService.delete(id);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
