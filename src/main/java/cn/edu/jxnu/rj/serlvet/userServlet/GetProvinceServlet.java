package cn.edu.jxnu.rj.serlvet.userServlet;

import cn.edu.jxnu.rj.dao.ProvinceDao;
import cn.edu.jxnu.rj.dao.impl.ProvinceDaoImpl;
import cn.edu.jxnu.rj.domain.Province;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//获取省份信息
@WebServlet(name = "GetProvinceServlet",urlPatterns = "/getProvince")
public class GetProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProvinceDao provinceDao = new ProvinceDaoImpl();
        List<Province> provinces = provinceDao.getAll();

        response.getWriter().write(new Gson().toJson(provinces));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
