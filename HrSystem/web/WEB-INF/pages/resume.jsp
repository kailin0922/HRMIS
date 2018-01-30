<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: xkl
  Date: 2018/1/26
  Time: 12:27
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
    <title>简历</title>
    <style>
        .newRe{
            display: none;
        }
    </style>
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $("#createResume").click(function () {
                $("#divCreateResume").show();
            })
            $("#updateResume").click(function () {
                $(".oldRe").hide();
                $(".newRe").show()
            })
        })
    </script>
</head>
<body <%--background="11.jpg"--%> >
    <c:if test="${resumeState==0}">
        <input id="createResume" type="button" value="创建简历"><br>
        <div id="divCreateResume" style="display: none">
            <form action="createResume" method="post">
                <table align="center" width="1000"  border="1" cellpadding="0" cellspacing="0">
                    <tr>
                        <td colspan="2"><h1><center>个人简历</center></h1></td>
                    </tr>
                    <tr>
                        <td  width="200px">
                            <br><br><br>
                            姓名：<input name="name"><br><br><br><br>
                            性别：<input type="radio" name="sex" value="男">男
                                <input type="radio" name="sex" value="女">女<br><br><br>
                            年龄：<input name="age"><br><br><br><br>
                            电话：<input name="tel"><br><br><br><br>
                            地址：<input name="address"><br><br><br><br>
                            专业：<input name="major"><br><br><br>
                            <input type="hidden" name="uid" value="${user.id}">
                        </td>
                        <td>
                            <br>
                            项目经验：<br>
                            <textarea name="experience" style="resize:none;width: 750px;border: none"></textarea><br><br>
                            获奖情况：<br><br>
                            <textarea name="honor" style="width: 750px;border: none"></textarea><br><br>
                            职业证书：<br><br>
                            <textarea name="credential" style="width: 750px;border: none"></textarea><br><br>
                            自我评价：<br><br>
                            <textarea name="introduction" style="width: 750px;border: none"></textarea><br>
                        </td>
                    </tr>
                </table>
                <input type="submit" value="确定">
            </form>
        </div>
    </c:if>
    <c:if test="${resumeState==1}">
        <input id="updateResume" type="button" value="修改简历"><br>
        <div id="divUpdateResume">
            <form action="updateResume" method="post">
                <table align="center" width="1000"  border="1" cellpadding="0" cellspacing="0">
                    <tr>
                        <td colspan="2"><h1><center>个人简历</center></h1></td>
                    </tr>
                    <tr>
                        <td  width="200px">
                            <br><br><br>
                            <span class="oldRe">姓名：<input name="name" value="${resume.name}" disabled="true"><br><br><br><br></span>
                            <span class="newRe">姓名：<input name="name" value="${resume.name}"><br><br><br><br></span>
                            <span class="oldRe">性别：<input class="sex" value="${resume.sex}" disabled="true"><br><br><br></span>
                            <span class="newRe">性别： <input type="radio" name="sex" value="男" checked="checked">男
                                <input type="radio" name="sex" value="女">女<br><br><br></span>
                            <span class="oldRe">年龄：<input name="age" value="${resume.age}" disabled="true"><br><br><br><br></span>
                            <span class="newRe">年龄：<input name="age" value="${resume.age}" ><br><br><br><br></span>
                            <span class="oldRe">电话：<input name="tel" value="${resume.tel}" disabled="true"><br><br><br><br></span>
                            <span class="newRe">电话：<input name="tel" value="${resume.tel}" ><br><br><br><br></span>
                            <span class="oldRe"> 地址：<input name="address" value="${resume.address}" disabled="true"><br><br><br><br></span>
                            <span class="newRe">地址：<input name="address" value="${resume.address}" class="updateRe"><br><br><br><br></span>
                            <span class="oldRe">专业：<input name="major" value="${resume.major}" disabled="true"><br><br><br></span>
                            <span class="newRe"> 专业：<input name="major" value="${resume.major}" class="updateRe"><br><br><br></span>
                            <input type="hidden" name="uid" value="${user.id}">
                            <input type="hidden" name="id" value="${resume.id}">
                        </td>
                        <td>
                            <br>
                            <span class="oldRe"> 项目经验：<br>
                            <textarea name="experience" style="resize:none;width: 750px;border: none" disabled="true">${resume.experience}</textarea><br><br></span>
                            <span class="newRe"> 项目经验：<br>
                            <textarea name="experience" style="resize:none;width: 750px;border: none" class="updateRe">${resume.experience}</textarea><br><br></span>

                            <span class="oldRe">获奖情况：<br><br>
                            <textarea name="honor" style="width: 750px;border: none" disabled="true">${resume.honor}</textarea><br><br></span>
                            <span class="newRe"> 获奖情况：<br><br>
                            <textarea name="honor" style="width: 750px;border: none" class="updateRe">${resume.honor}</textarea><br><br></span>

                            <span class="oldRe"> 职业证书：<br><br>
                            <textarea name="credential" style="width: 750px;border: none" disabled="true">${resume.credential}</textarea><br><br></span>
                            <span class="newRe"> 职业证书：<br><br>
                            <textarea name="credential" style="width: 750px;border: none" class="updateRe">${resume.credential}</textarea><br><br></span>

                            <span class="oldRe">自我评价：<br><br>
                            <textarea name="introduction" style="width: 750px;border: none" disabled="true">${resume.introduction}</textarea><br></span>
                            <span class="newRe">自我评价：<br><br>
                            <textarea name="introduction" style="width: 750px;border: none" class="updateRe">${resume.introduction}</textarea><br></span>
                        </td>
                    </tr>
                </table>
                <input type="submit" value="确定">
            </form>
        </div>
    </c:if>
</body>
</html>
