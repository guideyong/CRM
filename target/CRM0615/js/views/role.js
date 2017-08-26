$(function () {
    var roleDatagrid, roleDialog, roleForm, roleSearchForm, roleDatagridEditBtn, selfPermission, allPermission;
    roleDatagrid = $("#role_datagrid");
    roleDialog = $("#role_dialog");
    roleForm = $("#role_form");
    roleSearchForm = $("#role_searchForm");
    roleDatagridEditBtn = $("#tt a");
    selfPermission = $("#selfPermission");
    allPermission = $("#allPermission");

    //统一管理方法
    var cmdObj = {
        resetFrom: function () {
            roleSearchForm.form("clear");
        },
        //高级查询数据转换传输到后台
        searchContent: function () {
            var param = {};
            var paramArr = roleSearchForm.serializeArray();
            for (var i = 0; i < paramArr.length; i++) {
                param[paramArr[i].name] = paramArr[i].value;
            }
            roleDatagrid.datagrid("load", param);
        },
        add: function () {
            roleDialog.dialog("open");
            roleDialog.dialog("setTitle", "新增");
            //清除内容
            roleForm.form("clear");
           // $("input[name='id']").val("");
            //$("#_easyui_textbox_input2").val("");
            //$("#_easyui_textbox_input3").val("");
            //$("[name='name']").val("");
            selfPermission.datagrid("loadData",{rows:[]})
        },
        save: function () {
            //先判断到底是新增还是更新
            var url;
            var id = $("input[name='id']").val();
            if (id) {
                //编辑操作
                url = "/role_update";
            } else {
                //新增
                url = "/role_save";
            }
            roleForm.form("submit", {
                url: url,
                onSubmit:function (param) {
                    //获取自身集合
                    var selfRows=selfPermission.datagrid("getRows");
                    for (var i=0;i<selfRows.length;i++){
                        param["permissions["+i+"].id"]=selfRows[i].id;
                    }
                },
                success: function (data) {
                    data = $.parseJSON(data);//字符串转换成json对象格式
                    if (data) {
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            //确定之后关闭对话框
                            roleDialog.dialog("close");
                            roleDatagrid.datagrid("load");//重新加载表格
                        })
                    } else {
                        $.messager.alert("温馨提示", data.msg, "error")
                    }
                }
            })
        },
        cancel: function () {
            roleDialog.dialog("close");
        },

        edit: function () {
            //获取一行数据
            var rowData = roleDatagrid.datagrid("getSelected");
            if (rowData) {
                roleDialog.dialog("open"),
                    roleDialog.dialog("setTitle", "编辑");
                    //清除内容
                    roleForm.form("clear");
                //数据回显
                roleForm.form("load", rowData);
                selfPermission.datagrid('load',{
                    id: rowData.id
                });


            } else {
                $.messager.alert("温馨提示", "请选择需要编辑的数据", "warning");
            }
        },
        del: function () {
            //先判断用户是否有选中数据
            var rowData = roleDatagrid.datagrid("getSelected");
            if (rowData) {
                //删除之前让用户确定是否需要删除数据
                $.messager.confirm("温馨提示", "确定要删除该角色吗？", function (r) {
                    if (r) {
                        //点击确定后进入
                        $.get("/role_delete?id=" + rowData.id, function (data) {
                            if (data.success) {
                                //给出对应的提示刷新表格
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    roleDatagrid.datagrid("reload");//刷新
                                });
                            } else {
                                $.messager.alert("温馨提示", data.msg, "warning");
                            }
                        }, "json");//直接返回json对象不需要解析
                    }
                })
            } else {
                $.messager.alert("温馨提示", "请选择需要删除的角色", "warning");
            }

        },
        refresh: function () {
            roleDatagrid.datagrid("reload");
        }
    };
    //给按钮添加统一的事件
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    roleDatagrid.datagrid({
        url: "/role_list",
        fit: true,
        title: "角色信息",
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        pageList:[20,30,40,50],
        pageSize:20,
        singleSelect: true,
        columns: [
            [
                {field: "sn", title: "角色编号", width: 100, align: 'center'},
                {field: "name", title: "角色名称", width: 100, align: 'center'},
            ]
        ],
        toolbar: "#tt"
    });
    roleDialog.dialog({
        width: 600,
        height: 400,
        buttons: "#tb",
        closed: true
    });
    selfPermission.datagrid({
        title: "自身权限",
        width: 250,
        height: 250,
        fitColumns: true,
        rownumbers: true,
        singleSelect: true,
        url: "/permission_listByRId",/*?rid="+rowData.id*/
        columns: [
            [
                {field: "name", title: "权限名称", width: 100, align: 'center'}
            ]
        ],
        //双击响应
        onDblClickRow: function (index, row) {
            var rowIndex = selfPermission.datagrid('getRowIndex', row);
            selfPermission.datagrid('deleteRow', rowIndex);
        }
    });
    allPermission.datagrid({
        title: "所有权限",
        width: 250,
        height: 250,
        pagination: true,
        fitColumns: true,
        rownumbers: true,
        singleSelect: true,
        url: "/permission_list",
        columns: [
            [
                {field: "name", title: "权限名称", width: 100, align: 'center'}
            ]
        ],
        //双击响应
        onDblClickRow: function (rowIndex, rowData) {
            //获取selfPermission权限集合
            var selfRows = selfPermission.datagrid("getRows");
            var flag = false;
            var index = -1;
            //判断
            for (var i = 0; i < selfRows.length; i++) {
                if (selfRows[i].id == rowData.id) {
                    flag = true;
                    index = i;
                    break;
                }
            }
            //如果出现相同则选中
            if (flag) {
                //选中
                selfPermission.datagrid("selectRow", index);
            } else {
                selfPermission.datagrid("appendRow", rowData);
            }
        }
    });
    var pager = allPermission.datagrid("getPager");
    pager.pagination({
        showPageList: false,
        showRefresh: false,
        displayMsg: ''
    })
});



		