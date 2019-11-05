package nefu.edu.cn.zjh.servlet;

import nefu.edu.cn.zjh.dao.BookDao;
import nefu.edu.cn.zjh.vo.Book;

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
@WebServlet(name = "AddBookServlet",value = "/addBook.do")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("UTF-8");
        // 1. insert a book;
        String isbn = request.getParameter("isbn");
        String bookName = request.getParameter("bookName");
        String price = request.getParameter("price");
        BookDao bookDao = new BookDao();
        bookDao.save(new Book(Integer.valueOf(isbn),bookName,Integer.valueOf(price)));
        // 2. redirect bookList
        response.setContentType("text/html;charset=UTF-8"); // 返回一个网页，且网页可以使用中文
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>登录成功</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
//            printWriter.println("恭喜你，登录成功");
        // 登录成功，显示图书列表，完成curd；
        List<Book> result = bookDao.getAll();
        printWriter.println("<table width='90%' border=1>");
        printWriter.println("<caption>图书管理系统</caption>");
        printWriter.println("<tr>");
        printWriter.println("<td>");
        printWriter.println("序号");
        printWriter.println("</td>");
        printWriter.println("<td>");
        printWriter.println("isbn");
        printWriter.println("</td>");
        printWriter.println("<td>");
        printWriter.println("书名");
        printWriter.println("</td>");
        printWriter.println("<td>");
        printWriter.println("价格");
        printWriter.println("</td>");
        printWriter.println("</tr>");
        for (int i = 0; i < result.size(); i++) {
            printWriter.println("<tr>");
            printWriter.println("<td>");
            printWriter.println(i+1);
            printWriter.println("</td>");
            printWriter.println("<td>");
            printWriter.println(result.get(i).getIsbn());
            printWriter.println("</td>");
            printWriter.println("<td>");
            printWriter.println(result.get(i).getBookName());
            printWriter.println("</td>");
            printWriter.println("<td>");
            printWriter.println(result.get(i).getPrice());
            printWriter.println("</td>");
            printWriter.println("</tr>");
        }
        printWriter.println("</table>");
        printWriter.println("<a href='addBook.html'>添加新图书</a>");
        printWriter.println("</body>");
        printWriter.println("</html>");
        printWriter.close();
    }
}
