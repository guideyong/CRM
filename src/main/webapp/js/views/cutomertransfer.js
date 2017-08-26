$(function () {
    var cutomertransferDatagrid,cutomertransferDialog,cutomertransferForm,cutomertransferSearchForm,cutomertransferDatagridEditBtn;
    cutomertransferDatagrid=$("#cutomertransfer_datagrid");
    cutomertransferDialog=$("#cutomertransfer_dialog");
    cutomertransferForm=$("#cutomertransfer_form");
    cutomertransferSearchForm=$("#cutomertransfer_searchForm");
    cutomertransferDatagridEditBtn=$("#tt a");

    //统一管理方法
    var cmdObj={
        resetFrom:function() {
            cutomertransferSearchForm.form("clear");
    },
        //高级查询数据转换传输到后台
        searchContent:function() {
        var param = {};
        var paramArr = cutomertransferSearchForm.serializeArray();
        for (var i = 0; i < paramArr.length; i++) {
            param[paramArr[i].name] = paramArr[i].value;
        }
        cutomertransferDatagrid.datagrid("load", param);
    },
        trans:function() {
        cutomertransferDialog.dialog("open"),
            cutomertransferDialog.dialog("setTitle", "新创建移交");
            //清除内容
            cutomertransferForm.form("clear")
    },
        save:function() {
        //先判断到底是新增还是更新
        var url;
        var id = $("input[name='id']").val();
        if (id) {
            //编辑操作
            url = "/cutomertransfer_update";
        } else {
            //新增
            url = "/cutomertransfer_save";
        }
        cutomertransferForm.form("submit", {
            url: url,
            success: function (data) {
                data = $.parseJSON(data);//字符串转换成json对象格式
                if (data) {
                    $.messager.alert("温馨提示", data.msg, "info", function () {
                        //确定之后关闭对话框
                        cutomertransferDialog.dialog("close");
                        cutomertransferDatagrid.datagrid("load");//重新加载表格
                    })
                } else {
                    $.messager.alert("温馨提示", data.msg, "error")
                }
            }
        })
    },
        cancel:function() {
        cutomertransferDialog.dialog("close");
    },

        edit:function() {
        //获取一行数据
        var rowData = cutomertransferDatagrid.datagrid("getSelected");
        if (rowData) {
            cutomertransferDialog.dialog("open");
                cutomertransferDialog.dialog("setTitle", "编辑");
                //清除内容
                cutomertransferForm.form("clear");
            //添加一个属性
            if (rowData.dept) {
                rowData["dept.id"] = rowData.dept.id;
            }
            else {
                rowData["dept.id"] = null;
            }
            //数据回显
            cutomertransferForm.form("load", rowData);
        } else {
            $.messager.alert("温馨提示", "请选择需要编辑的数据", "warning");
        }
    },
        del:function() {
        //先判断用户是否有选中数据
        var rowData = cutomertransferDatagrid.datagrid("getSelected");
        if (rowData) {
            //删除之前让用户确定是否需要删除数据
            $.messager.confirm("温馨提示", "确定要删除该cutomertransfer吗？", function (r) {
                if (r) {
                    //点击确定后进入
                    $.get("/cutomertransfer_delete?id=" + rowData.id, function (data) {
                        if (data.success) {
                            //给出对应的提示刷新表格
                            $.messager.alert("温馨提示", data.msg, "info", function () {
                                cutomertransferDatagrid.datagrid("reload");//刷新
                            });
                        } else {
                            $.messager.alert("温馨提示", data.msg, "warning");
                        }
                    }, "json");//直接返回json对象不需要解析
                }
            })
        } else {
            $.messager.alert("温馨提示", "请选择需要删除的cutomertransfer", "warning");
        }

    },
        refresh:function() {
        cutomertransferDatagrid.datagrid("reload");
    }
    };
    //给按钮添加统一的事件
    $("a[data-cmd]").on("click",function(){
        var cmd=$(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    cutomertransferDatagrid.datagrid({
        url: "/cutomertransfer_list",
        fit: true,
        title: "客户移交记录信息",
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        singleSelect: true,
        columns: [
            [
                {field: "customer", title: "客户名称", width: 100,formatter: customerFormatter, align: 'center'},
                {field: "transtime", title: "移交时间", width: 100, align: 'center'},
                {field: "oldseller", title: "原市场专员", width: 100,formatter: userFormatter, align: 'center'},
                {field: "newseller", title: "新市场专员", width: 100,formatter: userFormatter, align: 'center'},
                {field: "transreason", title: "移交原因", width: 100, align: 'center'},
                {field: "transuser", title: "操作人", width: 100,formatter: userFormatter, align: 'center'}
            ]
        ],
        toolbar: "#tt"
    });
    cutomertransferDialog.dialog({
        width: 300,
        height: 200,
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


