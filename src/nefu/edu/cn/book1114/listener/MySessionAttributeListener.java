package nefu.edu.cn.book1114.listener; /**
 * author:Zuo Junhao
 * NEFU
 */

import nefu.edu.cn.book1114.vo.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.concurrent.ConcurrentHashMap;

@WebListener()
public class MySessionAttributeListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
    static ConcurrentHashMap<String, HttpSession> map = new ConcurrentHashMap<>();

    // Public constructor is required by servlet spec
    public MySessionAttributeListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
//        System.out.println("本次在Session中添加的属性名："+sbe.getName());
//        System.out.println("本次在Session中添加的属性值："+sbe.getValue());
//        System.out.println("本次添加的SessionId"+sbe.getSession().getId());
        if (sbe.getName().equals("user")) {
            User user = (User) sbe.getValue();
            // 当前账户是否正在线
            if (map.contains(user.getUserName())) {
                map.remove(user.getUserName()).invalidate();
            }

            map.put(user.getUserName(), sbe.getSession());
            System.out.println(user.getUserName()+"---------已上线");

        }
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
        if (sbe.getName().equals("user")) {
            User user = (User)sbe.getValue();
            map.remove(user.getUserName());
            System.out.println(user.getUserName()+"---------已下线");
        }
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
        // 下面两个是替换之前的session中的属性和值
        if (sbe.getName().equals("user")) {
            User user = (User) sbe.getValue();
            // 当前账户是否正在线
            if (map.contains(user.getUserName())) {
                map.remove(user.getUserName()).invalidate();
            }

            map.put(user.getUserName(), sbe.getSession());
            System.out.println(user.getUserName()+"---------已上线");

        }

    }
}
