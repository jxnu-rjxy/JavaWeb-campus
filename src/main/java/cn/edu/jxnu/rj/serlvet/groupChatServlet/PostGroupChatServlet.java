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
import javax.servlet.http.HttpSession;
import java.io.IOException;

//发送群聊消息
@WebServlet(name = "PostMutualGroupChatServlet",urlPatterns = "/postMutualGroupChat")
public class PostGroupChatServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从session中获取用户信息
        HttpSession session = req.getSession();
        User user1 = new User(2);
        session.setAttribute("user", user1);
        //从表单获取用户输入数据
        int user_id = Integer.parseInt(req.getParameter("user_id"));
        int mutual_id = Integer.parseInt(req.getParameter("mutual_id"));
        String group_chat_conent = req.getParameter("group_chat_conent");
        //发送聊天信息
        User user = (User) session.getAttribute("user");
        MutualService mutualService = new MutualServiceImpl();
        int group_chat= mutualService.insertchat(new Group_chat(user_id,mutual_id,group_chat_conent));
        /*将发表的动态传给前端显示*/
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String json = gson.toJson(group_chat);
        resp.getWriter().write(json);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
