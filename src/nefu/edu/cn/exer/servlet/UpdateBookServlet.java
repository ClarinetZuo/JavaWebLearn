package nefu.edu.cn.exer.servlet;

import nefu.edu.cn.exer.dao.BookDao;
import nefu.edu.cn.exer.vo.Book;

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
@WebServlet(name = "UpdateBookServlet", value = "/updateBook.do")
public class UpdateBookServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (null != req) {
            req.setCharacterEncoding("UTF-8");
            String isbn = req.getParameter("isbn");
            String bookName = req.getParameter("bookName");
            String price = req.getParameter("price");
            BookDao bookDao = new BookDao();
            if (null != isbn && null != bookName && null != price && null != bookDao) {
                Book book = new Book(Integer.valueOf(isbn), bookName, Integer.valueOf(price));
                if (null != book) {
                    bookDao.update(book);
                }
            }
        }
        // 重定向
        if (null != resp){
            resp.sendRedirect("bookList.do");
        }
    }
}
