<%--
  Created by IntelliJ IDEA.
  User: xkl
  Date: 2018/1/30
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>标题</title>
</head>
<body>
<form action="employeeLogin" method="post">
    帐号：<input name="name"><br>
    密码：<input type="password" name="pass"><br>
    <input type="submit" value="登录">
    <a href="index.jsp"><input type="button" value="返回"></a>
</form>
</body>
</html>
