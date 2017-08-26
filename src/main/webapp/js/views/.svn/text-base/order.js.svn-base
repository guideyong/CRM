$(function () {
    $(".fancybox").fancybox();//实现弹出效果

    var orderDatagrid,orderDialog,orderForm,orderSearchForm,orderDatagridEditBtn;
    orderDatagrid=$("#order_datagrid");
    orderDialog=$("#order_dialog");
    orderForm=$("#order_form");
    orderSearchForm=$("#order_searchForm");
    orderDatagridEditBtn=$("#tt a");

    //统一管理方法
    var cmdObj={
        resetFrom:function() {
            orderSearchForm.form("clear");
    },
        //高级查询数据转换传输到后台
        searchContent:function() {
        var param = {};
        var paramArr = orderSearchForm.serializeArray();
        for (var i = 0; i < paramArr.length; i++) {
            param[paramArr[i].name] = paramArr[i].value;
        }
        orderDatagrid.datagrid("load", param);
    },
        add:function() {
        orderDialog.dialog("open"),
            orderDialog.dialog("setTitle", "新增");
            //清除内容
            orderForm.form("clear")
    },
        save:function() {
        //先判断到底是新增还是更新
        var url;
        var id = $("input[name='id']").val();
        if (id) {
            //编辑操作
            url = "/order_update";
        } else {
            //新增
            url = "/order_save";
        }
        orderForm.form("submit", {
            url: url,
            success: function (data) {
                data = $.parseJSON(data);//字符串转换成json对象格式
                if (data) {
                    $.messager.alert("温馨提示", data.msg, "info", function () {
                        //确定之后关闭对话框
                        orderDialog.dialog("close");
                        orderDatagrid.datagrid("load");//重新加载表格
                    })
                } else {
                    $.messager.alert("温馨提示", data.msg, "error")
                }
            }
        })
    },
        cancel:function() {
        orderDialog.dialog("close");
    },

        edit:function() {
        //获取一行数据
        var rowData = orderDatagrid.datagrid("getSelected");
        if (rowData) {
            orderDialog.dialog("open");
                orderDialog.dialog("setTitle", "编辑");
                //清除内容
                orderForm.form("clear");
            //添加一个属性
            if (rowData.customer) {
                rowData["customer_id"] = rowData.customer.id;
            }
            else {
                rowData["customer_id"] = null;
            }
            //数据回显
            orderForm.form("load", rowData);
        } else {
            $.messager.alert("温馨提示", "请选择需要编辑的数据", "warning");
        }
    },
        del:function() {
        //先判断用户是否有选中数据
        var rowData = orderDatagrid.datagrid("getSelected");
        if (rowData) {
            //删除之前让用户确定是否需要删除数据
            $.messager.confirm("温馨提示", "确定要删除该订单吗？", function (r) {
                if (r) {
                    //点击确定后进入
                    $.get("/order_delete?id=" + rowData.id, function (data) {
                        if (data.success) {
                            //给出对应的提示刷新表格
                            $.messager.alert("温馨提示", data.msg, "info", function () {
                                orderDatagrid.datagrid("reload");//刷新
                            });
                        } else {
                            $.messager.alert("温馨提示", data.msg, "warning");
                        }
                    }, "json");//直接返回json对象不需要解析
                }
            })
        } else {
            $.messager.alert("温馨提示", "请选择需要删除的订单", "warning");
        }

    },
        addContract:function () {
            //先判断用户是否有选中数据
            var rowData = orderDatagrid.datagrid("getSelected");
            if (rowData) {
                //删除之前让用户确定是否需要删除数据
                $.messager.confirm("温馨提示", "确定要生成合同吗？", function (r) {
                    if (r) {
                        //点击确定后进入
                        $.get("/order_addContract?id=" + rowData.id, function (data) {
                            if (data.success) {
                                //给出对应的提示刷新表格
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    orderDatagrid.datagrid("reload");//刷新
                                });
                            } else {
                                $.messager.alert("温馨提示", data.msg, "warning");
                            }
                        }, "json");//直接返回json对象不需要解析
                    }
                })
            } else {
                $.messager.alert("温馨提示", "请选择需要生成合同的订单", "warning");
            }
        },
        refund:function () {
            //先判断用户是否有选中数据
            var rowData = orderDatagrid.datagrid("getSelected");
            if (rowData) {
                //删除之前让用户确定是否需要删除数据
                $.messager.confirm("温馨提示", "确定要退款吗？", function (r) {
                    if (r) {
                        //点击确定后进入
                        $.get("/order_refund?id=" + rowData.id, function (data) {
                            if (data.success) {
                                //给出对应的提示刷新表格
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    orderDatagrid.datagrid("reload");//刷新
                                });
                            } else {
                                $.messager.alert("温馨提示", data.msg, "warning");
                            }
                        }, "json");//直接返回json对象不需要解析
                    }
                })
            } else {
                $.messager.alert("温馨提示", "请选择需要退款的订单", "warning");
            }
        },
        refresh:function() {
        orderDatagrid.datagrid("reload");
    }
    };
    //给按钮添加统一的事件
    $("a[data-cmd]").on("click",function(){
        var cmd=$(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    orderDatagrid.datagrid({
        url: "/order_list",
        fit: true,
        title: "订单信息",
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        singleSelect: true,
        columns: [
            [
                {field: "customer", title: "定金客户", width: 100,formatter: customerFormatter, align: 'center'},
                {field: "signtime", title: "签订时间", width: 100, align: 'center'},
                {field: "seller", title: "销售人员", width: 100,formatter: userFormatter, align: 'center'},
                {field: "totalsum", title: "总金额", width: 100, align: 'center'},
                {field: "sum", title: "定金金额", width: 100, align: 'center'},
                {field: "intro", title: "摘要", width: 100, align: 'center'},
                {field: "file", title: "附件", width: 55,  formatter: imageFormatter,align: 'center'},
                {field: "modifyuser", title: "最近修改人", width: 100,formatter: userFormatter, align: 'center'},
                {field: "modifytime", title: "最近修改时间", width: 100, align: 'center'},
                {field: "status", title: "状态", width: 100,formatter: statusFormatter, align: 'center'}
            ]
        ],
        toolbar: "#tt",
        onClickRow: function (rowIndex, rowData) {
            if (rowData.status==1) {
                //让按钮变灰
                orderDatagridEditBtn.eq(1).linkbutton("disable");
                orderDatagridEditBtn.eq(2).linkbutton("disable");
                orderDatagridEditBtn.eq(3).linkbutton("disable");
                orderDatagridEditBtn.eq(4).linkbutton("disable");
            }
            else if (rowData.status==2){
                orderDatagridEditBtn.eq(1).linkbutton("disable");
                orderDatagridEditBtn.eq(2).linkbutton("disable");
                orderDatagridEditBtn.eq(3).linkbutton("disable");
                orderDatagridEditBtn.eq(4).linkbutton("disable");
            }else {
                orderDatagridEditBtn.eq(1).linkbutton("enable");
                orderDatagridEditBtn.eq(2).linkbutton("enable");
                orderDatagridEditBtn.eq(3).linkbutton("enable");
                orderDatagridEditBtn.eq(4).linkbutton("enable");
            }
        }
    });
    orderDialog.dialog({
        width: 300,
        height: 280,
        buttons: "#tb",
        closed: true
    });
});
function userFormatter(value, record, index) {
    if (value)
        return value.username;
    else
        return value;
}
function customerFormatter(value, record, index) {
    if (value)
        return value.name;
    else
        return value;
}
function statusFormatter(value, record, index) {
    if (value == 0)
        return "<font color='green'>初始录入</font>";
    else if (value == 1)
        return "<font color='#00bfff'>已生成合同</font>";
    else if (value == 2)
        return "<font color='red'>已退款</font>";
}
function imageFormatter(value ,row,index) {
    if (value)
        return  "<a class='fancybox' href='"+value+"'><img  style='width:70px;height:70px' src='"+value+"'/></a>";
    else
        return null;
}


