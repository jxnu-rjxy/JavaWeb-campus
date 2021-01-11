package cn.edu.jxnu.rj.serlvet.messageServlet;

import cn.edu.jxnu.rj.domain.Message;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.Impl.MessageServiceImpl2;
import cn.edu.jxnu.rj.service.Impl.UserServiceImpl;
import cn.edu.jxnu.rj.service.MessageService2;
import cn.edu.jxnu.rj.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//插入消息
@WebServlet(name = "InsertMessageServlet",urlPatterns = "/postMessage")
public class InsertMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //获取数据
            int userId1=Integer.parseInt(request.getParameter("userId1"));
            int userId2=Integer.parseInt(request.getParameter("userId2"));
            int messageType=Integer.parseInt(request.getParameter("messageType"));
            String messageContent=request.getParameter("messageContent");
            int messageLinkId = Integer.parseInt(request.getParameter("messageLinkId"));
            int messageLinkType = Integer.parseInt(request.getParameter("messageLinkType"));
            System.out.println(userId1+","+userId2+","+messageType+","+messageContent);

            UserService userService = new UserServiceImpl();
            User user1 = userService.findById(userId1);
            User user2 = userService.findById(userId2);
        //插入消息
          MessageService2 messageService = new MessageServiceImpl2();
          messageService.addMessage(new Message(userId1,userId2,messageType,messageContent,messageLinkId,messageLinkType,user1.getUser_name(),user2.getUser_name()));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
