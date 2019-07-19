$(function(){
	/*获取地址中的歌曲信息*/
	var albumid = GetQueryString("albumid")
	console.log(albumid)
	loadsongsbysingerid(1);
	var url = 'http://127.0.0.1:8080/userloadalbumbyalbumid.do?albumid='+albumid;
	$.ajax({
		type:"get",
		url:url,
		async:true,
		success:function(data){
			console.log(data)
			$("#singer_img").attr("src",data.data[0].albumpic);
			$("#albuminfo").html(data.data[0].albuminfo);
			$("#albumname").html(data.data[0].albumname);
		},
		error:function(){
			alert("请检查你的网络的设置！")
		}
	})
	})
	/*获取歌曲的信息结束*/
	
	/*歌手获取的基本信息*/

	/*歌手获取的基本信息结束*/
	
	$("#content").on('click',"i",function(event){
		var songId = event.target.id;
		console.log(songId);
		location.assign("sing_detail.html?songid="+songId)
	})
function loadsongsbysingerid(indexpage){
	var albumid = GetQueryString("albumid");
	var url = 'http://127.0.0.1:8080/userloadsongsbyalbumid.do?albumid='+albumid+'&indexpage='+indexpage;
	$.ajax({
		type:"get",
		url:url,
		async:true,
		success:function(data){
			var ul_item = $("#content");
			ul_item.empty();
			for (var i = 0; i < data.data.data.length; i++) {
				var li_item ="<tr>\n" +
					"\t\t\t\t\t\t\t<td>"+i+"</td>\n" +
					"\t\t\t\t\t\t\t<td>"+data.data.data[i].songname+"</td>\n" +
					"\t\t\t\t\t\t\t<td>" +data.data.data[i].singername+"</td>\n" +
					"\t\t\t\t\t\t\t<td><i id=\""+data.data.data[i].songid+"\" class=\"glyphicon glyphicon-play\"></i></td>\n" +
					"\t\t\t\t\t\t</tr>";
				ul_item.append(li_item);
			};


			$("#pagerutil").empty();


			var pager = " <a  href=\"#\" onclick=\"loadsongsbysingerid(1)\" style=\"color:#337ab7;\">首页</a>\n" +
				"            <a href=\"#\" onclick=\"loadsongsbysingerid("+(data.data.indexpage-1)+")\" style=\"color:#337ab7;\">上页</a>\n" +
				"            <a href=\"#\" style=\"color:#337ab7;\">"+data.data.indexpage+"/"+data.data.countpage+"</a>\n" +
				"            <a href=\"#\" onclick=\"loadsongsbysingerid("+(data.data.indexpage+1)+")\" style=\"color:#337ab7;\">下页</a>\n" +
				"            <a href=\"#\" onclick=\"loadsongsbysingerid("+(data.data.countpage)+")\" style=\"color:#337ab7;\">尾页</a>";

			$("#pagerutil").append(pager);

		}}
	);}
function GetQueryString(name) {
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r!=null)return  unescape(r[2]); return null;}