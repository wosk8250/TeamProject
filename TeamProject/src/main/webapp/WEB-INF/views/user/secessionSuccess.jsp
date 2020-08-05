<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<style>
 .container-fluid {
	color: black;
	text-align: center;
 }
</style>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
			<div class="jumbotron">
				<img alt="camp" src="/resources/image/us.svg" width="200" height="200">
				<h1>회원 탈퇴 완료</h1>
				<p>Camping Club 회원 탈퇴가 완료되었습니다.</p>
			</div>
		</div>
		<div class="col-md-2">
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
		<hr>
			<h5>그동안 Camping Club을 이용해 주셔서 감사합니다</h5>
			<p>더 좋은 서비스를 제공하기 위해서 열심히 노력 하겠습니다.</p>
			<p>
				<a class="btn btn-primary" href="/user/logout">확인</a>
			</p>
		</div>
		<div class="col-md-2">
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>