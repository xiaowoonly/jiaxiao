function update(){
    var username = sessionStorage.getItem("username");
    var newPwd = document.getElementById("txt_Pwd").value;
    var newPwd2 = document.getElementById("txt_PwdTwo").value;
    if(newPwd!==newPwd2){
        alert("原密码不一致");
        return false;
    }
    var params ={};
    params.username = username;
    params.password = newPwd;
    $.ajax({
        url: "/user/updatePwd",
        type: 'POST',
        dataType: "json",
        contentType: 'application/json',
        data: JSON.stringify(params),
        success: function (data) {
            if(data===0) {
                alert("修改成功");
                window.location.href='home.html';
            }
            else{
                alert("修改失败");
            }
        },
        error: function (data) {
        }
    });

}