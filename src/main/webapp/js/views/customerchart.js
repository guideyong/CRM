$(function () {
    var customerchartDatagrid, customerchartDialog, customerchartForm, customerchartSearchForm, customerchartDatagridEditBtn, customerchartDialog2, customerchartForm2;
    customerchartDatagrid = $("#customerchart_datagrid");
    customerchartDialog = $("#customerchart_dialog");
    customerchartSearchForm = $("#customerchart_searchForm");

    $("#cc").combobox({
        onChange: function (newValue, oldValue) {
            var param = {};
            var paramArr = customerchartSearchForm.serializeArray();
            for (var i = 0; i < paramArr.length; i++) {
                param[paramArr[i].name] = paramArr[i].value;
            }
            customerchartDatagrid.datagrid("load", param);
        }
    });
    //统一管理方法
    var cmdObj = {
        resetFrom: function () {
            customerchartSearchForm.form("clear");
        },
        //高级查询数据转换传输到后台
        searchContent: function () {
            var param = {};
            var paramArr = customerchartSearchForm.serializeArray();
            for (var i = 0; i < paramArr.length; i++) {
                param[paramArr[i].name] = paramArr[i].value;
            }
            customerchartDatagrid.datagrid("load", param);
        },
        cancel: function () {
            customerchartDialog.dialog("close");
        },
        chart:function () {
            $('#chart').window('open');
        },
        chart2:function () {
            $('#chart2').window('open');
        },
        refresh: function () {
            customerchartDatagrid.datagrid("reload");
        }
    };
    //给按钮添加统一的事件
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    customerchartDatagrid.datagrid({
        url: "/customerchart_list",
        fit: true,
        title: "正式客户信息",
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        singleSelect: true,
        columns: [
            [
                {field: "groupType", title: "分组信息", width: 100, align: 'center'},
                {field: "number", title: "正式客户数量", width: 100, align: 'center'}
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


