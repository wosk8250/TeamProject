<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../include/mainHeader.jsp"%>
<style>
	.jb-wrap {
	width: 100%;
	margin: 0px auto;
	position: relative;
	color: black;
}
.jb-wrap img {
	width: 100%;
	vertical-align: middle;
}
.jb-nav {
	position: absolute;
	top: 0px;
	width: 100%;
	height: 100%;
	text-align: center;
}
.jb-nav-table {
	display: table;
	width: 100%;
	height: 100%;
}
.jb-nav-table-row {
	display: table-row;
}
.jb-nav-table-cell {
	display: table-cell;
	vertical-align: middle;
}
.jb-nav nav {
	margin: 0px 25%;
	padding: 10px;
	background-color: rgba(255, 255, 255, 0.5);
	text-align: center;
}
#out {
 width: 50%;
 text-align: center;
 }
#in {
	float: left;
	margin-left: 50%;
 }
 .jb-image {
 
 }
</style>

<script>
$(function() {
	//렌덤 배경
	var random = Math.floor(Math.random() * 9);
	$("#img_bg").attr("src","/resources/image/main_bg0"+random+".jpg");
	
	//도시 선택
	$("#areaDo").change(function() {
		
		var camp_area = $("#areaDo").val()
		console.log(camp_area);
		
		
		var url = "/camp/locationArea/" + camp_area;
		console.log("url", url);
		var sendData ={
			"camp_area" : camp_area
		};
		$("#locationSi option").remove();
		console.log("sendData", sendData);	
		
		$.get(url, sendData, function(rData){
			$.each(rData, function(index){
				console.log(rData);
				var optionArea = "<option value='"+ rData[index] +"'>" + rData[index]+ "</option>";
				
				$("#locationSi").append(optionArea);
			});
			$("#locationSi option:eq(0)").before("<option value='${CampVo.camp_location}' selected>전체/시</option>");	
		});
		
	});
});


$(function() {
	$("#searchButton").click(function() {
		
		var selectDo = $("#areaDo").val();
		var selectSi = $("#locationSi").val();
		console.log(selectDo);
		console.log(selectSi);
		
		var sendData = {
			"camp_area"  : areaDo,
			"camp_location"	: locationSi
		};
		
		console.log(sendData);
		
		
		var url = "/camp/searchCampList";
		
			$.ajax({
				"type" : "post",
				"url" : url,
				"dataType" : "text",
				"data" : JSON.stringify(sendData),
				"headers" : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "post"
				},
				"success" : function(rData) {
					console.log(rData);
				}
			});
		});
});
</script>

<div class="container-fluid" style="padding: 0px;">
	<div class="row">
		<div class="col-md-12"id="main_bg">
		<div class="jb-wrap">
			<div class="jb-image" id="slideshow">
			<!-- 이미지 -->
				<img id="img_bg" src="">
			</div>
			<div class="jb-nav">
				<div class="jb-nav-table">
					<div class="jb-nav-table-row">
						<div class="jb-nav-table-cell">
							<nav class="navbar navbar-expand-lg">
								<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
									<span class="navbar-toggler-icon"></span>
								</button>
								<div id="out" >
									<!-- 셀렉트박스  -->
									<form class="form-inline" name="form">
									<div class="form-group" id="in">
									  
   										 <label>지역 선택</label>
   										<select id="areaDo" name="areaDo" class="custom-select">
   											 <option value="1" selected>전체/도</option>
		   									 <c:forEach items="${list}" var="areaDo">
	   										 <option value="${areaDo.camp_area}">${areaDo.camp_area}</option>
		   									 </c:forEach>
										</select>
										
										<label>&nbsp; | &nbsp;</label>
										<select id="locationSi" name="locationSi" class="custom-select">
							 			 <option value="11">전체/시</option>
							 			 </select>
										<button type="button" class="btn btn-primary my-2 my-sm-0"  id="searchButton">검색</button>
 									</div>
									</form>
								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
		</div>
		<div class="col-md-6">
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
		캠핑후기
		</div>
		<div class="col-md-3">
		공지사항
		</div>
		<div class="col-md-3">
		캠핑 수칙
		</div>
		<div class="col-md-3">
		자주묻는 질문
		</div>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>