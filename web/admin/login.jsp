<%@ page import="nefu.edu.cn.book_curd.dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: ClarinetZuo
  Date: 2019/11/12
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    if ("admin".equals(userName) && "tiger".equals(password)) {
            out.println("欢迎您，您登陆成功了");
    }else{
        response.sendRedirect("index.jsp");
    }
%>
</body>
</html>
