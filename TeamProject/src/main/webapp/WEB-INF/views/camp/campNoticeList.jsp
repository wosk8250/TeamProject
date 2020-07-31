
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h3>공지사항</h3>
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
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




<%@ include file="../include/footer.jsp" %>