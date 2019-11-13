<%--
  Created by IntelliJ IDEA.
  User: ClarinetZuo
  Date: 2019/11/13
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% pageContext.setAttribute("page_info","page中的数据",pageContext.PAGE_SCOPE);
       pageContext.setAttribute("request_info","request中的数据",pageContext.REQUEST_SCOPE);
       request.setAttribute("request","request的数据2");
       session.setAttribute("session_info","会话数据");
       application.setAttribute("app_info","全局的数据");
    %>

    当前页面是否能看到数据;<br/>
    page:<%=pageContext.getAttribute("page_info",pageContext.PAGE_SCOPE)%><br/>
    request:<%=request.getAttribute("request_info")%>
    <br/><br/>
    ------------<br/>
    <!-- 转发-->
<%--    <%pageContext.forward("b.jsp");%>--%>
<%--    <%response.sendRedirect("b.jsp");%>--%>
    <%pageContext.include("b.jsp");%>
    <br/><br/>
    -----------还是a页面
</body>
</html>
