<%--
  Created by IntelliJ IDEA.
  User: ClarinetZuo
  Date: 2019/11/14
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
</head>
</bod>
遍历数组<br/>
<select name="pingpang" style="width:200px">
<c:forEach items="${array}" var="arrayElement">
<%--    <li>${arrayElement}</li>--%>
<%--    <input type="checkbox" value="${arrayElement}"/>${arrayElement}<br/>--%>
    <option value="${arrayElement}">${arrayElement }</option>
</c:forEach>
</select>
<br/>

遍历list<br/>
<c:forEach items="${stringList}" var="listEle">
<li>${listEle}</li>
</c:forEach>
<br/>

遍历set<br/>
<table width="90%" border="1">
    <tr>
        <td>编号</td>
        <td>图书编号</td>
        <td>图书名字</td>
        <td>价格</td>
        <td>操作</td>
    </tr>
<c:forEach items="${set}" var="setEle" varStatus="state">
    <tr>
        <td>${state.index}</td>
        <td>${setEle.isbn}</td>
        <td>${setEle.bookName}</td>
        <td>${setEle.price}</td>
        <td>操作</td>
    </tr>
</c:forEach>
</table>
遍历map<br/>
<table width="90%" border="1">
    <tr>
        <td>编号</td>
        <td>图书编号</td>
        <td>图书名字</td>
        <td>价格</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${map}" var="mapEle" varStatus="state">
        <tr>
            <td>${state.index}</td>
            <td>${mapEle.key}</td>
            <td>${mapEle.value.bookName}</td>
            <td>${mapEle.value.price}</td>
            <td>操作</td>
        </tr>
    </c:forEach>
</table>
<br/>
<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/><br/>
${fn:length(set)}<br/>
${fn:contains(userName, '龙')}
</body>
</html>
