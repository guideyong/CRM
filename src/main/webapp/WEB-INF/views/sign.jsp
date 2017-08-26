<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="/WEB-INF/views/common.jsp"/>
    <script type="text/javascript" src="../../js/views/sign.js"></script>
    <style type="text/css">
        .border_top_none {
            border-top: none
        }
    </style>
    <title>考勤信息</title>
</head>
<body>
<table id="sign_datagrid" headerCls="border_top_none"></table>
<!--定义顶部按钮  -->
<div id="tt">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-addsign" plain="true" data-cmd="addSign">补签</a>
        <a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="refresh">刷新</a>
    </div>
    <div>
        <form id="sign_searchForm">
            员工:
            <input class="easyui-combobox" name="userID"
                   data-options="url:'/employee_all',valueField:'id',textField:'username'"/></td>
            状态：<select name="status" class="easyui-combobox" panelHeight="auto">
            <option value="">全部</option>
            <option value="0">正常</option>
            <option value="1">迟到</option>
            <option value="2">早退</option>
            <option value="3">迟到早退</option>
        </select>
            <a class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent">查询</a>
            <a class="easyui-linkbutton" iconCls="icon-clear" data-cmd="resetFrom">清空</a>
        </form>
    </div>
</div>
<!--定义对话框  -->
<div id="sign_dialog">
    <form id="sign_form" method="post" enctype="multipart/form-data">
        <table align="center" style="margin-top: 15px">
            <input type="hidden" name="id"/>
            <tr>
                <td>补签员工</td>
                <td><input class="easyui-combobox" name="userId.id"
                           data-options="url:'/employee_all',valueField:'id',textField:'username'"/></td>
            </tr>
        </table>
    </form>
</div>
<!--定义底部按钮  -->
<div id="tb">
    <a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
</div>

</body>
</html>