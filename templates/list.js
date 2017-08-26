$(function () {
    var ${objectName}Datagrid,${objectName}Dialog,${objectName}Form,${objectName}SearchForm,${objectName}DatagridEditBtn;
    ${objectName}Datagrid=$("#${objectName}_datagrid");
    ${objectName}Dialog=$("#${objectName}_dialog");
    ${objectName}Form=$("#${objectName}_form");
    ${objectName}SearchForm=$("#${objectName}_searchForm");
    ${objectName}DatagridEditBtn=$("#tt a");

    //统一管理方法
    var cmdObj={
        resetFrom:function() {
            ${objectName}SearchForm.form("clear");
    },
        //高级查询数据转换传输到后台
        searchContent:function() {
        var param = {};
        var paramArr = ${objectName}SearchForm.serializeArray();
        for (var i = 0; i < paramArr.length; i++) {
            param[paramArr[i].name] = paramArr[i].value;
        }
        ${objectName}Datagrid.datagrid("load", param);
    },
        add:function() {
        ${objectName}Dialog.dialog("open"),
            ${objectName}Dialog.dialog("setTitle", "新增");
            //清除内容
            ${objectName}Form.form("clear")
    },
        save:function() {
        //先判断到底是新增还是更新
        var url;
        var id = $("input[name='id']").val();
        if (id) {
            //编辑操作
            url = "/${objectName}_update";
        } else {
            //新增
            url = "/${objectName}_save";
        }
        ${objectName}Form.form("submit", {
            url: url,
            success: function (data) {
                data = $.parseJSON(data);//字符串转换成json对象格式
                if (data) {
                    $.messager.alert("温馨提示", data.msg, "info", function () {
                        //确定之后关闭对话框
                        ${objectName}Dialog.dialog("close");
                        ${objectName}Datagrid.datagrid("load");//重新加载表格
                    })
                } else {
                    $.messager.alert("温馨提示", data.msg, "error")
                }
            }
        })
    },
        cancel:function() {
        ${objectName}Dialog.dialog("close");
    },

        edit:function() {
        //获取一行数据
        var rowData = ${objectName}Datagrid.datagrid("getSelected");
        if (rowData) {
            ${objectName}Dialog.dialog("open");
                ${objectName}Dialog.dialog("setTitle", "编辑");
                //清除内容
                ${objectName}Form.form("clear");
            //添加一个属性
            if (rowData.dept) {
                rowData["dept.id"] = rowData.dept.id;
            }
            else {
                rowData["dept.id"] = null;
            }
            //数据回显
            ${objectName}Form.form("load", rowData);
        } else {
            $.messager.alert("温馨提示", "请选择需要编辑的数据", "warning");
        }
    },
        del:function() {
        //先判断用户是否有选中数据
        var rowData = ${objectName}Datagrid.datagrid("getSelected");
        if (rowData) {
            //删除之前让用户确定是否需要删除数据
            $.messager.confirm("温馨提示", "确定要删除该${objectName}吗？", function (r) {
                if (r) {
                    //点击确定后进入
                    $.get("/${objectName}_delete?id=" + rowData.id, function (data) {
                        if (data.success) {
                            //给出对应的提示刷新表格
                            $.messager.alert("温馨提示", data.msg, "info", function () {
                                ${objectName}Datagrid.datagrid("reload");//刷新
                            });
                        } else {
                            $.messager.alert("温馨提示", data.msg, "warning");
                        }
                    }, "json");//直接返回json对象不需要解析
                }
            })
        } else {
            $.messager.alert("温馨提示", "请选择需要删除的${objectName}", "warning");
        }

    },
        refresh:function() {
        ${objectName}Datagrid.datagrid("reload");
    }
    };
    //给按钮添加统一的事件
    $("a[data-cmd]").on("click",function(){
        var cmd=$(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    ${objectName}Datagrid.datagrid({
        url: "/${objectName}_list",
        fit: true,
        title: "数据表格",
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        singleSelect: true,
        columns: [
            [
                {field: "xx", title: "xx", width: 100, align: 'center'},
                {field: "xx", title: "xx", width: 100, align: 'center'},
            ]
        ],
        toolbar: "#tt"
    });
    ${objectName}Dialog.dialog({
        width: 300,
        height: 200,
        buttons: "#tb",
        closed: true
    });
});


		