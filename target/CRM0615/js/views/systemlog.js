$(function () {
    var systemlogDatagrid,systemlogDialog,systemlogForm,systemlogSearchForm,systemlogDatagridEditBtn;
    systemlogDatagrid=$("#systemlog_datagrid");
    systemlogDialog=$("#systemlog_dialog");
    systemlogForm=$("#systemlog_form");
    systemlogSearchForm=$("#systemlog_searchForm");
    systemlogDatagridEditBtn=$("#tt a");

    //统一管理方法
    var cmdObj={
        resetFrom:function() {
            systemlogSearchForm.form("clear");
    },
        //高级查询数据转换传输到后台
        searchContent:function() {
        var param = {};
        var paramArr = systemlogSearchForm.serializeArray();
        for (var i = 0; i < paramArr.length; i++) {
            param[paramArr[i].name] = paramArr[i].value;
        }
        systemlogDatagrid.datagrid("load", param);
    },

        cancel:function() {
        systemlogDialog.dialog("close");
    },

        del:function() {
        //先判断用户是否有选中数据
        var rowData = systemlogDatagrid.datagrid("getSelected");
        if (rowData) {
            //删除之前让用户确定是否需要删除数据
            $.messager.confirm("温馨提示", "确定要删除该systemlog吗？", function (r) {
                if (r) {
                    //点击确定后进入
                    $.get("/systemlog_delete?id=" + rowData.id, function (data) {
                        if (data.success) {
                            //给出对应的提示刷新表格
                            $.messager.alert("温馨提示", data.msg, "info", function () {
                                systemlogDatagrid.datagrid("reload");//刷新
                            });
                        } else {
                            $.messager.alert("温馨提示", data.msg, "warning");
                        }
                    }, "json");//直接返回json对象不需要解析
                }
            })
        } else {
            $.messager.alert("温馨提示", "请选择需要删除的systemlog", "warning");
        }

    },
        refresh:function() {
        systemlogDatagrid.datagrid("reload");
    }
    };
    //给按钮添加统一的事件
    $("a[data-cmd]").on("click",function(){
        var cmd=$(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    systemlogDatagrid.datagrid({
        url: "/systemlog_list",
        fit: true,
        title: "日志信息",
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        pageList:[20,30,40,50],
        pageSize:20,
        singleSelect: true,
        columns: [
            [
                {field: "opuser", title: "操作用户", width: 100,formatter:opuserFormatter, align: 'center'},
                {field: "optime", title: "操作时间", width: 100, align: 'center'},
                {field: "opip", title: "登录IP", width: 100, align: 'center'},
                {field: "function", title: "使用功能", width: 100, align: 'center'},
                {field: "params", title: "操作参数信息", width: 100, align: 'center'}
            ]
        ],
        toolbar: "#tt"
    });
    systemlogDialog.dialog({
        width: 300,
        height: 200,
        buttons: "#tb",
        closed: true
    });
});
function opuserFormatter(value, record, index) {
    if (value)
        return value.username;
    else
        return value;
}


