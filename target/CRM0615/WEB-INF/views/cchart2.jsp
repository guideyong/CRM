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
<form action="/cchart2" id="pp" method="post">
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
        var datas=${datas}; //接收后台传来的数据

        $("#ff").change(function () {
            $("#pp").submit();
        });
        $('#container').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: '正式客户报表'
            },
            subtitle: {
                text: '按照${group}分组'
            },
            tooltip: {
                headerFormat: '{series.name}<br>',
                pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    datasowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                        style: {
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                        }
                    }
                }
            },
            series: [{
                type: 'pie',
                name: '正式客户数量百分比',
                data: datas
            }]
        });
    }
</script>
</body>
</html>
