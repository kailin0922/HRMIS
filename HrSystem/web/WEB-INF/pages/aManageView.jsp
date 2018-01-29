<%--
  Created by IntelliJ IDEA.
  User: xkl
  Date: 2018/1/27
  Time: 20:15
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
<a href="toManageJobInfo" style="text-decoration: none"><input type="button" value="招聘信息管理"></a><br>
</body>
</html>
