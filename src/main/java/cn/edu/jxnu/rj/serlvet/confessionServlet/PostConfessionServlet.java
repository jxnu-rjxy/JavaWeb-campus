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

@WebServlet(name = "PostConfessionServlet",urlPatterns = "/postConfession")
public class PostConfessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId1 = Integer.parseInt(request.getParameter("userId1"));
        int userId2 = Integer.parseInt(request.getParameter("userId2"));

        String confessionContent = request.getParameter("confessionContent");

        ConfessionService confessionService = new ConfessionServiceImpl();
        Confession confession = confessionService.insert(new Confession(userId1, userId2, confessionContent));

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String json = gson.toJson(confession);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
