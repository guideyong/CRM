
$(function () {
    var systemdictionaryDatagrid,systemdictionaryitemDatagrid,systemdictionaryitemDialog,systemdictionaryitemForm,systemdictionaryitemSearchForm,systemdictionaryitemDatagridEditBtn;
    systemdictionaryDatagrid = $("#systemdictionary_datagrid");
    systemdictionaryitemDatagrid=$("#systemdictionaryitem_datagrid");
    systemdictionaryitemDialog=$("#systemdictionaryitem_dialog");
    systemdictionaryitemForm=$("#systemdictionaryitem_form");
    systemdictionaryitemSearchForm=$("#systemdictionaryitem_searchForm");
    systemdictionaryitemDatagridEditBtn=$("#tt a");
    //统一管理方法
    var cmdObj={
        resetFrom:function() {
            systemdictionaryitemSearchForm.form("clear");
        },
        //高级查询数据转换传输到后台
        searchContent:function() {
            var param = {};
            var paramArr = systemdictionaryitemSearchForm.serializeArray();
            for (var i = 0; i < paramArr.length; i++) {
                param[paramArr[i].name] = paramArr[i].value;
            }
            systemdictionaryitemDatagrid.datagrid("load", param);
        },
        add:function() {
            systemdictionaryitemDialog.dialog("open"),
                systemdictionaryitemDialog.dialog("setTitle", "新增");
            //清除内容
            systemdictionaryitemForm.form("clear")
        },
        save:function() {
            //先判断到底是新增还是更新
            var url;
            var id = $("input[name='id']").val();
            if (id) {
                //编辑操作
                url = "/systemdictionaryitem_update";
            } else {
                //新增
                url = "/systemdictionaryitem_save";
            }
            systemdictionaryitemForm.form("submit", {
                url: url,
                success: function (data) {
                    data = $.parseJSON(data);//字符串转换成json对象格式
                    if (data) {
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            //确定之后关闭对话框
                            systemdictionaryitemDialog.dialog("close");
                            systemdictionaryitemDatagrid.datagrid("load");//重新加载表格
                        })
                    } else {
                        $.messager.alert("温馨提示", data.msg, "error")
                    }
                }
            })
        },
        cancel:function() {
            systemdictionaryitemDialog.dialog("close");
        },

        edit:function() {
            //获取一行数据
            var rowData = systemdictionaryitemDatagrid.datagrid("getSelected");
            if (rowData) {
                systemdictionaryitemDialog.dialog("open");
                systemdictionaryitemDialog.dialog("setTitle", "编辑");
                //清除内容
                systemdictionaryitemForm.form("clear");
                //添加一个属性
                if (rowData.parent) {
                    rowData["parent.id"] = rowData.parent.id;
                }
                else {
                    rowData["parent.id"] = null;
                }
                //数据回显
                systemdictionaryitemForm.form("load", rowData);
/*                var html=$.ajax({
                    url:"/querysystemdictionaryBy?eid="+rowData.id,
                    async:false//关闭异步
                }).responseText;
                html=$.parseJSON(html);
                $("#systemdictionarybox").combobox('setValues',html)*/
            } else {
                $.messager.alert("温馨提示", "请选择需要编辑的数据", "warning");
            }
        },
        del:function() {
            //先判断用户是否有选中数据
            var rowData = systemdictionaryitemDatagrid.datagrid("getSelected");
            if (rowData) {
                //删除之前让用户确定是否需要删除数据
                $.messager.confirm("温馨提示", "确定要删除该systemdictionaryitem吗？", function (r) {
                    if (r) {
                        //点击确定后进入
                        $.get("/systemdictionaryitem_delete?id=" + rowData.id, function (data) {
                            if (data.success) {
                                //给出对应的提示刷新表格
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    systemdictionaryitemDatagrid.datagrid("reload");//刷新
                                });
                            } else {
                                $.messager.alert("温馨提示", data.msg, "warning");
                            }
                        }, "json");//直接返回json对象不需要解析
                    }
                })
            } else {
                $.messager.alert("温馨提示", "请选择需要删除的systemdictionaryitem", "warning");
            }

        },
        refresh:function() {
            systemdictionaryitemDatagrid.datagrid("reload");
        }
    };
    //给按钮添加统一的事件
    $("a[data-cmd]").on("click",function(){
        var cmd=$(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });
    systemdictionaryDatagrid.datagrid({
        url: "/systemdictionary_list",
        fit: true,
        title: "字典目录",
        fitColumns: true,
        singleSelect: true,
        columns: [
            [
                {field: "sn", title: "字典编号", width: 100, align: 'center'},
                {field: "name", title: "字典名称", width: 100, align: 'center'},
                {field: "intro", title: "字典简介", width: 100, align: 'center'}
            ]
        ],
        //单击响应
        onClickRow:function (index, row) {
            var rowIndex = systemdictionaryDatagrid.datagrid('getRowIndex', row);
            systemdictionaryitemDatagrid.datagrid("reload",{
                id:rowIndex+1
            });
        }
    });
    systemdictionaryitemDatagrid.datagrid({
        url: "/systemdictionaryitem_byone",
        fit: true,
        title: "字典目录明细",
        fitColumns: true,
        singleSelect: true,
        columns: [
            [
                {field: "name", title: "字典明细名称", width: 100, align: 'center'},
                {field: "intro", title: "字典明细简介", width: 100, align: 'center'},
                {field: "parent", title: "字典目录", width: 100,formatter:parentFormatter, align: 'center'}
            ]
        ],
        toolbar: "#tt"
    });
    systemdictionaryitemDialog.dialog({
        width: 300,
        height: 200,
        buttons: "#tb",
        closed: true
    });
});
function parentFormatter(value, record, index) {
    if (value)
        return value.name;
    else
        return value;
}



