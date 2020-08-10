
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
		text-align: center;
	}
	th {
		background-color: #4f6fcc25;
	}
</style>
<div class="container-fluid">
	<div class="row">
				<div class="col-md-1">
		</div>
		<div class="col-md-10">
		<h2>캠핑 수칙</h2>
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
				<c:forEach items="${list}" var="CampNoticeVo">
				
					<tr>
						<td>${CampNoticeVo.notice_no}</td>
						<td><a href="/camp/singleContentsCampNotice/${CampNoticeVo.notice_no}">${CampNoticeVo.notice_title}</a></td>
						<td>${CampNoticeVo.notice_writer}</td>
						<td>${CampNoticeVo.notice_date}</td>
						<td>${CampNoticeVo.notice_view}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
				</div>

		</div>
	</div>
</div>




<%@ include file="../include/footer.jsp" %>