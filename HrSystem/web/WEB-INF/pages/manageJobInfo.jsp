<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xkl
  Date: 2018/1/26
  Time: 9:47
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
    <title>招聘信息</title>
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
            <td><form action="deleteRecru" method="post">
                <input type="hidden" name="recruid" value="${recruitment.id}"><br>
                <input type="submit" value="删除">
            </form> </td>
        </tr>
    </c:forEach>
</table>
<input id="add" type="button" value="添加招聘职位信息">
<form id="addRecru" action="addRecru" method="post" style="display: none">
    职位名称：<input name="name"><br>
    所属部门：
    <select name="deptid">
        <c:forEach items="${departments}" var="dept">
           <option  value="${dept.id}">${dept.deptname}</option>
        </c:forEach>
    </select><br>需求人数：<input  name="peoplenumber"><br><%--这里添加数字正则判定--%>
    薪&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;水：<input name="salary"><br>
    工作地点：<input name="workplace"><br>
    职位需求：<textarea name="requirement"></textarea><br>

    <input type="submit" value="确定"><input type="button" value="取消" id="cancerRecru">
</form>
</body>
<script src="js/jquery-3.1.0.js"></script>
<script>
    $(function () {
        $("#add").click(function () {
            $("#addRecru").show();
        });
        $("#cancerRecru").click(function () {
            $("#addRecru").hide();
        })
    })
</script>
</html>
