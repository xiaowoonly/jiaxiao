
//加载好友
$(function(){
    var username = sessionStorage.getItem("username");
    var type = sessionStorage.getItem("type");
    // alert(username);
    var params ={};
    params.username = username;
    params.type = type;
    $.ajax({
        url: "/user/getFriend",
        type: 'POST',
        dataType: "json",
        contentType: 'application/json',
        data: JSON.stringify(params),
        success: function(data){
            var json = JSON.stringify(data);
            showFriend(data);//数据展示
        },
        error: function(msg){
            alert("ajax连接异常："+msg);
        }
    });
});

//展示数据
function showFriend(data) {
    var str = "";//定义用于拼接的字符串
    for (var i = 0; i < data.length; i++) {
        //拼接一下
        str = "<a href=\"chat.html?name=" + data[i].username + "\"><li>\n" +
            "       <div class=\"head\">\n" +
            "           <img src=\"images/person/01.jpg\">\n" +
            "       </div>\n" +
            "       <div class=\"new\">\n" +
            "           <div class=\"name\">" + data[i].realname + "</div>\n" +
            "        <div class=\"autograph\">"+"联系电话"+data[i].username+"</div></div>\n" +
            "</li></a> ";



        $("div.main_xiaoxi ul").append(str);
    }
}
