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
.trTable {
	width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
}

th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
  
.listTable {
	display: flex;
	justify-content: center;
}
.str {
	color: gray;
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
						output += "<tr style='background-color: #E1E5E6' class='trTable'>";
						output += "<th>" + rData.length + '개의 캠핑장이 검색되었습니다.' + "</th>";
						output += "<th>" + "</th>";
						output += "<th>" + "</th>";
						output += "<th>" + "</th>";
						output += "<th>" + "</th>";
						output += "<th>" + "</th>";
						output += "<th>" + "</th>";
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
							console.log("thumb", item.thumbnail);
							
							output += "<tr>";
							output += "<th>" + "<img width='200' height='200' src='/upload/displayCampingImg?fileName=" + item.thumbnail +"'>" + "</th>";
							output += "<th>" + "<h2>" + "<a href='/camp/campingContent?camp_no="+ item.camp_no +"' class='a_title' data-camp_no='" + item.camp_no + "'>"+ "<i class='str'>" + '[' + item.camp_area + item.camp_location + ']' + item.camp_name + "</i>" + "</a>" + "</h2>" + "</br>" + item.camp_intro + "</br>" + "</br>" + "<img width='20' height='20' src='/resources/image/locations.png'>"+ '&nbsp' +item.camp_address + '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp' + "<span>"+ "<img width='20' height='20' src='/resources/image/calling1.png'>" + '&nbsp' + item.camp_phone +"</span>";
							output += "</th>";
							output += "<td>" + "<button id='viewbtn' type='btn' class='btn btn-sm btn-success'>" + '조회 수 :' + item.viewcnt + "</button>" + "</br>";
							output += "<button type='recommendbtn' class='btn btn-sm btn-danger'>" + '추천 수 :' + item.recommend + "</button>";
							output += "</td>";
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
	
	$('#viewbtn').prop('disabled', true);
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
	<div class="listTable">
		<div class="col-md-12" id="campingDiv">
			<table id="camPingTable">
				<thead>
					<tr style="background-color: #E1E5E6" class="trTable"> 
						<th>지역별 인기 캠핑장 목록</th>
						<th></th>
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
<!-- 				style="background-color: #F9FFFF;" -->
				<c:forEach items="${campList}" var="CampVo">
						<th><img width="200" height="200" src="/upload/displayCampingImg?fileName=${CampVo.thumbnail}"></th>
						<th><h2><a href="/camp/campingContent" class="a_title" data-camp_no="${CampVo.camp_no}"><i class="str">[${CampVo.camp_area} ${CampVo.camp_location}] ${CampVo.camp_name}</i></a></h2></br>
							<span id="contentSpan">${CampVo.camp_intro}</span></br></br>
							<img width="20" height="20" src="/resources/image/locations.png">&nbsp${CampVo.camp_address}
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							<span><img width="20" height="20" src="/resources/image/calling1.png">&nbsp${CampVo.camp_phone}</span>
						</th>
							<th>
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
						</th>
						<td><button id="viewbtn" type="btn" class="btn btn-sm btn-success">조회수 : ${CampVo.viewcnt}</button></br>
							<button type="recommendbtn" class="btn btn-sm btn-danger">추천수 : ${CampVo.recommend}</button></td>
					</tr>
			 		</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</br>
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