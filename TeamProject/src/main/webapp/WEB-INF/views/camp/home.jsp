<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
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
						$("#camPingTable").empty();
						var table = $("#camPingTable tr:first").clone();
						$.each(rData, function(index, value) {
							
							console.log(value.camp_name);
							
							var table_re = "<tr>" +
								"<td>" + value.camp_name + "</td>" +
							
								
								"</tr>";
							
							$("#camPingTable").append(table);
						});	
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
<%-- list: ${list} --%>
<%-- CampList : ${campList} --%>
<%-- <%@ include file="../include/frmPage.jsp" %> --%>

<%@ include file="../board/mainFrmPage.jsp" %>

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
	<div class="row">
		<div class="col-md-12">
			<table class="table" id="camPingTable">
				<thead>
					<tr>
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
					<tr>
						<td><h2><a href="/camp/campingContent" class="a_title" data-camp_no="${CampVo.camp_no}">${CampVo.camp_name}</a></h2></td>
						<td>${CampVo.camp_phone}</td>
						<td>${CampVo.camp_location}</td>
						<td><img width="200" height="200" src="/resources/image/1594178025406.jpg"></td>
							<td>
							<div class="camp_item_box">
							<th>
								<ul>
									<li><i class="ico_wifi"><span>와이파이</span></i></li>
									<li><i class="ico_wood"><span>장작판매</span></i></li>
									<li><i class="ico_hotwater"><span>온수</span></i></li>
									<li><i class="ico_walk"><span>산책로</span></i></li>
									<li><i class="ico_mart"><span>마트.편의점</span></i></li>
								</ul>
							</th>
						</div>
							</td>
							<td>조회수 : ${CampVo.viewcnt}</td>
							<td>추천수 : ${CampVo.recommend}</td>
						</tr>
				</c:forEach>
					</tr>
				</tbody>
			</table>
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