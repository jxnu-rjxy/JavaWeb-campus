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

@WebServlet(name = "DynamicDetailServlet",urlPatterns = "/dynamicDetail")
public class DynamicDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dynamicId = Integer.parseInt(request.getParameter("dynamicId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        System.out.println("id:"+dynamicId+"user:"+userId);
        DynamicService dynamicService = new DynamicServiceImpl();
        Dynamic dynamic = dynamicService.findById(dynamicId,userId);
        System.out.println("当前查看的动态为L"+dynamic);
        response.getWriter().write(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(dynamic));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
