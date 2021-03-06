<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
    
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
		text-align: center;
	}
	th {
		background-color: #4f6fcc25;
	}
</style>

<script>
$(function () {
	$("#searchReview").click(function(){
		var searchCnd = $("select[name=searchCnd]").val();
		var textReview = $("#textReview").val();
		$("#reviewFaqFrmPage > input[name=searchCnd]").val(searchCnd);
		$("#reviewFaqFrmPage > input[name=textReview]").val(textReview);
		$("#reviewFaqFrmPage").submit();
	});
	// n줄씩 보기
		$("select[name=perPage]").change(function(){
		var perPage = $(this).val();
		var i = $("#reviewFaqFrmPage >input[name=perPage]").val(perPage);
		$("#reviewFaqFrmPage").submit();
	});
	//페이지 번호
		$("a.page-link").click(function(e){
		e.preventDefault();
		var page = $(this).attr("href").trim();
		$("#reviewFaqFrmPage > input[name=page]").val(page);
		$("#reviewFaqFrmPage").submit();
		});
		//현재 페이지 액티브
		$("a.page-link").each(function(){
			var page =$(this).attr("href");
			if(page == "${pagingDto.page}"){
				$(this).parent().addClass("active");
				return;
			}
		});
		$("a.faq_title").click(function(e){
			e.preventDefault();
			var faq_no = $(this).attr("data-faq_no");
			console.log("faq_no:", faq_no);
			$("#reviewFaqFrmPage > input[name=faq_no]").val(faq_no);
			$("#reviewFaqFrmPage").attr("action", $(this).attr("href"));
			$("#reviewFaqFrmPage").submit();
		});
});
</script>
<%@ include file="../include/campingFaqFrmPage.jsp" %>


<div class="container-fluid">
	<div class="row">
				<div class="col-md-1">
		</div>
		<div class="col-md-10">
		<select name="perPage" class="form-inline">
			<c:forEach begin="5" end="30" step="5" var="i">
				<option value="${i}"
					<c:if test="${i == pagingDto.perPage}">selected</c:if>>${i}줄씩
					보기</option>
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
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="faqVo">
					<tr>
						<td>${faqVo.faq_no}</td>
						<td width="450" id="td_title">
							<a href="/camp/selectByFaq/${faqVo.faq_no}" class="faq_title" data-faq_no="${faqVo.faq_no }">${faqVo.faq_title}</a>
						</td>
						<td>${faqVo.faq_writer}</td>
						<td>${faqVo.faq_date}</td>
						<td>${faqVo.faq_view}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
				</div>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div class="row">
	<div class="col-md-1"></div>
		<div class="col-md-10"></div>
		<div class="col-md-1"></div>
	</div>
	<div class="container-fluid">
	<div class="row">
				<div class="col-md-4">
								
				</div>
				<div class="col-md-4">
					<select name="searchCnd" id="searchCnd" class="form-group" title="검색조건선택">
						<option value="t"
						 <c:if test="${pagingDto.searchCnd == 't' }">selected</c:if>
						 >제목</option>
						<option value="w"
						 <c:if test="${pagingDto.searchCnd == 'w' }">selected</c:if>
						>내용</option>
					</select>
					<input type="text" class="form-group" id="textReview" name ="textReview"
						 value="${pagingDto.textReview }"/>
					<button class="btn btn-success" id="searchReview">검색</button>
				</div>
				<div class="col-md-4"></div>
	</div>
</div>
</div>


		<div class="container-fluid">
			<div class="row">
				<div class="col-md-5"></div>
				<div class="col-md-4">
							<nav>
				<ul class="pagination">
				<c:if test="${pagingDto.startPage != 1}">
					<li class="page-item">
						<a class="page-link" href="${pagingDto.startPage - 1}">&laquo;</a>
					</li>
				</c:if>
					<c:forEach begin="${pagingDto.startPage}" end="${pagingDto.endPage}" var="page">
					<li class="page-item">
						<a class="page-link" href="${page}">${page}</a>
					</li>
					</c:forEach>
					<c:if test="${pagingDto.endPage < pagingDto.totalPage}">
					<li class="page-item">
						<a class="page-link" href="${pagingDto.endPage + 1}">&raquo;</a>
					</li>
					</c:if>
				</ul>
			</nav>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
		
		<div class="col-md-12 text-center">

		</div>
<%@ include file="../include/footer.jsp"%>