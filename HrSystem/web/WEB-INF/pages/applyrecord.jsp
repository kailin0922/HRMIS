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
    <title>标题</title>
</head>
<body>
<table>
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
                  Hr已收到您的申请，请保持联络通畅
              </c:if>
          </td>
      </tr>
    </c:forEach>
</table>
</body>
</html>