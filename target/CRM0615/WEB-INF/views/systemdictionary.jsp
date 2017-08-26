<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="/WEB-INF/views/common.jsp"/>
    <script type="text/javascript" src="../../js/views/systemdictionary.js"></script>
    <style type="text/css">
        .border_top_none {
            border-top: none
        }
    </style>
    <title>数据字典</title>
</head>
<body>
<table align="center" width="100%" height="565px" headerCls="border_top_none">
    <tr height="100%">
        <td width="50%" height="100%">
            <table id="systemdictionary_datagrid"></table>
        </td>
        <td width="50%" height="100%">
            <table id="systemdictionaryitem_datagrid"></table>
        </td>
    </tr>
</table>
<!--定义底部按钮  -->
<div id="tt">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
        <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">编辑</a>
        <a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">删除</a>
        <a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="refresh">刷新</a>
    </div>
</div>
<!--定义对话框  -->
<div id="systemdictionaryitem_dialog">
    <form id="systemdictionaryitem_form" method="post">
        <table align="center" style="margin-top: 15px">
            <input type="hidden" name="id"/>
            <tr>
                <td>字典明细名称</td>
                <td><input class="easyui-textbox" name="name"/></td>
            </tr>
            <tr>
                <td>字典明细简介</td>
                <td><input class="easyui-textbox" name="intro"/></td>
            </tr>
            <tr>
                <td>字典目录</td>
                <td>
                    <input class="easyui-combobox" id="systemdictionarybox" name="parent.id" panelHeight="auto"
                           data-options="url:'/systemdictionary_list',valueField:'id',textField:'name'"/>
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