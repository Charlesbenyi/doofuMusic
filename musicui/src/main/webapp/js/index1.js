$(function(){
	/*查询功能*/
	$("#search").on('click',function(){
		var songname = $("#search_content").val()
		console.log(songname)
		
		$.ajax({
			type:"get",
			url:"http://127.0.0.1:8080/userloadsongsbysongname.do?songname="+songname,
			async:true,
			success:function(data){
					var html = '';
					var songId = data.data[0].songid;
					if (songid) {
						location.assign("sing_detail.html?songId="+songid);
					} else{
						alert("哈哈哈，这首歌我们没有爬")
					}
			},
			error:function(event){
				alert("网页飞走了")
			}
		});
	})
	/*查询功能结束*/
	
	/*点歌曲进入歌曲详情页面*/
	$.ajax({
		type:"get",
		url:"http://127.0.0.1:8080/userloadsongsbyaddress.do",
		async:true,
		success:function(data){
			var songlist = data.data;
			var html = ''
			songlist.forEach(function(item,index){
				html += '<div class="col-xs-2 col-sm-2" ><div class="show_list"><div class="pic"><img id="'+item.albumid+
				'"src="'+item.albumpic+'"style="width: 100%;"/>'+
				'</div><p style="margin-top: 10px; font-size: 15px;"><b>'+item.albumname+'</b></p>'+'</div></div>'
			})
			$('#recommand_songs').html(html)
		},
		error:function(event){
			alert("网络错误")
		}
	});
	$("#recommand_songs").on('click','img',function(event){
		location.assign("album.html?albumid="+event.target.id)
	})
	/*点击歌曲详情页面结束*/
	
	/*推荐歌手*/
	$.ajax({
		type:"get",
		url:"http://127.0.0.1:8080/userloadsingersix.do",
		async:true,
		success:function(data){
			var singerlist = data.data
			var html = ''
			singerlist.forEach(function(item,index){
				html += '<div class="col-xs-2 col-sm-2" ><div class="show_list"><div class="pic"><img id="'+item.singerid+
				'"src="'+item.singerimg+'"style="width: 100%;border-radius:50%;"/>'+
				'</div><p style="margin-top: 10px; font-size: 15px;"><b>'+item.singername+'</b></p>'+'</div></div>'
			})
			$("#recommand_singers").html(html)
		}
	});
	
	$("#recommand_singers").on('click','img',function(event){
		location.assign('singer.html?singerId='+event.target.id)
	})
	/*推荐歌手结束*/
})
