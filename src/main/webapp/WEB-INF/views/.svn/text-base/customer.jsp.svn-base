<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="/WEB-INF/views/common.jsp"/>
    <script type="text/javascript" src="../../js/views/customer.js"></script>
    <style type="text/css">
        .border_top_none {
            border-top: none
        }
    </style>
    <title>正式客户管理</title>
</head>
<body>
<table id="customer_datagrid" headerCls="border_top_none"></table>
<!--定义底部按钮  -->
<div id="tt">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
        <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">编辑</a>
        <a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">删除</a>
        <a class="easyui-linkbutton" iconCls="icon-transfer" plain="true" data-cmd="transfer">移交</a>
        <a class="easyui-linkbutton" iconCls="icon-lost" plain="true" data-cmd="lost">流失</a>
        <a class="easyui-linkbutton" iconCls="icon-intoPull" plain="true" data-cmd="intoPull">移入资源池</a>
        <a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="refresh">刷新</a>
    </div>
    <div>
        <form id="customer_searchForm">
            关键字:<input class="easyui-textbox" name="keyword" placeholder="姓名或手机号码">
            状态<select name="status" class="easyui-combobox" panelHeight="auto">
            <option value="">全部</option>
            <option value="1">正式客户</option>
            <option value="-2">流失客户</option>
        </select>
            <a class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent">查询</a>
            <a class="easyui-linkbutton" iconCls="icon-clear" data-cmd="resetFrom">清空</a>
        </form>
    </div>
</div>
<!--定义对话框  -->
<div id="customer_dialog">
    <form id="customer_form" method="post">
        <table align="center" style="margin-top: 15px">
            <input type="hidden" name="id"/>
            <tr>
                <td>客户姓名</td>
                <td><input class="easyui-textbox" name="name"/></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input class="easyui-textbox" name="age"/></td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <select class="easyui-combobox" name="gender"  panelHeight="auto" style="width:145px;">
                        <option value="1">男</option>
                        <option value="0">女</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>电话号码</td>
                <td><input class="easyui-textbox" name="tel"/></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input class="easyui-textbox" name="email"/></td>
            </tr>
            <tr>
                <td>qq</td>
                <td><input class="easyui-textbox" name="qq"/></td>
            </tr>
            <tr>
                <td>微信</td>
                <td><input class="easyui-textbox" name="wechart"/></td>
            </tr>
            <tr>
                <td>职业</td>
                <td>
                    <input class="easyui-combobox"  name="job.id" panelHeight="auto"
                           data-options="url:'/systemdictionaryitem_byone?id=1',valueField:'id',textField:'name'"/>
                </td>
            </tr>
            <tr>
                <td>收入水平</td>
                <td>
                    <input class="easyui-combobox"  name="salarylevel.id" panelHeight="auto"
                           data-options="url:'/systemdictionaryitem_byone?id=2',valueField:'id',textField:'name'"/>
                </td>
            </tr>
            <tr>
                <td>客户来源</td>
                <td>
                    <input class="easyui-combobox"  name="customersource.id" panelHeight="auto"
                           data-options="url:'/systemdictionaryitem_byone?id=3',valueField:'id',textField:'name'"/>
                </td>
            </tr>
        </table>
    </form>
</div>

<div id="customer_dialog2">
    <form id="customer_form2" method="post">
        <table align="center" style="margin-top: 15px">
            <input type="hidden" name="id"/>
            <tr>
                <td>当前潜在客户</td>
                <td><input class="easyui-textbox"data-options="disabled:true"  name="name"/></td>
            </tr>
            <tr>
                <td>当前潜在客户负责人</td>
                <td><input class="easyui-textbox"data-options="disabled:true"  name="inchargeuser.username"/></td>
            </tr>
            <tr>
                <td>将客户移交给</td>
                <td>
                    <input class="easyui-combobox"  name="inchargeuser.id"
                           data-options="url:'/employee_all',valueField:'id',textField:'username'"/>
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
<div id="tc">
    <a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save2">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
</div>
</body>
</html>