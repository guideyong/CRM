$(function () {
    var customerdevplanDatagrid,customerdevplanDialog,customerdevplanForm,customerdevplanSearchForm,customerdevplanDatagridEditBtn;
    customerdevplanDatagrid=$("#customerdevplan_datagrid");
    customerdevplanDialog=$("#customerdevplan_dialog");
    customerdevplanForm=$("#customerdevplan_form");
    customerdevplanSearchForm=$("#customerdevplan_searchForm");
    customerdevplanDatagridEditBtn=$("#tt a");

    //统一管理方法
    var cmdObj={
        resetFrom:function() {
            customerdevplanSearchForm.form("clear");
    },
        //高级查询数据转换传输到后台
        searchContent:function() {
        var param = {};
        var paramArr = customerdevplanSearchForm.serializeArray();
        for (var i = 0; i < paramArr.length; i++) {
            param[paramArr[i].name] = paramArr[i].value;
        }
        customerdevplanDatagrid.datagrid("load", param);
    },
        add:function() {
        customerdevplanDialog.dialog("open");
            customerdevplanDialog.dialog("setTitle", "新增");
            //清除内容
            customerdevplanForm.form("clear")
            $("#customerdevplan_form input").eq(18).combobox("enable");
    },
        save:function() {
        //先判断到底是新增还是更新
        var url;
        var id = $("input[name='id']").val();
        if (id) {
            //编辑操作
            url = "/customerdevplan_update";
        } else {
            //新增
            url = "/customerdevplan_save";
        }
        customerdevplanForm.form("submit", {
            url: url,
            success: function (data) {
                data = $.parseJSON(data);//字符串转换成json对象格式
                if (data) {
                    $.messager.alert("温馨提示", data.msg, "info", function () {
                        //确定之后关闭对话框
                        customerdevplanDialog.dialog("close");
                        customerdevplanDatagrid.datagrid("load");//重新加载表格
                    })
                } else {
                    $.messager.alert("温馨提示", data.msg, "error")
                }
            }
        })
    },
        cancel:function() {
        customerdevplanDialog.dialog("close");
    },

        edit:function() {
        //获取一行数据
        var rowData = customerdevplanDatagrid.datagrid("getSelected");
        if (rowData) {
            customerdevplanDialog.dialog("open");
                customerdevplanDialog.dialog("setTitle", "编辑");
                //清除内容
                customerdevplanForm.form("clear");
            //添加一个属性
            if (rowData.plantype) {
                rowData["plantype.id"] = rowData.plantype.id;
            }
            else {
                rowData["plantype.id"] = null;
            }
            if (rowData.customerid) {
                rowData["customerid.id"] = rowData.customerid.id;
            }
            else {
                rowData["customerid.id"] = null;
            }
            if (rowData.inputuser) {
                rowData["inputuser.id"] = rowData.inputuser.id;
            }
            else {
                rowData["inputuser.id"] = null;
            }
            //数据回显
            customerdevplanForm.form("load", rowData);
            $("#customerdevplan_form input").eq(18).combobox("disable");
        } else {
            $.messager.alert("温馨提示", "请选择需要编辑的数据", "warning");
        }
    },
        del:function() {
        //先判断用户是否有选中数据
        var rowData = customerdevplanDatagrid.datagrid("getSelected");
        if (rowData) {
            //删除之前让用户确定是否需要删除数据
            $.messager.confirm("温馨提示", "确定要删除该开发计划吗？", function (r) {
                if (r) {
                    //点击确定后进入
                    $.get("/customerdevplan_delete?id=" + rowData.id, function (data) {
                        if (data.success) {
                            //给出对应的提示刷新表格
                            $.messager.alert("温馨提示", data.msg, "info", function () {
                                customerdevplanDatagrid.datagrid("reload");//刷新
                            });
                        } else {
                            $.messager.alert("温馨提示", data.msg, "warning");
                        }
                    }, "json");//直接返回json对象不需要解析
                }
            })
        } else {
            $.messager.alert("温馨提示", "请选择需要删除的开发计划", "warning");
        }

    },
        refresh:function() {
        customerdevplanDatagrid.datagrid("reload");
    }
    };
    //给按钮添加统一的事件
    $("a[data-cmd]").on("click",function(){
        var cmd=$(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    customerdevplanDatagrid.datagrid({
        url: "/customerdevplan_list",
        fit: true,
        title: "客户开发计划信息",
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        singleSelect: true,
        columns: [
            [
                {field: "customerid", title: "潜在客户名称", width: 100,formatter: customeridFormatter,  align: 'center'},
                {field: "plansubject", title: "计划主题", width: 100, align: 'center'},
                {field: "plantype", title: "实施方式", width: 100,formatter: plantypeFormatter,  align: 'center'},
                {field: "traceresult", title: "跟进效果", width: 100,formatter: traceresultFormatter, align: 'center'},
                {field: "remark", title: "备注", width: 100, align: 'center'},
                {field: "inputuser", title: "创建人", width: 100,formatter: inputuserFormatter,  align: 'center'},
                {field: "inputtime", title: "创建时间", width: 100, align: 'center'},
                {field: "plantime", title: "计划时间", width: 100, align: 'center',hidden:true},
                {field: "plandetails", title: "计划内容", width: 100, align: 'center',hidden:true}
            ]
        ],
        toolbar: "#tt"
    });
    customerdevplanDialog.dialog({
        width: 300,
        height: 320,
        buttons: "#tb",
        closed: true
    });
});
function customeridFormatter(value, record, index) {
    if (value)
        return value.name;
    else
        return value;
}
function inputuserFormatter(value, record, index) {
    if (value)
        return value.username;
    else
        return value;
}
function plantypeFormatter(value, record, index) {
    if (value)
        return value.name;
    else
        return value;
}
function traceresultFormatter(value, record, index) {
    if (value == 3)
        return "<font color='green'>优</font>";
    else if (value == 2)
        return "<font color='#00bfff'>中</font>";
    else if (value == 1)
        return "<font color='red'>差</font>";
}


