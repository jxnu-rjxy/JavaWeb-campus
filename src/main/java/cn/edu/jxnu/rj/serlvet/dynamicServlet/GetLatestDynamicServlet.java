package cn.edu.jxnu.rj.serlvet.dynamicServlet;

import cn.edu.jxnu.rj.domain.Dynamic;
import cn.edu.jxnu.rj.service.DynamicService;
import cn.edu.jxnu.rj.service.Impl.DynamicServiceImpl;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "GetLatestDynamicServlet",urlPatterns = "/getLatestDynamic")
public class GetLatestDynamicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int start = Integer.parseInt(request.getParameter("start"));
        int nums = Integer.parseInt(request.getParameter("nums"));
        int userId = Integer.parseInt(request.getParameter("userId"));

        DynamicService dynamicService = new DynamicServiceImpl();
        Map<String, Object> latest = dynamicService.getLatest(start, nums, userId);

        response.getWriter().write(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(latest));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
