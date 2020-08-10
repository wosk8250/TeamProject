<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../include/header.jsp" %>
<style>
	.d-lg-block {
		background-image: url("/resources/image/userUpdate.svg");
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
	$("#updatePw").submit(function () {
		var pw = $("#new_pw").val();
		var pw2 = $("#new_pw2").val();

		//비밀번호 일치 여부 확인
		if(pw != pw2){
			alert("비밀번호 불일치");
			return false;
		}
	});
	var msg = "${message}";
	if(msg == "fail_pw"){
		alert("현재 비밀번호를 정확히 입력하세요");
	}
});
</script>

<div class="container-fluid">
	<div class="row" style="margin-bottom: 30px;">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<ul class="nav nav-tabs nav-fill">
				<c:if test="${sessionScope.checkAdmin == 2}">
					<li class="nav-item">
						<a class="nav-link" id="mylink" href="/business/myCampList">내가 올린 캠핑장</a>
					</li>
				</c:if>
				<li class="nav-item">
					<a class="nav-link" id="mylink" href="/user/myReviewList">내가 작성한 후기</a>
				</li>
				<li class="nav-item select">
					<a class="nav-link" id="mylink" href="/user/profile">회원정보</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="mylink" href="/user/updateInfo">회원정보 수정</a>
				</li>
				<li class="nav-item">
					<a class="nav-link active" id="mylink-active" href="/user/updatePw">비밀번호 수정</a>
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
						<h1 class="h4 text-gray-900 mb-4">비밀번호 변경</h1>
					</div>
					<form class="user" id="updatePw" action="/user/updatePw" method="post">
					<table class="table table-boardered">
						<tr>
							<td> 현재 비밀번호 : </td>
							<td><input type="password" class="form-control" id="user_pw" name="user_pw" required></td>
						</tr>
						<tr>
							<td>새 비밀번호 : </td>
							<td><input type="password" class="form-control" id="new_pw" name="new_pw" maxlength="15" required></td>
						</tr>
						<tr>
							<td>새비밀번호 확인 : </td>
							<td><input type="password" class="form-control" id="new_pw2" name="new_pw2" maxlength="15" required></td>
						</tr>
					</table>
						<hr>
						<button type="submit" class="btn btn-primary btn-block">수정</button>
						<hr>
					</form>
					<div class="col-md-12">
						<div class="row">
							<div class="col-md-12">
								<a class="btn btn-primary btn-user btn-block" href="/camp/home">메인페이지로 이동</a>
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