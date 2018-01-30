<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>管理员申请职位记录表</title>
</head>
<body>
<table border="1" cellpadding="1" cellspacing="1">
    <tr>
        <td>Id</td>
        <td>用户姓名uid</td>
        <td>申请职位</td>
        <td>所属部门</td>
        <td>状态</td>
    </tr>
    <c:forEach items="${allApplyRecords}" var="allApplyRecord">
        <tr>
            <td>${allApplyRecord.id}</td>
            <c:forEach items="${users}" var="user">
                <c:if test="${user.id==allApplyRecord.uid}">
                   <td> ${user.name}</td>
                </c:if>
            </c:forEach>
            <td>
               <c:forEach items="${recruitments}" var="recruitment">
                   <c:if test="${recruitment.id==allApplyRecord.recruid}">
                       ${recruitment.name}
                   </c:if>
               </c:forEach> 
            </td>
            <td>
                <c:forEach items="${recruitments}" var="recruitment">
                    <c:if test="${recruitment.id==allApplyRecord.recruid}">
                        <c:forEach items="${departments}" var="depart">
                            <c:if test="${depart.id==recruitment.deptid}">
                                ${depart.deptname}
                            </c:if>
                        </c:forEach>
                    </c:if>
                </c:forEach>
            </td>
            <td>
                <c:if test="${allApplyRecord.state==0}">
                    <a href="manageLookResume?uid=${allApplyRecord.uid}&id=${allApplyRecord.id}">查看简历</a>
                </c:if>
                <c:if test="${allApplyRecord.state==1}">
                    <a href="manageLookResume?uid=${allApplyRecord.uid}&id=${allApplyRecord.id}">已查看简历，未回复</a>
                </c:if>
                <c:if test="${allApplyRecord.state==2}">
                    已拒绝
                </c:if>
                <c:if test="${allApplyRecord.state==3}">
                    已通知面试
                </c:if>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
