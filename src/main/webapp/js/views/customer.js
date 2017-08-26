$(function () {
    var customerDatagrid, customerDialog, customerForm, customerSearchForm, customerDatagridEditBtn, customerDialog2, customerForm2;
    customerDatagrid = $("#customer_datagrid");
    customerDialog = $("#customer_dialog");
    customerForm = $("#customer_form");
    customerDialog2 = $("#customer_dialog2");
    customerForm2 = $("#customer_form2");
    customerSearchForm = $("#customer_searchForm");
    customerDatagridEditBtn = $("#tt a");

    //统一管理方法
    var cmdObj = {
        resetFrom: function () {
            customerSearchForm.form("clear");
        },
        //高级查询数据转换传输到后台
        searchContent: function () {
            var param = {};
            var paramArr = customerSearchForm.serializeArray();
            for (var i = 0; i < paramArr.length; i++) {
                param[paramArr[i].name] = paramArr[i].value;
            }
            customerDatagrid.datagrid("load", param);
        },
        add: function () {
            customerDialog.dialog("open");
                customerDialog.dialog("setTitle", "新增");
            //清除内容
            customerForm.form("clear")
        },
        save2:function () {
            //移交操作
            url = "/customer_transfer";
            customerForm2.form("submit", {
                url: url,
                success: function (data) {
                    data = $.parseJSON(data);//字符串转换成json对象格式
                    if (data) {
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            //确定之后关闭对话框
                            customerDialog2.dialog("close");
                            customerDatagrid.datagrid("load");//重新加载表格
                        })
                    } else {
                        $.messager.alert("温馨提示", data.msg, "error")
                    }
                }
            })
        },
        save: function () {
            //先判断到底是新增还是更新
            var url;
            var id = $("input[name='id']").val();
            if (id) {
                //编辑操作
                url = "/customer_update";
            } else {
                //新增
                url = "/customer_save";
            }
            customerForm.form("submit", {
                url: url,
                success: function (data) {
                    data = $.parseJSON(data);//字符串转换成json对象格式
                    if (data) {
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            //确定之后关闭对话框
                            customerDialog.dialog("close");
                            customerDatagrid.datagrid("load");//重新加载表格
                        })
                    } else {
                        $.messager.alert("温馨提示", data.msg, "error")
                    }
                }
            })
        },
        cancel: function () {
            customerDialog.dialog("close");
        },

        edit: function () {
            //获取一行数据
            var rowData = customerDatagrid.datagrid("getSelected");
            if (rowData) {
                customerDialog.dialog("open");
                customerDialog.dialog("setTitle", "编辑");
                //清除内容
                customerForm.form("clear");
                //添加一个属性
                if (rowData.job) {
                    rowData["job.id"] = rowData.job.id;
                }
                else {
                    rowData["job.id"] = null;
                }
                if (rowData.salarylevel) {
                    rowData["salarylevel.id"] = rowData.salarylevel.id;
                }
                else {
                    rowData["salarylevel.id"] = null;
                }
                if (rowData.customersource) {
                    rowData["customersource.id"] = rowData.customersource.id;
                }
                else {
                    rowData["customersource.id"] = null;
                }
                //数据回显
                customerForm.form("load", rowData);
            } else {
                $.messager.alert("温馨提示", "请选择需要编辑的数据", "warning");
            }
        },
        del: function () {
            //先判断用户是否有选中数据
            var rowData = customerDatagrid.datagrid("getSelected");
            if (rowData) {
                //删除之前让用户确定是否需要删除数据
                $.messager.confirm("温馨提示", "确定要删除该客户吗？", function (r) {
                    if (r) {
                        //点击确定后进入
                        $.get("/customer_delete?id=" + rowData.id, function (data) {
                            if (data.success) {
                                //给出对应的提示刷新表格
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    customerDatagrid.datagrid("reload");//刷新
                                });
                            } else {
                                $.messager.alert("温馨提示", data.msg, "warning");
                            }
                        }, "json");//直接返回json对象不需要解析
                    }
                })
            } else {
                $.messager.alert("温馨提示", "请选择需要删除的客户", "warning");
            }

        },
        failOpen:function () {
          //开发失败
            var rowData = customerDatagrid.datagrid("getSelected");
            if (rowData) {
                //删除之前让用户确定是否需要删除数据
                $.messager.confirm("温馨提示", "确定标记为开发失败吗？", function (r) {
                    if (r) {
                        //点击确定后进入
                        $.get("/customer_failOpen?id=" + rowData.id, function (data) {
                            if (data.success) {
                                //给出对应的提示刷新表格
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    customerDatagrid.datagrid("reload");//刷新
                                });
                            } else {
                                $.messager.alert("温馨提示", data.msg, "warning");
                            }
                        }, "json");//直接返回json对象不需要解析
                    }
                })
            } else {
                $.messager.alert("温馨提示", "请选择需要标记为开发失败的客户", "warning");
            }
        },
        lost:function () {
            //流失
            var rowData = customerDatagrid.datagrid("getSelected");
            if (rowData) {
                //删除之前让用户确定是否需要删除数据
                $.messager.confirm("温馨提示", "确定流失该客户吗？", function (r) {
                    if (r) {
                        //点击确定后进入
                        $.get("/customer_lost?id=" + rowData.id, function (data) {
                            if (data.success) {
                                //给出对应的提示刷新表格
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    customerDatagrid.datagrid("reload");//刷新
                                });
                            } else {
                                $.messager.alert("温馨提示", data.msg, "warning");
                            }
                        }, "json");//直接返回json对象不需要解析
                    }
                })
            } else {
                $.messager.alert("温馨提示", "请选择需要标记流失的客户", "warning");
            }
        },
        intoPull:function () {
            //移入资源池
            var rowData = customerDatagrid.datagrid("getSelected");
            if (rowData) {
                //删除之前让用户确定是否需要删除数据
                $.messager.confirm("温馨提示", "确定将该客户移入资源池吗？", function (r) {
                    if (r) {
                        //点击确定后进入
                        $.get("/customer_intoPull?id=" + rowData.id, function (data) {
                            if (data.success) {
                                //给出对应的提示刷新表格
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    customerDatagrid.datagrid("reload");//刷新
                                });
                            } else {
                                $.messager.alert("温馨提示", data.msg, "warning");
                            }
                        }, "json");//直接返回json对象不需要解析
                    }
                })
            } else {
                $.messager.alert("温馨提示", "请选择需要移入资源池的客户", "warning");
            }
        },
        change:function () {
            //转正
            var rowData = customerDatagrid.datagrid("getSelected");
            if (rowData) {
                    //删除之前让用户确定是否需要删除数据
                    $.messager.confirm("温馨提示", "确定要转正该客户吗？", function (r) {
                        if (r) {
                            //点击确定后进入
                            $.get("/customer_change?id=" + rowData.id, function (data) {
                                if (data.success) {
                                    //给出对应的提示刷新表格
                                    $.messager.alert("温馨提示", data.msg, "info", function () {
                                        customerDatagrid.datagrid("reload");//刷新
                                    });
                                } else {
                                    $.messager.alert("温馨提示", data.msg, "warning");
                                }
                            }, "json");//直接返回json对象不需要解析
                        }
                    })
            } else {
                $.messager.alert("温馨提示", "请选择需要转正的客户", "warning");
            }
        },
        //客户移交
        transfer: function () {
            //获取一行数据
            var rowData = customerDatagrid.datagrid("getSelected");
            if (rowData){
                customerDialog2.dialog("open");
                    customerDialog2.dialog("setTitle", "客户移交");
                //清除内容
                customerForm2.form("clear");
                if (rowData.inchargeuser) {
                    rowData["inchargeuser.username"] = rowData.inchargeuser.username;
                }
                else {
                    rowData["inchargeuser.username"] = null;
                }
                //数据回显
                customerForm2.form("load", rowData);
            }else {
                $.messager.alert("温馨提示", "请选择需要移交的客户", "warning");
            }
        },
        refresh: function () {
            customerDatagrid.datagrid("reload");
        }
    };
    //给按钮添加统一的事件
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    customerDatagrid.datagrid({
        url: "/customer_list",
        fit: true,
        title: "客户信息",
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
                {field: "status", title: "状态", width: 100, formatter: statusFormatter, align: 'center'}
            ]
        ],
        toolbar: "#tt",
            onClickRow: function (rowIndex, rowData) {
               if (rowData.status==-2) {
                   //让按钮变灰
                   customerDatagridEditBtn.eq(3).linkbutton("disable");
                    customerDatagridEditBtn.eq(4).linkbutton("disable");
                   customerDatagridEditBtn.eq(5).linkbutton("disable");
                }
                else{
                   customerDatagridEditBtn.eq(3).linkbutton("enable");
                    customerDatagridEditBtn.eq(4).linkbutton("enable");
                    customerDatagridEditBtn.eq(5).linkbutton("enable");
                }
            }
    });
    customerDialog.dialog({
        width: 300,
        height: 400,
        buttons: "#tb",
        closed: true
    });
    customerDialog2.dialog({
        width: 300,
        height: 200,
        buttons: "#tc",
        closed: true
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

