// 判断是登录账号和密码是否为空
function check(){
    var username = $("#username").val();
    var passwd = $("#passwd").val();
    if(username=="" || passwd==""){
        $("#message").text("账号或密码不能为空！");
        return false;
    }
    return true;
}