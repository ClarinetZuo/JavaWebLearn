package nefu.edu.cn.exer.servlet;

import nefu.edu.cn.exer.dao.BookDao;
import nefu.edu.cn.exer.vo.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * author:Zuo Junhao
 * NEFU
 */
@WebServlet(name = "BookListServlet", value = "/bookList.do")
public class BookListServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        List<Book> list = bookDao.getAll();

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<table width='90%' border=1>");
        out.println("<tr><td>序号</td><td>isbn</td><td>书名</td><td>价格</td><td>操作</td></tr>");

        for (int i = 0; i < list.size(); i++) {
            out.println("<tr>");
            out.println("<td>");
            out.println(i+1);
            out.println("</td>");
            out.println("<td>");
            out.println(list.get(i).getIsbn());
            out.println("</td>");
            out.println("<td>");
            out.println(list.get(i).getBookName());
            out.println("</td>");
            out.println("<td>");
            out.println(list.get(i).getPrice());
            out.println("</td>");
            out.println("<td>");
            out.println("<a href='deleteBook.do?isbn="+list.get(i).getIsbn()+"'>删除</a>");
            out.println("</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("<a href='addBook.html'>添加新图书</a>");
        out.println("</body></html>");
        out.close();

    }
}
