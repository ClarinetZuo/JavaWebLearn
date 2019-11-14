<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ClarinetZuo
  Date: 2019/11/13
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%List<String> list = (List<String>) request.getAttribute("names");%>
<table width="80%" border="1">
    <%
        for (String s:
             list) {

        %>
    <tr>
        <td><%=s%></td>
    </tr>
    <%}%>
</table>
${book.isbn}<br/>
${book.bookName}<br/>
${book.price}<br/>
<c:choose>
    <c:when test="${book.price > 50}">
        这本书的价格大于50元
    </c:when>
    <c:when test="${book.price <= 50}">
        这本书的价格小于等于50元
    </c:when>

</c:choose>

</body>
</html>
