<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ClarinetZuo
  Date: 2019/11/13
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <!-- 这是一个EL表达式-->
${userName}<br/>
${book.price gt 100}<br/>
    ${empty book.bookName}<br/>
    ${book.price > 100 ? '不买' : '买'} <!-- 三目运算符-->

${sessionScope.book.isbn}<br/>
${sessionScope.book.bookname}<br/>
${sessionScope.book.price}<br/>
${names[0]}
</body>
</html>
