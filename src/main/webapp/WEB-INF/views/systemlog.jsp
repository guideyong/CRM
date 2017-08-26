<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="/WEB-INF/views/common.jsp"/>
    <script type="text/javascript" src="../../js/views/systemlog.js"></script>
    <style type="text/css">
        .border_top_none {
            border-top: none
        }
    </style>
    <title>系统日志</title>
</head>
<body>
<table id="systemlog_datagrid" headerCls="border_top_none"></table>
<!--定义底部按钮  -->
<div id="tt">
    <div>
        <form id="systemlog_searchForm">
            关键字:<input class="easyui-textbox" name="keyword" placeholder="编号或名称">
            日期<input class="easyui-datebox" name="beginDate">
            -
            <input class="easyui-datebox" name="endDate">
            操作用户：
            <input class="easyui-combobox" name="opuserId"
                   data-options="url:'/employee_all',valueField:'id',textField:'username'"/>
            <a class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent">查询</a>
            <a class="easyui-linkbutton" iconCls="icon-clear" data-cmd="resetFrom">清空</a>
        </form>
    </div>
</div>
</body>
</html>