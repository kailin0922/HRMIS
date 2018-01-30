<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xkl
  Date: 2018/1/29
  Time: 15:31
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
    <title>游客职位申请记录表</title>
</head>
<body>
<table border="1" cellspacing="1" cellpadding="1" >
    <tr>
        <td>ID</td>
        <td>申请职位</td>
        <td>所属部门</td>
        <td>申请状态</td>
    </tr>
    <c:forEach items="${applyrecords}" var="applyrecord">
      <tr>
          <td>
                  ${applyrecord.id}
          </td>
          <td>
              <c:forEach items="${recruitments}" var="recruitmenr">
                  <c:if test="${applyrecord.recruid==recruitmenr.id}">
                      ${recruitmenr.name}
                  </c:if>
              </c:forEach>
          </td>
          <td>
              <c:forEach items="${recruitments}" var="recruitmenr">
                  <c:if test="${applyrecord.recruid==recruitmenr.id}">
                      <c:forEach items="${departments}" var="depart">
                          <c:if test="${depart.id==recruitmenr.deptid}">
                              ${depart.deptname}
                          </c:if>
                      </c:forEach>
                  </c:if>
              </c:forEach>
          </td>
          <td>
              <c:if test="${applyrecord.state==0}">
                  等待Hr读取消息
              </c:if>
              <c:if test="${applyrecord.state==1}">
                  Hr已经查看您的申请，请保持联络畅通
              </c:if>
              <c:if test="${applyrecord.state==2}">
                  您的申请已被拒绝
              </c:if>
              <c:if test="${applyrecord.state==3}">
                  收到面试通知
                  <a href="agreeInterView?id=${applyrecord.id}">确认面试</a>
                  <a href="refuseInterView?id=${applyrecord.id}">拒绝面试</a>
              </c:if>
              <c:if test="${applyrecord.state==4}">
                  <a href="userToEmployeeInfo">您已经接受面试，成为员工,点击查看您的信息</a>
              </c:if>
              <c:if test="${applyrecord.state==5}">
                  您已经拒绝面试
              </c:if>
          </td>
      </tr>
    </c:forEach>
</table>
</body>
</html>
