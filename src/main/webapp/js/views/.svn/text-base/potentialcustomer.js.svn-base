$(function () {
    var potentialcustomerDatagrid, potentialcustomerDialog, potentialcustomerForm, potentialcustomerSearchForm, potentialcustomerDatagridEditBtn, potentialcustomerDialog2, potentialcustomerForm2;
    potentialcustomerDatagrid = $("#potentialcustomer_datagrid");
    potentialcustomerDialog = $("#potentialcustomer_dialog");
    potentialcustomerForm = $("#potentialcustomer_form");
    potentialcustomerDialog2 = $("#potentialcustomer_dialog2");
    potentialcustomerForm2 = $("#potentialcustomer_form2");
    potentialcustomerSearchForm = $("#potentialcustomer_searchForm");
    potentialcustomerDatagridEditBtn = $("#tt a");

    //统一管理方法
    var cmdObj = {
        resetFrom: function () {
            potentialcustomerSearchForm.form("clear");
        },
        //高级查询数据转换传输到后台
        searchContent: function () {
            var param = {};
            var paramArr = potentialcustomerSearchForm.serializeArray();
            for (var i = 0; i < paramArr.length; i++) {
                param[paramArr[i].name] = paramArr[i].value;
            }
            potentialcustomerDatagrid.datagrid("load", param);
        },
        add: function () {
            potentialcustomerDialog.dialog("open"),
                potentialcustomerDialog.dialog("setTitle", "新增");
            //清除内容
            potentialcustomerForm.form("clear")
        },
        save2:function () {
            //移交操作
            url = "/potentialcustomer_transfer";
            potentialcustomerForm2.form("submit", {
                url: url,
                success: function (data) {
                    data = $.parseJSON(data);//字符串转换成json对象格式
                    if (data) {
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            //确定之后关闭对话框
                            potentialcustomerDialog2.dialog("close");
                            potentialcustomerDatagrid.datagrid("load");//重新加载表格
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
                url = "/potentialcustomer_update";
            } else {
                //新增
                url = "/potentialcustomer_save";
            }
            potentialcustomerForm.form("submit", {
                url: url,
                success: function (data) {
                    data = $.parseJSON(data);//字符串转换成json对象格式
                    if (data) {
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            //确定之后关闭对话框
                            potentialcustomerDialog.dialog("close");
                            potentialcustomerDatagrid.datagrid("load");//重新加载表格
                        })
                    } else {
                        $.messager.alert("温馨提示", data.msg, "error")
                    }
                }
            })
        },
        cancel: function () {
            potentialcustomerDialog.dialog("close");
        },

        edit: function () {
            //获取一行数据
            var rowData = potentialcustomerDatagrid.datagrid("getSelected");
            if (rowData) {
                potentialcustomerDialog.dialog("open");
                potentialcustomerDialog.dialog("setTitle", "编辑");
                //清除内容
                potentialcustomerForm.form("clear");
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
                potentialcustomerForm.form("load", rowData);
            } else {
                $.messager.alert("温馨提示", "请选择需要编辑的数据", "warning");
            }
        },
        del: function () {
            //先判断用户是否有选中数据
            var rowData = potentialcustomerDatagrid.datagrid("getSelected");
            if (rowData) {
                //删除之前让用户确定是否需要删除数据
                $.messager.confirm("温馨提示", "确定要删除该客户吗？", function (r) {
                    if (r) {
                        //点击确定后进入
                        $.get("/potentialcustomer_delete?id=" + rowData.id, function (data) {
                            if (data.success) {
                                //给出对应的提示刷新表格
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    potentialcustomerDatagrid.datagrid("reload");//刷新
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
            var rowData = potentialcustomerDatagrid.datagrid("getSelected");
            if (rowData) {
                //删除之前让用户确定是否需要删除数据
                $.messager.confirm("温馨提示", "确定标记为开发失败吗？", function (r) {
                    if (r) {
                        //点击确定后进入
                        $.get("/potentialcustomer_failOpen?id=" + rowData.id, function (data) {
                            if (data.success) {
                                //给出对应的提示刷新表格
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    potentialcustomerDatagrid.datagrid("reload");//刷新
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
        change:function () {
            //转正
            var rowData = potentialcustomerDatagrid.datagrid("getSelected");
            if (rowData) {
                    //删除之前让用户确定是否需要删除数据
                    $.messager.confirm("温馨提示", "确定要转正该客户吗？", function (r) {
                        if (r) {
                            //点击确定后进入
                            $.get("/potentialcustomer_change?id=" + rowData.id, function (data) {
                                if (data.success) {
                                    //给出对应的提示刷新表格
                                    $.messager.alert("温馨提示", data.msg, "info", function () {
                                        potentialcustomerDatagrid.datagrid("reload");//刷新
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
            var rowData = potentialcustomerDatagrid.datagrid("getSelected");
            if (rowData){
                potentialcustomerDialog2.dialog("open");
                    potentialcustomerDialog2.dialog("setTitle", "客户移交");
                //清除内容
                potentialcustomerForm2.form("clear");
                if (rowData.inchargeuser) {
                    rowData["inchargeuser.username"] = rowData.inchargeuser.username;
                }
                else {
                    rowData["inchargeuser.username"] = null;
                }
                //数据回显
                potentialcustomerForm2.form("load", rowData);
            }else {
                $.messager.alert("温馨提示", "请选择需要移交的客户", "warning");
            }
        },
        refresh: function () {
            potentialcustomerDatagrid.datagrid("reload");
        }
    };
    //给按钮添加统一的事件
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    potentialcustomerDatagrid.datagrid({
        url: "/potentialcustomer_list",
        fit: true,
        title: "潜在客户信息",
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
        toolbar: "#tt",
            onClickRow: function (rowIndex, rowData) {
               if (rowData.status==1) {
                   //让按钮变灰
                   potentialcustomerDatagridEditBtn.eq(3).linkbutton("disable");
                    potentialcustomerDatagridEditBtn.eq(4).linkbutton("disable");
                   potentialcustomerDatagridEditBtn.eq(5).linkbutton("disable");
                } else if(rowData.status==-1){
                   //让按钮变灰
                   potentialcustomerDatagridEditBtn.eq(3).linkbutton("disable");
                   potentialcustomerDatagridEditBtn.eq(4).linkbutton("disable");
                    potentialcustomerDatagridEditBtn.eq(5).linkbutton("disable");
                }
                else if(rowData.status==0){
                   potentialcustomerDatagridEditBtn.eq(3).linkbutton("enable");
                    potentialcustomerDatagridEditBtn.eq(4).linkbutton("enable");
                    potentialcustomerDatagridEditBtn.eq(5).linkbutton("enable");
                }
            }
    });
    potentialcustomerDialog.dialog({
        width: 300,
        height: 400,
        buttons: "#tb",
        closed: true
    });
    potentialcustomerDialog2.dialog({
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

