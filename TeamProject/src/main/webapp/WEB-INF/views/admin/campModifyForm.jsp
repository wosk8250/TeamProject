<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../include/adminheader.jsp"%>

<style>

#uploadedList > div {
	float : left;
	margin : 20px;
}

.img {
	float : left;
	margin : 20px;
}

.btn {
	float: right;
}


</style>


<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>

$(function() {
	$("#file").change(function (e) {
		var	file = e.target.files;
		var formData = new FormData();
		var url = "/upload/image";
				for (var i = 0; i < file.length; i++) {
				formData.set('file', file[i]);
		
		$.ajax({
			"processData" : false,
			"contentType" : false,	
			"type" : "post",
			"url" : url,
			"data" : formData,
			"success" : function(rData) {
				var slashIndex = rData.lastIndexOf("/");
				var front = rData.substring(0, slashIndex + 1);
				var rear = rData.substring(slashIndex + 1);
				var thumbnailName = front + "sm_" + rear;
				
					if(rData == "notImg"){
					alert("사진만 첨부 가능합니다");
					} else{
					var originalFilename = rData.substring(rData.indexOf("_") + 1);
					
					var html = "<div data-filename=" + rData + ">";
					html += "<img src='/upload/displayImg?fileName=" + thumbnailName + "'/><br/>";
					html += "<span>"+originalFilename+"</span>";
					html += "<a href='"+rData+"' class='attach-del'><span class='pull-right'>x</span></a>";
					html += "</div>";
					$("#uploadedList").append(html);
					}//else
						}//success
				});//ajax
													}//for
									});//#file
	$("#uploadedList").on("click",".attach-del",function(e){
		e.preventDefault();
		var that = $(this);
		var filename = that.attr("href");
		var url = "/upload/deleteFile";
		sendData = {"filename" : filename};
		$.get(url, sendData, function(rData) {
			that.parent().remove();
		});		
	});
	$("#fileLoad").on("click",".modify-file",function(e){
		e.preventDefault();
		var that = $(this);
		var filename = that.attr("href");
		var url = "/upload/deleteModifyFile";
		sendData = {"filename" : filename};
		$.get(url, sendData, function(rData) {
			that.parent().remove();
		});		
	});
	$("#campModifyRun").submit(function() {
		var upDiv = $("#uploadedList > div");
		upDiv.each(function(index) {
			var filename = $(this).attr("data-filename");
			var hiddenInput = "<input type='hidden' name='files["+index+"]' value='"+filename+"'/>";
			$("#campModifyRun").prepend(hiddenInput);
		});
	});
	
});
</script>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form" id="campModifyRun" action="/admin/campModifyRun" method="post"  enctype="multipart/form-data">
				<div class="form-group">

					<label for="camp_title"> 제목 </label> 
					<span>캠핑장</span>
					<input type="text" class="form-control id="camp_name" name="camp_name" value="${campVo.camp_name}"/>
					<span>주소span>
					<input type="text" class="form-control id="camp_address" name="camp_address" value="${campVo.camp_address}"/>
					<span>전화번호</span>
					<input type="text" class="form-control id="camp_phone" name="camp_phone" value="${campVo.camp_phone}"/>
					<span>홈페이지</span>
					<input type="text" class="form-control id="camp_http" name="camp_http" value="${campVo.camp_http}"/>
					<span>지역</span>
					<input type="text" class="form-control id="camp_location" name="camp_location" value="${campVo.camp_location}"/>
					<span>구</span>
					<input type="text" class="form-control id="camp_area" name="camp_area" value="${campVo.camp_area}"/>
					<input type="hidden" class="form-group" id="camp_no" name="camp_no" value="${campVo.camp_no}"/>
					
					<input type="hidden" class="form-group" id="table_name" name="table_name" value="${campVo.table_name}"/>
				</div>
				<div class="form-group">

				<textarea class="form-control id="camp_content" name="camp_content" rows="25" style="resize:none; width:100%;" >${campVo.camp_content}</textarea>
					
				</div>
					<input type="file" id="file" name="file[]" multiple="multiple">
				<div id = "fileLoad">
				<div id="uploadedList">
				</div>
						<c:forEach items="${fileList}" var="filesVo">
							<div class="img" data-filename="${filesVo.files}">
							<img alt="실패" src="/upload/displayImg?fileName=${filesVo.thumbnailName}" /><br/>
							<span>${filesVo.orgFileName}</span>
							<a href="${filesVo.files}" class="attach-del modify-file"><span class="pull-right">x</span></a>
							</div>
						</c:forEach>
				<br/>
				</div>
					
				<div>
				
				<button type="submit" class="btn btn-primary">완료</button>
				</div>
			</form>
		</div>
	</div>
</div>



<%@include file="../include/adminfooter.jsp"%>

