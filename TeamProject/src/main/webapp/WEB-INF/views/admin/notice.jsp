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
	console.log(msg);
	if(msg == "delete"){
		alert("게시글 삭제완료");
	}
	
	$(".page-link").click(function(e) {
		e.preventDefault();
		var page = $(this).attr("href").trim();
		$("#reviewNoitceFrmPage > input[name=page]").val(page);
		$("#reviewNoitceFrmPage").submit();
	});
	
	$("select[name=perPage]").change(function() {
		var perPage = $(this).val();
		var i = $("#noticeFrmPage > input[name=perPage]").val(perPage);
	 	$("#reviewNoitceFrmPage").submit();
	});
	$(".searchNotice").click(function() {
		var textReview = $("#textReview").val();
		$("#reviewNoitceFrmPage > input[name=textReview]").val(textReview);
		$("#reviewNoitceFrmPage").submit();
	});
	$("a.page-link").each(function(){
		var page =$(this).attr("href");
		if(page == "${pagingDto.page}"){
			$(this).parent().addClass("active");
			return;
		}
	}); 
	$("a.page-link").click(function(e){
		e.preventDefault();
		var page = $(this).attr("href").trim();
		$("#reviewNoitceFrmPage > input[name=page]").val(page);
		$("#reviewNoitceFrmPage").submit();
	});
	$("a.notice_title").click(function(e){
		e.preventDefault();
		var notice_no=$(this).attr("data-notice_no");
		console.log("notice_no:", notice_no);
		$("#reviewNoitceFrmPage > input[name=notice_no]").val(notice_no);
		$("#reviewNoitceFrmPage").attr("action", $(this).attr("href"));
		$("#reviewNoitceFrmPage").submit();
	});
	});



</script>

<%@ include file="../include/campingNoticeFrmPage.jsp" %>

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
				<h2>공지사항</h2>
			<hr>
			<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="campNoticeVo">
					<c:if test="${campNoticeVo.notice_admin == 0}">
					<tr>
						<td>${campNoticeVo.notice_no}</td>
						<td><a href="/camp/singleContentsCampNotice/${campNoticeVo.notice_no}" class="notice_title" data-notice_no="${campNoticeVo.notice_no}">${campNoticeVo.notice_title}</a></td>
						<td>${campNoticeVo.notice_date}</td>
					</tr>
					</c:if>
				</c:forEach>
				</tbody>
			</table>
		</div>
	<div>
	<a class="btn btn-primary" href="/admin/noticeForm">작성</a>
	</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<input type="text" class="form-group" id="textNotice"/>
					<button class="btn btn-success searchNotice">검색</button>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
		<div class="row">
		<div class="col-md-5">
		</div>
		<div class="col-md-4">
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
		<div class="col-md-3">
		</div>
	</div>
	</div>
</div>

<%@include file ="../include/adminfooter.jsp" %>