function register()
{
    var username = document.getElementById("ID").value;
    var password = document.getElementById("txt_Pwd").value;
    var password2 = document.getElementById("txt_PwdTwo").value;
    var stuno = document.getElementById("txt_stuNo").value;
    var realname= document.getElementById("realname").value;
    var type=$('input:radio[name="Fruit"]:checked').val();
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
    if(type==null){
        alert("请选择账号类型");
        return false;
    }else if(username===""){
        alert("请输入用户名");
        return false;
    }else  if(!myreg.test(username)){
        alert("请输入正确的11位手机号");
        return false;
    }else if(realname===""){
        alert("请输入姓名");
        return false;
    }  else if(password===""){
        alert("请输入密码");
        return false;
    }else if(password.length<6 || password.length>11){
        alert("请输入6至11位密码");
        return false;
    } else if(password2===""){
        alert("请再次输入密码");
        return false;
    } else if(password2!==password){
        alert("两次输入的密码不一致");
        return false;
    }else if(type=="2"&&stuno===""){
        alert("请输入学生学号");
        return false;
    }
    var params ={};
    params.username = username;
    params.password = password;
    params.stuno = stuno;
    params.realname = realname;
    params.type = type;
    $.ajax({
        url: "/register/register",
        type: 'POST',
        dataType: "json",
        contentType: 'application/json',
        data: JSON.stringify(params),
        success: function (data) {
            console.log(data);
            if(data===0) {
                alert('注册成功');
                window.location.href='login.html';
            }
            else if(data===2){
                alert("不存在该学号的学生");
            }else{
                alert("该账号已经存在");
            }
        },
        error: function (data) {
        }
    });
}