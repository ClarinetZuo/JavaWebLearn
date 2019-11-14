package nefu.edu.cn.web1112.servlet;

import nefu.edu.cn.book_curd.vo.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * author:Zuo Junhao
 * NEFU
 */
@WebServlet(name = "BookList1Servlet", value = "/bookList1.action")
public class BookList1Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> names = new ArrayList<>();

        names.add("张继科");
        names.add("张继科");
        names.add("马龙");
        names.add("许昕");

        //将names保存在request中
        req.setAttribute("names", names);
        req.setAttribute("userName", "马龙");

        Book book = new Book(12345, "Hadoop权威指南", 100);
        Book book1 = new Book(135, "Kafka权威指南", 99);

        req.setAttribute("book", book);

        req.getSession().setAttribute("book", book1);

        req.setAttribute("stringList", names);
        req.setAttribute("array", new String[]{"viscaria", "968", "stiga45"});
        List<Book> set = new ArrayList<>();
        set.add(new Book(00, "傲慢与偏见", 123));
        set.add(new Book(01, "好吗好的", 124));
        set.add(new Book(02, "阿弥陀佛么么哒", 125));
        set.add(new Book(03, "我不", 126));
        set.add(new Book(04, "天龙八部", 127));
        set.add(new Book(05, "乒乓球技巧", 128));
        set.add(new Book(06, "公安基础知识", 129));
        set.add(new Book(07, "行测", 130));

        req.setAttribute("set",set);

        Map<Integer,Book> map = new HashMap<>();
        map.put(1,new Book(00, "傲慢与偏见", 123));
        map.put(2,new Book(01, "好吗好的", 124));
        map.put(3,new Book(02, "阿弥陀佛么么哒", 125));
        map.put(4,new Book(03, "我不", 126));
        map.put(5,new Book(04, "天龙八部", 127));
        map.put(6,new Book(05, "乒乓球技巧", 128));
        map.put(7,new Book(06, "公安基础知识", 129));
        req.setAttribute("map",map);

        req.setAttribute("date",new Date());

        // 做一个页面的转发
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewList.jsp");

        requestDispatcher.forward(req, resp);
    }
}
