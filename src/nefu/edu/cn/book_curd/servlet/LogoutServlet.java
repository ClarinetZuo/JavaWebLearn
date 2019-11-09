package nefu.edu.cn.book_curd.servlet;

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
@WebServlet(name = "LogoutServlet", value = "/logout.do")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (null != req && null != req.getSession()) {
            req.getSession().invalidate();
        }
        if (null != resp) {

            resp.sendRedirect("demo_login.html");
        }
    }
}
