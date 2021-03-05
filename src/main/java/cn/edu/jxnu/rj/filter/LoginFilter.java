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
        String ignore[] = {"/login","/user/","/upload/","/websocket"};
        boolean isNotFilte = false;

        //3.判断是否包含登录相关资源路径
        for (int i = 0; i <ignore.length; i++) {
            if(requestURI.contains(ignore[i])){
                isNotFilte = true;
            }
        }

        if (isNotFilte) {
            //放行
            System.out.println("放行！");
            chain.doFilter(req, resp);
        } else {
            //4.判断是否有token
            String authorization = request.getHeader("authorization");
            if(authorization!=null){
                boolean verify = TokenUtils.verify(authorization);
                if(verify){
                    System.out.println("放行！");
                    chain.doFilter(req, resp);
                }else {
                    response.setStatus(600);
                }
            }else {
                response.setStatus(600);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
