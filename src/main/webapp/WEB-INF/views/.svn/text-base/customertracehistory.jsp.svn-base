<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="/WEB-INF/views/common.jsp"/>
    <script type="text/javascript" src="../../js/views/customertracehistory.js"></script>
    <style type="text/css">
        .border_top_none {
            border-top: none
        }
    </style>
    <title>跟进历史</title>
</head>
<body>
<table id="customertracehistory_datagrid" headerCls="border_top_none"></table>
<!--定义底部按钮  -->
<div id="tt">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
        <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">编辑</a>
        <a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">删除</a>
        <a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="refresh">刷新</a>
    </div>
    <div>
        <form id="customertracehistory_searchForm">
            客户:
            <input class="easyui-combobox" name="customerID" panelHeight="auto"
                   data-options="url:'/potentialcustomer_all2',valueField:'id',textField:'name'"/>
            时间段查询:<input class="easyui-datebox" name="beginDate">
            -
            <input class="easyui-datebox" name="endDate">
            <a class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent">查询</a>
            <a class="easyui-linkbutton" iconCls="icon-clear" data-cmd="resetFrom">清空</a>
        </form>
    </div>
</div>
<!--定义对话框  -->
<div id="customertracehistory_dialog">
    <form id="customertracehistory_form" method="post">
        <table align="center" style="margin-top: 15px">
            <input type="hidden" name="id"/>
            <tr>
                <td>开发时间</td>
                <td><input class="easyui-datebox" name="plantime"/></td>
            </tr>
            <tr>
                <td>开发主题</td>
                <td><input class="easyui-textbox" name="plansubject"/></td>
            </tr>
            <tr>
                <td>开发内容</td>
                <td><input class="easyui-textbox" name="plandetails"/></td>
            </tr>
            <tr>
                <td>开发实施方式</td>
                <td>
                    <input class="easyui-combobox"  name="plantype.id" panelHeight="auto"
                           data-options="url:'/systemdictionaryitem_byone?id=4',valueField:'id',textField:'name'"/></td>
            </tr>
            <tr>
                <td>开发效果</td>
                <td>
                    <select class="easyui-combobox" name="traceresult"  panelHeight="auto" style="width:145px;">
                        <option value="3">优</option>
                        <option value="2">中</option>
                        <option value="1">差</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>备注</td>
                <td><input class="easyui-textbox" name="remark"/></td>
            </tr>
            <tr>
                <td>正式客户</td>
                <td><input class="easyui-combobox" name="customerid.id" panelHeight="auto"
                           data-options="url:'/potentialcustomer_all2',valueField:'id',textField:'name'"/></td>
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