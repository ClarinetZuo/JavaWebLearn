package nefu.edu.cn.exer.servlet;

import nefu.edu.cn.exer.dao.UserDao;
import nefu.edu.cn.exer.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            response.sendRedirect("bookList.do");
        } else {
            // 登录失败
            response.sendRedirect("demo_login.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
