<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/js/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/js/carhartl-jquery-cookie-92b7715/jquery.cookie.js"></script>
    <!-- jQuery核心库 -->
        <%
    //从cookies中读取主题名称
    String easyuiThemeName = "default";
    String col="blue";
    Cookie cookies[] = request.getCookies();
    if(cookies != null && cookies.length > 0){
        for(int i=0; i<cookies.length; i++){
            if(cookies[i].getName().equals("easyuiThemeName")){
                easyuiThemeName = cookies[i].getValue();
                break;
            }
            if(cookies[i].getName().equals("col")){
                col = cookies[i].getValue();
                break;
            }
        }
    }
%>
    <link id="easyuiTheme" rel="stylesheet" type="text/css"
          href="/js/jquery-easyui/themes/<%=easyuiThemeName%>/easyui.css">
    <!-- 样式文件 -->
    <link rel="stylesheet" type="text/css"
          href="/js/jquery-easyui/themes/icon.css">
    <!--图标样式  -->
    <script type="text/javascript"
            src="/js/jquery-easyui/jquery.easyui.min.js"></script>
    <!-- EasyUI核心库 -->
    <script type="text/javascript"
            src="/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
    <%--bug补丁包--%>
    <script type="text/javascript"
            src="/js/jquery-easyui/base.js"></script>
    <script type="application/javascript">
        /**
         * 更换主题
         */
        changeTheme = function (type, col) {
            var easyuiTheme = $('#easyuiTheme');
            var head = $("#head");
            var color='#'+col;
            head.css('background', color);
            var url = easyuiTheme.attr('href');
            var href = url.substring(0, url.indexOf('themes')) + 'themes/' + type + '/easyui.css';
            easyuiTheme.attr('href', href);

            // 如果使用了iframe  则要添加下面这段代码、否则的话iframe中的内容不会出现样式的改变
            /*        var $iframe = $('iframe');
             if($ifram.length > 0){
             for ( var i = 0; i < $iframe.length; i++) {
             var ifr = $iframe[i];
             $(ifr).contents.find('#easyuiTheme').attr('href', href);

             }
             }*/
            $.cookie('easyuiThemeName', type, {
                expires: 7
            });
            $.cookie('col', col, {
                expires: 7
            });
            $.messager.alert("温馨提示", '更换皮肤成功', "info", function () {
                //确定之后关闭对话框
                $("#theme_dialog").dialog("close");
            })
        };
    </script>

