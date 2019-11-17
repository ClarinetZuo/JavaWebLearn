package nefu.edu.cn.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author:Zuo Junhao
 * NEFU
 */
@WebFilter(filterName = "URLFilter",value = "/*")
public class URLFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("经过过滤器");
        String ip = req.getRemoteAddr();
        HttpServletRequest httpServletRequest = (HttpServletRequest)req;
        String url = httpServletRequest.getRequestURL().toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("ip:"+ip+"url:"+url+simpleDateFormat.format(new Date()));
        chain.doFilter(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
