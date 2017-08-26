<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="/WEB-INF/views/common.jsp"/>
    <script type="text/javascript" src="../../js/views/cutomertransfer.js"></script>
    <style type="text/css">
        .border_top_none {
            border-top: none
        }
    </style>
    <title>客户移交记录管理</title>
</head>
<body>
<table id="cutomertransfer_datagrid" headerCls="border_top_none"></table>
<!--定义底部按钮  -->
<div id="tt">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-trans" plain="true" data-cmd="trans">创建客户移交</a>
        <a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="refresh">刷新</a>
    </div>
    <div>
        <form id="cutomertransfer_searchForm">
            客户姓名:
            <input class="easyui-combobox" name="customerID"
                   data-options="url:'/potentialcustomer_all3',valueField:'id',textField:'name'"/>
            开始时间:<input class="easyui-datebox" name="beginDate">
            -
            <input class="easyui-datebox" name="endDate">
            <a class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent">查询</a>
            <a class="easyui-linkbutton" iconCls="icon-clear" data-cmd="resetFrom">清空</a>
        </form>
    </div>
</div>
<!--定义对话框  -->
<div id="cutomertransfer_dialog">
    <form id="cutomertransfer_form" method="post">
        <table align="center" style="margin-top: 15px">
            <input type="hidden" name="id"/>
            <tr>
                <td>客户选择</td>
                <td><input class="easyui-combobox" name="customer.id"  data-options="url:'/potentialcustomer_all3',valueField:'id',textField:'name'"/></td>
            </tr>
            </tr>
            <tr>
                <td>新市场专员</td>
                <td><input class="easyui-combobox" name="newseller.id"
                           data-options="url:'/employee_all',valueField:'id',textField:'username'"/></td>
            </tr>
            <tr>
                <td>移交原因</td>
                <td><input class="easyui-textbox" name="transreason"/></td>
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