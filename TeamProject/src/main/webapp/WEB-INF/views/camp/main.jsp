<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="/resources/js/owl.carousel.js"></script>
    <%@ include file="../include/mainHeader.jsp"%>

<style>
	#owl-demo {
	color: white;
	}

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
.navbar-expand-lg {
	margin: 0px 20%;
	padding: 10px;
	background-color: rgba(255, 255, 255, 0.5);
	text-align: center;
	margin-top: 20%;
}
#out {
 width: 50%;
 text-align: center;
 }
#in {
	float: left;
	margin-left: 60%;
 }
#owl-demo .item img{
  display: block;
  width: 100%;
  height: 160px;
  
}
#owl-demo {
	margin-top: 250px;
}
#form {
margin-bottom: 0;
}
</style>
<link rel="stylesheet" href="/resources/assets/owl.carousel.min.css">
<link rel="stylesheet" href="/resources/assets/owl.theme.default.min.css">
<script src="/resources/owl.carousel.js"></script>
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
				<div class="row">
						<div class="col-md-12">
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
				<div class="row">
					<div class="col-md-12">
			<!-- 인기 캠핑장 -->
						<div class="owl-carousel" id="owl-demo">
							<c:forEach items="${campVo}" var="campVo">
					            <div class="item">
					            <img src="/upload/displayCampingImg?fileName=${campVo.thumbnail}" alt="${campVo.thumbnail}"/>
					              <h4>${campVo.camp_name}</h4>
					            </div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
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
			<table class="table">
				<thead>
					<tr>
						<th>후기</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${reviewVo}" var="reviewVo">
						<tr>
							<td><a href="/camp/selectReview/${reviewVo.review_no}">${reviewVo.review_title}</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-md-3">
			<table class="table">
				<thead>
					<tr>
						<th>공지사항</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${CampNoticeVo}" var="CampNoticeVo">
						<tr>
							<td><a href="/camp/singleContentsCampNotice/${CampNoticeVo.notice_no}">${CampNoticeVo.notice_title}</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-md-3">
			<table class="table">
				<thead>
					<tr>
						<th>캠핑수칙</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${CampingTipVo}" var="CampingTipVo">
						<tr>
							<td><a href="/camp/singleContentsCampingTip/${CampingTipVo.campingtip_no}">${CampingTipVo.campingtip_title}</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-md-3">
			<table class="table">
				<thead>
					<tr>
						<th>자주 묻는 질문</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${faqVo}" var="faqVo">
						<tr>
							<td><a href="/camp/selectByfaq/${faqVo.faq_no}/${checkBoard}">${faqVo.faq_title}</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
	<!-- Owl Carousel JS -->
	
	<script>
	
	var owl = $('.owl-carousel');
	owl.owlCarousel({
	    items:6,
	    loop:true,
	    margin:10,
	    autoplay:true,
	    autoplayTimeout:5000,
	    autoplayHoverPause:true

	});
	
	</script>
<%@ include file="../include/footer.jsp"%>
