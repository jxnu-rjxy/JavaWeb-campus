package cn.edu.jxnu.rj.serlvet.dynamicServlet;

import cn.edu.jxnu.rj.service.DynamicService;
import cn.edu.jxnu.rj.service.Impl.DynamicServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteDynamicServlet",urlPatterns = "/deleteDynamic")
public class DeleteDynamicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("准备删除id为"+id+"的动态。。。。。。。。。。。。");
        DynamicService dynamicService = new DynamicServiceImpl();
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        dynamicService.delete(id,realPath);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
