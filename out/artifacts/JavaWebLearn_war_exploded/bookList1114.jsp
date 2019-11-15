<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ClarinetZuo
  Date: 2019/11/15
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="addBook1114.jsp" method="post">
    <table border="1" width="90%" align="center">
        <caption>图书列表</caption>
        <tr>
            <td>
                序号
            </td>
            <td>
                isbn
            </td>
            <td>
                书名
            </td>
            <td>
                价格
            </td>
            <td>
                操作
            </td>
        </tr>
        <c:forEach items="${list}" var="book" varStatus="state">
            <tr>
                <td>${state.count}</td>
                <td>${book.isbn}</td>
                <td>${book.bookName}</td>
                <td>${book.price}</td>
                <td><a href="editBook1114.do?isbn=${book.isbn}">编辑</a>  <a href="deleteBook1114.do?isbn=${book.isbn}"> 删除</a></td>
            </tr>
        </c:forEach>
    </table>
<input type="submit" value="添加新图书">
</form>
</body>
</html>
