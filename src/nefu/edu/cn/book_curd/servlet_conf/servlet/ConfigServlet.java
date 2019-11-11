package nefu.edu.cn.book_curd.servlet_conf.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author:Zuo Junhao
 * NEFU
 */
@WebServlet(name = "ConfigServlet",value = "/config.do",loadOnStartup = 1,initParams = {@WebInitParam(name="userName",value="root"),@WebInitParam(name="password",value="root"),@WebInitParam(name="url",value="jdbc:mysql://localhost:3306/zjhdb")})
public class ConfigServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        String userName = config.getInitParameter("userName");
        String password = config.getInitParameter("password");
        String url = config.getInitParameter("url");
        System.out.println("init userName:"+userName);
        System.out.println("init password:"+password);
        System.out.println("init url:"+url);

    }
}
