package nefu.edu.cn.book_curd.servlet;

import nefu.edu.cn.book_curd.dao.UserDao;
import nefu.edu.cn.book_curd.vo.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * author:Zuo Junhao
 * NEFU
 */
@WebServlet(name = "LoginServlet", value = "/demoLogin.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        System.out.println("输入的密码"+password);
        User user = userDao.getUser(userName, password);
        if (null != user) {
            // 登录成功
            // 成功后，将用户的信息存储在Session中
            HttpSession session = request.getSession();
            System.out.println("id："+session.getId());
            System.out.println("最大间隔时间："+session.getMaxInactiveInterval());
            System.out.println("Session的创建时间："+session.getCreationTime());
//            session.setMaxInactiveInterval(30);
            System.out.println("最大间隔时间："+session.getMaxInactiveInterval());

            session.setAttribute("user",user);


            //1. create,addCookie,getCookies
            String maxAge = request.getParameter("maxage");
            if (null != maxAge){
                Cookie cookie = new Cookie("userName1",user.getUserName());
                cookie.setMaxAge(Integer.valueOf(maxAge));
                Cookie cookie1 = new Cookie("password",password);

                cookie1.setMaxAge(Integer.valueOf(maxAge)); // 最大存活15天
                response.addCookie(cookie);
                response.addCookie(cookie1);
            }
            // 获得上下文的两种方式
            ServletContext servletContext = request.getServletContext();
//            request.getSession().getServletContext();
            String path = servletContext.getRealPath("/");
            System.out.println(path);
            String contextPath = servletContext.getContextPath();
            System.out.println(contextPath);

            // 统计登录次数
            Integer count = (Integer)servletContext.getAttribute("count");
            if (null == count){
                count = 0;
            }
            count ++;
            servletContext.setAttribute("count",count);


            response.sendRedirect("bookList.do");
        } else {
            // 登录失败
            response.sendRedirect("demo_login.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
