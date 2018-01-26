<%--
  Created by IntelliJ IDEA.
  User: xkl
  Date: 2018/1/25
  Time: 14:57
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
<a href="toUserView">我是游客</a>
<a href="toEmployeeView">我是员工</a>
<a href="toManageView">我是管理员</a>
</body>
</html>
