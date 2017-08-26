<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/js/HighChart/jquery-1.8.2.min.js"></script>
    <jsp:include page="/WEB-INF/views/common.jsp"/>
    <script type="text/javascript" src="/js/HighChart/highcharts.js"></script>
    <!-- 需要保存导出功能模块文件是在 highcharts.js 之后引入 -->
    <title>Title</title>
</head>
<body>
<div id="container" style="min-width: 750px; height: 275px; margin: 0 auto">
</div>
<script type="application/javascript">
    window.onload=function () {
        var groupTypes=${groupTypes}; //接收后台传来的数据
        var numbers=${numbers};
        $('#container').highcharts({
            chart: {
                type: 'column'
            },
            title: {
                text: ''
            },
            xAxis: {
                categories: groupTypes,
                crosshair: true
            },
            yAxis: {
                min: 0,
                title: {
                    text: '金额 (元)'
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} 元</b></td></tr>',
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
                name: '销售金额',
                data: numbers,
            }]
        });
    }

</script>
</body>
</html>
