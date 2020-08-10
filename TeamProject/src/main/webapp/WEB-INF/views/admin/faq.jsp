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
	$("#faqFrmPage > input[name=page]").val(page);
	$("#faqFrmPage").submit();
});

$("select[name=perPage]").change(function() {
	var perPage = $(this).val();
	var i = $("#faqFrmPage > input[name=perPage]").val(perPage);
 	$("#faqFrmPage").submit();
});
$(".searchFaq").click(function() {
	var faq_title = $("#textFaq").val();
	location.href="/admin/faq?faq_title=" + faq_title;
});
$("a.page-link").each(function(){
	var page =$(this).attr("href");
	if(page == "${pagingDto.page}"){
		$(this).parent().addClass("active");
		return;
	}
}); 

});

</script>

<%@include file ="../include/adminFaqFrmPage.jsp" %>

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
				<h2>자주묻는 질문</h2>
			<hr>
			<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
					<th width="450">제목</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="faqVo">
				<c:if test="${faqVo.faq_admin == 0}">
					<tr>
						<td>${faqVo.faq_no}</td>
						<td><a href="/camp/selectByFaq/${faqVo.faq_no}">${faqVo.faq_title}</a></td>
						<td>${faqVo.faq_date}</td>
					</tr>
				</c:if>
				</c:forEach>
				</tbody>
			</table>
			</div>
			<div>
	<a class="btn btn-primary" href="/admin/faqForm">작성</a>
			</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<input type="text" class="form-group" id="textFaq"/>
					<button class="btn btn-success searchFaq">검색</button>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
		<div class="container-fluid">
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
	</div>
	




</div>
    


<%@include file="../include/adminfooter.jsp"%>