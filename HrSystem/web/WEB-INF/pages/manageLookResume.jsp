<%--
  Created by IntelliJ IDEA.
  User: xkl
  Date: 2018/1/29
  Time: 19:25
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
    <title>管理员查看简历</title>
</head>
<body>

    <table align="center" width="1000"  border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td colspan="2"><h1><center>个人简历</center></h1></td>
        </tr>
        <tr>
            <td  width="200px">
                <br><br><br>
                <span class="oldRe">姓名：<input name="name" value="${resume.name}" disabled="true"><br><br><br><br></span>
                <span class="oldRe">性别：<input class="sex" value="${resume.sex}" disabled="true"><br><br><br></span>
                <span class="oldRe">年龄：<input name="age" value="${resume.age}" disabled="true"><br><br><br><br></span>
                <span class="oldRe">电话：<input name="tel" value="${resume.tel}" disabled="true"><br><br><br><br></span>
                <span class="oldRe"> 地址：<input name="address" value="${resume.address}" disabled="true"><br><br><br><br></span>
                <span class="oldRe">专业：<input name="major" value="${resume.major}" disabled="true"><br><br><br></span>
                <input type="hidden" name="uid" value="${resume.uid}">
                <input type="hidden" name="id" value="${resume.id}">
            </td>
            <td>
                <br>
                <span class="oldRe"> 项目经验：<br>
                            <textarea name="experience" style="resize:none;width: 750px;border: none" disabled="true">${resume.experience}</textarea><br><br></span>
                <span class="oldRe">获奖情况：<br><br>
                            <textarea name="honor" style="width: 750px;border: none" disabled="true">${resume.honor}</textarea><br><br></span>
                <span class="oldRe"> 职业证书：<br><br>
                            <textarea name="credential" style="width: 750px;border: none" disabled="true">${resume.credential}</textarea><br><br></span>
                <span class="oldRe">自我评价：<br><br>
                            <textarea name="introduction" style="width: 750px;border: none" disabled="true">${resume.introduction}</textarea><br></span>
            </td>
        </tr>
    </table>
    <a href="agreeApply?id=${applyreruitmentid}"><input type="button" value="发送面试通知"></a>
    <a href="refuseApply?id=${applyreruitmentid}"><input type="button" value="拒绝此次申请"></a>
    <a href="">返回</a>
</body>
</html>
