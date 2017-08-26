$(function () {
    var customerresourcepoolDatagrid, customerresourcepoolDialog, customerresourcepoolForm, customerresourcepoolSearchForm, customerresourcepoolDatagridEditBtn, customerresourcepoolDialog2, customerresourcepoolForm2;
    customerresourcepoolDatagrid = $("#customerresourcepool_datagrid");
    customerresourcepoolDialog = $("#customerresourcepool_dialog");
    customerresourcepoolForm = $("#customerresourcepool_form");
    customerresourcepoolDialog2 = $("#customerresourcepool_dialog2");
    customerresourcepoolForm2 = $("#customerresourcepool_form2");
    customerresourcepoolSearchForm = $("#customerresourcepool_searchForm");
    customerresourcepoolDatagridEditBtn = $("#tt a");

    //统一管理方法
    var cmdObj = {
        resetFrom: function () {
            customerresourcepoolSearchForm.form("clear");
        },
        //高级查询数据转换传输到后台
        searchContent: function () {
            var param = {};
            var paramArr = customerresourcepoolSearchForm.serializeArray();
            for (var i = 0; i < paramArr.length; i++) {
                param[paramArr[i].name] = paramArr[i].value;
            }
            customerresourcepoolDatagrid.datagrid("load", param);
        },
        cancel: function () {
            customerresourcepoolDialog.dialog("close");
        },

        receive:function () {
            //吸纳
            var rowData = customerresourcepoolDatagrid.datagrid("getSelected");
            if (rowData) {
                //删除之前让用户确定是否需要删除数据
                $.messager.confirm("温馨提示", "确定要吸纳该客户吗？", function (r) {
                    if (r) {
                        //点击确定后进入
                        $.get("/customerresourcepool_receive?id=" + rowData.id, function (data) {
                            if (data.success) {
                                //给出对应的提示刷新表格
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    customerresourcepoolDatagrid.datagrid("reload");//刷新
                                });
                            } else {
                                $.messager.alert("温馨提示", data.msg, "warning");
                            }
                        }, "json");//直接返回json对象不需要解析
                    }
                })
            } else {
                $.messager.alert("温馨提示", "请选择需要吸纳的客户", "warning");
            }
        },
        refresh: function () {
            customerresourcepoolDatagrid.datagrid("reload");
        }
    };
    //给按钮添加统一的事件
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    customerresourcepoolDatagrid.datagrid({
        url: "/customerresourcepool_list",
        fit: true,
        title: "客户资源池信息",
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        singleSelect: true,
        columns: [
            [
                {field: "name", title: "客户姓名", width: 100, align: 'center'},
                {field: "age", title: "年龄", width: 100, align: 'center'},
                {field: "gender", title: "性别", width: 100, formatter: genderFormatter, align: 'center'},
                {field: "tel", title: "电话号码", width: 100, align: 'center'},
                {field: "email", title: "邮箱", width: 100, align: 'center'},
                {field: "qq", title: "qq", width: 100, align: 'center'},
                {field: "wechart", title: "微信", width: 100, align: 'center'},
                {field: "job", title: "职业", width: 100, formatter: systemdictionaryitemFormatter, align: 'center'},
                {
                    field: "salarylevel",
                    title: "收入水平",
                    width: 100,
                    formatter: systemdictionaryitemFormatter,
                    align: 'center'
                },
                {
                    field: "customersource",
                    title: "客户来源",
                    width: 100,
                    formatter: systemdictionaryitemFormatter,
                    align: 'center'
                },
                {field: "inchargeuser", title: "负责人", width: 100, formatter: userFormatter, align: 'center'},
                {field: "inputuser", title: "创建人", width: 100, formatter: userFormatter, align: 'center'},
                {field: "inputtime", title: "日期", width: 100, align: 'center'},
                {field: "status", title: "状态", width: 100, formatter: statusFormatter, align: 'center'}
            ]
        ],
        toolbar: "#tt"
    });
});
function genderFormatter(value, record, index) {
    if (value)
        return "男";
    else
        return "女";
}
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
function statusFormatter(value, record, index) {
    if (value == 0)
        return "<font color='green'>潜在客户</font>";
    else if (value == 1)
        return "<font color='green'>正式客户</font>";
    else if (value == 2)
        return "<font color='green'>资源池客户</font>";
    else if (value == -2)
        return "<font color='red'>流失</font>";
    else if (value == -1)
        return "<font color='red'>开发失败</font>";
}

