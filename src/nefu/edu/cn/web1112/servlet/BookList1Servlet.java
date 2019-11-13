package nefu.edu.cn.web1112.servlet;

import nefu.edu.cn.book_curd.vo.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * author:Zuo Junhao
 * NEFU
 */
@WebServlet(name = "BookList1Servlet",value = "/bookList1.action")
public class BookList1Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> names = new ArrayList<>();

        names.add("张继科");
        names.add("张继科");
        names.add("马龙");
        names.add("许昕");

        //将names保存在request中
        req.setAttribute("names",names);
        req.setAttribute("userName","马龙");

        Book book = new Book(12345,"Hadoop权威指南",100);
        Book book1 = new Book(135,"Kafka权威指南",99);

        req.setAttribute("book",book);

        req.getSession().setAttribute("book",book1);

        // 做一个页面的转发
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("bookList.jsp");

        requestDispatcher.forward(req,resp);
    }
}
