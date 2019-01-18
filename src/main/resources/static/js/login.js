function login()
{
    var username = document.getElementById("ID").value;
    var password = document.getElementById("PASSWORD").value;
    if(username===""){
        alert("请输入用户名");
        return false;
    }else if(password===""){
        alert("请输入密码");
        return false;
    }

    var params ={};
    params.username = username;
    params.password = password;

    $.ajax({
        url: "/login/check",
        type: 'POST',
        dataType: "json",
        contentType: 'application/json',
        data: JSON.stringify(params),
        success: function (data) {
            console.log(data);
            alert("1111111");
            if(data===0) {
                sessionStorage.setItem("username",username);
                alert(username);

               /* $.ajax({
                    url: "/TimeTables/get?username="+username,
                    type: 'GET',
                    success: function (data) {
                        console.log(data);
                        sessionStorage.setItem("course",data);
                    },
                    error: function (data) {
                    }
                });
*/
                window.location.href='index.html';
            }
            else{
                alert("用户名和密码错误");
            }
        },
        error: function (data) {
        }
    });
}