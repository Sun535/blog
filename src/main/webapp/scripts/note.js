
function loadnotes(){
	$("#note_ul").html("");
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