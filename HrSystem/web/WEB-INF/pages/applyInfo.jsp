<%--
  Created by IntelliJ IDEA.
  User: xkl
  Date: 2018/1/29
  Time: 16:44
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
${allApplyRecords}
<table border="1" cellpadding="1" cellspacing="1">
    <tr>
        <td>Id</td>
        <td>Id</td>
        <td>Id</td>
        <td>Id</td>
        <td>Id</td>
    </tr>
</table>
</body>
</html>
