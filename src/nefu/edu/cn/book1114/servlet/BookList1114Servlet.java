package nefu.edu.cn.book1114.servlet;

import nefu.edu.cn.book1114.dao.BookDao;
import nefu.edu.cn.book1114.vo.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * author:Zuo Junhao
 * NEFU
 */
@WebServlet(name = "BookList1114Servlet",value = "/bookList1114.do")
public class BookList1114Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        // 获得请求


        // 调用业务逻辑
        List<Book> list = bookDao.getAll();

        // 转发请求
        req.setAttribute("list",list);
        req.getRequestDispatcher("bookList1114.jsp").forward(req,resp);
    }
}
