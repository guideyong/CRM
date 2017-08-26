<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="common.jsp"/>
    <script type="text/javascript" src="js/views/employee.js"></script>
    <style type="text/css">
        .border_top_none {
            border-top: none
        }
    </style>
    <title>员工管理</title>
</head>
<body>
<table id="employee_datagrid"  headerCls="border_top_none"></table>
<!--定义底部按钮  -->
<div id="tt">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-useradd" plain="true" data-cmd="add">新增</a>
        <a class="easyui-linkbutton" iconCls="icon-useredit" plain="true" data-cmd="edit">编辑</a>
        <a class="easyui-linkbutton" iconCls="icon-userdelete" plain="true" data-cmd="del">离职</a>
        <a class="easyui-linkbutton" iconCls="icon-userreload" plain="true" data-cmd="refresh">刷新</a>
    </div>
    <div>
        <form id="employee_searchForm">
            关键字:<input class="easyui-textbox" name="keyword" placeholder="编号或名称">
            日期<input class="easyui-datebox" name="beginDate">
            -
            <input class="easyui-datebox" name="endDate">
            状态：<select name="state" class="easyui-combobox" panelHeight="auto">
            <option value="">全部</option>
            <option value="1">正常</option>
            <option value="0">离职</option>
        </select>
            <a class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent">查询</a>
            <a class="easyui-linkbutton" iconCls="icon-clear" data-cmd="resetFrom">清空</a>
        </form>
    </div>
</div>
<!--定义对话框  -->
<div id="employee_dialog">
    <form id="employee_form" method="post">
        <table align="center" style="margin-top: 15px">
            <input type="hidden" name="id"/>
            <tr>
                <td>账号</td>
                <td><input class="easyui-textbox" name="username"/></td>
            </tr>
            <tr>
                <td>真实姓名</td>
                <td><input class="easyui-textbox" name="realname"/></td>
            </tr>
            <tr>
                <td>电话</td>
                <td><input class="easyui-textbox" name="tel"/></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input class="easyui-textbox" name="email"/></td>
            </tr>
            <tr>
                <td>部门</td>
                <td>
                    <input class="easyui-combobox" name="dept.id" panelHeight="auto"
                           data-options="url:'/department_queryForEmp',valueField:'id',textField:'name'"/>
                </td>
            </tr>
            <tr>
                <td>角色</td>
                <td>
                    <input class="easyui-combobox" id="employee_roleCombo" panelHeight="auto"
                           data-options="url:'/role_queryForEmp',valueField:'id',textField:'name',multiple:true"/>
                </td>
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