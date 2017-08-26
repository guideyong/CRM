$(function () {
    var contractchartDatagrid, contractchartDialog, contractchartForm, contractchartSearchForm, contractchartDatagridEditBtn, contractchartDialog2, contractchartForm2;
    contractchartDatagrid = $("#contractchart_datagrid");
    contractchartDialog = $("#contractchart_dialog");
    contractchartSearchForm = $("#contractchart_searchForm");

    $("#cc").combobox({
        onChange: function (newValue, oldValue) {
            var param = {};
            var paramArr = contractchartSearchForm.serializeArray();
            for (var i = 0; i < paramArr.length; i++) {
                param[paramArr[i].name] = paramArr[i].value;
            }
            contractchartDatagrid.datagrid("load", param);
        }
    });
    //统一管理方法
    var cmdObj = {
        resetFrom: function () {
            contractchartSearchForm.form("clear");
        },
        //高级查询数据转换传输到后台
        searchContent: function () {
            var param = {};
            var paramArr = contractchartSearchForm.serializeArray();
            for (var i = 0; i < paramArr.length; i++) {
                param[paramArr[i].name] = paramArr[i].value;
            }
            contractchartDatagrid.datagrid("load", param);
        },
        cancel: function () {
            contractchartDialog.dialog("close");
        },
        chart:function () {
            $('#chart').window('open');
        },
        chart2:function () {
            $('#chart2').window('open');
        },
        refresh: function () {
            contractchartDatagrid.datagrid("reload");
        }
    };
    //给按钮添加统一的事件
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    contractchartDatagrid.datagrid({
        url: "/contractchart_list",
        fit: true,
        title: "销售金额信息",
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        singleSelect: true,
        columns: [
            [
                {field: "groupType", title: "分组信息", width: 100, align: 'center'},
                {field: "number", title: "销售金额（单位元）", width: 100, align: 'center'}
            ]
        ],
        toolbar: "#tt"
    });
});

function systemdictionaryitemFormatter(value, record, index) {
    if (value)
        return value.name;
    else
        return value;
}
function userFormatter(value, record, index) {
    if (value)
        return value.username;
    else
        return value;
}


