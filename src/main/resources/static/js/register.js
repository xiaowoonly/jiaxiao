function register()
{
    var username = document.getElementById("ID").value;
    var password = document.getElementById("txt_Pwd").value;
    var password2 = document.getElementById("txt_PwdTwo").value;
    var stuno = document.getElementById("txt_stuNo").value;
    if(username===""){
        alert("请输入用户名");
        return false;
    }else if(password===""){
        alert("请输入密码");
        return false;
    }else if(password2!==password){
        alert("两次输入的密码不一致");
        return false;
    }else if(stuno===""){
        alert("请输入学生学号");
        return false;
    }

    var params ={};
    params.username = username;
    params.password = password;
    params.stuno = stuno;
    $.ajax({
        url: "/register/register",
        type: 'POST',
        dataType: "json",
        contentType: 'application/json',
        data: JSON.stringify(params),
        success: function (data) {
            console.log(data);
            if(data===1) {
                alert('注册成功');
                window.location.href='login.html';
            }
            else{
                alert("注册失败");
            }
        },
        error: function (data) {
        }
    });
}