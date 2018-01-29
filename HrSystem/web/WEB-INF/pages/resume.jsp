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
    <title>标题</title>
</head>
<body <%--background="11.jpg"--%> >


<table align="center" width="750"  border="1" cellpadding="0" cellspacing="0">
    <tr>
        <td colspan="2"><h1><center>个人简历</center></h1></td>
    </tr>
    <tr>
        <td rowspan="4" width="100px">
            姓名：xxkkll<br>
            性别：男<br>
        </td>
       <td>AAA</td>
    </tr>
    <tr>
        <td>BBB</td>
    </tr>
    <tr>
        <td>BBB</td>
    </tr>
    <tr>
        <td>BBB</td>
    </tr>


    <%--<tr>
        <td><b>任职情况</b><br />
            2011.9至今    宿舍舍长<br />
            2012.10    系学生会办公室主任<br />
        </td>
        &lt;%&ndash; <td width="250" rowspan="2" &lt;%&ndash;background="22.jpg"&ndash;%&gt;></td>&ndash;%&gt;
        <td width="500"><b>现单位</b>海同科技</td>
        <td><b>教育/培训经历</b><br>
    </tr>--%>
</table>
</body>
</html>
