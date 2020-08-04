<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<script src="/resources/vendor/jquery/jquery.js"></script>

<script>
$(function() {
	$("#btnRecommend").click(function() {
		
		var user_id = "${sessionScope.user_id}";
		var camp_no = "${campVo.camp_no}";
		console.log(user_id);
		console.log(camp_no);
		if (user_id == "") {
			location.href = "/user/login";
			return;
		} 
		var url = "/camp/recommend?user_id=" + user_id + "&camp_no="+camp_no;
		
		var sendData = {
			"camp_no" : camp_no,
			"user_id" : user_id
		}
		
		console.log(sendData);
		$.ajax({
			"type" : "post",
			"url" : url,
			"dataType" : "text",
			"data"	: JSON.stringify(sendData),
			"headers" : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "post"
			},
			"success" : function(rData) {
				console.log(rData);
				
				if (rData == "success") {
					alert("추천 되었습니다.");
				} else if (rData == "fail") {
					alert("이미 추천되었습니다.")
				}
			}
		});
		
	});
});
</script>
<div class="container-fluid">
<%-- ${campVo} --%>
<%-- ${CampRecommendVo} --%>
	<div class="row">
		<div class="col-md-4">
		<h2>${campVo.camp_name}</h2>
			<td><img width="400" height="400"
				src="/resources/image/1594178025406.jpg"></td>
		</div>
		<div class="col-md-4">
			<table class="table" id="recommendTable" name="recommendTable">
				<thead>
					<tr>
						<th>주소</th>
						<td>${campVo.camp_address}</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>문의처</th>
						<td>${campVo.camp_phone}</td>
					</tr>
					<tr>
						<th>캠핑장 유형</th>
						<td>${campVo.camp_content}</td>
					</tr>
					<tr>
						<th>운영기간</th>
						<td>365일</td>
					</tr>
					<tr>
						<th>운영일</th>
						<td>${campVo.operatingday}</td>
					</tr>
					<tr>
						<th>추천 수</th>
						<td>${campVo.recommend}</td>
					</tr>
					<tr>
						<th>홈페이지 바로가기</th>
						<td><a href="https://www.gocamping.or.kr/">홈페이지</a></td>
						<button class="btn btn-sm btn-success" type="button" id="btnRecommend" name="btnRecommend">추천하기</button>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="col-md-4"></div>
	</div>
	<div class="row">
		<div class="col-md-12"></div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr>
						<th>
							<h2>캠핑장 소개</h2>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><img width="300" height="300"
							src="/resources/image/1594178025406.jpg"></td>
						<td>
						<td><img width="300" height="300"
							src="/resources/image/1594178025406.jpg"></td>
						</td>
						<td>
						<td><img width="300" height="300"
							src="/resources/image/1594178025406.jpg"></td>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>


<%@ include file="../include/footer.jsp"%>