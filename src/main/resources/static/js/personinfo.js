$(function(){

    var username = sessionStorage.getItem("username");
    var type  = sessionStorage.getItem("type");
    var adress ;
    var params ={};
    params.username = username;
    params.type = type;

    if(type==2){
        adress="/user/studentInfo";
    }else{
        adress="/user/teacherInfo";
    }
    $.ajax({
        url: adress,
        type: 'POST',
        dataType: "json",
        contentType: 'application/json',
        data: JSON.stringify(params),
        success: function (data) {
            var json =eval(data);
            if(type==1){
                document.getElementById('parentName').value=json[0].realname;
                document.getElementById('parentPhone').value=json[0].username;
            }else{
                document.getElementById('stuName').value=json[0].name;
                document.getElementById('stuNo').value=json[0].number;
                document.getElementById('stuGender').value=json[0].gender;
                document.getElementById('stuAddress').value=json[0].address;
                document.getElementById('stuPhone').value=json[0].phone;
                document.getElementById('parentName').value=json[0].parentName;
                document.getElementById('parentPhone').value=json[0].parentPhone;
            }
        },
        error: function (data) {
        }
    });
});

function updateInfo(){
    var parentName =	document.getElementById('parentName').value;
    var parentPhone =	document.getElementById('parentPhone').value;
    var params ={};
    params.parentName = parentName;
    params.parentPhone = parentPhone;
    $.ajax({
        url: "/user/updateinfo",
        type: 'POST',
        dataType: "json",
        contentType: 'application/json',
        data: JSON.stringify(params),
        success: function (data) {
            console.log(data);
            window.location.href='person.html';
        },
        error: function (data) {
        }
    });

}