
    function register() {
		var accounts = $("#accounts").val();
		var username = $("#username").val();
		var userpwd = $("#userpwd").val();
		var sex = $("#sex").val();
		var age = $("#age").val();
		var telephone = $("#telephone").val();
		var email = $("#email").val();
		if (accounts == "" || username == "" || userpwd == "" || age == "" || sex == "" || telephone == "" || email == "") {
			alert("所有选项不能为空")
		} else {
			$.post(
				"http://localhost:8080/adduser.do",
				{
					accounts: accounts,
					username: username,
					userpwd: userpwd,
					age: age,
					sex: sex,
					telephone: telephone,
					email: email
				},
				function (data) {
					if (data.result) {
						alert(data.msg);
						location.href = "login.html";
					} else {
						alert(data.msg);
					}
				})
		}
	}
