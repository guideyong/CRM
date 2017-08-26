$(function () {
    var signDatagrid, signDialog,theme_dialog, signForm, signSearchForm, signDatagridEditBtn, passwordDialog, passwordForm;
    signDatagrid = $("#sign_datagrid");
    signDialog = $("#sign_dialog");
    signForm = $("#sign_form");
    signSearchForm = $("#sign_searchForm");
    signDatagridEditBtn = $("#tt a");
    passwordDialog = $("#password_dialog");
    theme_dialog=$("#theme_dialog");
    passwordForm = $("#password_form");

    //统一管理方法
    var cmdObj = {
        resetFrom: function () {
            signSearchForm.form("clear");
        },
        //高级查询数据转换传输到后台
        searchContent: function () {
            var param = {};
            var paramArr = signSearchForm.serializeArray();
            for (var i = 0; i < paramArr.length; i++) {
                param[paramArr[i].name] = paramArr[i].value;
            }
            signDatagrid.datagrid("load", param);
        }, cpassword: function () {
            passwordDialog.dialog("open");
            passwordDialog.dialog("setTitle", "修改密码");
            //清楚内容
            passwordForm.form("clear")
        },
        theme: function () {
            theme_dialog.dialog("open");
            theme_dialog.dialog("setTitle", "皮肤");
            //清楚内容
            passwordForm.form("clear")
        },
        logout: function () {
            $.messager.alert("温馨提示", '确定要退出系统吗',"warning", function () {
                window.location.href='/login.jsp';
            })
        },
        save2: function () {
            var url;
            url = "/password_update";
            passwordForm.form("submit", {
                url: url,
                success: function (data) {
                    data = $.parseJSON(data);//字符串转换成json对象格式
                    if (data) {
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            //确定之后关闭对话框
                            passwordDialog.dialog("close");
                        })
                    } else {
                        $.messager.alert("温馨提示", data.msg, "error")
                    }
                }
            })
        },
        my: function () {
            $.messager.show({
                title: '我的消息',
                msg: '暂未收到消息。',
                timeout: 4000,
                showType: 'slide'
            });

        },
        cancel2: function () {
            passwordDialog.dialog("close");
        },
        del: function () {
            //先判断用户是否有选中数据
            var rowData = signDatagrid.datagrid("getSelected");
            if (rowData) {
                //删除之前让用户确定是否需要删除数据
                $.messager.confirm("温馨提示", "确定要删除该sign吗？", function (r) {
                    if (r) {
                        //点击确定后进入
                        $.get("/sign_delete?id=" + rowData.id, function (data) {
                            if (data.success) {
                                //给出对应的提示刷新表格
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    signDatagrid.datagrid("reload");//刷新
                                });
                            } else {
                                $.messager.alert("温馨提示", data.msg, "warning");
                            }
                        }, "json");//直接返回json对象不需要解析
                    }
                })
            } else {
                $.messager.alert("温馨提示", "请选择需要删除的sign", "warning");
            }

        },
        isign: function () {
            $.messager.confirm("温馨提示", "确定要签到吗？", function (r) {
                if (r) {
                    //点击确定后进入
                    $.get("/sign_in", function (data) {
                        if (data.success) {
                            //给出对应的提示刷新表格
                            $.messager.alert("温馨提示", data.msg, "info", function () {
                                signDatagrid.datagrid("reload");//刷新
                            });
                        } else {
                            $.messager.alert("温馨提示", data.msg, "warning");
                        }
                    }, "json");//直接返回json对象不需要解析
                }
            })
        },
        osign: function () {
            $.messager.confirm("温馨提示", "确定要签退吗？", function (r) {
                if (r) {
                    //点击确定后进入
                    $.get("/sign_out", function (data) {
                        if (data.success) {
                            //给出对应的提示刷新表格
                            $.messager.alert("温馨提示", data.msg, "info", function () {
                                signDatagrid.datagrid("reload");//刷新
                            });
                        } else {
                            $.messager.alert("温馨提示", data.msg, "warning");
                        }
                    }, "json");//直接返回json对象不需要解析
                }
            })
        }, addSign: function () {
            signDialog.dialog("open"),
                signDialog.dialog("setTitle", "补签");
            //清除内容
            signForm.form("clear")
        },
        save: function () {
            var url;
            url = "/sign_addsign";
            signForm.form("submit", {
                url: url,
                success: function (data) {
                    data = $.parseJSON(data);//字符串转换成json对象格式
                    if (data) {
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            //确定之后关闭对话框
                            signDialog.dialog("close");
                            signDatagrid.datagrid("load");//重新加载表格
                        })
                    } else {
                        $.messager.alert("温馨提示", data.msg, "error")
                    }
                }
            })
        },

        refresh: function () {
            signDatagrid.datagrid("reload");
        }
    };
    //给按钮添加统一的事件
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    signDatagrid.datagrid({
        url: "/sign_list",
        fit: true,
        title: "考勤信息",
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        singleSelect: true,
        columns: [
            [
                {field: "userId", title: "姓名", width: 100, formatter: userFormatter, align: 'center'},
                {field: "ip", title: "签到ip", width: 100, align: 'center'},
                {field: "itime", title: "签到时间", width: 100, formatter: itimeFormatter, align: 'center'},
                {field: "otime", title: "签退时间", width: 100, formatter: otimeFormatter, align: 'center'},
                {field: "status", title: "状态", width: 100, formatter: statusFormatter, align: 'center'},
                {field: "adduser", title: "补签人", width: 100, formatter: userFormatter, align: 'center'},
                {field: "addtime", title: "补签时间", width: 100, align: 'center'}
            ]
        ],
        toolbar: "#tt"
    });
    signDialog.dialog({
        width: 300,
        height: 140,
        buttons: "#tb",
        closed: true
    });
    passwordDialog.dialog({
        width: 300,
        height: 170,
        buttons: "#tc",
        closed: true,
        modal: true
    });
    theme_dialog.dialog({
        width: 700,
        height: 750,
        closed: true,
        modal: true
    });
});

function userFormatter(value, record, index) {
    if (value)
        return value.username;
    else
        return value;
}
function itimeFormatter(value, record, index) {
    if (value != null) {
        str = value.replace(/-/g, "/");
        var date = new Date(str);
        var hh = date.getHours(); //截取小时
        var mm = date.getMinutes(); //截取分钟
        if (hh < 8) {
            return "<font color='green'>" + value + "</font>";
        } else if (hh > 9) {
            return "<font color='red'>" + value + "</font>";
        }
        else {
            if (mm < 30) {
                return "<font color='green'>" + value + "</font>";
            } else {
                return "<font color='red'>" + value + "</font>";
            }
        }
    }
    if (value == null) {
        return value;
    }
}
function otimeFormatter(value, record, index) {
    if (value != null) {
        str = value.replace(/-/g, "/");
        var date = new Date(str);
        var hh = date.getHours(); //截取小时
        var mm = date.getMinutes(); //截取分钟
        if (hh > 18) {
            return "<font color='green'>" + value + "</font>";
        }
        else if (hh < 17) {
            return "<font color='red'>" + value + "</font>";
        }
        else {
            if (mm >= 30) {
                return "<font color='green'>" + value + "</font>";
            } else {
                return "<font color='red'>" + value + "</font>";
            }
        }
    }
    if (value == null) {
        return value;
    }
}
function statusFormatter(value, record, index) {
    if (value == 0)
        return "<font color='green'>正常</font>";
    else if (value == 1)
        return "<font color='red'>迟到</font>";
    else if (value == 2)
        return "<font color='red'>早退</font>";
    else if (value == 3)
        return "<font color='#8b0000'>迟到早退</font>";
}


