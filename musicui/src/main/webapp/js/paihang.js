  $(function () {
      $.post(
          "http://localhost:8080/newsongs.do",
          {},
          function (data) {
              var pitem=$("#paihang-content")
              pitem.empty();
              for (var i=0;i<data.data.length;i++){
                  var k=i+1;
                  var item = "  <tr>\n" +
                      "                    <td>\n" +
                      "                        <h3 class=\"xuhao\">"+k+"</h3>\n" +
                      "                        <img  class=\"song-img\" src=\""+data.data[i].songpic+"\">\n" +
                      "                    </td>\n" +
                      "                    <td>"+data.data[i].songname+"</td>\n" +
                      "                    <td>"+data.data[i].singername+"</td>\n" +
                      "                    <td>"+data.data[i].songTimeMinutes+"</td>\n" +
                      "                    <td><a href='sing_detail.html?songid="+data.data[i].songid+"'>播放</a></td>\n" +
                      "                </tr>"
                  pitem.append(item)
              }
          }
      )
  })