<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: ClarinetZuo
  Date: 2019/11/12
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="login.jsp" method="post">
        userName:<input type="text" name="userName"/><br/>
        password:<input type="password" name="password"/><br/>
        <%out.println("还有谁；你的随机数是："+new Random().nextInt());%><br/>
    <input type="submit" value="提交"/>
    <%-- 100个按钮--%>
<%--        <%--%>
<%--            for (int i = 0; i < 100; i++) {--%>
<%--                if (i % 10 == 0){--%>
<%--                    out.println("<br/>");--%>
<%--                }--%>
<%--                out.println("<input type='button' value='按钮'/>");--%>
<%--            }--%>
<%--        %>--%>
    </form>
</body>
</html>
