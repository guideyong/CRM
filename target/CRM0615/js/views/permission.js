$(function () {
    var permissionDatagrid,permissionDialog,permissionForm,permissionSearchForm,permissionDatagridEditBtn;
    permissionDatagrid=$("#permission_datagrid");
    permissionDialog=$("#permission_dialog");
    permissionForm=$("#permission_form");
    permissionSearchForm=$("#permission_searchForm");
    permissionDatagridEditBtn=$("#tt a");

    //统一管理方法
    var cmdObj={
        resetFrom:function() {
            permissionSearchForm.form("clear");
    },
        //高级查询数据转换传输到后台
        searchContent:function() {
        var param = {};
        var paramArr = permissionSearchForm.serializeArray();
        for (var i = 0; i < paramArr.length; i++) {
            param[paramArr[i].name] = paramArr[i].value;
        }
        permissionDatagrid.datagrid("load", param);
    },
        add:function() {
        permissionDialog.dialog("open"),
            permissionDialog.dialog("setTitle", "新增");
            //清楚内容
            permissionForm.form("clear")
    },
        save:function() {
        //先判断到底是新增还是更新
        var url;
        var id = $("input[name='id']").val();
        if (id) {
            //编辑操作
            url = "/permission_update";
        } else {
            //新增
            url = "/permission_save";
        }
        permissionForm.form("submit", {
            url: url,
            success: function (data) {
                data = $.parseJSON(data);//字符串转换成json对象格式
                if (data) {
                    $.messager.alert("温馨提示", data.msg, "info", function () {
                        //确定之后关闭对话框
                        permissionDialog.dialog("close");
                        permissionDatagrid.datagrid("load");//重新加载表格
                    })
                } else {
                    $.messager.alert("温馨提示", data.msg, "error")
                }
            }
        })
    },
        cancel:function() {
        permissionDialog.dialog("close");
    },

        edit:function() {
        //获取一行数据
        var rowData = permissionDatagrid.datagrid("getSelected");
        if (rowData) {
            permissionDialog.dialog("open");
                permissionDialog.dialog("setTitle", "编辑");
                //清除内容
                permissionForm.form("clear");
            //添加一个属性
            if (rowData.dept) {
                rowData["dept.id"] = rowData.dept.id;
            }
            else {
                rowData["dept.id"] = null;
            }
            //数据回显
            permissionForm.form("load", rowData);
        } else {
            $.messager.alert("温馨提示", "请选择需要编辑的数据", "warning");
        }
    },
        del:function() {
        //先判断用户是否有选中数据
        var rowData = permissionDatagrid.datagrid("getSelected");
        if (rowData) {
            //删除之前让用户确定是否需要删除数据
            $.messager.confirm("温馨提示", "确定要删除该权限吗？", function (r) {
                if (r) {
                    //点击确定后进入
                    $.get("/permission_delete?id=" + rowData.id, function (data) {
                        if (data.success) {
                            //给出对应的提示刷新表格
                            $.messager.alert("温馨提示", data.msg, "info", function () {
                                permissionDatagrid.datagrid("reload");//刷新
                            });
                        } else {
                            $.messager.alert("温馨提示", data.msg, "warning");
                        }
                    }, "json");//直接返回json对象不需要解析
                }
            })
        } else {
            $.messager.alert("温馨提示", "请选择需要删除的权限", "warning");
        }

    },
        refresh:function() {
        permissionDatagrid.datagrid("reload");
    }
    };
    //给按钮添加统一的事件
    $("a[data-cmd]").on("click",function(){
        var cmd=$(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    permissionDatagrid.datagrid({
        url: "/permission_list",
        fit: true,
        title: "权限信息",
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        pageList:[20,30,40,50],
        pageSize:20,
        singleSelect: true,
        columns: [
            [
                {field: "name", title: "权限名称", width: 100, align: 'center'},
                {field: "resource", title: "资源地址", width: 100, align: 'center'},
            ]
        ],
        toolbar: "#tt"
    });
    permissionDialog.dialog({
        width: 300,
        height: 200,
        buttons: "#tb",
        closed: true
    });
});


		