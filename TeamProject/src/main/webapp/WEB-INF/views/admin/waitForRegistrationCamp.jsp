<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="../include/adminheader.jsp" %>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>
$(function() {

	$(".page-link").click(function(e) {
		e.preventDefault();
		var page = $(this).attr("href").trim();
		$("#campFrmPage > input[name=page]").val(page);
		$("#campFrmPage").submit();
	});
	
	$("select[name=perPage]").change(function() {
		var perPage = $(this).val();
		var i = $("#campFrmPage > input[name=perPage]").val(perPage);
	 	$("#campFrmPage").submit();
	});
	
	$(".searchCamp").click(function() {
		var campName = $("#textCamp").val();
		location.href="/admin/camp?camp_name=" + campName;
	});

	$(".modalScreenBtn").click(function() {
		var modalBody = $(this).parent().find($(".modal-body"));
		modalBody.find("div").remove();
		modalBody.append('<div><textarea class="form-control" style="height: 500px; width: 450px; resize: none;" ></textarea></div>');
		
	});
	
	$(".modalBtn").one("click",function() {
		var madalBody = $(this).parent().parent().find($(".modal-body"));
		var email = $(this).parent().parent().find($(".modal-body")).attr("data-email");
		var context = $(this).parent().parent().find($("textarea")).val();

		var url = "/admin/rejectRegistCamp/"+email+"/"+context
		$.get(url,function(e){
	 		$(".modal-body > div" ).remove();
	 		$(".modalBtn").remove();
	 		$(".btn-secondary").text("확인");
	 		$(".modal-body").append("<div>메일 전송 완료</div>");
		});
		
		
	});
});

</script>

<%@include file ="../include/adminCampFrmPage.jsp" %>

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
						<th>캠핑장 이름</th>
						<th>지역</th>
						<th>시&구</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="campVo" varStatus="vs">
					<tr>
						<td>${campVo.camp_no}</td>
						<td>
							<img src="/upload/displayImg?fileName=${campVo.thumbnail}" alt="사진 미등록"/>
						</td>
						<td>${campVo.camp_name}</td>
						<td>${campVo.camp_location}</td>
						<td>${campVo.camp_area}</td>
						<td><a href="/admin/registCamp/${campVo.camp_no}" class="btn btn-warning">등록</a></td>
						<td>
									<a id="modal-602868" href="#modal-container-602868${vs.index}"
										role="button" class="btn btn-warning modalScreenBtn" data-toggle="modal">거절모달
										</a>

									<div class="modal fade" id="modal-container-602868${vs.index}"
										role="dialog" aria-labelledby="myModalLabel"
										aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="myModalLabel">${campVo.user_email}
													</h5>
													<button type="button" class="close" data-dismiss="modal">
														<span aria-hidden="true">×</span>
													</button>
												</div>
												<div data-email="${campVo.user_email}" class="modal-body">
													
												</div>
												<div class="modal-footer">

													<button type="button" class="btn btn-primary modalBtn">
														보내기</button>
													<button type="button" class="btn btn-secondary"
														data-dismiss="modal">닫기</button>
												</div>
											</div>

										</div>

									</div>

						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<input type="text" class="form-group" id="textCamp"/>
					<button class="btn btn-success searchCamp">검색</button>
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