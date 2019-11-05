package nefu.edu.cn.zjh.servlet;

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
@WebServlet(name = "LifeCycleServlet",value = "/life.do",loadOnStartup = 1)
public class LifeCycleServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

        System.out.println("Life生命周期开始了：init");
    }

    public LifeCycleServlet(){
        super();
        System.out.println("构造方法调用了，，，");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("提供服务方法被调用...");
        try {
            Thread.sleep(5000);
            System.out.println("线程名"+Thread.currentThread().getName()+"对象地址："+this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        response.getWriter().append("Serve at :").append(request.getContextPath());
    }


    @Override
    public void destroy() {
        System.out.println("销毁完成了：destroy");
    }
}
