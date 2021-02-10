package cn.edu.jxnu.rj.filter;

import cn.edu.jxnu.rj.util.TokenUtils;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) resp;
        //获取请求资源路径
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        //3.判断是否包含登录相关资源路径
        if ( requestURI.contains("login")|| requestURI.contains("/user/")) {
            //放行
            System.out.println("这是登录界面，放行");
        System.out.println("开始检查是否登录");
            chain.doFilter(req, resp);
        } else {
            //4.判断是否有token
            String authorization = request.getHeader("authorization");
            if(authorization!=null){
                boolean verify = TokenUtils.verify(authorization);
                if(verify){
                    chain.doFilter(req, resp);
                    System.out.println("token有效，放行");
                }else {
                    response.setStatus(401);
                    System.out.println("token无效，401");
                }
            }else {
                System.out.println("token不存在，401");
                response.setStatus(401);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
