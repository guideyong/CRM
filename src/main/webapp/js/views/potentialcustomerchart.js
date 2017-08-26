$(function () {
    var potentialcustomerchartDatagrid, potentialcustomerchartDialog, potentialcustomerchartForm, potentialcustomerchartSearchForm, potentialcustomerchartDatagridEditBtn, potentialcustomerchartDialog2, potentialcustomerchartForm2;
    potentialcustomerchartDatagrid = $("#potentialcustomerchart_datagrid");
    potentialcustomerchartDialog = $("#potentialcustomerchart_dialog");
    potentialcustomerchartSearchForm = $("#potentialcustomerchart_searchForm");

    $("#cc").combobox({
        onChange: function (newValue, oldValue) {
            var param = {};
            var paramArr = potentialcustomerchartSearchForm.serializeArray();
            for (var i = 0; i < paramArr.length; i++) {
                param[paramArr[i].name] = paramArr[i].value;
            }
            potentialcustomerchartDatagrid.datagrid("load", param);
        }
    });
    //统一管理方法
    var cmdObj = {
        resetFrom: function () {
            potentialcustomerchartSearchForm.form("clear");
        },
        //高级查询数据转换传输到后台
        searchContent: function () {
            var param = {};
            var paramArr = potentialcustomerchartSearchForm.serializeArray();
            for (var i = 0; i < paramArr.length; i++) {
                param[paramArr[i].name] = paramArr[i].value;
            }
            potentialcustomerchartDatagrid.datagrid("load", param);
        },
        cancel: function () {
            potentialcustomerchartDialog.dialog("close");
        },
        chart:function () {
            $('#chart').window('open');
        },
        chart2:function () {
            $('#chart2').window('open');
        },
        refresh: function () {
            potentialcustomerchartDatagrid.datagrid("reload");
        }
    };
    //给按钮添加统一的事件
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    potentialcustomerchartDatagrid.datagrid({
        url: "/potentialcustomerchart_list",
        fit: true,
        title: "潜在客户信息",
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        singleSelect: true,
        columns: [
            [
                {field: "groupType", title: "分组信息", width: 100, align: 'center'},
                {field: "number", title: "潜在客户数量", width: 100, align: 'center'}
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


