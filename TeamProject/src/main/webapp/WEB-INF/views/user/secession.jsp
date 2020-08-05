<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<style>
<!--
 .container-fluid {
 	color: black;
 }
 #id {
 	color: rgb(34,74,190);
 }
 div.button{
   margin: auto;
   width: 50%;
}
div.button button{
   padding: 5px;
   width: 100%;
   font-size: 18px;
}
-->
</style>
<script>
$(function () {
	//체크박스에 체크하면 탈퇴버튼 활성화
	$("#checkbox").change(function () {
		if($(this).is(":checked")){
			$("#btnSecssion").attr("disabled",false);
		} else {
			$("#btnSecssion").attr("disabled",true);
		}
	});
});
</script>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>회원 탈퇴안내</h2>
				<p>회원탈퇴를 신청하기 전에 안내 사항을 꼭 확인해주세요.</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
		<table>
			<tr>
				<td valign="top"><i class="fa fa-check" aria-hidden="true"></i>&nbsp;</td>
				<td>
					<h6>사용하고 계신 아이디(<b id="id">${sessionScope.user_id}</b>)는 탈퇴할 경우 재사용 및 복구가 불가능합니다.</h6>
					<p>탈퇴한 아이디는 본인과 타인 모두 재사용 및 복구가 불가하오니 신중하게 선택하시기 바랍니다</p>
					<hr>
				</td>
			</tr>
			<tr>
				<td valign="top"><i class="fa fa-check" aria-hidden="true"></i>&nbsp;</td>
				<td>
					<h6>탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두 삭제됩니다.</h6>
					<p>회원 정보는 삭제되며, 삭제된 데이터는 복구가 되지 않습니다.</p>
					<hr>
				</td>
			</tr>
			<tr>
				<td valign="top"><i class="fa fa-check" aria-hidden="true"></i>&nbsp;</td>
				<td>
					<h6>탈퇴 후에도 게시판형 서비스에 등록한 게시물은 그대로 남아 있습니다.</h6>
					<p>캠핑후기, 캠핑이야기에 올린 게시글과 댓글은 그대로 남아 있습니다.</p>
					<p>삭제를 원하는 게시글이 있다면 반드시 탈퇴 전 삭제하시기 바랍니다.</p>
					<p>탈퇴 후에는 회원정보가 삭제되어 본인 여부를 확인할 수 있는 방법이 없어, 게시글을 임의로 삭제해드릴 수 없습니다.</p>
					<hr>
				</td>
			</tr>
		</table>
			<p>탈퇴 후에는 아이디 (<b id="id">${sessionScope.user_id}</b>)로 다시 가입할 수 없으며 아이디와 데이터는 복구할 수 없습니다.</p>
			<p>게시판형 서비스에 남아 있는 게시글은 탈퇴 후 삭제할 수 없습니다.</p>
			<p>또한, 네이버 아이디를 사용해 다른 서비스에 로그인 할 수 없게 됩니다.</p>
			<br><hr><br>
			<input type="checkbox" id="checkbox">
			<label><b>안내 사항을 모두 확인하였으며, 이에 동의합니다.</b></label>
			<br>
		</div>
		<div class="col-md-2">
		</div>
	</div>
		<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-8">
							<form class="user" id="secessionUser" action="/user/secession" method="post">
				<table class="table table-boardered">
					<tr>
						<td> 아이디 : </td>
						<td>
							<label>${sessionScope.user_id}</label>
							<input type="hidden" class="form-control" id="user_id" name="user_id" value="${sessionScope.user_id}">
						</td>
					</tr>
					<tr>
						<td>비밀번호 : </td>
						<td><input type="password" class="form-control" id="user_pw" name="user_pw" placeholder="비밀번호" required></td>
					</tr>
				</table>
					<hr>
					<div class="button">
						<button type="submit" id="btnSecssion" class="btn btn-danger" disabled="disabled" >탈퇴</button>
					</div>
				</form>
				</div>
				<div class="col-md-2">
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>