package nefu.edu.cn.exer.servlet;

import nefu.edu.cn.exer.dao.BookDao;

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
@WebServlet(name = "DeleteBookServlet",value = "/deleteBook.do")
public class DeleteBookServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获得isbn
        String isbn = req.getParameter("isbn");

        BookDao bookDao = new BookDao();

        bookDao.delete(Integer.valueOf(isbn));

        resp.sendRedirect("bookList.do");
    }
}
