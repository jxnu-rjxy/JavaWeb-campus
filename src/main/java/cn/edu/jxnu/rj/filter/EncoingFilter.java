package cn.edu.jxnu.rj.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "EncoingFilter")
public class EncoingFilter implements Filter {
    String encoding = null;
    public void destroy() {
        encoding = null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if(encoding != null){
            System.out.println("设置编码为"+encoding);
            req.setCharacterEncoding(encoding);
            resp.setCharacterEncoding(encoding);
            resp.setContentType("text/html,charset="+encoding);
        }
        chain.doFilter(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
    }

}
