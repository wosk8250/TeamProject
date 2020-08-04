<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="../include/adminheader.jsp" %>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>
	$(function() {
		$("#searchBtn").click(function() {
			var board = $("#textBoard").val();
			var textTitle = $("#textTitle").val();
			location.href = "/admin/deleteList/"+board+"/"+textTitle;
		});
		$(".page-link").click(function(e) {
			e.preventDefault();
			var page = $(this).attr("href").trim();
			$("#campFrmPage > input[name=page]").val(page);
			$("#campFrmPage").submit();
		});
		
		$("select[name=perPage]").change(function() {
			var perPage = $(this).val();
			var i = $("#deleteListFrmPage > input[name=perPage]").val(perPage);
		 	$("#deleteListFrmPage").submit();
		});
		
	});


</script>

<%@include file ="../include/adminDeleteListFrmPage.jsp" %>

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
						<th>게시판이름</th>
						<th>이미지</th>
						<th>글제목</th>
						<th>작성자</th>
						<th>날짜</th>
						
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${campingTipVoList}" var="CampingTipVo">
					<tr>
					<td>${CampingTipVo.table_name}</td>
					<td><img src="/upload/displayImg?fileName=${CampingTipVo.campingtip_img}" alt="사진없음"/></td>
					<td><a href="/camp/singleContentsCampingTip/${CampingTipVo.campingtip_no}/admin">${CampingTipVo.campingtip_title}</a></td>
					<td>${CampingTipVo.campingtip_writer}</td>
					<td>${CampingTipVo.campingtip_date}</td>
					</tr>
				</c:forEach>
				<c:forEach items="${campingTalkList}" var="CampingTalkVo">
					<tr>
					<td>${CampingTalkVo.table_name}</td>
					<td><img src="/upload/displayImg?fileName=${CampingTalkVo.campingtalk_img}" alt="사진없음"/></td>
					<td>${CampingTalkVo.campingtalk_title}</td>
					<td>${CampingTalkVo.campingtalk_writer}</td>
					<td>${CampingTalkVo.campingtalk_date }</td>
					</tr>
				</c:forEach>
				<c:forEach items="${faqList}" var="FaqVo">
					<tr>
					<td>${FaqVo.table_name}</td>
					<td></td>
					<td>${FaqVo.faq_title}</td>
					<td>${FaqVo.faq_writer}</td>
					<td>${FaqVo.faq_date}</td>
					</tr>
				</c:forEach>
				<c:forEach items="${noticeList}" var="CampNoticeVo">
					<tr>
					<td>${CampNoticeVo.table_name}</td>
					<td></td>
					<td>${CampNoticeVo.notice_title }</td>
					<td>${CampNoticeVo.notice_writer }</td>
					<td>${CampNoticeVo.notice_date }</td>
					</tr>
				</c:forEach>
				<c:forEach items="${reviewList}" var="ReviewVo">
					<tr>
					<td>${ReviewVo.table_name }</td>
					<td><img src="/upload/displayImg?fileName=${ReviewVo.review_img}" alt="사진없음"/></td>
					<td>${ReviewVo.review_title }</td>
					<td>${ReviewVo.review_id }</td>
					<td>${ReviewVo.review_date }</td>
					</tr>
				</c:forEach>
				
				</tbody>
			</table>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<select id="textBoard" name="board" >
						<option hidden="true" selected="selected">선택하세요
						<option>캠핑 후기
						<option>캠핑 이야기
						<option>공지사항
						<option>캠핑 수칙
						<option>자주 묻는 질문
					</select>
					<input type="text" name="textTitle" class="form-group" id="textTitle"/>
					<button id="searchBtn" type="button" class="btn btn-success searchCamp">검색</button>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
		
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


<%@include file="../include/adminfooter.jsp"%>