$(function(){
    var realname = sessionStorage.getItem("realname");
    console.log(realname);
    $(".name span").text(realname);
    var type = sessionStorage.getItem("type");
    console.log(type == '1');
    if (type == '1') {
        var username = sessionStorage.getItem("realname");
        // alert(username);
        var params ={};
        params.publish_name = username;
        $.ajax({
            url: "/notice/getNotice",
            type: 'POST',
            dataType: "json",
            contentType: 'application/json',
            data: JSON.stringify(params),
            success: function(data){
                var json = JSON.stringify(data);
                showData(data);//数据展示
                console.log(data);
            },
            error: function(msg){
                alert("ajax连接异常："+msg);
            }
        });
    } else {
        alert("没有所发布的公告");
    }
});


//展示数据
function showData(data) {
    var str = "";//定义用于拼接的字符串
    var type = 0;
    for (var i = 0; i < data.length; i++) {
        //拼接一下
        str = "<a href=\"bulletinInfo.html?id=" + data[i].id +"\"><li id =" + data[i].id + ">\n"
            +   "<p class=\"publish_title\">\n"
            +   data[i].title
            + "</p>\n"
            + "</li>";


        /*  str = "<a href=\"bulletinInfo.html?id=" + data[i].id +"\"><li id =" + data[i].id + ">\n" +
              data[i].title +
              "</li></a>"*/
        // alert(data[i].title);
        //追加到ul中
        $("#ul").append(str);
    }
}

