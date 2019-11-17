package nefu.edu.cn.filter;

import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * author:Zuo Junhao
 * NEFU
 * 做一个Session拦截器
 */
@WebFilter(filterName = "SessionFilter",value = "/*")
public class SessionFilter implements Filter {
    List<String> list = new ArrayList<>();
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        // 获得Session
        HttpServletRequest httpServletRequest = (HttpServletRequest)req;
        String path = httpServletRequest.getServletPath();
        if (list.contains(path)){

            chain.doFilter(req, resp);
        }else{
            HttpSession session = httpServletRequest.getSession();
            if (session.getAttribute("user") != null){
                chain.doFilter(req,resp);
            }else {
                HttpServletResponse response = (HttpServletResponse)resp;
                String contextPath = httpServletRequest.getServletContext().getContextPath();
                // contextPath:/JavaWebLearn_war_exploded
                response.sendRedirect(contextPath+"/userLogin.jsp");
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {
        list.add("/userLogin.jsp");
        list.add("/userLogin.do");
    }

}
