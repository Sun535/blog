

function loadUserBooks(){
	//1.获取参数
	var userId=getCookie("uid");
	//2.检查参数
	if (userId==null) {
		window.location.href="log_in.html";
		return;
	}
	//3.发送ajax
	$.ajax({
		type:"post",
		url:base_path+"/book/loadbooks.do",
		data:{
			"userId":userId
		},
		dataType: "json",
		success: function(result){
			if (result.status==0) {
				//获取返回的笔记本集合
				var books=result.data;
				//循环生成列表元素
				for(var i=0;i<books.length;i++){
					var book=books[i];
					createBookLi(book.cn_notebook_name,book.cn_notebook_id);
				}
			}
		},
		error: function(){
			alert("加载笔记本列表异常");
		}
	});
}
//常见笔记本
/*	<li class="online">
<a  class='checked'>
<i class="fa fa-book" title="online" rel="tooltip-bottom">
</i> 默认笔记本</a></li> */
function createBookLi(bookName,bookId){
	//构建li元素
	var sli='<li class="online"><a  class=""><i class="fa fa-book" title="online" rel="tooltip-bottom"></i>'+bookName+'</a></li>'
	//将bookId绑定到li元素上
	var $li=$(sli);
	$li.data("bookId",bookId);
	$("#book_ul").append($li);
}

function addBook(){
	var bookName=$("#input_notebook").val().trim();
	var userId=getCookie("uid");
	
	if (userId==null) {
		location.href="login_in.html";
	}
	
	if (bookName=="") {
		$("#notebook_span").text("笔记本名称不能为空");
		return;
	}
	
	$.ajax({
		type: "post",
		url: base_path+"/book/add.do",
		data: {
			"bookName":bookName,
			"userId":userId
		},
		dataType: "json",
		success: function(result){
			if (result.status==0) {
				var book=result.data;
				createBookLi(book.cn_notebook_name,book.cn_notebook_id);
				alert(result.msg);
			}
		},
		error: function(){
			
		}
	});
}