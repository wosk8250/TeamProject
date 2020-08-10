<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<script src="/resources/vendor/jquery/jquery.js"></script>
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
	margin: 0px 15%;
	padding: 10px;
	background-color: rgba(255, 255, 255, 0.3);
}
#out {
 width: 50%;
 text-align: center;
 }
#in {
	float: left;
	margin-left: 50%;
 }
</style>
<script>
	$(function() {
		$("#areaDo").change(function() {
			
			var camp_area = $("#areaDo").val()
// 			console.log(camp_area);
			
			var url = "/camp/locationArea/" + camp_area;
// 			console.log("url", url);
			var sendData ={
				"camp_area" : camp_area
			};
			$("#locationSi option").remove();
// 			console.log("sendData", sendData);	
			
			$.get(url, sendData, function(rData){
				$.each(rData, function(index){
// 					console.log(rData);
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
			
			var sendData = {
				"camp_area"  : selectDo,
				"camp_location"	: selectSi
			};
			
			console.log(sendData);
			
			var output = '';
			
			var url = "/camp/searchList";
			
				$.ajax({
					"type" : "post",
					"url" : url,
					"dataType" : "JSON",
					"data" : JSON.stringify(sendData),
					"headers" : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "post"
					},
					"success" : function(rData) {
						console.log(rData);
						
						
						
						
						
						$("#camPingTable").remove();
						
						output += "<div class='row'>";
						output += "<div class='col-md-12' id='campingDiv'>";
						output += "<table class='table' id='camPingTable'>";
						output += "<thead>";
						output += "<tr>";
						output += "<th>" + rData.length + '개의 캠핑장이 검색되었습니다.' + "</th>"; 
//							output += "<th>" + "</th>";
//							output += "<th>" + "</th>";
//							output += "<th>" + "</th>";
//							output += "<th>" + "</th>";
//							output += "<th>";
//							output += "<select name='perPage' class='form-inline'>";
//							output += "<c:forEach begin='5' end='10' step='5' var='i'>";
//							output += "<option value='${i}' <c:if test='${i == pagingDto.perPage}'>" + 'selected' + "</c:if>";
//							output += ">" + '${i}줄씩 보기' + "</option>" + "</c:forEach>";
//							output += "</select>";
//							output += "</th>";
						output += "</tr>";
						output += "</thead>";
						output += "<tbody>";
						
// 						$("#campingDiv").append(output);
						
						
						$.each(rData, function(index, item) {
// 							output = '';
							console.log(index);
							console.log("item", item);
							console.log("CampVo", "${CampVo}");
							console.log(output);
							
							
							
							output += "<tr>";
							output += "<td>" + "<h2>" + "<a href='/camp/campingContent?camp_no="+ item.camp_no +"' class='a_title' data-camp_no='" + item.camp_no + "'>" + item.camp_name + "</a>" + "</h2>" + "</td>";
							output += "<td>" + item.camp_phone + "</td>";
							output += "<td>" + item.camp_location + "</td>";
							output += "<td>" + "<img width='200' height='200' src='/resources/image/1594178025406.jpg'>" + "</td>";
							output += "<td>" + '조회 수 :' + item.viewcnt + "</td>";
							output += "<td>" + '추천 수 :' + item.recommend + "</td>";
							output += "</tr>";
// 							$("#campingDiv").append(output);
							
					}); // $.each()
					
						output += "</tbody>";
						output += "</table>";
						output += "</div>";
						output += "</div>";
						console.log("c");
						$("#campingDiv").append(output);
				}
			});
		});
	});

	$(function() {

		$("a.page-link").click(function(e) {
			e.preventDefault();
			var page = $(this).attr("href").trim();
			$("#mainFrmPage > input[name=page]").val(page);
			$("#mainFrmPage").submit();
		});

		$("select[name=perPage]").change(function() {
			console.log($(this).val());
			$("#mainFrmPage > input[name=perPage]").val($(this).val());
			$("#mainFrmPage").submit();
		});

		$("a.page-link").each(function() {
			var page = $(this).attr("href");
			if (page == "${pagingDto.page}") {
				$(this).parent().addClass("active");
				return;
			}
		});

		// 글제목 클릭 -> 상세보기
		$("a.a_title").click(function(e) {
			e.preventDefault();
			var camp_no = $(this).attr("data-camp_no");
			$("#mainFrmPage > input[name=camp_no]").val(camp_no);
			$("#mainFrmPage").attr("action", $(this).attr("href"));
			$("#mainFrmPage").submit();
		});

	});
</script>

<%@ include file="../board/mainFrmPage.jsp" %>
<%-- amenitiesList : ${amenitiesList} --%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-8">
		<div class="jb-wrap">
			<div class="jb-image">
				<img src="/resources/image/1594178025406.jpg">
			</div>
			<div class="jb-nav">
				<div class="jb-nav-table">
					<div class="jb-nav-table-row">
						<div class="jb-nav-table-cell">
							<nav class="navbar navbar-expand-lg">
								<button class="navbar-toggler" type="button"
									data-toggle="collapse"
									data-target="#bs-example-navbar-collapse-1">
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
										
										<label>동 선택</label>
										<select id="locationSi" name="locationSi" class="custom-select">
							 			 <option value="11">전체/시</option>
							 			 </select>
										<button class="btn btn-primary my-2 my-sm-0" type="button" id="searchButton">검색</button>
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
		<div class="col-md-4">
			<img class="d-block w-100" src="/resources/image/camping01.jpg" />
			<img class="d-block w-100" src="/resources/image/camping02.jpg" />
		</div>
	</div>
	</br>
	<div class="row">
		<div class="col-md-12" id="campingDiv">
			<table id="camPingTable">
				<thead>
					<tr style="background-color: #FAFAFA"> 
						<th>지역별 인기 캠핑장 목록</th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th>
							<select name="perPage" class="form-inline">
									<c:forEach begin="5" end="10" step="5" var="i">
										<option value="${i}" <c:if test="${i == pagingDto.perPage}">selected</c:if> 
										>${i}줄씩 보기</option></c:forEach>
							</select>
						</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${campList}" var="CampVo">
					<tr style="background-color: #e6f4fa;">
						<th><img width="200" height="200" src="/resources/image/1594178025406.jpg"></th>
						<th><h2>[${CampVo.camp_area} ${CampVo.camp_location}] <a href="/camp/campingContent" class="a_title" data-camp_no="${CampVo.camp_no}">${CampVo.camp_name}</a></h2></th>
						<tr>
						<td>${CampVo.camp_content}</td>
						</tr>
						<td>${CampVo.camp_phone}</td>
							<td style="display: none">조회수 : ${CampVo.viewcnt}</td>
							<td style="display: none">추천수 : ${CampVo.recommend}</td>
							<td>
							<div class="camp_item_box">
							<c:forEach items="${amenitiesList}" var="optionVo">
							
							<ul>
							<c:if test="${optionVo.wifi == '1' and optionVo.camp_no == CampVo.camp_no}">
									<li>무선인터넷 <i class="fa fa-wifi" aria-hidden="true"></i></li>
							</c:if>		
							<c:if test="${optionVo.power == '1' and optionVo.camp_no == CampVo.camp_no}">
									<li>전기 <i class="fa fa-bolt" aria-hidden="true"></i></li>
							</c:if>
							<c:if test="${optionVo.hotwater == '1' and optionVo.camp_no == CampVo.camp_no}">
									<li>온수 <i class="fa fa-shower" aria-hidden="true"></i></li>
							</c:if>
							<c:if test="${optionVo.trail == '1' and optionVo.camp_no == CampVo.camp_no}">
									<li>산책로 <i class="fa fa-leaf" aria-hidden="true"></i></li>
							</c:if>
							<c:if test="${optionVo.mart == '1' and optionVo.camp_no == CampVo.camp_no}">
									<li>마트,편의점	<i class="fa fa-shopping-basket" aria-hidden="true"></i></li>
							</c:if>
							<c:if test="${optionVo.park == '1' and optionVo.camp_no == CampVo.camp_no}">
									<li>주차장 <i class="fa fa-car" aria-hidden="true"></i></li>
							</c:if>
							</ul>
							</c:forEach>
							</div>
						</td>
			 		</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="c_list update">
					<a href="/bsite/camp/info/read.do?c_no=1345&amp;viewType=read01&amp;listOrdrTrget=last_updusr_pnttm" class="dc_none"><span class="skip">캠핑장정보 더보기</span>
						<div class="img_box">
							<img src="/img/2018/layout/noimg.jpg" alt="별수하야영장에 등록된 이미지가 업습니다.">
								<div class="clist_icon">
								<ul>
									<li><i class="con_tip c03"><span class="skip">산</span></i></li>
									<li><i class="con_tip con_update"><span class="skip">최근 한달 내 업데이트</span></i></li>
									</ul>
							</div>
						</div> </a>
					<div class="camp_cont">
						<p class="item_group">
							<span class="item_t01">관광사업자 등록업체</span>
							<span class="item_t02">리뷰수 0</span> <span class="item_t03">조회수 4882</span> <span class="item_t04">추천수 1</span>
						</p>
						<h2 class="camp_tt">
							<a href="/bsite/camp/info/read.do?c_no=1345&amp;viewType=read01&amp;listOrdrTrget=last_updusr_pnttm">[충청북도 제천시] 별수하야영장</a>
						</h2>
						<span class="camp_stt">산속 맑은 공기와 시원한 계곡물을 함께 즐기는 캠핑장</span> <span class="camp_txt"> <a href="/bsite/camp/info/read.do?c_no=1345&amp;viewType=read01&amp;listOrdrTrget=last_updusr_pnttm"><span class="skip">캠핑장정보 더보기</span> 별수하 야영장은 충북 제천시 백운면에 자리 잡고 있다. 제천시청을 기점으로 약 26km 거리에 있으며, 자동차를 타고...</a>
								</span>
						<ul class="camp_info01">
							<li class="addr">충청북도 제천시 백운면 운학리  171 </li>
							</ul>
						<!--아이콘모음-->
						<div class="camp_item_box">
								<ul>
									<li><i class="ico_volt"><span>전기</span></i></li>
									<li><i class="ico_wifi"><span>와이파이</span></i></li>
									<li><i class="ico_wood"><span>장작판매</span></i></li>
									<li><i class="ico_hotwater"><span>온수</span></i></li>
									<li><i class="ico_pool"><span>물놀이장</span></i></li>
									<li><i class="ico_ico_sports"><span>운동시설</span></i></li>
									</ul>
							</div>
						<!--//아이콘모음-->
					</div>
				</div>
	
	<div class="row">
		<div class="col-md-12 text-center" >
			<nav>
				<ul class="pagination" >
					<!-- 이전 -->
					<c:if test="${pagingDto.startPage != 1}">
					<li class="page-item">
						<a class="page-link" href="${pagingDto.startPage - 1}">&laquo;</a>
					</li>
					</c:if>
					<!-- 페이지 넘버링 -->
					<c:forEach begin="${pagingDto.startPage}" end="${pagingDto.endPage}" var="v">
					<li class="page-item">
						<a class="page-link" href="${v}">${v}</a>
					</li>
					</c:forEach>
					<!-- 다음 -->
					<c:if test="${pagingDto.endPage < pagingDto.totalPage}">
					<li class="page-item">
						<a class="page-link" href="${pagingDto.endPage + 1}">&raquo;</a>
					</li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>