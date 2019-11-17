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
@WebServlet(name = "UpdateBook1114Servlet",value = "/updateBook1114.do")
public class UpdateBook1114Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        req.setCharacterEncoding("UTF-8");
        BookDao bookDao = new BookDao();
        Integer isbn = Integer.valueOf(req.getParameter("isbn"));
        String bookName = req.getParameter("bookName");
        Integer price = Integer.valueOf(req.getParameter("price"));
        Book book = new Book(isbn,bookName,price);
        bookDao.update(book);

        resp.sendRedirect("bookList1114.do");

    }
}
