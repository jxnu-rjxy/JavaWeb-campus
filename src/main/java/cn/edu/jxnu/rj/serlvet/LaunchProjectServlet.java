package cn.edu.jxnu.rj.serlvet;

import cn.edu.jxnu.rj.domain.Dynamic;
import cn.edu.jxnu.rj.domain.Mutual;
import cn.edu.jxnu.rj.domain.User;
import cn.edu.jxnu.rj.service.DynamicService;
import cn.edu.jxnu.rj.service.Impl.DynamicServiceImpl;
import cn.edu.jxnu.rj.service.Impl.MutualServiceImpl;
import cn.edu.jxnu.rj.service.MutualService;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
//发布互助项目
@WebServlet(name = "PublishMutualServlet",urlPatterns = "/launchProject")
public class LaunchProjectServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置字符编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //从表单获取用户输入数据
        String mutual_title = request.getParameter("mutual_title");
        String mutual_content = request.getParameter("mutual_content");
       // Mutual mutual = new Mutual();

        MutualService mutualService = new MutualServiceImpl();
       // mutualService.post(new Mutual());
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
