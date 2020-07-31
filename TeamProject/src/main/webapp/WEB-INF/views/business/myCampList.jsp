<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/topImgHeader.jsp" %>
<style>
	div {
		color: black;
	}
	table {
		text-align: center;
		color: black;
	}
	#td-title {
		text-align: left;
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
					<a class="nav-link active" id="mylink-active" href="/user/myReviewList">내가 작성한 후기</a>
				</li>
				<li class="nav-item select">
					<a class="nav-link" id="mylink" href="/user/profile">회원정보</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="mylink" href="/user/updateInfo">회원정보 수정</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="mylink" href="/user/updatePw">비밀번호 수정</a>
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
						<th width="450">이름</th>
						<th>추천 수</th>
						<th>조회 수</th>
						<th>작성자</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${myCampList}" var="campVo">
					<tr>
						<td>${campVo.camp_no}</td>
						<td width="450" id="td-title">
							<a href="/camp/selectReview/${campVo.camp_no}">${campVo.camp_address}</a>
						</td>
						<td>${campVo.recommend}</td>
						<td>${campVo.viewcnt}</td>
						<td>${campVo.user_id}</td>
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