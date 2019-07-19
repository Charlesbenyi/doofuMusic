function login(){
	var accounts = $("#accounts").val();
	var userpwd  = $("#userpwd").val()
	console.log("ding")
	if (accounts && userpwd) {
		$.ajax({
			type:"post",
			url:"http://localhost:8080/userlogin.do",
			async:true,
			data:{
				accounts:accounts,
				userpwd:userpwd
			},
			success:function(data){
				if (data.msg!=null) {
					alert(data.msg)
				} else{
					alert("登陆成功");
					location.assign("index1.html");
					localStorage.setItem("userid",data.data.userid);
				}
			},
			error:function(){
				alert("请检查您的网络设置")
			}
		});
	} else{
		alert("请输入必要信息！")
	}
}


function adminlogin(){
	var accounts = $("#accounts").val();
	var userpwd  = $("#userpwd").val()
	console.log("ding")
	if (accounts && userpwd) {
		$.ajax({
			type:"post",
			url:"http://localhost:8080/adminlogin.do",
			async:true,
			data:{
				accounts:accounts,
				userpwd:userpwd
			},
			success:function(data){
				if (data.result) {
					alert(data.msg)
					location.assign("index.html")
				} else{
					alert(data.msg)
				}
			},
			error:function(){
				alert("请检查您的网络设置")
			}
		});
	} else{
		alert("请输入必要信息！")
	}
}
