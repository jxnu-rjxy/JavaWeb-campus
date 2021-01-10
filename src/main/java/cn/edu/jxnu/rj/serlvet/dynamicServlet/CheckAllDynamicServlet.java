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

@WebServlet(name = "CheckAllDynamicServlet",urlPatterns = "/checkAllDynamic")
public class CheckAllDynamicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int toNum = Integer.parseInt(request.getParameter("toNum"));
        int fromNum = Integer.parseInt(request.getParameter("fromNum"));
        int userId = Integer.parseInt(request.getParameter("userId"));

        DynamicService dynamicService = new DynamicServiceImpl();
        List<Dynamic> dynamicList = dynamicService.checkAll(toNum,fromNum,userId);
        response.getWriter().write(new GsonBuilder().setDateFormat("yyyy-MM-dd HH-mm-ss").create().toJson(dynamicList));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
