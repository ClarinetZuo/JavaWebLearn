<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: ClarinetZuo
  Date: 2019/11/12
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<br>
<head>
    <title>Title</title>
</head>
<!-- 这是html注释-->
<%-- 这是隐藏注释--%>
<%! int i=9;%>
<%! public int add(int a,int b){
    System.out.println("a:"+a+","+"b:"+b);
    return a+b;
}%>
<body>


<%@ include file="subPage.jsp"%>

    <form action="demoLogin.do" method="post">
    userName:<input type="text" name="userName"/></br>
    password:<input type="password" name="password"/></br>
    <input type="submit" value="提交"/>
    </form>
    i:<%=i%><br/>
    add:<%=add(i,10)%><br/>
    <%
        for (int j = 0; j < 100; j++) {
            out.println("<input type='button' value='按钮'/><br/>");
        }
    %>
    <%
        int j = 9;
        i++;
        j++;
    %>
    <%
        session.setAttribute("name","张继科");
    %>
    <br/>
    i:<%=i%><br/>
    j:<%=j%><br/>

    当前时间:<%=new Date()%><br/>

</body>
</html>
