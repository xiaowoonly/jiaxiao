/*发送消息*/
function send(headSrc, str) {
    var html = "<div class='send'><div class='msg'><img src=" + headSrc + " />" +
        "<p><i class='msg_input'></i>" + str + "</p></div></div>";
    upView(html);
}

/*接受消息*/
function show(headSrc, str) {
    var html = "<div class='show'><div class='msg'><img src=" + headSrc + " />" +
        "<p><i class='msg_input'></i>" + str + "</p></div></div>";
    upView(html);
}

/*更新视图*/
function upView(html) {
    $('.message').append(html);
    $('body').animate({scrollTop: $('.message').outerHeight() - window.innerHeight}, 200)
}

function sj() {
    return parseInt(Math.random() * 10)
}

$(function () {
    $('.footer').on('keyup', 'input', function () {
        if ($(this).val().length > 0) {
            $(this).next().css('background', '#114F8E').prop('disabled', true);

        } else {
            $(this).next().css('background', '#ddd').prop('disabled', false);
        }
    })
    $('.footer p').click(function () {
        show("images/touxiangm.png", $(this).prev().val());
        test();
        sendMessage($(this).prev().val());
    })
});

/*测试数据*/
var arr ;
var imgarr = ['images/touxiang.png', 'images/touxiangm.png']
test();

function test() {
    $(arr).each(function (i) {
        setTimeout(function () {
            send("images/touxiang.png", arr[i])
        }, sj() * 500)
    })
}


UrlParam = function() { // url参数
    var data, index;
    (function init() {
        data = []; //值，如[["1","2"],["zhangsan"],["lisi"]]
        index = {}; //键:索引，如{a:0,b:1,c:2}
        var u = window.location.search.substr(1);
        if (u != '') {
            var params = decodeURIComponent(u).split('&');
            for (var i = 0, len = params.length; i < len; i++) {
                if (params[i] != '') {
                    var p = params[i].split("=");
                    if (p.length == 1 || (p.length == 2 && p[1] == '')) {// p | p= | =
                        data.push(['']);
                        index[p[0]] = data.length - 1;
                    } else if (typeof(p[0]) == 'undefined' || p[0] == '') { // =c 舍弃
                        continue;
                    } else if (typeof(index[p[0]]) == 'undefined') { // c=aaa
                        data.push([p[1]]);
                        index[p[0]] = data.length - 1;
                    } else {// c=aaa
                        data[index[p[0]]].push(p[1]);
                    }
                }
            }
        }
    })();
    return {
        // 获得参数,类似request.getParameter()
        param : function(o) { // o: 参数名或者参数次序
            try {
                return (typeof(o) == 'number' ? data[o][0] : data[index[o]][0]);
            } catch (e) {
            }
        },
        //获得参数组, 类似request.getParameterValues()
        paramValues : function(o) { // o: 参数名或者参数次序
            try {
                return (typeof(o) == 'number' ? data[o] : data[index[o]]);
            } catch (e) {}
        },
        //是否含有paramName参数
        hasParam : function(paramName) {
            return typeof(paramName) == 'string' ? typeof(index[paramName]) != 'undefined' : false;
        },
        // 获得参数Map ,类似request.getParameterMap()
        paramMap : function() {
            var map = {};
            try {
                for (var p in index) { map[p] = data[index[p]]; }
            } catch (e) {}
            return map;
        }
    }
}();
