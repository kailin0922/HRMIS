<%--
  Created by IntelliJ IDEA.
  User: xkl
  Date: 2018/1/30
  Time: 14:12
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
您好！欢迎成为我司员工！<br>
您的员工登录帐号为：${employee.name}<br>
您的员工登录密码为：${employee.pass}<br>
<a href="index.jsp">点击进入登录界面</a>
</body>
</html>
