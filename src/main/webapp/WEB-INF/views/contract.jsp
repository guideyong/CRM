<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="/WEB-INF/views/common.jsp"/>
    <script type="text/javascript" src="../../js/views/contract.js"></script>
    <link rel="stylesheet" type="text/css" href="/js/fancybox/jquery.fancybox.css">
    <script type="text/javascript" src="/js/fancybox/jquery.fancybox.pack.js"></script>
    <style type="text/css">
        .border_top_none {
            border-top: none
        }
    </style>
    <title>合同管理</title>
</head>
<body>
<table id="contract_datagrid" headerCls="border_top_none"></table>
<!--定义底部按钮  -->
<div id="tt">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
        <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">编辑</a>
        <a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">删除</a>
        <a class="easyui-linkbutton" iconCls="icon-examine" plain="true" data-cmd="examine">审核</a>
        <a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="refresh">刷新</a>
    </div>
    <div>
        <form id="contract_searchForm">
            客户姓名:
            <input class="easyui-combobox" name="customerID"
                   data-options="url:'/potentialcustomer_all3',valueField:'id',textField:'name'"/>
            状态<select name="status" class="easyui-combobox" panelHeight="auto">
            <option value="">全部</option>
            <option value="0">初始录入</option>
            <option value="1">审核通过</option>
        </select>
            开始日期:<input class="easyui-datebox" name="beginDate">
            -
            <input class="easyui-datebox" name="endDate">
            <a class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent">查询</a>
            <a class="easyui-linkbutton" iconCls="icon-clear" data-cmd="resetFrom">清空</a>
        </form>
    </div>
</div>
<!--定义对话框  -->
<div id="contract_dialog">
    <form id="contract_form" method="post" enctype="multipart/form-data">
        <table align="center" style="margin-top: 15px">
            <input type="hidden" name="id"/>
            <tr>
                <td>定金客户</td>
                <td><input class="easyui-combobox" name="customer_id"
                           data-options="url:'/potentialcustomer_all2',valueField:'id',textField:'name'"/></td>
            </tr>
            <tr>
                <td>签订时间</td>
                <td><input class="easyui-datebox" name="signtime"/></td>
            </tr>
            <tr>
                <td>合同金额</td>
                <td><input class="easyui-textbox" name="sum"/></td>
            </tr>
            <tr>
                <td>付款金额</td>
                <td><input class="easyui-textbox" name="money"/></td>
            </tr>
            <tr>
                <td>付款时间</td>
                <td><input class="easyui-datebox" name="paytime"/></td>
            </tr>
            <tr>
                <td>摘要</td>
                <td><input class="easyui-textbox" name="intro"/></td>
            </tr>
            <tr>
                <td>附件</td>
                <td><input class="easyui-filebox" data-options="buttonText:'选择附件'" name="file" multiple="multiple"/></td>
            </tr>
        </table>
    </form>
</div>
<!--定义底部按钮  -->
<div id="tb">
    <a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
</div>
<div id="dlg">
<img id="simg"  src="" style="width: 800px" height="800px">
</div>
</body>
</html>