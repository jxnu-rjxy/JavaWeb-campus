package cn.edu.jxnu.rj.service;

import cn.edu.jxnu.rj.domain.Mutual;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.io.IOException;

public class LaunchProjectServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置字符编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //从表单获取用户输入数据
        String mutual_title = request.getParameter("mutual_title");
        String mutual_content = request.getParameter("mutual_content");
        Mutual mutual = new Mutual();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
