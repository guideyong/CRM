$(function () {
    $(".fancybox").fancybox();//实现弹出效果

    var contractDatagrid,contractDialog,contractForm,contractSearchForm,contractDatagridEditBtn;
    contractDatagrid=$("#contract_datagrid");
    contractDialog=$("#contract_dialog");
    contractForm=$("#contract_form");
    contractSearchForm=$("#contract_searchForm");
    contractDatagridEditBtn=$("#tt a");

    //统一管理方法
    var cmdObj={
        resetFrom:function() {
            contractSearchForm.form("clear");
    },
        //高级查询数据转换传输到后台
        searchContent:function() {
        var param = {};
        var paramArr = contractSearchForm.serializeArray();
        for (var i = 0; i < paramArr.length; i++) {
            param[paramArr[i].name] = paramArr[i].value;
        }
        contractDatagrid.datagrid("load", param);
    },
        add:function() {
        contractDialog.dialog("open"),
            contractDialog.dialog("setTitle", "新增");
            //清除内容
            contractForm.form("clear")
    },
        save:function() {
        //先判断到底是新增还是更新
        var url;
        var id = $("input[name='id']").val();
        if (id) {
            //编辑操作
            url = "/contract_update";
        } else {
            //新增
            url = "/contract_save";
        }
        contractForm.form("submit", {
            url: url,
            success: function (data) {
                data = $.parseJSON(data);//字符串转换成json对象格式
                if (data) {
                    $.messager.alert("温馨提示", data.msg, "info", function () {
                        //确定之后关闭对话框
                        contractDialog.dialog("close");
                        contractDatagrid.datagrid("load");//重新加载表格
                    })
                } else {
                    $.messager.alert("温馨提示", data.msg, "error")
                }
            }
        })
    },
        cancel:function() {
        contractDialog.dialog("close");
    },

        edit:function() {
        //获取一行数据
        var rowData = contractDatagrid.datagrid("getSelected");
        if (rowData) {
            contractDialog.dialog("open");
                contractDialog.dialog("setTitle", "编辑");
                //清除内容
                contractForm.form("clear");
            //添加一个属性
            if (rowData.customer) {
                rowData["customer_id"] = rowData.customer.id;
            }
            else {
                rowData["customer_id"] = null;
            }
            //数据回显
            contractForm.form("load", rowData);
        } else {
            $.messager.alert("温馨提示", "请选择需要编辑的数据", "warning");
        }
    },
        del:function() {
        //先判断用户是否有选中数据
        var rowData = contractDatagrid.datagrid("getSelected");
        if (rowData) {
            //删除之前让用户确定是否需要删除数据
            $.messager.confirm("温馨提示", "确定要删除该合同吗？", function (r) {
                if (r) {
                    //点击确定后进入
                    $.get("/contract_delete?id=" + rowData.id, function (data) {
                        if (data.success) {
                            //给出对应的提示刷新表格
                            $.messager.alert("温馨提示", data.msg, "info", function () {
                                contractDatagrid.datagrid("reload");//刷新
                            });
                        } else {
                            $.messager.alert("温馨提示", data.msg, "warning");
                        }
                    }, "json");//直接返回json对象不需要解析
                }
            })
        } else {
            $.messager.alert("温馨提示", "请选择需要删除的合同", "warning");
        }

    },
        examine:function () {
            //先判断用户是否有选中数据
            var rowData = contractDatagrid.datagrid("getSelected");
            if (rowData) {
                //删除之前让用户确定是否需要删除数据
                $.messager.confirm("温馨提示", "确定要审核该合同吗？", function (r) {
                    if (r) {
                        //点击确定后进入
                        $.get("/contract_examine?id=" + rowData.id, function (data) {
                            if (data.success) {
                                //给出对应的提示刷新表格
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    contractDatagrid.datagrid("reload");//刷新
                                });
                            } else {
                                $.messager.alert("温馨提示", data.msg, "warning");
                            }
                        }, "json");//直接返回json对象不需要解析
                    }
                })
            } else {
                $.messager.alert("温馨提示", "请选择需要审核的合同", "warning");
            }
        },
        refresh:function() {
        contractDatagrid.datagrid("reload");
    }
    };
    //给按钮添加统一的事件
    $("a[data-cmd]").on("click",function(){
        var cmd=$(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    contractDatagrid.datagrid({
        url: "/contract_list",
        fit: true,
        title: "合同信息",
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        singleSelect: true,
        columns: [
            [
                {field: "sn", title: "合同编号", width: 100, align: 'center'},
                {field: "customer", title: "定金客户", width: 100,formatter: customerFormatter, align: 'center'},
                {field: "signtime", title: "签订时间", width: 100, align: 'center'},
                {field: "seller", title: "销售人员", width: 100,formatter: userFormatter, align: 'center'},
                {field: "sum", title: "合同金额", width: 100, align: 'center'},
                {field: "money", title: "付款金额", width: 100, align: 'center'},
                {field: "paytime", title: "付款时间", width: 100, align: 'center'},
                {field: "intro", title: "摘要", width: 100, align: 'center'},
                {field: "file", title: "附件", width: 70, formatter: imageFormatter,align: 'center'},
                {field: "modifyuser", title: "最近修改人", width: 100,formatter: userFormatter, align: 'center'},
                {field: "modifytime", title: "最近修改时间", width: 100, align: 'center'},
                {field: "status", title: "状态", width: 100,formatter: statusFormatter, align: 'center'}
            ]
        ],
        toolbar: "#tt",
        onClickRow: function (rowIndex, rowData) {
            if (rowData.status==1) {
                //让按钮变灰
                contractDatagridEditBtn.eq(1).linkbutton("disable");
                contractDatagridEditBtn.eq(2).linkbutton("disable");
                contractDatagridEditBtn.eq(3).linkbutton("disable");
            } 
            else{
                contractDatagridEditBtn.eq(1).linkbutton("enable");
                contractDatagridEditBtn.eq(2).linkbutton("enable");
                contractDatagridEditBtn.eq(3).linkbutton("enable");
            }
        }
    });
    contractDialog.dialog({
        width: 300,
        height: 310,
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
        return "<font color='#00bfff'>审核通过</font>";
    else if (value == 2)
        return "<font color='red'>审核拒绝</font>";
}
function imageFormatter(value ,row,index) {
    if (value)
        return  "<a class='fancybox' href='"+value+"'><img  style='width:70px;height:70px' src='"+value+"'/></a>";
    else
        return null;
}



