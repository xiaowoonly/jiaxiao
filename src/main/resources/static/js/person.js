$(function(){
    var type = sessionStorage.getItem("type");
    var realname = sessionStorage.getItem("realname");
    console.log(realname);
    $(".name span").text(realname);
    console.log(type == '1');
    //拼接一下
    str = "<a href=\"addBulletin.html\"><li>\n" +
        "       <span class=\"pic\"><img src=\"images/person/3_main_icon_wddt.png\"></span>发布公告\n" +
        "  </li></a>";
    stre = " <a href=\"login.html\"><li>\n" +
        "            <span class=\"pic\"><img src=\"images/home/icon_personal.png\"></span>退出当前账号\n" +
        "        </li></a>";
    if (type == '1') {
        //追加到ul中
        $("div._main_section ul").append(str);
        $("div._main_section ul").append(stre);
        str1 = "<a href=\"bulletin.html\"><li><center><div class=\"wrap\"><img src=\"images/person/5_main_icon_wdsc.png\">已发布公告</div></center></li></a>";
        //追加到ul中
        $("#sell").append(str1);
    }else {
        //追加到ul中
        $("div._main_section ul").append(stre);
    }
});