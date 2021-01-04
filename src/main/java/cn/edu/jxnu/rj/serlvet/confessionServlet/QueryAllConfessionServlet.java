package cn.edu.jxnu.rj.serlvet.confessionServlet;

import cn.edu.jxnu.rj.domain.Confession;
import cn.edu.jxnu.rj.service.ConfessionService;
import cn.edu.jxnu.rj.service.Impl.ConfessionServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryAllConfessionServlet",urlPatterns = "/queryAllConfession")
public class QueryAllConfessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));

        ConfessionService confessionService = new ConfessionServiceImpl();
        List<Confession> confessionList = confessionService.getAllByUser(userId);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd hh:mm:ss").create();
        String json = gson.toJson(confessionList);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
