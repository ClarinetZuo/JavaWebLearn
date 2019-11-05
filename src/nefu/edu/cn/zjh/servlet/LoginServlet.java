package nefu.edu.cn.zjh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;

/**
 * author:Zuo Junhao
 * NEFU
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        response.setContentType("text/html;charset=UTF-8"); // 返回内容的类型
        PrintWriter printWriter = response.getWriter();
        if ("scott".equals(userName) && "tiger".equals(password)) {
            System.out.println("成功了");
            printWriter.println("<body>这是一个小网页</body>");
        } else {
            System.out.println("失败了");
            response.sendRedirect("first.html");
        }

        printWriter.close();

    }
}
