<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/adminheader.jsp"%>





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
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script> 
	<script>
	$(function() {

		var msg = "${msg}"
		if (msg == "delete") {
			alert("게시글 삭제완료");
		}

		$(".page-link").click(function(e) {
			e.preventDefault();
			var page = $(this).attr("href").trim();
			$("#adminReviewFrmPage > input[name=page]").val(page);
			$("#adminReviewFrmPage").submit();
		});

		$("select[name=perPage]").change(
				function() {
					var perPage = $(this).val();
					var i = $("#adminReviewFrmPage > input[name=perPage]").val(
							perPage);
					$("#adminReviewFrmPage").submit();
				});

		$(".searchReview").click(function() {
			var reviewTitle = $("#textReview").val();
			location.href = "/admin/review?review_title=" + reviewTitle;
		});
		
		//-----------------예약 달력------------------
		var disabledDays = ${date};
		console.log(disabledDays);
		$( "#startDate" ).datepicker({
		    nextText: '다음 달',
		    prevText: '이전 달', 
		    dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
		    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
		    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		    dateFormat: "yy-mm-dd",
		    minDate: 0,                       // 선택할수있는 최소날짜, ( 0 : 오늘 이후 날짜 선택 불가)
		   beforeShowDay: disableAllTheseDays,
		    onClose: function( selectedDate ) {    
		        $("#endDate").datepicker( "option", "minDate", selectedDate );
		        $("#endDate").focus();
		    }    
		});

		$('#startDate').datepicker('setDate', '+0');

		function disableAllTheseDays(date) { 
			   var m = date.getMonth(), d = date.getDate(), y = date.getFullYear(); 
			   for (i = 0; i < disabledDays.length; i++) { 
			       if($.inArray(y + '-' +(m+1) + '-' + d,disabledDays) != -1) { 
			           return [false]; 
			       } 
			   } 
			   return [true]; 
			}

		$( "#endDate" ).datepicker({
		    nextText: '다음 달',
		    prevText: '이전 달', 
		    dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
		    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
		    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		    dateFormat: "yy-mm-dd",
		    minDate: 0,   
		    beforeShowDay: disableAllTheseDays,
		    onClose: function( selectedDate ) {    

		        $("#startDate").datepicker( "option", "maxDate", selectedDate );
		        var url = "/admin/reservationDateConfirm";
		        var sendData = {"startdate" : $("#startDate").val(), "enddate" : $("#endDate").val()};
		        $.ajax({
		        	"type" : "post",
		        	"url" : url,
		        	"dataType" : "text",
		        	"data" : JSON.stringify(sendData),
					"headers" : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "post"
					},
					"success" :function(rData){
						
						if(rData == "false"){
							alert("예약을 할 수 없습니다");
							location.href="/admin/review";
						}
						
					}
		        	
		        });
		        	
		        
		        
		        
		        
		    }    
		});   

		$("#startDate").focusout(function() {

		});

		function disableAllTheseDays(date) {
		var m = date.getMonth(), d = date.getDate(), y = date.getFullYear();
		for (i = 0; i < disabledDays.length; i++) {
		  if($.inArray(y + '-' +(m+1) + '-' + d,disabledDays) != -1) {
		      return [false];
		  }
		}
		return [true];
		}
		
		
});
		
		
	
</script>




<%@include file="../include/adminReviewFrmPage.jsp"%>

<div class="container-fluid">
	<div class="row">
	<div class="col-md-1">
		</div>
		<div class="col-md-10">


<form role="form" method="post" action="/admin/reservationDate">
<div style="margin: 20px">
입실일
<input type="text" id=startDate name="startdate">
퇴실일
<input type="text" id="endDate" name="enddate">
</div>
<button type="submit" id="reservationBtn">예약</button>
</form>


			<select name="perPage" class="form-inline">
				<c:forEach begin="5" end="30" step="5" var="i">
					<option value="${i}"
						<c:if test="${i == pagingDto.perPage}">selected</c:if>>${i}줄씩
						보기</option>
				</c:forEach>
			</select>
			<h2>캠핑장 후기</h2>
			<hr>
			<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>글번호</th>
						<th>이미지</th>
						<th>제목</th>
						<th>아이디</th>
						<th>등록일</th>
						<th>캠핑장</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="reviewVo">
						<c:if test="${reviewVo.review_admin == 0}">
							<tr>
								<td>${reviewVo.review_no}</td>
								<td><img
									src="/upload/displayImg?fileName=${reviewVo.review_img}"
									alt="사진없음" /></td>
								<td><a href="/camp/selectReview/${reviewVo.review_no}">${reviewVo.review_title}</a></td>
								<td>${reviewVo.review_id}</td>
								<td>${reviewVo.review_date}</td>
								<td>${reviewVo.review_campingname}</td>

							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
			</div>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<input type="text" class="form-group" id="textReview" />
					<button class="btn btn-success searchReview">검색</button>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
		<div class="container-fluid">
		<div class="row">
		<div class="col-md-1">
		</div>
			<div class="col-md-10 text-center">
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
			<div class="col-md-1">
		</div>
		</div>
		</div>
	</div>
</div>


<%@include file="../include/adminfooter.jsp"%>