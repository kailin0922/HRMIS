<%--
  Created by IntelliJ IDEA.
  User: xkl
  Date: 2018/1/29
  Time: 9:49
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
<a href="toUserView">此用户已存在，点击返回注册界面</a>
</body>
</html>
