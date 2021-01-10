package cn.edu.jxnu.rj.serlvet.messageServlet;

import cn.edu.jxnu.rj.domain.Message;
import cn.edu.jxnu.rj.service.Impl.MessageServiceImpl2;
import cn.edu.jxnu.rj.service.MessageService2;

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
            int user1=Integer.parseInt(request.getParameter("user1"));
            int user2=Integer.parseInt(request.getParameter("user2"));
            int messageType=Integer.parseInt(request.getParameter("messageType"));
            String messageContent=request.getParameter("messageContent");
            int messageLinkId = Integer.parseInt(request.getParameter("messageLinkId"));
            int messageLinkType = Integer.parseInt(request.getParameter("messageLinkType"));
            System.out.println(user1+","+user2+","+messageType+","+messageContent);
            //插入消息
          MessageService2 messageService = new MessageServiceImpl2();
          messageService.addMessage(new Message(user1,user2,messageType,messageContent,messageLinkId,messageLinkType));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
