$(function(){
    var type = sessionStorage.getItem("type");
    var realname = sessionStorage.getItem("realname");
    console.log(realname);
    $(".name span").text(realname);
    console.log(type == '1');
    if (type == '1') {
        //拼接一下
        str = "<a href=\"addBulletin.html\"><li>\n" +
            "       <span class=\"pic\"><img src=\"images/person/3_main_icon_wddt.png\"></span>已发布公告\n" +
            "  </li></a>";
        //追加到ul中
        $("div._main_section ul").append(str);
        str1 = "<a href=\"bulletin.html\"><li><center><div class=\"wrap\"><img src=\"images/person/5_main_icon_wdsc.png\">发布的公告</div></center></li></a>";
        //追加到ul中
        $("#sell").append(str1);
    }
});