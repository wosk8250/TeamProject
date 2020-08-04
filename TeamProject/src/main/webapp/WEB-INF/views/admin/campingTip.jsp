<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="../include/adminheader.jsp" %>
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
			$("#adminCampingTipFrmPage > input[name=page]").val(page);
			$("#adminCampingTipFrmPage").submit();
		});

		$("select[name=perPage]").change(function() {
			var perPage = $(this).val();
			var i = $("#adminCampingTipFrmPage > input[name=perPage]").val(perPage);
			$("#adminCampingTipFrmPage").submit();
		});
		$(".searchCampingTip").click(function() {
			var campingtip_title = $("#textCampingTip").val();
			location.href="/admin/campingTip?campingtip_title=" + campingtip_title;
		});


	});
</script>

<%@include file ="../include/adminCampingTipFrmPage.jsp" %>

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
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="campingTipVo">
					<tr>
						<td>${campingTipVo.campingtip_no}</td>
						<td>
							<img src="/upload/displayImg?fileName=${campingTipVo.campingtip_img}" alt="사진등록" />
						</td>
						<td><a href="/camp/singleContentsCampingTip/${campingTipVo.campingtip_no}/${checkBoard}">${campingTipVo.campingtip_title}</a></td>
						<td><a href="/admin/campingTipModifyForm?campingtip_title=${campingTipVo.campingtip_title}" class="btn btn-info" >수정</a></td>
						<td><a href="/admin/campingTipDelete?campingtip_no=${campingTipVo.campingtip_no}" class="btn btn-warning">삭제</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<input type="text" class="form-group" id="textCampingTip"/>
					<button class="btn btn-success searchCampingTip">검색</button>
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
	<a class="btn btn-primary" href="/admin/campingTipForm">작성</a>
</div>
    


<%@include file="../include/adminfooter.jsp"%>