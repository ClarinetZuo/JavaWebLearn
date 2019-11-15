package nefu.edu.cn.book1114.servlet;

import nefu.edu.cn.book1114.dao.BookDao;
import nefu.edu.cn.book1114.vo.Book;

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
@WebServlet(name = "EditBook1114Servlet",value = "/editBook1114.do")
public class EditBook1114Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        Integer isbn = Integer.valueOf(req.getParameter("isbn"));

        Book book = bookDao.getBookById(isbn);

        req.setAttribute("book",book);

        req.getRequestDispatcher("editBook.jsp").forward(req,resp);


    }
}
