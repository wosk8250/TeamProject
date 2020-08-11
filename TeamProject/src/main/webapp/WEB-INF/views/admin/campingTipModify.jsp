<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:choose>
 <c:when test="${sessionScope.checkBoard == 'admin'}">
 <%@ include file="../include/adminheader.jsp" %>
 </c:when>
 <c:when test="${sessionScope.checkBoard eq 'camp'}">
<%@ include file="../include/header.jsp" %>
 </c:when>
 </c:choose>

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
	$("#campingModifyRun").submit(function() {
		var upDiv = $("#uploadedList > div");
		upDiv.each(function(index) {
			var filename  = $(this).attr("data-filename");
			var hiddenInput = "<input type='hidden' name='files["+index+"]' value= '"+ filename+"' />";
			$("#campingModifyRun").prepend(hiddenInput);
		});
	});
	$("#a").click(function() {
		console.log($("#campingModifyRun"));
		var upDiv = $("#uploadedList > div");
		upDiv.each(function(index) {
			var filename  = $(this).attr("data-filename");
			var hiddenInput = "<input type='hidden' name='files["+index+"]' value= '"+ filename+"' />";
			console.log(hiddenInput);
			$("#campingModifyRun").prepend(hiddenInput);
		});
	});

});


</script>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
		<button id="a">as</button>
			<form role="form" id="campingModifyRun" action="/admin/campingTipModifyRun" method="post"  enctype="multipart/form-data">
				<div class="form-group">
					<label for="campingtip_title"> 제목 </label> 
					<input type="text" class="form-control" id="campingtip_title" name="campingtip_title" value="${campingTipVo.campingtip_title}" />
					<input type="hidden" class="form-control"  name="campingtip_no" value="${campingTipVo.campingtip_no}" />
					<input type="hidden" class="form-control" name="table_name" value="${campingTipVo.table_name}" />
					<input type="hidden" class="form-control" name="campingtip_img" value="${campingTipVo.campingtip_img}" />
				</div>
				<div class="form-group">

				<textarea class="form-control" id="campingtip_content" name="campingtip_content" rows="25" style="resize:none; width:100%;" >${campingTipVo.campingtip_content}</textarea>
					
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
