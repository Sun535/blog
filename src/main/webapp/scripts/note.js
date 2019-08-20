
function loadnotes(){
	$("#note_ul").empty();
	var bookId=$(this).data("bookId")
	
	//设置笔记本li选中效果
	$(this).children("a").addClass("checked")
		.parent().siblings().children("a").removeClass("checked");
	
	if (bookId=="") {
		return;
	}
	$.ajax({
		type: "post",
		url: base_path + "/note/loadnotes.do",
		data: {
			"bookId":bookId
		},
		dataType: "json",
		success: function(result){
			if (result.status==0) {
				createNoteLi(result.data);
			}
		},
		error: function(){
			alert("加载笔记列表异常");
		}
	});
}

function createNoteLi(data){
	for(var i=0;i<data.length;i++){
		var sli='<li class="online"><a  class=""><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+data[i].cn_note_title+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button></a><div class="note_menu" tabindex="-1"><dl><dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt><dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt><dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt></dl></div></li>';
		var $li=$(sli);
		$li.data("noteId",data[i].cn_note_id);
		$("#note_ul").append($li);
	}
}


function loadnote(){
	var noteId=$(this).data("noteId");
	
	$(this).children("a").addClass("checked")
	.parent().siblings().children("a").removeClass("checked");
	
	$.ajax({
		type: "post",
		url: base_path + "/note/load.do",
		data: {
			"noteId":noteId
		},
		dataType: "json",
		success: function(result){
			if (result.status==0) {
				var data=result.data;
				$("#input_note_title").val(data.cn_note_title);
				um.setContent(data.cn_note_body)
				//$("#save_note").data("noteId",data.cn_note_id)
			}
		},
		error: function(){
			alert("加载笔记列表异常");
		}
	});
}

function updateNote(){
	var noteId=$("#note_ul li .checked").parent().data("noteId");
	//var noteId=$(this).data("noteId");
	var title=$("#input_note_title").val().trim();
	var body=um.getContent();
	
	if (title=="") {
		$("#input_note_title").html("<font color='red'>标题不能为空</font>");
		return;
	}
	if (noteId==null||noteId=="") {
		alert("请选择要保存的笔记");
		return;
	}
	
	$.ajax({
		type: "post",
		url: base_path + "/note/update.do",
		data: {
			"noteId":noteId,
			"title":title,
			"body":body
		},
		dataType: "json",
		success: function(result){
			if (result.status==0) {
				$("#note_ul li .checked").html('<i class="fa fa-book" title="online" rel="tooltip-bottom"></i> '+title);
				alert(result.msg);
			}
		},
		error: function(){
			alert("加载笔记列表异常");
		}
	});
}

function addNote(){
	var bookId=$("#book_ul li .checked").parent().data("bookId");
	var userId=getCookie("uid");
	var title=$("#input_note").val().trim();
	
	if (title=="") {
		$("#note_span").text("笔记名称不能为空");
		return;
	}
	
	$.ajax({
		type: "post",
		url: base_path + "/note/add.do",
		data: {
			"bookId": bookId,
			"userId": userId,
			"title": title
		},
		dataType: "json",
		success: function(result){
			if (result.status==0) {
				var data=result.data;
				var title=data.cn_note_title;
				var sli='<li class="online"><a  class=""><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+title+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button></a><div class="note_menu" tabindex="-1"><dl><dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt><dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt><dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt></dl></div></li>';
				var $li=$(sli);
				$li.data("noteId",data.cn_note_id);
				$("#note_ul").append($li);
				alert("添加成功");
				closeAlertWindow();
			}
		},
		error: function(){
			
		}
	});
}