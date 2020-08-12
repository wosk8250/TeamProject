<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<style>
ul.tabs {
	margin: 0px;
	padding: 0px;
	list-style: none;
}

ul.tabs li {
	display: inline-block;
	background: #898989;
	color: white;
	padding: 10px 15px;
	cursor: pointer;
}

ul.tabs li.current {
	background: #e0e0e0;
	color: #222;
}

.tab-content {
	display: none;
	padding: 12px;
}

.tab-content.current {
	display: inherit;
}

.containers {
	display: flex;
	justify-content: center;
}

.maps {
	display: flex;
	justify-content: center;
}

.imgArticle {
	margin: 50px;
}

.mapDiv {
	margin: 0 auto 0 auto;
}

.spanDiv {
	display: flex;
	justify-content: center;
}

.str {
	color: red;
}

.str1 {
	color: black;
}

#tableSize {
	width: 120%
}

#note {
	width: 100%;
	text-align: center
}
#tabMenu {
	width:60%;
	rhight: 50px;
	text-align: center;
}
#tab-2 {
 	width:90%; 
 	rhight: 50px; 
	text-align: center; 
}
#btnRecommend {
	float: left;
	margin-left: 70%;
}

</style>


<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script>
	$(function() {
		//-----------------예약 달력------------------
		var disabledDays = ${date};
		console.log(disabledDays);
		$( "#startDate" ).datepicker({
		    nextText: '다음 달',
		    prevText: '이전 달', 
		    dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
		    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
		    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		    dateFormat: "yy-mm-dd",
		    minDate: 0,                       // 선택할수있는 최소날짜, ( 0 : 오늘 이후 날짜 선택 불가)
		   beforeShowDay: disableAllTheseDays,
		    onClose: function( selectedDate ) {    
		        $("#endDate").datepicker( "option", "minDate", selectedDate );
		        $("#endDate").focus();
		    }    
		});

		$('#startDate').datepicker('setDate', '+0');

		function disableAllTheseDays(date) { 
			   var m = date.getMonth(), d = date.getDate(), y = date.getFullYear(); 
			   for (i = 0; i < disabledDays.length; i++) { 
			       if($.inArray(y + '-' +(m+1) + '-' + d,disabledDays) != -1) { 
			           return [false]; 
			       } 
			   } 
			   return [true]; 
			}

		$( "#endDate" ).datepicker({
		    nextText: '다음 달',
		    prevText: '이전 달', 
		    dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
		    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
		    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		    dateFormat: "yy-mm-dd",
		    minDate: 0,   
		    beforeShowDay: disableAllTheseDays,
		    onClose: function( selectedDate ) {    

		        $("#startDate").datepicker( "option", "maxDate", selectedDate );
		        var url = "/camp/reservationDateConfirm";
		        var sendData = {"startdate" : $("#startDate").val(), "enddate" : $("#endDate").val(),"camp_no" : "${campVo.camp_no}"};
		        $.ajax({
		        	"type" : "post",
		        	"url" : url,
		        	"dataType" : "text",
		        	"data" : JSON.stringify(sendData),
					"headers" : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "post"
					},
					"success" :function(rData){
						
						if(rData == "false"){
							alert("예약을 할 수 없습니다");
							$( "#startDate" ).val("");
							$( "#endDate" ).val("");
						}
					}
		        });
		    }    
		});   

		$("#startDate").focusout(function() {

		});

		function disableAllTheseDays(date) {
		var m = date.getMonth(), d = date.getDate(), y = date.getFullYear();
		for (i = 0; i < disabledDays.length; i++) {
		  if($.inArray(y + '-' +(m+1) + '-' + d,disabledDays) != -1) {
		      return [false];
		  }
		}
		return [true];
		}
		
		$("a.page-link").each(function(){
			var page =$(this).attr("href");
			if(page == "${pagingDto.page}"){
				$(this).parent().addClass("active");
				return;
			}
		}); 
		
		$("#reservationBtn").click(function() {
			$("#reservationForm").submit();
		});
		//-------------------예약
		
		
		$("#btnRecommend").click(
				function() {
					var user_id = "${sessionScope.user_id}";
					var camp_no = "${campVo.camp_no}";
					console.log(user_id);
					console.log(camp_no);
					if (user_id == "") {
						location.href = "/user/login";
						return;
					}
					var url = "/camp/recommend?user_id=" + user_id
							+ "&camp_no=" + camp_no;

					var sendData = {
						"camp_no" : camp_no,
						"user_id" : user_id
					}

					console.log(sendData);
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

							if (rData == "success") {
								alert("추천 되었습니다.");
							} else if (rData == "fail") {
								alert("이미 추천되었습니다.")
							}
						}
					});

				});
	});
	$(function() {

		$('ul.tabs li').click(function() {
			var tab_id = $(this).attr('data-tab');

			$('ul.tabs li').removeClass('current');
			$('.tab-content').removeClass('current');

			$(this).addClass('current');
			$("#" + tab_id).addClass('current');
		})

		
		
		
	});
</script>
<div class="containers">
	<%-- ${campVo} --%>
	<%-- ${CampRecommendVo} --%>
	<article class="imgArticle">
		<div>
			<img width="450" height="450" src="/upload/displayCampingImg?fileName=${campVo.thumbnail}">
		</div>
	</article>

	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-12">
			<table class="table" id="recommendTable" name="recommendTable">
				<thead>
				<h2><i class="str1">${campVo.camp_name}</i></h2>
					<tr>
						<th>주소</th>
						<td>${campVo.camp_address}</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>문의처</th>
						<td>${campVo.camp_phone}</td>
					</tr>
					<tr>
						<th>운영일</th>
						<td>${campVo.operatingday}</td>
					</tr>
					<tr>
						<th>운영기간</th>
						<td>${campVo.camp_operation}</td>
					</tr>
					<tr>
						<th>추천 수</th>
						<td>${campVo.recommend}</td>
					</tr>
					<tr>
						<th>홈페이지</th>
						<td><a href="${campVo.camp_http}">${campVo.camp_http}</a></td>
					</tr>
					<tr>
						<th></th>
						<td><button class="btn btn-large btn-success" type="button" id="btnRecommend" name="btnRecommend">추천하기</button></td>
						
						<td>
							 	 <a id="modal-649695" href="#modal-container-649695" role="button" class="btn btn-dark" data-toggle="modal">예약하기</a>
			
								<div class="modal fade" id="modal-container-649695" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="myModalLabel">
													${campVo.camp_name} 예약하기
												</h5> 
												<button type="button" class="close" data-dismiss="modal">
													<span aria-hidden="true">×</span>
												</button>
											</div>
											<div class="modal-body">
												<form id="reservationForm" role="form" method="post" action="/camp/reservationDate">
												<div style="margin: 20px">
												입실일<input type="text" id=startDate name="startdate"/>
												</div>
												<div style="margin: 20px">
												퇴실일<input type="text" id="endDate" name="enddate"/>
												</div>
												<input type="hidden" name="camp_no" value="${campVo.camp_no}"/>
												<input type="hidden" name="camp_name" value="${campVo.camp_name}"/>
												<input type="hidden" name="host" value="${campVo.user_id}"/>
												<input type="hidden" name="user_id" value="${sessionScope.user_id}"/>
												</form>
											</div>
											<div class="modal-footer">
												 
												<button id="reservationBtn" type="button" class="btn btn-primary">
													예약
												</button> 
												<button type="button" class="btn btn-secondary" data-dismiss="modal">
													닫기
												</button>
											</div>
										</div>
										
								</div>
			</div>
							
						</td>
					</tr>
					
				</tbody>
			</table>
		</div>
	</div>
	<div class="col-md-1"></div>
</div>

<div class="container">
	<!-- 탭 메뉴 상단 시작 -->
	<ul class="tabs">
		<li class="tab-link current" data-tab="tab-1">캠핑장소개</li>
		<li class="tab-link" data-tab="tab-2">이용안내</li>
	</ul>
	<hr>
	<!-- 탭 메뉴 상단 끝 -->
	<!-- 탭 메뉴 내용 시작 -->
	<div id="tab-1" class="tab-content current">
		<div class="row">
			<div class="col-md-12">
			<table>
				<tr>
					<th>${campVo.camp_content}</th>
				</tr>
			</table>
			</div>
		</div>
		<hr>
	</div>
</div>
<div id="tab-2" class="tab-content">
	<h2>● ${campVo.camp_name} 요금안내표</h2>
	</br>
	</br>
<div class="container-fluid" id="tabMenu">
	<div class="row">
		<div class="col-md-12">
			<table class="table table-bordered" id="tableSize">
				<thead>
				<h2>일반캠핑</h2>
				</thead>
				<tbody>
					<tr class="table-active" >
						<th rowspan="2">구분</th>
						<th colspan="2">평상시</th>
						<th colspan="2">성수기</th>
					</tr>
					<tr>
						<td>주중</td>
						<td>주말</td>
						<td>주중</td>
						<td>주말</td>
					</tr>
					
					<tr> 
						<td>일반</td>
						<td>${campVo.camp_weekdays}</td>
						<td>${campVo.camp_weekend}</td>
						<td>${campVo.camp_peakweekdays}</td>
						<td>${campVo.camp_peakweekend}</td>
						</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</div>

</br>


	<div class="mapDiv" id="map" style="width: 63%; height: 350px;"></div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6a7370418a9ba06a9222aff299cacd04&libraries=services"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 생성합니다   

		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();

		// 주소로 좌표를 검색합니다
		geocoder
				.addressSearch(
						'${campVo.camp_address}',
						function(result, status) {

							// 정상적으로 검색이 완료됐으면 
							if (status === kakao.maps.services.Status.OK) {

								var coords = new kakao.maps.LatLng(result[0].y,
										result[0].x);

								// 결과값으로 받은 위치를 마커로 표시합니다
								var marker = new kakao.maps.Marker({
									map : map,
									position : coords
								});

								// 인포윈도우로 장소에 대한 설명을 표시합니다
								var infowindow = new kakao.maps.InfoWindow(
										{
											content : '<div style="width:150px;text-align:center;padding:6px 0;">${campVo.camp_name}</div>'
										});

								infowindow.open(map, marker);

								// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
								map.setCenter(coords);
							}
						});
	</script>
	</br>
	<div class="maps">
	<p style="margin-top: -12px">
		<em class="link"> <a href="javascript:void(0);"
			onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
				혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요. </a>
		</em>
	</p>
</div>
</br>
<div class="container-fluid">
	<div class="row" id="note">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr>
						<th>
							* 사이트에 등록된 정보는 현장상황과 다소 다를 수 있으니<i class="str"> 애완동물 동반 여부, 부가 시설물, 추가차량 </i>등 원활한 캠핑을 위해 꼭 필요한 사항은 해당 캠핑장에 미리 확인하시기 바랍니다.
						</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
</div>

<%@ include file="../include/footer.jsp"%>