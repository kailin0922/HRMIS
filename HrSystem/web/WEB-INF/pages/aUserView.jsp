<%--
  Created by IntelliJ IDEA.
  User: xkl
  Date: 2018/1/28
  Time: 19:16
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
${user}<br>
<a href="jobInfo" style="text-decoration: none"><input id="jobInfo" type="button" value="招聘信息"></a><br>
<a href="toResume" style="text-decoration: none"><input type="button" value="个人简历"></a><br>
<a href="toApplyRecord" style="text-decoration: none"><input type="button" value="申请职位记录"></a><br>
<a href="" style="text-decoration: none"><input type="button" value="面试通知"></a><br>
</body>
</html>
