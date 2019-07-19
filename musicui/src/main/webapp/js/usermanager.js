$(function () {
    var userid=localStorage.getItem("userid");
    $.post(
        "http://localhost:8080/selectuserbyuserid.do",
        {userid:userid},
        function (data) {
            $("#username").text(data.data[0].username)
            $("#emial").text(data.data[0].email)
            $("#zhanhao").text(data.data[0].accounts)
            $("#telepone").text(data.data[0].telephone)
            $("#sex").text(data.data[0].sex)
            $("#age").text(data.data[0].age)
            $("#eusername").attr("value",data.data[0].username)
            $("#eemail").attr("value",data.data[0].email)
            $("#esex").attr("value",data.data[0].sex)
            $("#eage").attr("value",data.data[0].age)
            $("#etelephone").attr("value",data.data[0].telephone)
            $("#euserpwd").attr("value",data.data[0].userpwd)
        }
    )
     loadsongslist(1);
    /*客户退出开始*/
    $("#loginout").on('click',function(){
        localStorage.clear();
        alert("成功退出")
        location.assign("index1.html")
    })
    /*客户退出结束*/
    /*页面跳转*/
    $("#shoucang").on("click",'i',function (event) {
        location.assign("sing_detail.html?songid="+event.target.id)
    })
    /*页面跳转结束*/

    $("#user_update").on('click',function(){
        var username= $("#eusername").val();
        var email= $("#eemail").val();
        var sex=  $("#esex").val();
        var age= $("#eage").val();
        var telephone=  $("#etelephone").val();
        var userpwd=  $("#euserpwd").val();
        $.post(
            "http://localhost:8080/userinfoupdate.do",
            {userid:userid,username:username,email:email,sex:sex,age:age,telephone:telephone,userpwd:userpwd},
            function (data) {
                alert(data.msg);
                window.location.reload();
            }
        )
    })

 /*   function editoruserbtn(){
       var username= $("#eusername").val();
        var email= $("#eemail").val();
        var sex=  $("#esex").val();
        var age= $("#eage").val();
        var telephone=  $("#etelephone").val();
        var userpwd=  $("#userpwd").val();
        $.post(
            "http://localhost:8080/userinfoupdate.do",
            {userid:userid,username:username,email:email,sex:sex,age:age,telephone:telephone,userpwd:userpwd},
            function (data) {
                alert(data.msg);
                window.location.reload();
            }
        )
    }*/
})
function loadsongslist(indexpage){
    var userid=localStorage.getItem("userid");
    $.post(
        "http://localhost:8080/querymysongslist.do",
        {userid:userid},
        function (data) {
            var ul_item = $("#shoucang");
            ul_item.empty();
            for (var i = 0; i < data.data.data.length; i++) {
                var li_item ="<tr>\n" +
                    "\t\t\t\t\t\t\t<td>"+i+"</td>\n" +
                    "\t\t\t\t\t\t\t<td><img src=' "+data.data.data[i].songpic+"'></td>\n" +
                    "\t\t\t\t\t\t\t<td>" +data.data.data[i].songname+"</td>\n" +
                    "\t\t\t\t\t\t\t<td>" +data.data.data[i].albumname+"</td>\n" +
                    "\t\t\t\t\t\t\t<td>" +data.data.data[i].songreleaseDate+"</td>\n" +
                    "\t\t\t\t\t\t\t<td><i id=\""+data.data.data[i].songid+"\" class=\"glyphicon glyphicon-play\"></i></td>\n" +
                    "\t\t\t\t\t\t</tr>";
                ul_item.append(li_item);
            };


            $("#pagerutil").empty();


            var pager = " <a  href=\"#\" onclick=\"loadsongslist(1)\" style=\"color:#337ab7;\">首页</a>\n" +
                "            <a href=\"#\" onclick=\"loadsongslist("+(data.data.indexpage-1)+")\" style=\"color:#337ab7;\">上页</a>\n" +
                "            <a href=\"#\" style=\"color:#337ab7;\">"+data.data.indexpage+"/"+data.data.countpage+"</a>\n" +
                "            <a href=\"#\" onclick=\"loadsongslist("+(data.data.indexpage+1)+")\" style=\"color:#337ab7;\">下页</a>\n" +
                "            <a href=\"#\" onclick=\"loadsongslist("+(data.data.countpage)+")\" style=\"color:#337ab7;\">尾页</a>";

            $("#pagerutil").append(pager);
        }
    )}

