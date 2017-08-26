<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/js/HighChart/jquery-1.8.2.min.js"></script>
    <jsp:include page="/WEB-INF/views/common.jsp"/>
    <script type="text/javascript" src="/js/HighChart/highcharts.js"></script>
    <!-- 需要保存导出功能模块文件是在 highcharts.js 之后引入 -->
    <script src="/js/HighChart/modules/exporting.js"></script>
    <script src="/js/HighChart/export-csv.js"></script>
    <title>Title</title>
</head>
<body>
<form action="/cchart" id="pp" method="post">
    分组<select name="groupType" id="ff">
    <option>请选择(默认月份)</option>
    <option value="month">月份</option>
    <option value="year">年份</option>
</select>
</form>
<div id="container" style="min-width: 900px; height: 450px; margin: 0 auto">
</div>
<script type="application/javascript">
    window.onload=function () {
        var groupTypes=${groupTypes}; //接收后台传来的数据
        var numbers=${numbers};
        $("#ff").change(function () {
            $("#pp").submit();
        })
        $('#container').highcharts({
            chart: {
                type: 'column'
            },
            title: {
                text: '正式客户报表'
            },
            subtitle: {
                text: '按照${group}分组'
            },
            xAxis: {
                categories: groupTypes,
                crosshair: true
            },
            yAxis: {
                min: 0,
                title: {
                    text: '数量 (个)'
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} 个</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            series: [{
                name: '正式客户数量',
                data: numbers
            }]
        });
    }

</script>
</body>
</html>
