<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<table border="1" cellspacing="0" cellpadding="0">
    <tr>
        <td>Id</td>
        <td>职位名称</td>
        <td>部门</td>
        <td>需求人数peoplenumber</td>
        <td>岗位要求requirement</td>
        <td>工资salary</td>
        <td>工作地点workspace</td>
        <td>操作</td>
    </tr>
    <c:forEach var="recruitment" items="${recruitments}">
        <tr>
            <td>${recruitment.id}</td>
            <td>${recruitment.name}</td>
            <td><c:forEach var="department" items="${departments}">
                <c:if test="${recruitment.deptid==department.id}">
                    <c:out value="${department.deptname}"></c:out>
                </c:if>
                </c:forEach>
            <td>${recruitment.peoplenumber}</td>
            <td>${recruitment.requirement}</td>
            <td>${recruitment.salary}</td>
            <td>${recruitment.workplace}</td>
            <td><form action="applyRecru" method="post">
                <input type="hidden" name="recruid" value="${recruitment.id}"><br>
                <input type="submit" value="投递简历">
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
