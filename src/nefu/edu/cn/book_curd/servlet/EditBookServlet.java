package nefu.edu.cn.book_curd.servlet;

import nefu.edu.cn.book_curd.dao.BookDao;
import nefu.edu.cn.book_curd.vo.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * author:Zuo Junhao
 * NEFU
 */
@WebServlet(name = "EditBookServlet",value = "/editBook.do")
public class EditBookServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer isbn = Integer.valueOf(req.getParameter("isbn"));

        BookDao bookDao = new BookDao();

        Book book = bookDao.getBookById(isbn);

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = resp.getWriter();

        String str = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"updateBook.do\",method=\"post\">\n" +
                "    <input type=\"hidden\" readonly name=\"isbn\" value="+book.getIsbn()+">\n" +
                "    bookName:<input type=\"text\" name=\"bookName\" value="+book.getBookName()+"><br/>\n" +
                "    price:<input type=\"text\" name=\"price\" value="+book.getPrice()+"><br/>\n" +
                "    <input type=\"submit\" value=\"提交\"/>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>";
        printWriter.println(str);
    }
}
