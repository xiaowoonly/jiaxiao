$(function(){
    $.ajax({
        url: "/notice/list",
        type: 'POST',
        dataType: "json",
        contentType: 'application/json',
        success: function(data){
            var json = JSON.stringify(data);
            showData(data);//数据展示
            console.log(data);
        },
        error: function(msg){
            alert("ajax连接异常："+msg);
        }
    });
});

//展示数据
function showData(data) {
    var str = "";//定义用于拼接的字符串
    for (var i = 0; i < data.length; i++) {
        getMyDate(parseInt(data));
        var time1 = new Date().Format("yyyy-MM-dd");
        var time =new Date().getTime();
        str = "<li>"
            + "<span class=\"hd_tag_jh\">" + data[i].publish_name +"&nbsp;&nbsp;"
            + getMyDate(data[0].created) +"</span>"
            + "<p class=\"publish_title\">&nbsp;&nbsp;"+ data[i].title +"&nbsp;&nbsp;"
            + "</p>"
            + "</li>\n";
        //追加到table中
        $("#ul").append(str);
    }
}

//格式化时间
function getMyDate(str) {
    var oDate = new Date(str),
        oYear = oDate.getFullYear(),
        oMonth = oDate.getMonth()+1,
        oDay = oDate.getDate(),
        oHour = oDate.getHours(),
        oMin = oDate.getMinutes(),
        oSen = oDate.getSeconds(),
        oTime = oYear +'-'+ addZero(oMonth) +'-'+ addZero(oDay) +' '+ addZero(oHour) +':'+
            addZero(oMin) +':'+addZero(oSen);
    return oTime;
}

//补零操作
function addZero(num){
    if(parseInt(num) < 10){
        num = '0'+num;
    }
    return num;
}

Date.prototype.Format = function (fmt) { // author: meizz
    var o = {
        "M+": this.getMonth() + 1, // 月份
        "d+": this.getDate(), // 日
        "h+": this.getHours(), // 小时
        "m+": this.getMinutes(), // 分
        "s+": this.getSeconds(), // 秒
        "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
        "S": this.getMilliseconds() // 毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
