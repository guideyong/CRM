$(function(){
	$("#menuTree").tree({
		url:'/js/data/tree.json',
		onClick:function(node){
			//在选项中添加新面板
			var myTab = $("#myTabs");
			//在选项卡中是否已经有该节点的面板.
			if(myTab.tabs("exists",node.text)){
				//选中面板
				myTab.tabs("select",node.text);
			}else{
				myTab.tabs("add",{
					title:node.text,
					closable:true,
					content:"<iframe  src='"+node.attributes.url+"' style='width:100%;height:99%;' frameborder=0></iframe>"
				});
			}
		}
	});
    AnalogClock("clock1");//simple use
    AnalogClock("clock2", { width: 300, bgColor: "#bf0" });//simple option
    AnalogClock("clock3", new AnalogClockOption(200, "#eee", "#7AC5CD"));//using option class to customize
        $('#pp').portal({
            border:false,
            fit:true
        });
});





