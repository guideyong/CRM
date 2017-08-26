<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="/WEB-INF/views/common.jsp"/>
    <script type="text/javascript" src="../../js/views/contractchart.js"></script>
    <style type="text/css">
        .border_top_none {
            border-top: none
        }
    </style>
    <title>销售金额报表</title>
</head>
<body>
<table id="contractchart_datagrid" headerCls="border_top_none"></table>
<!--定义底部按钮  -->
<div id="tt">
    <div>
        <div id="chart" class="easyui-window" title="销售金额报表" style="width:1100px;height:550px"
             data-options="iconCls:'icon-chart_a',modal:true,closed: true">
            <iframe src='/mchart' style='width:100%;height:95%' frameborder=0 SCROLLING="NO"></iframe>
        </div>
        <div id="chart2" class="easyui-window" title="销售金额报表" style="width:1100px;height:550px"
             data-options="iconCls:'icon-chart_a',modal:true,closed: true">
            <iframe src='/mchart2' style='width:100%;height:95%' frameborder=0 SCROLLING="NO"></iframe>
        </div>
        <a class="easyui-linkbutton" iconCls="icon-bar" plain="true" data-cmd="chart">生成柱状图</a>
        <a class="easyui-linkbutton" iconCls="icon-pie" plain="true" data-cmd="chart2">生成饼状图</a>
        <a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="refresh">刷新</a>
    </div>
    <div>
        <form id="contractchart_searchForm">
            时间段查询:<input class="easyui-datebox" name="beginDate"/>
            -
            <input class="easyui-datebox" name="endDate"/>
            <a class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent">查询</a>
            分组信息<select name="groupType" class="easyui-combobox" panelHeight="auto" id="cc">
            <option value="month">月份</option>
            <option value="year">年份</option>
        </select>
        </form>
    </div>
</div>
</body>
</html>