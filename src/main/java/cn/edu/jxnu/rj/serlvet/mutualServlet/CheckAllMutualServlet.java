package cn.edu.jxnu.rj.serlvet.mutualServlet;

import cn.edu.jxnu.rj.domain.Dynamic;
import cn.edu.jxnu.rj.domain.Mutual;
import cn.edu.jxnu.rj.service.DynamicService;
import cn.edu.jxnu.rj.service.Impl.DynamicServiceImpl;
import cn.edu.jxnu.rj.service.Impl.MutualServiceImpl;
import cn.edu.jxnu.rj.service.MutualService;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CheckAllMutualServlet",urlPatterns = "/checkAllMutual")
public class CheckAllMutualServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int toNum = Integer.parseInt(req.getParameter("toNum"));
        int fromNum = Integer.parseInt(req.getParameter("fromNum"));


        MutualService mutualService = new MutualServiceImpl();
        List<Mutual> mutualList = mutualService.checkAll(toNum,fromNum);
        resp.getWriter().write(new GsonBuilder().setDateFormat("yyyy-MM-dd HH-mm-ss").create().toJson(mutualList));
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

}
