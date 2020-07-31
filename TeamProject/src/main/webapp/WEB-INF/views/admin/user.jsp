<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/adminheader.jsp"%>
<style>
button.demeritBtn {
	margin: 10px;
}

.dropdown-menu {
	width: 400px !important;
	height: 600px !important;
}
</style>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>
	$(function() {
		var msg = "${msg}"
		if (msg == "delete") {
			alert("유저 삭제완료");
		}

		$(".page-link").click(function(e) {
			e.preventDefault();
			var page = $(this).attr("href").trim();
			$("#adminUserFrmPage > input[name=page]").val(page);
			$("#adminUserFrmPage").submit();
		});

		$("select[name=perPage]").change(function() {
			var perPage = $(this).val();
			var i = $("#adminUserFrmPage > input[name=perPage]").val(perPage);
			$("#adminUserFrmPage").submit();
		});

		$(".demeritBtn").click(
				function() {
					var demerit_content = $(this).parent().find("select")
							.select().val();
					var user_id = $(this).attr("data-userId");
					location.href = "/admin/userDemerit/" + user_id + "/"
							+ demerit_content;

				});
		$(".searchId").click(function() {
			 var user = $("#textId").val();
			 location.href="/admin/user?user_id="+user;


	});
});
</script>


<%@include file="../include/adminUserFrmPage.jsp"%>

<div class="container-fluid">
	<div class="row">

		<div class="col-md-12">
			<select name="perPage" class="form-inline">
				<c:forEach begin="5" end="30" step="5" var="i">
					<option value="${i}"
						<c:if test="${i == pagingDto.perPage}">selected</c:if>>${i}줄씩
						보기</option>
				</c:forEach>
			</select>
			<table class="table">
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>휴대폰번호</th>
						<th>벌점</th>
					</tr>
				</thead>
				<tbody id="userTody">
					<c:forEach items="${list}" var="userVo" varStatus="vs">
										<tr data-demerit="${userVo.admin}">

							<td>${userVo.user_id}</td>
							<td>${userVo.user_name}</td>
							<td>${userVo.user_phone}</td>
							<td>${userVo.user_demerit}</td>


							<td>
							<a id="modal-129046" href="#modal-container-129046${vs.index}"
								role="button" class="btn btn-info btnModal"
								data-user="${userVo.user_id}" data-toggle="modal">벌점내역</a>

								<div class="modal fade" id="modal-container-129046${vs.index}"
									role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="myModalLabel">${userVo.user_id} 벌점내역</h5>
												<button type="button" class="close" data-dismiss="modal">
													<span aria-hidden="true">×</span>
												</button>
											</div>
											<div class="modal-body">
												<table style="color: gray;">
													<thead>
														<tr>
															<th>내용</th>
															<th>벌점</th>
															<th>날짜</th>
														</tr>
													</thead>
													<tbody id="tbody">
														<c:forEach items="${demeritList}" var="demeritVo" >
															<c:if test="${demeritVo.user_id eq userVo.user_id}">
																<tr>
																	<td>${demeritVo.demerit_content}</td>
																	<td>${demeritVo.demerit_value}</td>
																	<td>${demeritVo.demerit_date}</td>
																</tr>
															</c:if>
														</c:forEach>
													</tbody>
												</table>





											</div>
											<div class="modal-footer">

												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">닫기</button>
											</div>
										</div>

									</div>

								</div></td>
							<td><select class="selectpicker">
									<c:forEach items="${demeritContentList}" var="demeritCodeVo">
										<option>${demeritCodeVo.demerit_content }
									</c:forEach>
							</select> <input type="button" data-userId="${userVo.user_id}"
								class="btn btn-dark demeritBtn" value="벌점" /></td>
							</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<input type="text" class="form-group" id="textId"/>
					<button class="btn btn-success searchId">검색</button>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12 text-center">
				<nav>
					<ul class="pagination">
						<c:if test="${pagingDto.startPage != 1}">
							<li class="page-item"><a class="page-link"
								href="${pagingDto.startPage - 1}">이전</a></li>
						</c:if>
						<c:forEach begin="${pagingDto.startPage}"
							end="${pagingDto.endPage}" var="page">
							<li class="page-item"><a class="page-link" href="${page}">${page}</a>
							</li>
						</c:forEach>
						<c:if test="${pagingDto.endPage < pagingDto.totalPage}">
							<li class="page-item"><a class="page-link"
								href="${pagingDto.endPage + 1}">다음</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</div>





<%@include file="../include/adminfooter.jsp"%>
