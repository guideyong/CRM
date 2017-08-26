<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="/WEB-INF/views/common.jsp"/>
    <link rel="stylesheet" type="text/css"
          href="/js/jquery-easyui/themes/portal.css">
    <script type="text/javascript"
            src="/js/jquery-easyui/jquery.portal.js"></script>
    <script src="/js/analogClock/analogClock.js"></script>
    <script type="text/javascript" src="../../js/views/main.js"></script>
    <script type="text/javascript" src="../../js/views/sign.js"></script>
    <script src="/js/weather/js/jquery.leoweather.min.js"></script>

    <style type="text/css">
        a:link, a:visited {
            text-decoration: none; /*超链接无下划线*/
        }
    </style>
    <style>
        body {
            font: 14px/1.5 微软雅黑;
            text-align: center;
        }

        #demo {
            width: 170px;
            color: #FFF;
        }

        #demo i {
            background: no-repeat top left;
            display: inline-block;
            height: 48px;
            line-height: 50px;
            font-size: 40px;
            padding-left: 50px;
            font-style: normal;
            text-align: center;
            font-weight: bold;
        }

        #demo i.icon-xiaoyu {
            background-image: url(/js/weather/icon/xiaoyu.png);
        }

        #demo i.icon-zhongyu {
            background-image: url(/js/weather/icon/zhongyu.png);
        }

        #demo i.icon-dayu {
            background-image: url(/js/weather/icon/dayu.png);
        }

        #demo i.icon-qing {
            background-image: url(/js/weather/icon/qing.png);
        }

        #demo i.icon-duoyun {
            background-image: url(/js/weather/icon/duoyun.png);
        }

        #demo i.icon-yin {
            background-image: url(/js/weather/icon/yin.png);
        }

        #demo p {
            font-size: 10px;
            background: rgba(0, 0, 0, .3);
            border-radius: 8px;
        }

        #demo p span {
            margin: 0 10px;
        }
    </style>
    <style type="text/css">
        .border_botton_none {
            border-bottom: none
                 }
        .border_right_botton_none {
            border-right: none;
            border-bottom: none
        }
        .border_top_none {
            border-top: none
        }

        .clock {
            width: 300px;
            margin: 0px auto;
        }
    </style>
    <%
        //从cookies中读取主题名称
        String col = "9fd9ed";
        Cookie cookies[] = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("col")) {
                    col = cookies[i].getValue();
                    break;
                }
            }
        }
    %>
    <title>系统首页</title>
</head>
<body>
<div id="cc" class="easyui-layout" fit="true" style="width: 600px; height: 400px;">
    <div id=head data-options="region:'north',border:false"
         style="height: 100px;background: #<%=col%>">
        <div style="float: right;margin-right: 10px;margin-top: 14px;">
            <div id="demo">
                <script>$('#demo').leoweather({format: '<i class="icon-{图标}">{气温}℃</i><p>{城市}<span>|</span>{天气}<span>|</span>{风向}{风级}级</p>'});</script>
            </div>
        </div>
        <div align="center" style="float: right;margin-right: 20px;margin-top: 18px;"><a data-cmd="logout"><img alt="安全退出"
                                                                                                 src="/image/logout.png">
            <div>安全退出</div>
        </a></div>
        <div align="center"style="float: right;margin-right: 20px;margin-top: 18px;"><a data-cmd="theme"><img alt="更换皮肤"
                                                                                                src="/image/theme.png">
            <div>更换皮肤</div>
        </a></div>
        <div align="center" style="float: right;margin-right: 20px;margin-top: 18px;"><a data-cmd="cpassword"><img alt="修改密码"
                                                                                                    src="/image/changepassword.png">
            <div>修改密码</div>
        </a></div>
        <div align="center" style="float: right;margin-right: 20px;margin-top: 18px;"><a data-cmd="osign"><img alt="签退"
                                                                                                src="/image/signout.png">
            <div>签退</div>
        </a></div>
        <div align="center" style="float: right;margin-right: 20px;margin-top: 18px;"><a data-cmd="isign"><img alt="签到"
                                                                                                src="/image/signin.png">
            <div>签到</div>
        </a></div>
        <div align="center" style="float: right;margin-right: 20px;margin-top: 18px;"><a data-cmd="my"><img alt="当前用户"
                                                                                             src="/image/day.png">
            <div>${userINsession.username}&nbsp;&nbsp;&nbsp;</div>
        </a></div>
        <div style="float: left;margin-left: 20px;margin-top: 18px;"><img alt="logo"
                                                                          src="/image/crm.png"></div>

    </div>
    <div data-options="region:'south',border:false"
         style="height: 30px;line-height:30px; font-size: 10px " align="center">
        版权信息©2017 西安财经学院信管1402桂德雍
    </div>
    <div data-options="region:'west',title:'导航'" style="width: 150px;" headerCls="border_botton_none"
         bodyCls="border_right_botton_none">
        <!--手风琴+菜单  -->
        <div class="easyui-accordion" fit="true">
            <div title="菜单" iconCls="icon-menu">
                <!--使用树组件来定义菜单  -->
                <ul id="menuTree"></ul>
            </div>
            <div title="帮助" iconCls="icon-help">
                当前版本v2.0
            </div>
            <div title="简介" iconCls="icon-tip">
                客户关系管理系统用于管理与客户相关的信息与活动，包括企业与顾客间在销售、营销和服务上的交互，从而提升其管理方式，向客户提供创新式的个性化的客户交互和服务的过程。CRM不仅仅是一个软件，它是方法论、软件和IT能力综合，是商业策略。其最终目标是吸引新客户、保留老客户以及将已有客户转为忠实客户。
            </div>
        </div>
    </div>
    <div data-options="region:'center'" class="border_top_none border_botton_none">
        <!--正文操作  -->
        <div id="myTabs" class="easyui-tabs" fit="true">
            <div id="pp" title="首页" closable="true">
                <div style="width:30%">
                    <div title="时钟" style="text-align:center;height:275px;padding:20px;">
                        <div id="clock3" class="clock" align="center" style="float:none"></div>
                    </div>
                    <div title="日历" id="c" class="easyui-calendar"
                         style="text-align:center;background:#f3eeaf;height:280px;" bodyCls="border_top_none"></div>
                </div>
                <div style="width:70%">
                    <div>
                        <div title="潜在客户报表"
                             style="float: left;text-align:center;height:275px;width:50%;">
                            <iframe src='/ppchart' style='width:100%;height:98%' frameborder=0 SCROLLING="NO"></iframe>
                        </div>
                        <div title="正式客户报表" style="float: left;text-align:center;height:275px;width:50%;">
                            <iframe src='/ccchart' style='width:100%;height:98%' frameborder=0 SCROLLING="NO"></iframe>
                        </div>
                    </div>
                    <div title="销售金额报表" style="text-align:center;background:white;height:275px;padding:0px;">
                        <iframe src='/mmchart' style='width:100%;height:98%' frameborder=0 SCROLLING="NO"></iframe>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!--定义对话框  -->
<div id="password_dialog">
    <form id="password_form" method="post">
        <table align="center" style="margin-top: 15px">
            <tr>
                <td>原密码</td>
                <td><input class="easyui-textbox" name="oldpassword"/></td>
            </tr>
            <tr>
                <td>新密码</td>
                <td><input class="easyui-textbox" name="newpassword"/></td>
            </tr>
        </table>
    </form>
</div>
<div id="theme_dialog" style="width: 100%">
    <div style="width: 50%;float: left">
    <div align="center" style="float: left;margin-left: 20px;margin-top: 20px; "onclick="changeTheme('default','9fd9ed')"><img alt="默认"src="/image/themebuilder.jpg">
        <div>默认</div>
    </div>
    <div align="center" style="float: left;margin-left: 20px;margin-top: 20px; "onclick="changeTheme('gray','c0ccd3')"><img alt="灰白"src="/image/theme-cupertino.png">
        <div>灰白</div>
    </div>
    <div align="center" style="float: left;margin-left: 20px;margin-top: 20px; "onclick="changeTheme('sunny','ffda85')"><img alt="夏日"src="/image/theme-sunny.png">
        <div>夏日</div>
    </div>
    <div align="center" style="float: left;margin-left: 20px;margin-top: 20px; "onclick="changeTheme('dark-hive','545454')"><img alt="深黑"src="/image/theme-dark-hive.png">
        <div>酷黑</div>
    </div>
    <div align="center" style="float: left;margin-left: 20px;margin-top: 20px; "onclick="changeTheme('pepper-grinder','e3d1cd')"><img alt="细粉"src="/image/theme-pepper-grinder.png">
        <div>细粉</div>
    </div>
    </div>
    <div style="width: 50%;float: right">
        <div align="center" style="float: right;margin-right: 20px;margin-top: 20px; "onclick="changeTheme('metro-blue','b8e7eb')"><img alt="海蓝"src="/image/theme-metro-blue.png">
            <div>海蓝</div>
        </div>
        <div align="center" style="float: right;margin-right: 20px;margin-top: 20px; "onclick="changeTheme('metro-gray','d3d1d1')"><img alt="淡灰"src="/image/theme-metro-gray.png">
            <div>淡灰</div>
        </div>
        <div align="center" style="float: right;margin-right: 20px;margin-top: 20px; "onclick="changeTheme('metro-green','d7ffc2')"><img alt="轻绿"src="/image/theme-metro-green.png">
            <div>轻绿</div>
        </div>
        <div align="center" style="float: right;margin-right: 20px;margin-top: 20px; "onclick="changeTheme('metro-orange','f7edd2')"><img alt="黄橙"src="/image/theme-metro-orange.png">
            <div>黄橙</div>
        </div>
        <div align="center" style="float: right;margin-right: 20px;margin-top: 20px; "onclick="changeTheme('metro-red','f18888')"><img alt="桃红"src="/image/theme-metro-red.png">
            <div>桃红</div>
        </div>
    </div>
</div>
<div id="tc">
    <a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save2">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel2">取消</a>
</div>
</body>
</html>