<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="common.jsp"/>
    <script type="text/javascript" src="../../js/views/department.js"></script>
    <style type="text/css">
        .border_top_none {
            border-top: none
        }
    </style>
    <title>部门管理</title>
</head>
<body>
<table id="department_datagrid" headerCls="border_top_none"></table>
<!--定义底部按钮  -->
<div id="department_tt">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-departmentadd" plain="true" data-cmd="add">新增</a>
        <a class="easyui-linkbutton" iconCls="icon-departmentedit" plain="true" data-cmd="edit">编辑</a>
        <a class="easyui-linkbutton" iconCls="icon-departmentdelete" plain="true" data-cmd="del">停用</a>
        <a class="easyui-linkbutton" iconCls="icon-departmentreload" plain="true" data-cmd="refresh">刷新</a>
    </div>
    <div>
        <form id="department_searchForm">
            关键字:<input class="easyui-textbox" name="keyword" placeholder="编号或名称">
            状态：<select name="state" class="easyui-combobox" panelHeight="auto">
            <option value="">全部</option>
            <option value="1">正常</option>
            <option value="0">停用</option>
        </select>
            <a class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent">查询</a>
            <a class="easyui-linkbutton" iconCls="icon-clear" data-cmd="resetFrom">清空</a>
        </form>
    </div>
</div>
<!--定义对话框  -->
<div id="department_dialog">
    <form id="department_form" method="post">
        <table align="center" style="margin-top: 15px">
            <input type="hidden" name="id"/>
            <tr>
                <td>部门名称</td>
                <td><input class="easyui-textbox" name="name"/></td>
            </tr>
            <tr>
                <td>部门编码</td>
                <td><input class="easyui-textbox" name="sn"/></td>
            </tr>
            <tr>
                <td>部门经理</td>
                <td>
                <input class="easyui-combobox" name="manager.id"
                       data-options="url:'/employee_queryFordept',valueField:'id',textField:'username'"/>
                </td>
            </tr>
            <tr>
                <td>上级部门</td>
                <td>
                    <input class="easyui-combobox" name="parent.id" panelHeight="auto"
                           data-options="url:'/department_queryForEmp',valueField:'id',textField:'name'"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<!--定义底部按钮  -->
<div id="department_tb">
    <a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
</div>
</body>
</html>