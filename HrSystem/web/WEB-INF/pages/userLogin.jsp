<%--
  Created by IntelliJ IDEA.
  User: xkl
  Date: 2018/1/25
  Time: 15:49
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
    <title>游客界面</title>
</head>
<body>
<div id="divLogUser">
    请输入名称：<input  id="logName" type="text" name="logname"><br>
    请输入密码：<input  id="logPass" type="password" name="logpass"><br>
    <input id="log" type="button" value="登录">
    <input id="regUser" type="button" value="注册"><br>
</div>
<div id="divRegUser" style="display: none">
    <form action="regUser" method="post">
        请设置名称：<input id="username" type="text" name="name"><span  id="spRegUser"></span> <br>
        请设置密码：<input id="userpass" type="password" name="pass"><span id="spRegPass"></span><br>
        请确认密码：<input id="cuserpass" type="password" name="cpass"><span id="spRegCpass"></span><br>
        <input id=saveUser type="button" value="注册"><input type="reset" value="重置"><input type="button" id="cancerRegUser" value="取消">
    </form>
</div>
</body>
<script src="js/jquery-3.1.0.js"></script>
<script>
    $(function () {
        var x=false;
        var y=false;
        var z=false;
            $("#log").click(function () {
               $.ajax({
                    type:"post",
                    url:"logUser",
                    data:{"logname":$("#logName").val(),"logpass":$("#logPass").val()},
                    success:function (obj) {
                       if(obj=="ok"){
                          /* location.reload(true);*/
                          $(location).attr("href","aUserView")
                       }else if(obj=="sorry"){
                           alert("没有此用户，请先注册")
                       }
                   },
                   error:function () {
                       alert("error")
                   }
               });
           });
        $("#regUser").click(function () {
            $("#divRegUser").show();
            $("#divLogUser").hide();
        });
        $("#cancerRegUser").click(function () {
            $("#divRegUser").hide();
            $("#divLogUser").show();
        });
        /*游客用户名判定*/
        $("#username").blur(function () {
            if($("#username").val()==""||$("#username").val()==null){
                $("#spRegUser").html("帐号不能为空")
                $("#spRegUser").css("color","red");
            }else {
                $("#spRegUser").html("OK");
                $("#spRegUser").css("color","green");
                x=true;
            }
        });
        /*游客密码判定*/
        $("#userpass").blur(function () {
            var len=$("#userpass").val().length;
            if(len<3||len>16){
                $("#spRegPass").html("密码长度需为3-16");
                $("#spRegPass").css("color","red");
            }else {
                $("#spRegPass").html("OK");
                $("#spRegPass").css("color","green");
                y=true;
            }
        });
        /*游客密码确认判定*/
        $("#cuserpass").blur(function () {
            if($("#userpass").val()==$("#cuserpass").val()){
                $("#spRegCpass").html("OK");
                $("#spRegCpass").css("color","green");
                z=true;
            }else {
                $("#spRegCpass").html("密码不一致");
                $("#spRegCpass").css("color","red")
            }
        });
        /*这里加入上面三个都对，就执行submint,否则button*/
        $("#saveUser").click(function () {
            if(x==true&y==true&z==true){
                $("#saveUser").attr("type","submit");
            }
        });
    })
</script>
</html>
