//log_in.html主处理
//登录处理
$(function(){
	//页面加载的时候调用这个方法
	//给登录按钮绑定单击事件
	$("#login").click(log_in);
	$("#regist_button").click(registUser);
});
function log_in(){
	//1.获取请求参数值
	var name=$("#count").val().trim();
	var password=$("#password").val().trim();
	//2.检查参数格式
	$("#count_span").text("");
	$("#password_span").text("");
	var ok=true;
	if (name==null||name=="") {
		ok=false;
		$("#count_span").text("用户名不能为空");
	}
	if (password==null||password=="") {
		ok=false;
		$("#password_span").text("密码不能为空");
	}
	if (!ok) {
		return;
	}
	//3.发送Ajax
	$.ajax({
		type:"post",
		url:"user/login.do",
		data:{"name":name,"password":password},
		dataType: "json",
		success: function(result){
			if (result.status==0) {
				var user = result.data;
				//写入cookie，2小时过期
				addCookie("uid",user.cn_user_id,2);
				addCookie("uname",user.cn_user_name,2);
				//成功登录后跳转到主页面
				window.location.href="edit.html";
			}else if(result.status==1){//用户名不存在
				$("#count_span").text(result.msg);
			}else{
				$("#count_span").text(result.msg);
			}
			console.log(result);
		},
		error: function(){
			alert("登录异常");
		}
	});
}
//注册方法
function registUser(){
	//1.获取参数
	var name=$("#regist_username").val().trim();
	var nick=$("#nickname").val().trim();
	var password=$("#regist_password").val().trim();
	var f_password=$("#final_password").val().trim();
	//2.参数可是检查
	$("#warning_1").hide();
	$("#warning_2").hide();
	$("#warning_3").hide();
	var ok=true;
	if (name=="") {
		ok=false;
		$("#warning_1").show();
		$("#warning_1 span").html("用户名为空");
	}
	if (password=="") {
		ok=false;
		$("#warning_2").show();
		$("#warning_2 span").html("密码为空");
	}else if (password=="") {
		ok=false;
		$("#warning_2").show();
		$("#warning_2 span").html("密码长度过短");
	}
	if (f_password=="") {
		ok=false;
		$("#warning_3").show();
		$("#warning_3 span").html("确认密码不能为空");
	}else if (password!=f_password) {
		ok=false;
		$("#warning_3").show();
		$("#warning_3 span").html("密码不一致");
	}
	if (!ok) {
		return;
	}
	//3.发送AJAX
	$.ajax({
		type:"post",
		url: base_path+"/user/add.do",
		data: {
			"name":name,
			"nick":nick,
			"password":password,
		},
		dataType: "json",
		success: function(result){
			//对回调函数进行判断
			if (result.status==0) {
				$("#back").click();
			}else if(result.status==1){
				$("#warning_1").show();
				$("#warning_1 span").html(result.msg);
			}
		},
		error: function(){
			alert("注册异常");
		}
	});
}