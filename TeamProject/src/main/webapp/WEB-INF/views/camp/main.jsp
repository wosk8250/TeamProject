<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="/resources/js/owl.carousel.js"></script>
<%@ include file="../include/header.jsp" %>

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
	  background-color: rgba(0, 0, 0, 0.2);
}
.navbar-expand-lg {
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
	padding: 10px;
	
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
	
	//군,구 불러오기
	$("#camp_area").change(function() {
		
		var camp_area = $("#camp_area").val()
		console.log(camp_area);
		
		
		var url = "/camp/locationArea/" + camp_area;
		console.log("url", url);
		var sendData ={
			"camp_area" : camp_area
		};
		$("#camp_location option").remove();
		console.log("sendData", sendData);	
		
		$.get(url, sendData, function(rData){
			$.each(rData, function(index){
				console.log(rData);
				var optionArea = "<option value='"+ rData[index] +"'>" + rData[index]+ "</option>";
				
				$("#camp_location").append(optionArea);
			});
			$("#camp_location option:eq(0)").before("<option value='${CampVo.camp_location}' selected>전체/시</option>");	
		});
		
	});
// 	$("#searchButton").click(function () {
// 		var area = $("#camp_area").val();
// 		var location = $("#camp_location").val();
// 		console.log(area);
// 		console.log(location);
// 	});
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
				<div class="col-md-3"></div>
						<div class="col-md-6">
							<nav class="navbar navbar-expand-lg">
								<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
									<span class="navbar-toggler-icon"></span>
								</button>
								<div id="out" >
									<!-- 셀렉트박스  -->
									<form class="form-inline" name="form" action="/camp/home">
									<div class="form-group" id="in">
									  
   										 <label>지역 선택</label>
   										<select id="camp_area" name="camp_area" class="custom-select">
   											 <option value="1" selected>전체/도</option>
		   									 <c:forEach items="${list}" var="areaVo">
	   										 <option value="${areaVo.camp_area}">${areaVo.camp_area}</option>
		   									 </c:forEach>
										</select>
										
										<label>&nbsp; | &nbsp;</label>
										<select id="camp_location" name="camp_location" class="custom-select">
							 			 <option value="11">전체/시</option>
							 			 </select>
										<button type="submit" class="btn btn-primary my-2 my-sm-0"  id="searchButton">검색</button>
 									</div>
									</form>
								</div>
							</nav>
						</div>
						<div class="col-md-3"></div>
					</div>
				<div class="row">
					<div class="col-md-1">
					</div>
					<div class="col-md-10">
			<!-- 인기 캠핑장 -->
						<div class="owl-carousel" id="owl-demo">
							<c:forEach items="${campVo}" var="campVo">
					            <div class="item">
					            <a href="/camp/campingContent?camp_no=${campVo.camp_no }">
					            <img src="/upload/displayCampingImg?fileName=${campVo.thumbnail}" alt="${campVo.thumbnail}"/>
					            </a>
					              <h4>${campVo.camp_name}</h4>
					            </div>
							</c:forEach>
						</div>
					</div>
					<div class="col-md-1">
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
