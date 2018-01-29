<%--
  Created by IntelliJ IDEA.
  User: xkl
  Date: 2018/1/28
  Time: 19:24
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
<table border="1" cellspacing="10" cellpadding="10">
    <tr>
        <td>Id</td>
        <td>deptid</td>
        <td>peoplenumber</td>
        <td>requirement</td>
        <td>salary</td>
        <td>workspace</td>
        <td>操作</td>
    </tr>
    <c:forEach var="recruitment" items="${recruitments}">
        <tr>
            <td>${recruitment.id}</td>
            <td>${recruitment.deptid}</td>
            <td>${recruitment.peoplenumber}</td>
            <td>${recruitment.requirement}</td>
            <td>${recruitment.salary}</td>
            <td>${recruitment.workplace}</td>
            <td><form action="applyRecru" method="post">
                <input type="hidden" name="recruid" value="${recruitment.id}"><br>
                <input type="submit" value="申请职位">
            </form> </td>
        </tr>
    </c:forEach>
</table>
</body>
<script src="js/jquery-3.1.0.js"></script>
<script>
    $(function () {

    })
</script>
</html>
