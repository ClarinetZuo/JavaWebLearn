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
@WebServlet(name = "AddBook1114Servlet",value = "/addBook1114.do")
public class AddBook1114Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
        BookDao bookDao = new BookDao();
        Book book = new Book(Integer.valueOf(req.getParameter("isbn")),req.getParameter("bookName"),Integer.valueOf(req.getParameter("price")));

        bookDao.save(book);

//        req.getRequestDispatcher("bookList1114.do").forward(req,resp);
        resp.setContentType("text/html;charset='UTF-8'");
        resp.sendRedirect("bookList1114.do");

    }
}
