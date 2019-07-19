$(function(){
	$(".singers_nav").on('click',function(event){
		var singerid = event.target.id;
		console.log(singerid);
		location.href = "singer.html?singerId="+singerid
	})
	$("#serchbtn").on('click',function () {

		loadsingerdatabyname(1);
	})
});
function loadSingerData(indexpage){

	$.post(
		"http://127.0.0.1:8080/loadsinger.do?indexpage="+indexpage,
		{},
		function(data){
			var ul_item = $("#allsingers");
			ul_item.empty();
			for (var i = 0; i < data.data.data.length; i++) {
				var li_item = "\t\t\t<div class=\"show_singer\" >\n" +
					"\t\t\t\t<img id=\""+data.data.data[i].singerid+"\" src=\""+data.data.data[i].singerimg+"\" style=\"width: 200px; border-radius: 50%;\"/>\n" +
					"\t\t\t\t<span style=\"color: black;\">\n" +
					"\t\t\t\t"+data.data.data[i].singername+"\n" +
					"\t\t\t\t</span>\n" +
					"\t\t\t</div>";
				ul_item.append(li_item);
			};


			$("#pagerutil").empty();


			var pager = " <a  href=\"#\" onclick=\"loadSingerData(1)\" style=\"color:#337ab7;font-size: 30px;\">首页</a>\n" +
				"            <a href=\"#\" onclick=\"loadSingerData("+(data.data.indexpage-1)+")\" style=\"color:#337ab7;font-size: 30px;\">上页</a>\n" +
				"            <a href=\"#\" style=\"color:#337ab7;font-size: 30px;\">"+data.data.indexpage+"/"+data.data.countpage+"</a>\n" +
				"            <a href=\"#\" onclick=\"loadSingerData("+(data.data.indexpage+1)+")\" style=\"color:#337ab7;font-size: 30px;\">下页</a>\n" +
				"            <a href=\"#\" onclick=\"loadSingerData("+(data.data.countpage)+")\" style=\"color:#337ab7;font-size: 30px;\">尾页</a>";

			$("#pagerutil").append(pager);

		}
	);

}
function loadsingerdatabyname(indexpage){
	var singername=$("#serchvalue").val();
	$.post(
		"http://127.0.0.1:8080/userloadsingerbyname.do?indexpage="+indexpage+"&singername="+singername,
		{},
		function(data){
			var ul_item = $("#allsingers");
			ul_item.empty();
			for (var i = 0; i < data.data.data.length; i++) {
				var li_item = "\t\t\t<div class=\"show_singer\" >\n" +
					"\t\t\t\t<img id=\""+data.data.data[i].singerid+"\" src=\""+data.data.data[i].singerimg+"\" style=\"width: 200px; border-radius: 50%;\"/>\n" +
					"\t\t\t\t<span style=\"color: black;\">\n" +
					"\t\t\t\t"+data.data.data[i].singername+"\n" +
					"\t\t\t\t</span>\n" +
					"\t\t\t</div>";
				ul_item.append(li_item);
			};


			$("#pagerutil").empty();


			var pager = " <a  href=\"#\" onclick=\"loadsingerdatabyname(1)\" style=\"color:#337ab7;font-size: 30px;\">首页</a>\n" +
				"            <a href=\"#\" onclick=\"loadsingerdatabyname("+(data.data.indexpage-1)+")\" style=\"color:#337ab7;font-size: 30px;\">上页</a>\n" +
				"            <a href=\"#\" style=\"color:#337ab7;font-size: 30px;\">"+data.data.indexpage+"/"+data.data.countpage+"</a>\n" +
				"            <a href=\"#\" onclick=\"loadsingerdatabyname("+(data.data.indexpage+1)+")\" style=\"color:#337ab7;font-size: 30px;\">下页</a>\n" +
				"            <a href=\"#\" onclick=\"loadsingerdatabyname("+(data.data.countpage)+")\" style=\"color:#337ab7;font-size: 30px;\">尾页</a>";

			$("#pagerutil").append(pager);

		}
	);}

$(function(){
	loadSingerData(1);
});

