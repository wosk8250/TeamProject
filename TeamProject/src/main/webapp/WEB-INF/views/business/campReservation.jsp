<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<style>
	div {
		color: black;
	}
	table {
		text-align: center;
		color: black;
	}
	th {
		background-color: #4f6fcc25;
	}
	#mylink {
 		background-color: rgba(226,226,226,0.5);
		color: black;
 		border: 1px solid white;
 		box-shadow: inset 0px -4px 5px #ccc;
	}
	#mylink-active {
		color: black;
	}
</style>
<script>
$(function () {
	
	// 페이지 번호
	$("a.page-link").click(function(e) {
		e.preventDefault(); // 브라우저의 기본기능(a:링크) 막기
		var page = $(this).attr("href").trim();
		$("#myReviewFrmPage > input[name=page]").val(page);
		$("#myReviewFrmPage").submit();
	});
});
</script>

<%@ include file="../include/myReviewFrmPage.jsp" %>

<div class="container-fluid">
	<div class="row" style="margin-bottom: 30px;">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<ul class="nav nav-tabs nav-fill">
				<li class="nav-item">
					<a class="nav-link" id="mylink" href="/business/campForm">캠핑장 등록</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="mylink" href="/business/myCampList">캠핑장 리스트</a>
				</li>
				<li class="nav-item">
					<a class="nav-link active" id="mylink-active" href="/business/campReservation">캠핑장 예약현황</a>
				</li>
			</ul>
		</div>
		<div class="col-md-2"></div>
	</div>
	<div class="row">
		<div class="col-md-1">
		</div>
		<div class="col-md-10">
			<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>캠핑장 이름</th>
						<th>입실</th>
						<th>퇴실</th>
						<th>고객ID</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="reservationVo">
					<tr>
						<td>${reservationVo.camp_no}</td>
						<td>
							<a href="/camp/selectReview/${reservationVo.camp_no}">${reservationVo.camp_name}</a>
						</td>
						<td>${reservationVo.startdate}</td>
						<td>${reservationVo.enddate}</td>
						<td>${reservationVo.user_id}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</div>
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
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
		<div class="col-md-1">
		</div>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>