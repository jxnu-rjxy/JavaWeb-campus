package cn.edu.jxnu.rj.serlvet.confessionServlet;

import cn.edu.jxnu.rj.service.ConfessionService;
import cn.edu.jxnu.rj.service.Impl.ConfessionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteConfessionServlet",urlPatterns = "/deleteConfession")
public class DeleteConfessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int confessionId = Integer.parseInt(request.getParameter("confessionId"));

        ConfessionService confessionService = new ConfessionServiceImpl();
        confessionService.delete(confessionId);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
