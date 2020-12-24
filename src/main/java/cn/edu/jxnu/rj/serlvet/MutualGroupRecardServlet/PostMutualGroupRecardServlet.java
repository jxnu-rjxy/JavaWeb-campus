package cn.edu.jxnu.rj.serlvet.MutualGroupRecardServlet;

import cn.edu.jxnu.rj.domain.Mutual_group_recard;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.Impl.MutualServiceImpl;
import cn.edu.jxnu.rj.service.MutualService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PostMutualGroupRecardServlet",urlPatterns = "/postMutualGroupRecard")
public class PostMutualGroupRecardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //从session中获取用户信息
        HttpSession session = request.getSession();
        User user1 = new User(2);
        session.setAttribute("user", user1);

        //发起组队
        User user = (User) session.getAttribute("user");
        int mutual_id = Integer.parseInt(request.getParameter("mutual_id"));
        Mutual_group_recard mutual_group_recard = new Mutual_group_recard(user.getUser_id(),mutual_id);
        MutualService mutualService = new MutualServiceImpl();
        Mutual_group_recard m = mutualService.postgrouprequest(mutual_group_recard);


        /*将发表的动态传给前端显示*/
        Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd HH:mm:ss").create();
        String json = gson.toJson(m);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
