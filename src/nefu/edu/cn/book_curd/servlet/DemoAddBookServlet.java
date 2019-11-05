package nefu.edu.cn.book_curd.servlet;

import nefu.edu.cn.zjh.dao.BookDao;
import nefu.edu.cn.zjh.vo.Book;

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
@WebServlet(name = "DemoAddBookServlet",value = "/demo_addBook.do")
public class DemoAddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // 1. 获得图书信息

        String isbn = req.getParameter("isbn");
        String bookName = req.getParameter("bookName");
        String price = req.getParameter("price");

        BookDao bookDao = new BookDao();
        Book book = new Book();

        book.setIsbn(Integer.valueOf(isbn));
        book.setBookName(bookName);
        book.setPrice(Integer.valueOf(price));

        bookDao.save(book);
        resp.setContentType("text/html;charset=UTF-8");
        // 重定向到查询页
        resp.sendRedirect("bookList.do");

    }
}
