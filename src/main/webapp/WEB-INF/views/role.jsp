<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="common.jsp"/>
    <script type="text/javascript" src="../../js/views/role.js"></script>
    <style type="text/css">
        .border_top_none {
            border-top: none
        }
    </style>
    <title>角色管理</title>
</head>
<body>
<table id="role_datagrid" headerCls="border_top_none"></table>
<!--定义底部按钮  -->
<div id="tt">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
        <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">编辑</a>
        <a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">删除</a>
        <a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="refresh">刷新</a>
    </div>
    <div>
        <form id="role_searchForm">
            关键字:<input class="easyui-textbox" name="keyword" placeholder="编号或名称">
            <a class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent">查询</a>
            <a class="easyui-linkbutton" iconCls="icon-clear" data-cmd="resetFrom">清空</a>
        </form>
    </div>
</div>
<!--定义对话框  -->
<div id="role_dialog">
    <form id="role_form" method="post">
        <table align="center" style="margin-top: 15px">
            <input type="hidden" name="id"/>
            <tr>
                <td>角色名称：<input class="easyui-textbox" name="name"/></td>
                <td>角色编号：<input class="easyui-textbox" name="sn"/></td>
            </tr>

            <tr>
                <td><table id="selfPermission"></table></td>
                <td><table id="allPermission"></table></td>
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