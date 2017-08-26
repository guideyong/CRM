<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CRM客户关系管理系统</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" type="text/css"
          href="/js/jquery-easyui/themes/default/easyui.css">
    <!-- 样式文件 -->
    <link rel="stylesheet" type="text/css"
          href="/js/jquery-easyui/themes/icon.css">
    <!--图标样式  -->
    <script type="text/javascript" src="/js/jquery-easyui/jquery.min.js"></script>
    <!-- jQuery核心库 -->
    <script type="text/javascript"
            src="/js/jquery-easyui/jquery.easyui.min.js"></script>
    <!-- EasyUI核心库 -->
    <script type="text/javascript"
            src="/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="index.js"></script>
    <script type="text/javascript">
        function login() {
            $.ajax({
                type: 'post',
                url: '/login',
                data:$("form").serialize(),
                success: function (data) {
                    //将json字符串转化为json对象
                   // data = $.parseJSON(data);
                    if (data.success) {
                        //如果登录成功，跳转
                        location.href = "/main"
                    } else {
                        //如果登录失败给出响应的提示信息
                        $.messager.alert("温馨提示", data.msg, "info")
                    }
                },
                dataType:"json"
            })
        }
        function resetFrom() {
            $("form")[0].reset();
        }
        $(function () {
            $(document.documentElement).on("keydown",function(e){
                if(e.keyCode==13){
                    login();
                }
            })
        })
    </script>
</head>
<body>
<% session.invalidate();%>
<section class="container">
    <div class="login">
        <h1>用户登录</h1>
        <form method="post" id="myFrom">
            <p><input type="text" name="username" value="" placeholder="账号"></p>
            <p><input type="password" name="password" value="" placeholder="密码"></p>
            <p class="submit">
                <input type="button" value="登录" onclick="login()">
                <input type="button" value="重置" onclick="resetFrom()">
            </p>
        </form>
    </div>
    <div style="text-align:center;" class="login-help">
        <p>©2017 西安财经学院信管1402桂德雍</p>
    </div>
</section>
</body>
</html>