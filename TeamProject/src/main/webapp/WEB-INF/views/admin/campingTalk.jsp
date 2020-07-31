<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="../include/adminheader.jsp" %>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>
$(function() {
	var msg = "${msg}"
	console.log(msg);
	if(msg == "delete"){
		alert("게시글 삭제완료");
	}
	
	$(".page-link").click(function(e) {
		e.preventDefault();
		var page = $(this).attr("href").trim();
		$("#adminCampingTalkFrmPage > input[name=page]").val(page);
		$("#adminCampingTalkFrmPage").submit();
	});
	
	$("select[name=perPage]").change(function() {
		var perPage = $(this).val();
		var i = $("#adminCampingTalkFrmPage > input[name=perPage]").val(perPage);
	 	$("#adminCampingTalkFrmPage").submit();
	});
	$(".searchCampingTalk").click(function() {
		var campingtalk_title = $("#textCampingTalk").val();
		location.href="/admin/campingTalk?campingtalk_title=" + campingtalk_title;
	});

	
});


</script>

<%@include file ="../include/adminCampingTalkFrmPage.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
		<select name="perPage" class="form-inline">
			<c:forEach begin="5" end="30" step="5" var="i">
				<option value="${i}"
					<c:if test="${i == pagingDto.perPage}">selected</c:if>
				>${i}줄씩 보기</option>
			</c:forEach>
			</select>
			<table class="table">
				<thead>
					<tr>
						<th>글번호</th>
						<th>이미지</th>
						<th>제목</th>
						<th>날짜</th>
						<th>아이디</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="campingTalkVo">
				<c:if test="${campingTalkVo.campingtalk_admin == 0}">
					<tr>
						<td>${campingTalkVo.campingtalk_no}</td>
						<td></td>
						<td>${campingTalkVo.campingtalk_title}</td>
						<td>${campingTalkVo.campingtalk_date}</td>
						<td>${campingTalkVo.campingtalk_id}</td>
						<td><a href="/admin/campingTalkDelete?campingTalk_no=${campingTalkVo.campingtalk_no}" class="btn btn-warning">삭제</a></td>
					</tr>
				</c:if>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<input type="text" class="form-group" id="textCampingTalk"/>
					<button class="btn btn-success searchCampingTalk">검색</button>
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