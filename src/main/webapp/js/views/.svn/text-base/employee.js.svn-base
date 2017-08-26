$(function () {
    var employeeDatagrid,employeeDialog,employeeForm,employeeSearchForm,employeeDatagridEditBtn;
    employeeDatagrid=$("#employee_datagrid");
    employeeDialog=$("#employee_dialog");
    employeeForm=$("#employee_form");
    employeeSearchForm=$("#employee_searchForm");
    employeeDatagridEditBtn=$("#tt a");

    //统一管理方法
    var cmdObj={
        resetFrom:function() {
            employeeSearchForm.form("clear");
    },
        //高级查询数据转换传输到后台
        searchContent:function() {
        var param = {};
        var paramArr = employeeSearchForm.serializeArray();
        for (var i = 0; i < paramArr.length; i++) {
            param[paramArr[i].name] = paramArr[i].value;
        }
        employeeDatagrid.datagrid("load", param);
    },
        add:function() {
        employeeDialog.dialog("open");
            employeeDialog.dialog("setTitle", "新增");
            //清楚内容
            employeeForm.form("clear")
    },
        save:function() {
        //先判断到底是新增还是更新
        var url;
        var id = $("input[name='id']").val();
        if (id) {
            //编辑操作
            url = "/employee_update";
        } else {
            //新增
            url = "/employee_save";
        }
        employeeForm.form("submit", {
            url: url,
            onSubmit:function (param) {
              var ids=$("#employee_roleCombo").combobox("getValues");
                for(var i=0;i<ids.length;i++){
                  param["roles["+i+"].id"]=ids[i];
                }
            },
            success: function (data) {
                data = $.parseJSON(data);//字符串转换成json对象格式
                if (data) {
                    $.messager.alert("温馨提示", data.msg, "info", function () {
                        //确定之后关闭对话框
                        employeeDialog.dialog("close");
                        employeeDatagrid.datagrid("load");//重新加载表格
                    })
                } else {
                    $.messager.alert("温馨提示", data.msg, "error")
                }
            }
        })
    },
        cancel:function() {
        employeeDialog.dialog("close");
    },

        edit:function() {
        //获取一行数据
        var rowData = employeeDatagrid.datagrid("getSelected");
        if (rowData) {
            employeeDialog.dialog("open");
                employeeDialog.dialog("setTitle", "编辑");
                //清除内容
                employeeForm.form("clear");
            //添加一个属性
            if (rowData.dept) {
                rowData["dept.id"] = rowData.dept.id;
            }
            else {
                rowData["dept.id"] = null;
            }
            //数据回显
            employeeForm.form("load", rowData);
            //发送请求到后台查询这个员工对应的角色id
            var html=$.ajax({
                url:"/role_queryRoleByEid?eid="+rowData.id,
                async:false//关闭异步
            }).responseText;
            html=$.parseJSON(html);
            $("#employee_roleCombo").combobox('setValues',html)
        } else {
            $.messager.alert("温馨提示", "请选择需要编辑的数据", "warning");
        }
    },
        del:function() {
        //先判断用户是否有选中数据
        var rowData = employeeDatagrid.datagrid("getSelected");
        if (rowData) {
            //删除之前让用户确定是否需要删除数据
            $.messager.confirm("温馨提示", "确定要离职该员工吗？", function (r) {
                if (r) {
                    //点击确定后进入
                    $.get("/employee_delete?id=" + rowData.id, function (data) {
                        if (data.success) {
                            //给出对应的提示刷新表格
                            $.messager.alert("温馨提示", data.msg, "info", function () {
                                employeeDatagrid.datagrid("reload");//刷新
                            });
                        } else {
                            $.messager.alert("温馨提示", data.msg, "warning");
                        }
                    }, "json");//直接返回json对象不需要解析
                }
            })
        } else {
            $.messager.alert("温馨提示", "请选择需要离职的员工", "warning");
        }

    },
        refresh:function() {
        employeeDatagrid.datagrid("reload");
    }
    };
    //给按钮添加统一的事件
    $("a[data-cmd]").on("click",function(){
        var cmd=$(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    employeeDatagrid.datagrid({
        url: "/employee_list",
        fit: true,
        title: "员工信息",
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        pageList:[20,30,40,50],
        pageSize:20,
        singleSelect: true,
        columns: [
            [
                {field: "username", title: "账号", width: 100, align: 'center'},
                {field: "realname", title: "真实姓名", width: 100, align: 'center'},
                {field: "tel", title: "电话", width: 100, align: 'center'},
                {field: "email", title: "邮箱", width: 100, align: 'center'},
                {field: "dept", title: "部门", width: 100, formatter: deptFormatter, align: 'center'},
                {field: "inputtime", title: "入职时间", width: 100, align: 'center'},
                {field: "state", title: "状态", width: 100, formatter: statusFormatter, align: 'center'}
            ]
        ],
        toolbar: "#tt",
        onClickRow: function (rowIndex, rowData) {
            if (rowData.state) {
                employeeDatagridEditBtn.eq(1).linkbutton("enable");
                employeeDatagridEditBtn.eq(2).linkbutton("enable");
            } else {
                //让按钮变灰
                employeeDatagridEditBtn.eq(1).linkbutton("disable");
                employeeDatagridEditBtn.eq(2).linkbutton("disable");
            }
        }
    });
    employeeDialog.dialog({
        width: 300,
        height: 300,
        buttons: "#tb",
        closed: true
    });
});
function deptFormatter(value, record, index) {
    if (value)
        return value.name;
    else
        return value;
}
function statusFormatter(value, record, index) {
    if (value)
        return "<font color='green'>在职</font>";
    else
        return "<font color='red'>离职</font>";
}


		