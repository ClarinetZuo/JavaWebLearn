package nefu.edu.cn.book1114.servlet;

import nefu.edu.cn.book1114.dao.BookDao;

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
@WebServlet(name = "DeleteBook1114Servlet",value = "/deleteBook1114.do")
public class DeleteBook1114Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        // 获得数据

        String[] ids = req.getParameterValues("isbn");

        Integer[] isbns = new Integer[ids.length];
        for (int i = 0; i < ids.length; i++) {
            isbns[i] = Integer.valueOf(ids[i]);
        }

        //2
        bookDao.delete(isbns);

        resp.sendRedirect("bookList1114.do");

    }
}
