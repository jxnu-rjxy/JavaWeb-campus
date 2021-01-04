package cn.edu.jxnu.rj.serlvet.groupChatServlet;

import cn.edu.jxnu.rj.domain.Group_chat;
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
import java.io.IOException;
import java.util.List;

//查看群聊记录
@WebServlet(name = "CheckMutualGroupChatServlet",urlPatterns = "/checkMutualGroupChat")
public class CheckGroupChatServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        resp.setContentType("text/html;charset=UTF-8");
        //从session中获取用户信息
//        HttpSession session = req.getSession();
        //      测试：登录存入用户数据
        User user = new User(2);
//        session.setAttribute("user", user1);
//        User user = (User) session.getAttribute("user");

        int mutual_id = Integer.parseInt(req.getParameter("mutual_id"));
        MutualService mutualService = new MutualServiceImpl();
        //调用DAO
        List<Group_chat> groupchatList = mutualService.checkGroupchat(mutual_id);
        //将动态集合以json形式传给前端
        Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd HH:mm:ss").create();
        String json = gson.toJson(groupchatList);
        resp.getWriter().write(json);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
