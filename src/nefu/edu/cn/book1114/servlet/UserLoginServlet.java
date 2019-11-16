package nefu.edu.cn.book1114.servlet;

import nefu.edu.cn.book1114.dao.UserDao;
import nefu.edu.cn.book1114.vo.User;

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
@WebServlet(name = "UserLoginServlet",value = "/userLogin.do")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        //1. 获取数据
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        // 2. 逻辑搞起来
        User user = userDao.getUser(userName,password);
        // 3. 转发
        if (null != user){
            req.getSession().setAttribute("user",user);
            userDao.updateUserLoginCount(user.getUserId());
            resp.sendRedirect("bookList1114.do");
        }else {
            resp.sendRedirect("userLogin.do");
        }
    }
}
