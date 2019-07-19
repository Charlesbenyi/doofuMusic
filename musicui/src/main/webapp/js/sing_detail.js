$(function(){
				/*歌曲跳转的获取参数*/
				var songId = GetQueryString("songid")
				console.log(songId)
				
				function GetQueryString(name) {
				     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
				     var r = window.location.search.substr(1).match(reg);
				     if(r!=null)return  unescape(r[2]); return null;
				}
				/*歌曲跳转获取参数*/
				
				
			
				
//				https://win-web-rh01-sycdn.kuwo.cn/ae9a3f8f4fd39773e0c7a92a624704c4/5d2424c2/resource/n2/77/88/427663201.mp3
				
				/*歌曲的基本展示*/
//				$("#music_play").attr("src","https://win-web-rh01-sycdn.kuwo.cn/ae9a3f8f4fd39773e0c7a92a624704c4/5d2424c2/resource/n2/77/88/427663201.mp3")
				$.ajax({
		            type:"GET",
		            url:"http://www.kuwo.cn/api/www/music/musicInfo?mid="+songId, //访问的链接
		            dataType:"jsonp",  //数据格式设置为jsonp
		            jsonp:"callback",  //Jquery生成验证参数的名称
		            success:function(data){  //成功的回调函数
		               console.log(data);
		               $("#img_likn").attr("src",data.data.pic)
		               var ablum_name ="<span>"+data.data.album+"</span>"
		               $("#ablum_name").append(ablum_name)
		               var ablum_descipt = data.data.albuminfo
		               $("#ablum_descript").text(ablum_descipt)
		               var song_name = "<span>"+data.data.name+"</span>"
		               $("#song_name").append(song_name)
		                var artist = "<span>"+data.data.artist+"</span>"
		               $("#artist").append(artist)
		            },
		            error: function (e) {
		                alert("error");
		            }
        		})
				/*歌曲的基本的展示结束*/
				/*歌曲资源加载*/
				$.ajax({
		            type:"GET",
		            url:"http://www.kuwo.cn/url?format=mp3&rid="+songId+"&response=url&type=convert_url3&br=128kmp3", //访问的链接
		            dataType:"jsonp",  //数据格式设置为jsonp
		            jsonp:"callback",  //Jquery生成验证参数的名称
		            success:function(data){  //成功的回调函数
		               console.log(data);
		               $("#music_play").attr("src",data.url)
		            },
		            error: function (e) {
		                console.log("error");
		            }
        		})
				/*歌曲资源加载结束*/
				/*歌词获取*/
				var oLRC = [];
				$.getJSON("http://m.kuwo.cn/newh5/singles/songinfoandlrc?musicId="+songId,function(data){
					var lrclist = data.data.lrclist;
					console.log(lrclist)
					oLRC = lrclist;
					var html =''
					lrclist.forEach(function(item,index){
						html += "<li>"+item.lineLyric+"</li>"
					})
					$("#lyric").html(html)
				})
				/*歌词获取结束*/
				/*歌词滚动*/
				
				var lineNo= 0; //当前行
				var C_pos= 6; //C位
				var offset= -20; //滚动距离（应等于行高）
				var audio = document.getElementById("music_play");//播放器
				var ul = document.getElementById("lyric"); //歌词容器列表
				
				//高亮显示歌词当前行及文字滚动控制，行号为lineNo
				function lineHigh() {
					var lis = ul.getElementsByTagName("li");//歌词数组
					if(lineNo>0){
				 		lis[lineNo-1].removeAttribute("class");//去掉上一行的高亮样式
					}
					lis[lineNo].className = "lineHigh";//高亮显示当前行
				
					//文字滚动
					if(lineNo>C_pos){
						ul.style.transform = "translateY("+(lineNo-C_pos)*offset+"px)"; //整体向上滚动一行高度
					}
				}
				
				//滚回到开头，用于播放结束时
				function goback() {
					document.querySelector("#lyric .lineHigh").removeAttribute("class");
					ul.style.transform = "translateY(0)";
					lineNo = 0;
				}
				
				//监听播放器的timeupdate事件，实现文字与音频播放同步
				audio.ontimeupdate = function () {
				    if(lineNo==oLRC.length)
						return;
					var curTime = audio.currentTime; //播放器时间
					if(parseFloat(oLRC[lineNo].time)<=curTime){
						lineHigh();//高亮当前行
						lineNo++;
					}
				};
				
				//监听播放器的ended事件，播放结束时回滚歌词
				audio.onended = function () {
				    goback(); //回滚歌词
				};

				/*歌词滚动结束*/

	             /*添加收藏*/
	$("#shoucang").on('click',function () {
		var userid=localStorage.getItem("userid")
		$.ajax({
			type:"post",
			url:"http://localhost:8080/shoucang.do",
			async:true,
			data:{
				userid:userid,
				songid:songId,
			},
			success:function(data){
				if (data.msg =="收藏成功" ){
					$("#shoucang").text("已收藏")
					$("#shoucang").addClass("active")
				} else{
					$("#shoucang").text("收藏")
					$("#shoucang").removeClass("active")
				}
			}
		});
	})
})

