package nefu.edu.cn.book_curd.servlet;

import nefu.edu.cn.book_curd.dao.UserDao;
import nefu.edu.cn.book_curd.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
        User user = userDao.getUser(userName, password);
        if (null != user) {
            // 登录成功
            // 成功后，将用户的信息存储在Session中
            HttpSession session = request.getSession();
            System.out.println("id："+session.getId());
            System.out.println("最大间隔时间："+session.getMaxInactiveInterval());
            System.out.println("Session的创建时间："+session.getCreationTime());
            session.setMaxInactiveInterval(30);
            System.out.println("最大间隔时间："+session.getMaxInactiveInterval());

            session.setAttribute("user",user);

            response.sendRedirect("bookList.do");
        } else {
            // 登录失败
            response.sendRedirect("demo_login.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}