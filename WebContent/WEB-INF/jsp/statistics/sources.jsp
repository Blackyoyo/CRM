<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>客户来源统计</title>
</head>
<body>
<script src="${pageContext.request.contextPath }/js/echarts.js"></script>
<script type="text/javascript"
    src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">

        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        var sources = $.parseJSON('${sources}');
        var num = $.parseJSON('${num}');
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '客户来源统计',
            },
            tooltip: {},
            legend: {
                data:['数量']
            },
            xAxis:{
                data: sources
            },
            yAxis: {},
            series: [{
                name: '数量',
                type: 'bar',
                data: num
            }]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

    </script>
</body>

</html>