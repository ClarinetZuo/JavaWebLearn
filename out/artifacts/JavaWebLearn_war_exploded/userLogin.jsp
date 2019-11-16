<%--
  Created by IntelliJ IDEA.
  User: ClarinetZuo
  Date: 2019/11/15
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="userLogin.do" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="userName"/></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="登录"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
