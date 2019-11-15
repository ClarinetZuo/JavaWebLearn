<%--
  Created by IntelliJ IDEA.
  User: ClarinetZuo
  Date: 2019/11/15
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="addBook1114.do" method="post">
    <table>
        <tr>
            <td>isbn</td>
            <td><input type="text" name="isbn"/> </td>
        </tr>
        <tr>
            <td>书名</td>
            <td><input type="text" name="bookName"/> </td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text" name="price"/> </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>

</body>
</html>
