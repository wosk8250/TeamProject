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
	#td_title {
		text-align: left;
	}
	th {
		background-color: #4f6fcc25;
	}
</style>

<script>
$(function () {
	
	// 페이지 번호
	$("a.page-link").click(function(e) {
		e.preventDefault(); // 브라우저의 기본기능(a:링크) 막기
		var page = $(this).attr("href").trim();
		$("#frmPage > input[name=page]").val(page);
		$("#frmPage").attr("action","/camp/faqList")
		$("#frmPage").submit();
	});
});
</script>
<%@ include file="../include/frmPage.jsp" %>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-1">
		</div>
		<div class="col-md-10">
			<h2>자주묻는 질문</h2>
			<hr>
			<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th width="450">제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${faqList}" var="faqVo">
					<tr>
						<td>${faqVo.faq_no}</td>
						<td width="450" id="td_title">
							<a href="/camp/selectByfaq/${faqVo.faq_no}">${faqVo.faq_title}</a>
						</td>
						<td>${faqVo.faq_writer}</td>
						<td>${faqVo.faq_date}</td>
						<td>${faqVo.faq_view}</td>
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