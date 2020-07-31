<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<script src="/resources/vendor/jquery/jquery.js"></script>
<style>
table{
	width : 60%;
	height: 100px;
	margin: auto;
	text-align:  center;
}
.btn{
  float:right;
  margin-left: 20px;
}
#div_select{
	width : 60%;
	height : 100px;
	margin: auto;
	text-align:  center;
}
#uploadedList > div {
	float : left;
	margin : 20px;
}
#file{
	float : left;
	 margin-left: 100px;
}
select{
	width: 450px;
}

</style>


<script>
$(function() {
	$("#review_area").change(function(){
		var area_si =$(this).val();
		
		if(area_si == "전체"){
			$('#review_location').children('option:not(:first)').remove();
			
			var url = "/areaCampingName/campingNamesList" ;
			console.log("url:", url);
			
			$.get(url, function(rData) {

//		 			console.log("get_sendData:", sendData);
//		 			console.log("get_rData:", rData);
				
					$("#review_campingname option").remove();

					$.each(rData, function(index) {
					
// 					console.log("index:",index);
// 					console.log("rData[index]:",rData[index]);
					var option_tag  = "<option value='"+rData[index]+"'>" + rData[index] + "</option>";
					
					$("#review_campingname").append(option_tag);
					});
					$("#review_campingname option:eq(0)").before("<option value='' selected>선택하세요</option>");			
			});
			return;
		}else{
			console.log("area_si:", area_si);
			var url = "/areaCampingName/getAreaCampingList/" + area_si ;
			console.log("url:", url);
			
			var review_area = $("#review_area").val();

			
			var sendData = {
					"review_area" : review_area,	
			};
// 			console.log("sendData:", sendData);

	
			$.get(url, sendData, function(rData) {
// 	 				console.log("url:", url);
	 			console.log("sendData:", sendData);
	 			console.log("rData:", rData);
				
					$("#review_location option").remove();

					$.each(rData, function(index) {
					
// 					console.log("index:",index);
// 					console.log("rData[index]:",rData[index]);
					var option_tag  = "<option value='"+rData[index]+"'>" + rData[index] + "</option>";
					
					$("#review_location ").append(option_tag);
					
					});
					$("#review_location option:eq(0)").before("<option value='전체' selected>전체</option>");			
			});
			
		}
		var url = "/areaCampingName/campingAreaSiNamesList/" + area_si ;
		console.log("url:", url);
		var review_area = $("#review_area").val();

		
		var sendData = {
				"review_area" : review_area,	
		};
		console.log("sendData:", sendData);

		$.get(url, sendData, function(rData) {

 			console.log("sendData:", sendData);
 			console.log("rData:", rData);
			
 			$("#review_campingname option:eq(1)").remove();			 			
				$("#review_campingname	 option").remove();

				$.each(rData, function(index) {
				
				var option_tag  = "<option value='"+rData[index]+"'>" + rData[index] + "</option>";
				
				$("#review_campingname ").append(option_tag);
				
				});
		});


		}); //$("#review_area").change(function()
	
	$("#review_location").change(function(){
		var area_gu = $(this).val();
		console.log("area_gu:" , area_gu);
		

		if(area_gu != "전체"){
		var url="/areaCampingName/getCampingNameList";
		var area_si = $("#review_area").val();
		var area_gu = $("#review_location").val();
		var sendData ={
			"area_si" : area_si ,
			"area_gu" : area_gu ,
		};
		
		console.log("sendData:", sendData);
		
		$("#review_campingname option").remove();
		$.get(url , sendData ,function(rData){
			console.log("rData:",rData);
			
			$.each(rData, function(index){	
				
				var option_tag = "<option value='"+rData[index]+"'>"+rData[index]+"</option>";
				$("#review_campingname").append(option_tag);
			});
		});
	}else{
		console.log("area_gu2:" , area_gu);
		var area_si = $("#review_area").val();
		var url = "/areaCampingName/campingAreaSiNamesList/" + area_si ;
		console.log("url:", url);
		var review_area = $("#review_area").val();

		
		var sendData = {
				"review_area" : review_area,	
		};
		console.log("sendData:", sendData);

		$.get(url, sendData, function(rData) {

 			console.log("sendData:", sendData);
 			console.log("rData:", rData);
			
 			$("#review_campingname option:eq(1)").remove();			 			
				$("#review_campingname	 option").remove();

				$.each(rData, function(index) {
				
				var option_tag  = "<option value='"+rData[index]+"'>" + rData[index] + "</option>";
				
				$("#review_campingname ").append(option_tag);
				
				});
		});	
	}
		

		
	});//$("#review_location").change(function()
	//파일업로드
	$("#file").change(function(e){
		var	file = e.target.files;
		var formData = new FormData();
		var url = "/upload/campingImage";
		
		console.log("file:", file);
		console.log("formData:", formData);
		console.log("url:", url);
		for (var i = 0; i < file.length; i++) {
			formData.set('file', file[i]);
	
	$.ajax({
		"processData" : false,
		"contentType" : false,
		"type" : "post",
		"url" : url,
		"data" : formData,
		"success" : function(rData) {
			console.log("rData:",rData);
			var slashIndex = rData.lastIndexOf("/");
			var front = rData.substring(0, slashIndex + 1);
			var rear = rData.substring(slashIndex + 1);
			var thumbnailName = front + "sm_" + rear;
			
				if(rData == "notImg"){
				alert("사진만 첨부 가능합니다");
				} else{
				var originalFilename = rData.substring(rData.indexOf("_") + 1);
				
				var html = "<div data-filename=" + rData + ">";
				html += "<img src='/upload/displayCampingImg?fileName=" + thumbnailName + "'/><br/>";
				html += "<span>"+originalFilename+"</span>";
				html += "<a href='"+rData+"' class='attach-del'><span class='pull-right' >x</span></a>";
				html += "</div>";
				console.log(html);
				$("#uploadedList").append(html);
				}//else
					}//success
			});//ajax
												}//for
		
	}); //$("#file").change(function(e)
	$("#uploadedList").on("click",".attach-del",function(e){
		e.preventDefault();
		var that = $(this);
		console.log("that:" ,that);
		var filename = that.attr("href");
		console.log("filename:" ,filename);
		var url = "/upload/deleteCampingFile";
		sendData = {"filename" : filename};
		$.get(url, sendData, function(rData) {
			that.parent().remove();
		});		
	});	
	$("#campingReviewWritingRun").submit(function() {
		var upDiv = $("#uploadedList > div");
		upDiv.each(function(index) {
			var filename = $(this).attr("data-filename");
			var hiddenInput = "<input type='hidden' name='files["+index+"]' value='"+filename+"'/>";
			$("#campingReviewWritingRun").prepend(hiddenInput);
		});
	});
			
			
}); //function()


</script>


<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">

			<form id="campingReviewWritingRun" role="form" action="/camp/campingReviewWritingRun" method='post'enctype="multipart/form-data">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<h3>캠핑 후기</h3>
							<table class="table">
								<tbody>
									<tr>
										<th scope="row" class="th_first">
											<label for="review_title">제목(*)</label>
										</th>
										<td class="td_frist">
											<input id="review_title" name="review_title" size="180" type="text" value="" maxlength="100" />
										</td>
									</tr>
									<tr style="display: none;">
										<th scope="row" class="th_second"></th>
										<td>
										<input type="hidden" id="review_id" name="review_id" size="100" value="${user_id}" type="text" readonly />
										
										</td>
									</tr>
									<tr>
										<th scope="row" class="th_third">
											<label for="review_content">내용</label>
										</th>
										<td>
											<textarea id="review_content" name="review_content" maxlength="2000" style="width: 100%; height: 300px;"></textarea>
										</td>
									</tr>
									<tr>
										<th scope="row" class="gray">
											<label for="camp_name">캠핑장</label>
										</th>
										<td>
											<select title="시/도" id="review_area" name="review_area">
												<option value="전체">전체</option>
												<c:forEach items="${listArea}" var="AreaCampingNameVo">
													<option value="${AreaCampingNameVo.area_si}"id="${AreaCampingNameVo.area_si}">${AreaCampingNameVo.area_si}</option>
												</c:forEach>
											</select> 
											<select title="구/군" id="review_location" name="review_location">
												<option value="전체" selected>전체</option>
											</select>
										 	<select title="캠핑장" id="review_campingname" name="review_campingname">
												<option value="">선택하세요</option>
												<c:forEach items="${listAll}" var="AreaCampingNameVo">
													<option value="${AreaCampingNameVo.area_camping}">${AreaCampingNameVo.area_camping}</option>
												</c:forEach>
											</select>
										</td>
									</tr>
									<tr>
										<th scope="row" class="gray">
											<label class="pictures">사진첨부</label>
										</th>

										<td>
										<input type="file" id="file" name="file[]" multiple="multiple"/>
											<div id="uploadedList">
											</div>
												
										</td>

									</tr>
								</tbody>
							</table>

						</div>
					</div>
				</div>

				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
					
							<a href="/camp/campingReviewList" class="btn btn-secondary">목록</a>
							<button type="submit" class="btn btn-primary">글쓰기</button>
						</div>
					</div>
				</div>


			</form>
		</div>
	</div>
</div>

<%@ include file="../include/footer.jsp" %>