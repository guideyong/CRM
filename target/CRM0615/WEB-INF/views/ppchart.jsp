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
<div id="container" style="min-width: 450px; height: 275px; margin: 0 auto">
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
                text: ''
            },
            subtitle: {
                text: '潜在客户'
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
                name: '潜在客户数量百分比',
                data: datas
            }]
        });
    }

</script>

</body>
</html>
