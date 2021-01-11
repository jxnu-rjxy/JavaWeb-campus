package cn.edu.jxnu.rj.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest request=(HttpServletRequest) req;
//        HttpServletResponse response=(HttpServletResponse) resp;
//        //获取请求资源路径
//        String requestURI = request.getRequestURI();
//        System.out.println(requestURI);
//        //3.判断是否包含登录相关资源路径
//        if ( requestURI.contains("#/") ||requestURI.contains("/login")) {
//            //放行
//            System.out.println("这是登录界面，放行");
        System.out.println("开始检查是否登录");
            chain.doFilter(req, resp);
//        } else {
//            //4.判断是否有token
//            String token = request.getHeader("token");
//            if(token!=null){
//                boolean verify = TokenUtils.verify(token);
//                if(verify){
//                    chain.doFilter(req, resp);
//                    System.out.println("token有效，放行");
//                }else {
//                    response.setStatus(600);
//                    response.getWriter().write(new Gson().toJson("error"));
//                    System.out.println("token无效，600");
//                }
//            }else {
//                System.out.println("token不存在，600");
//                response.setStatus(600);
//                response.getWriter().write(new Gson().toJson("error"));
//            }
//        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
