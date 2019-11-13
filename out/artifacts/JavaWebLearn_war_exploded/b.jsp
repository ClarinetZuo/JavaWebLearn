<%--
  Created by IntelliJ IDEA.
  User: ClarinetZuo
  Date: 2019/11/13
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
这是b页面的信息<br/>
page:<%=pageContext.getAttribute("page_info",pageContext.PAGE_SCOPE)%><br/>
request:<%=request.getAttribute("request_info")%><br/>
session:<%=session.getAttribute("session_info")%><br/>
application:<%=application.getAttribute("app_info")%><br/>
</body>
</html>
