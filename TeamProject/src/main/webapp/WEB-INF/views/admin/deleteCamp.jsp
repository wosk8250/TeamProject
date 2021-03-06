<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="../include/adminheader.jsp" %>

<style>
	div {
		color: black;
	}
	table {
		text-align: center;
		color: black;
	}
	#td_title {
		text-align: center;
	}
	th {
		background-color: #4f6fcc25;
	}
</style>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>
$(function() {
	var msg = "${msg}"
	if(msg == "delete"){
		alert("게시글 삭제완료");
	}

	$(".page-link").click(function(e) {
		e.preventDefault();
		var page = $(this).attr("href").trim();
		$("#campFrmPage > input[name=page]").val(page);
		$("#campFrmPage").submit();
	});
	
	$("select[name=perPage]").change(function() {
		var perPage = $(this).val();
		var i = $("#campFrmPage > input[name=perPage]").val(perPage);
	 	$("#campFrmPage").submit();
	});
	
	$(".searchCamp").click(function() {
		var campName = $("#textCamp").val();
		location.href="/admin/deleteCamp?camp_name=" + campName;
	});

});

</script>

<%@include file ="../include/adminDeleteCampFrmPage.jsp" %>

<div class="container-fluid">
	<div class="row">
	<div class="col-md-1">
		</div>
		<div class="col-md-10">
			<select name="perPage" class="form-inline">
			<c:forEach begin="5" end="30" step="5" var="i">
				<option value="${i}"
					<c:if test="${i == pagingDto.perPage}">selected</c:if>
				>${i}줄씩 보기</option>
			</c:forEach>
			</select>
		<div class="col-md-10">
			<h2>이용 중지된 캠핑장</h2>
			<hr>
			<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>글번호</th>
						<th>이미지</th>
						<th>캠핑장 이름</th>
						<th>지역</th>
						<th>시&구</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="campVo">
					<tr>
						<td>${campVo.camp_no}</td>
						<td>
							<img src="/upload/displayImg?fileName=${campVo.thumbnail}" alt="사진 미등록"/>
						</td>
						<td><a href="/camp/campingContent?camp_no=${campVo.camp_no}">${campVo.camp_name}</a></td>
						<td>${campVo.camp_location}</td>
						<td>${campVo.camp_area}</td>
						<td><a href="/admin/deleteCampReEnrollment/${campVo.camp_no}" class="btn btn-info">재등록</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</div>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<input type="text" class="form-group" id="textCamp"/>
					<button class="btn btn-success searchCamp">검색</button>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
		
		<div class="row">
		<div class="col-md-12 text-center">
			<nav>
				<ul class="pagination">
				<c:if test="${pagingDto.startPage != 1}">
					<li class="page-item">
						<a class="page-link" href="${pagingDto.startPage - 1}">이전</a>
					</li>
				</c:if>
					<c:forEach begin="${pagingDto.startPage}" end="${pagingDto.endPage}" var="page">
					<li class="page-item">
						<a class="page-link" href="${page}">${page}</a>
					</li>
					</c:forEach>
					<c:if test="${pagingDto.endPage < pagingDto.totalPage}">
					<li class="page-item">
						<a class="page-link" href="${pagingDto.endPage + 1}">다음</a>
					</li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
	
	</div>
</div>
    


<%@include file="../include/adminfooter.jsp"%>