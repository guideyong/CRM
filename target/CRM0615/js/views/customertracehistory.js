$(function () {
    var customertracehistoryDatagrid,customertracehistoryDialog,customertracehistoryForm,customertracehistorySearchForm,customertracehistoryDatagridEditBtn;
    customertracehistoryDatagrid=$("#customertracehistory_datagrid");
    customertracehistoryDialog=$("#customertracehistory_dialog");
    customertracehistoryForm=$("#customertracehistory_form");
    customertracehistorySearchForm=$("#customertracehistory_searchForm");
    customertracehistoryDatagridEditBtn=$("#tt a");

    //统一管理方法
    var cmdObj={
        resetFrom:function() {
            customertracehistorySearchForm.form("clear");
    },
        //高级查询数据转换传输到后台
        searchContent:function() {
        var param = {};
        var paramArr = customertracehistorySearchForm.serializeArray();
        for (var i = 0; i < paramArr.length; i++) {
            param[paramArr[i].name] = paramArr[i].value;
        }
        customertracehistoryDatagrid.datagrid("load", param);
    },
        add:function() {
        customertracehistoryDialog.dialog("open");
            customertracehistoryDialog.dialog("setTitle", "新增");
            //清除内容
            customertracehistoryForm.form("clear")
            $("#customertracehistory_form input").eq(18).combobox("enable");
    },
        save:function() {
        //先判断到底是新增还是更新
        var url;
        var id = $("input[name='id']").val();
        if (id) {
            //编辑操作
            url = "/customertracehistory_update";
        } else {
            //新增
            url = "/customertracehistory_save";
        }
        customertracehistoryForm.form("submit", {
            url: url,
            success: function (data) {
                data = $.parseJSON(data);//字符串转换成json对象格式
                if (data) {
                    $.messager.alert("温馨提示", data.msg, "info", function () {
                        //确定之后关闭对话框
                        customertracehistoryDialog.dialog("close");
                        customertracehistoryDatagrid.datagrid("load");//重新加载表格
                    })
                } else {
                    $.messager.alert("温馨提示", data.msg, "error")
                }
            }
        })
    },
        cancel:function() {
        customertracehistoryDialog.dialog("close");
    },

        edit:function() {
        //获取一行数据
        var rowData = customertracehistoryDatagrid.datagrid("getSelected");
        if (rowData) {
            customertracehistoryDialog.dialog("open");
                customertracehistoryDialog.dialog("setTitle", "编辑");
                //清除内容
                customertracehistoryForm.form("clear");
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
            customertracehistoryForm.form("load", rowData);
            $("#customertracehistory_form input").eq(18).combobox("disable");
        } else {
            $.messager.alert("温馨提示", "请选择需要编辑的数据", "warning");
        }
    },
        del:function() {
        //先判断用户是否有选中数据
        var rowData = customertracehistoryDatagrid.datagrid("getSelected");
        if (rowData) {
            //删除之前让用户确定是否需要删除数据
            $.messager.confirm("温馨提示", "确定要删除该开发开发吗？", function (r) {
                if (r) {
                    //点击确定后进入
                    $.get("/customertracehistory_delete?id=" + rowData.id, function (data) {
                        if (data.success) {
                            //给出对应的提示刷新表格
                            $.messager.alert("温馨提示", data.msg, "info", function () {
                                customertracehistoryDatagrid.datagrid("reload");//刷新
                            });
                        } else {
                            $.messager.alert("温馨提示", data.msg, "warning");
                        }
                    }, "json");//直接返回json对象不需要解析
                }
            })
        } else {
            $.messager.alert("温馨提示", "请选择需要删除的开发开发", "warning");
        }

    },
        refresh:function() {
        customertracehistoryDatagrid.datagrid("reload");
    }
    };
    //给按钮添加统一的事件
    $("a[data-cmd]").on("click",function(){
        var cmd=$(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    customertracehistoryDatagrid.datagrid({
        url: "/customertracehistory_list",
        fit: true,
        title: "客户跟进历史信息",
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        singleSelect: true,
        columns: [
            [
                {field: "customerid", title: "正式客户名称", width: 100,formatter: customeridFormatter,  align: 'center'},
                {field: "plansubject", title: "开发主题", width: 100, align: 'center'},
                {field: "plantype", title: "实施方式", width: 100,formatter: plantypeFormatter,  align: 'center'},
                {field: "traceresult", title: "开发效果", width: 100,formatter: traceresultFormatter, align: 'center'},
                {field: "remark", title: "备注", width: 100, align: 'center'},
                {field: "inputuser", title: "创建人", width: 100,formatter: inputuserFormatter,  align: 'center'},
                {field: "inputtime", title: "创建时间", width: 100, align: 'center'},
                {field: "plantime", title: "开发时间", width: 100, align: 'center',hidden:true},
                {field: "plandetails", title: "开发内容", width: 100, align: 'center',hidden:true}
            ]
        ],
        toolbar: "#tt"
    });
    customertracehistoryDialog.dialog({
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


