<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/topImgHeader.jsp" %>
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

<style>
	.d-lg-block {
		background-image: url("/resources/image/profile.svg");
		background-repeat: no-repeat;
		background-position: center;
		background-size: 200px;
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
	//메시지 띄우기
	var msg = "${message}";
	console.log(msg);
	if(msg == "success"){
		alert("비밀번호가 변경되었습니다");
	} else if(msg == "updateInfo"){
		alert("프로필 수정 완료!");
	};
	
});
</script>

</head>
<div class="container-fluid">
	<div class="row" style="margin-bottom: 30px;">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<ul class="nav nav-tabs nav-fill">
				<li class="nav-item">
					<a class="nav-link" id="mylink" href="/user/myReviewList">내가 작성한 후기</a>
				</li>
				<li class="nav-item select">
					<a class="nav-link active" id="mylink-active" href="/user/profile">회원정보</a>
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
</div>

<div class="container">
	<div class="card o-hidden border-0 shadow-lg my-5">
		<div class="card-body p-0">
			<!-- Nested Row within Card Body -->
			<div class="row">
				<div class="col-lg-5 d-none d-lg-block"></div>
				<div class="col-lg-7">
					<div class="p-5">
						<div class="text-center">
							<h1 class="h4 text-gray-900 mb-4">프로필</h1>
						</div>
						<table class="table table-boardered">
						<tr>
							<td> 아이디 : </td>
							<td><input type="text" class="form-control" placeholder="아이디" value="${userVo.user_id}" readonly></td>
						</tr>
						<tr>
							<td>전화번호 : </td>
							<td><input type="text" class="form-control" placeholder="전화번호" value="${userVo.user_phone}" readonly></td>
						</tr>
						<tr>
							<td>이메일 : </td>
							<td><input type="email" class="form-control" placeholder="이메일" value="${userVo.user_email}" readonly></td>
						</tr>
						<tr>
							<td>이름 : </td>
							<td><input type="text" class="form-control" placeholder="이름" value="${userVo.user_name}" readonly></td>
						</tr>
						</table>
						<hr>
						<div class="row">
							<div class="col-md-6">
								<a href="/user/updateInfo" class="btn btn-warning btn-user btn-block">프로필 수정</a>
							</div>
							<div class="col-md-6">
								<a href="/user/secession" class="btn btn-danger btn-user btn-block">회원 탈퇴 바로가기</a>
							</div>
						</div>
						<div style="margin-top: 10px; text-align: right;">
							<a id="modal-552853" href="#modal-container-552853" role="button" class="btn btn-secondary btn-sm" data-toggle="modal">벌점 조회</a>
							<div class="modal fade" id="modal-container-552853" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="myModalLabel">나의 벌점</h5> 
											<button type="button" class="close" data-dismiss="modal">
												<span aria-hidden="true">×</span>
											</button>
										</div>
										<div class="modal-body">
											<table class="table table-hover" style="text-align: center;">
												<thead>
													<tr>
														<th>내용</th>
														<th>점수</th>
														<th>날짜</th>
													</tr>
												</thead>
												<tbody>
												<c:forEach items="${demeritList}" var="demeritVo">
													<tr>
														<td>${demeritVo.demerit_content}</td>
														<td>${demeritVo.demerit_value}</td>
														<td>${demeritVo.demerit_date}</td>
													</tr>
												</c:forEach>
												</tbody>
											</table>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>