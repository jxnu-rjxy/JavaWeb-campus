package cn.edu.jxnu.rj.serlvet.userServlet;

import cn.edu.jxnu.rj.dao.CityDao;
import cn.edu.jxnu.rj.dao.ProvinceDao;
import cn.edu.jxnu.rj.dao.impl.CityDaoImpl;
import cn.edu.jxnu.rj.dao.impl.ProvinceDaoImpl;
import cn.edu.jxnu.rj.domain.City;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//根据省份获取该省的所有城市
@WebServlet(name = "GetCityServlet",urlPatterns = "/getCity")
public class GetCityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String province = request.getParameter("province");
        ProvinceDao provinceDao = new ProvinceDaoImpl();
        int pid = provinceDao.getId(province);
        CityDao cityDao = new CityDaoImpl();
        List<City> cities = cityDao.getAll(pid);
        response.getWriter().write(new Gson().toJson(cities));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
