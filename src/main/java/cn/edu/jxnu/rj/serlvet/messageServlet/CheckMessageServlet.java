package cn.edu.jxnu.rj.serlvet.messageServlet;

import cn.edu.jxnu.rj.domain.Message;
import cn.edu.jxnu.rj.service.Impl.MessageServiceImpl2;
import cn.edu.jxnu.rj.service.MessageService2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CheckMessageServlet",urlPatterns = "/checkMessage")
public class CheckMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取信息
        int messageType=Integer.parseInt(request.getParameter("messageType"));
        int userId=Integer.parseInt(request.getParameter("userId"));
        MessageService2 messageService= new MessageServiceImpl2();
        List<Message> messages= messageService.query(userId,messageType);

        //将以json形式传给前端
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String json = gson.toJson(messages);
        response.getWriter().write(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
