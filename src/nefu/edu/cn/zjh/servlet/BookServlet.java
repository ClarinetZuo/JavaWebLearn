package nefu.edu.cn.zjh.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * author:Zuo Junhao
 * NEFU
 */
@WebServlet(name = "BookServlet", value = "/book.do")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName = request.getParameter("bookname"); // 注意字符串大小写，必须一毛一样
        String price = request.getParameter("price");
        String[] hobby = request.getParameterValues("hobby");
        String degree = request.getParameter("degree");
        System.out.println("name:" + new String(bookName.getBytes("ISO-8859-1"),"UTF-8"));
        System.out.println("price:" + price);
        System.out.println("degree:" + degree);
        System.out.println("hobby:" + Arrays.toString(hobby));
        System.out.println("-------");
        // 获得所有的请求参数名
        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
        System.out.println("以下是map");

        Map<String, String[]> map = request.getParameterMap();
        Set<Map.Entry<String, String[]>> set = map.entrySet();
        for (Map.Entry<String, String[]> a :
                set) {
            System.out.println(a.getKey() + ":" + Arrays.toString(a.getValue()));
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at : ").append(request.getContextPath());
    }
}
