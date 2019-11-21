<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
当前在线人数:${count}<br/>
当前登录人数:${fn:length(loginMap)}<br/>
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
        <c:forEach items="${pageInfo.list}" var="book" varStatus="state">
            <tr>
                <td>${state.count}</td>
                <td>${book.isbn}</td>
                <td>${book.bookName}</td>
                <td>${book.price}</td>
                <td><a href="editBook1114.do?isbn=${book.isbn}">编辑</a>  <a href="deleteBook1114.do?isbn=${book.isbn}"> 删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="5">
                <div>
                    总记录数：${pageInfo.recordCount }&nbsp;
                    总页数：${pageInfo.pageCount }&nbsp;
                    每页记录数：${pageInfo.pageSize }&nbsp;
                    当前页数：${pageInfo.currentPage }&nbsp;
                    当前URL：${pageInfo.url }&nbsp;&nbsp;
                    <a class="urlaction" href="javascript:return void(0)" value="1">首页</a>
                    <a class="urlaction" href="javascript:return void(0)" value="${pageInfo.pageCount}">尾页</a>
                </div>
            </td>
        </tr>
    </table>
<input type="submit" value="添加新图书">
</form>
<form action="&{pageInfo.url}" method="post">
    <input type="hidden" name="currentPage"/>
</form>
</body>
</html>
