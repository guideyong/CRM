$(function () {
    var departmentDatagrid,departmentDialog,departmentForm,departmentSearchForm,departmentDatagridEditBtn;
    departmentDatagrid=$("#department_datagrid");
    departmentDialog=$("#department_dialog");
    departmentForm=$("#department_form");
    departmentSearchForm=$("#department_searchForm");
    departmentDatagridEditBtn=$("#department_tt a");

    //统一管理方法
    var cmdObj={
        resetFrom:function() {
            departmentSearchForm .form("clear");
       //$("form")[0].reset();
    },
        //高级查询数据转换传输到后台
        searchContent:function() {
        var param = {};
        var paramArr = departmentSearchForm.serializeArray();
        for (var i = 0; i < paramArr.length; i++) {
            param[paramArr[i].name] = paramArr[i].value;
        }
        departmentDatagrid.datagrid("load", param);
    },
        add:function() {
        departmentDialog.dialog("open"),
            departmentDialog.dialog("setTitle", "新增");
            //清楚内容
            departmentForm.form("clear")
    },
        save:function() {
        //先判断到底是新增还是更新
        var url;
        var id = $("input[name='id']").val();
        if (id) {
            //编辑操作
            url = "/department_update";
        } else {
            //新增
            url = "/department_save";
        }
        departmentForm.form("submit", {
            url: url,
            success: function (data) {
                data = $.parseJSON(data);//字符串转换成json对象格式
                if (data) {
                    $.messager.alert("温馨提示", data.msg, "info", function () {
                        //确定之后关闭对话框
                        departmentDialog.dialog("close");
                        departmentDatagrid.datagrid("load");//重新加载表格
                    })
                } else {
                    $.messager.alert("温馨提示", data.msg, "error")
                }
            }
        })
    },
        cancel:function() {
        departmentDialog.dialog("close");
    },

        edit:function() {
        //获取一行数据
        var rowData = departmentDatagrid.datagrid("getSelected");
        if (rowData) {
            departmentDialog.dialog("open");
                departmentDialog.dialog("setTitle", "编辑");
                //清除内容
                departmentForm.form("clear");
            //添加一个属性
            if (rowData.manager) {
                rowData["manager.id"] = rowData.manager.id;
            }
            else {
                rowData["manager.id"] = null;
            }
            if (rowData.parent) {
                rowData["parent.id"] = rowData.parent.id;
            }
            else {
                rowData["parent.id"] = null;
            }
            //数据回显
            departmentForm.form("load", rowData);
        } else {
            $.messager.alert("温馨提示", "请选择需要编辑的数据", "warning");
        }
    },
        del:function() {
        //先判断用户是否有选中数据
        var rowData = departmentDatagrid.datagrid("getSelected");
        if (rowData) {
            //删除之前让用户确定是否需要删除数据
            $.messager.confirm("温馨提示", "确定要停用该部门吗？", function (r) {
                if (r) {
                    //点击确定后进入
                    $.get("/department_delete?id=" + rowData.id, function (data) {
                        if (data.success) {
                            //给出对应的提示刷新表格
                            $.messager.alert("温馨提示", data.msg, "info", function () {
                                departmentDatagrid.datagrid("reload");//刷新
                            });
                        } else {
                            $.messager.alert("温馨提示", data.msg, "warning");
                        }
                    }, "json");//直接返回json对象不需要解析
                }
            })
        } else {
            $.messager.alert("温馨提示", "请选择需要离职的部门", "warning");
        }

    },
        refresh:function() {
        departmentDatagrid.datagrid("reload");
    }
    };
    //给按钮添加统一的事件
    $("a[data-cmd]").on("click",function(){
        var cmd=$(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    departmentDatagrid.datagrid({
        url: "/department_list",
        fit: true,
        title: "部门信息",
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        pageList:[20,30,40,50],
        pageSize:20,
        singleSelect: true,
        columns: [
            [
                {field: "name", title: "部门名称", width: 100, align: 'center'},
                {field: "sn", title: "部门编码", width: 100, align: 'center'},
                {field: "manager", title: "部门经理", width: 100,formatter: managerFormatter,align: 'center'},
                {field: "parent", title: "上级部门", width: 100,formatter: deptFormatter,align: 'center'},
                {field: "state", title: "部门状态", width: 100,formatter:statusFormatter,align: 'center'}
            ]
        ],
        toolbar: "#department_tt",
        onClickRow: function (rowIndex, rowData) {
            if (rowData.state) {
                departmentDatagridEditBtn.eq(1).linkbutton("enable");
                departmentDatagridEditBtn.eq(2).linkbutton("enable");
            } else {
                //让按钮变灰
                departmentDatagridEditBtn.eq(1).linkbutton("disable");
                departmentDatagridEditBtn.eq(2).linkbutton("disable");
            }
        }
    });
    departmentDialog.dialog({
        width: 300,
        height: 250,
        buttons: "#department_tb",
        closed: true
    });
});
function managerFormatter(value, record, index) {
    if (value)
        return value.username;
    else
        return value;
}
function deptFormatter(value, record, index) {
    if (value)
        return value.name;
    else
        return value;
}
function statusFormatter(value, record, index) {
    if (value)
        return "<font color='green'>正常</font>";
    else
        return "<font color='red'>停用</font>";
}




		