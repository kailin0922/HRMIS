<%--
  Created by IntelliJ IDEA.
  User: xkl
  Date: 2018/1/27
  Time: 19:43
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
<div id="divLogin">
    <form action="manageLogin" method="post">
        帐号：<input name="manageName"><br>
        密码：<input type="password" name="managePass"><br>
        <input id="inputLogin" type="submit" value="登录">
    </form>
</div>
</body>
</html>
