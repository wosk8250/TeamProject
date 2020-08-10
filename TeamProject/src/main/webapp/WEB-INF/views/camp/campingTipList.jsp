<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

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
<script>
$(function(){
	$(".page-link").click(function(e){
		e.preventDefault();
// 		console.log("test");
		var page = $(this).attr("href").trim();
// 		console.log("page:", page);	
		$("#reviewTipFrmPage > input[name=page]").val(page);
		$("#reviewTipFrmPage").submit();
	}); 
	$("select[name=perPage]").change(function(){
		
		var perPage = $(this).val();
		var i = $("#reviewTipFrmPage >input[name=perPage]").val(perPage);

		$("#reviewTipFrmPage").submit();
	});
	$("#searchReview").click(function(){
		
		var TipTitle = $("#textReview").val();
		console.log("TipTitle:",TipTitle);
	location.href="/camp/campingTipList?campingtip_title=" + TipTitle;
	});
	
});
</script>

	


<%@ include file = "../include/campingTipFrmPage.jsp" %>
<div class="container-fluid">
	<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-5"></div>
				<div class="col-md-5"></div>
	</div>
</div>


<div class="container-fluid">
	<div class="row">
	
				<div class="col-md-1">
		</div>
				<div class="col-md-10">
					<select name="perPage" class="form-inline">
		<c:forEach begin="5" end="30" step="5" var="i">
			<option value="${i}"
				<c:if test="${i == pagingDto.perPage}">selected</c:if>>${i}줄씩
				보기</option>
		</c:forEach>
	</select>
				
				
				
	<h2>캠핑 수칙</h2>
			<hr>
		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th></th>
						<th width="450">제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
				</thead>
				
				<tbody>

				<c:forEach items="${list}" var ="CampingTipVo">

					<tr>
					<td>${CampingTipVo.campingtip_no}</td>
					<td><img src="/upload/displayCampingImg?fileName=${CampingTipVo.campingtip_img}" alt="사진 등록"/>
					</td>
					<td><h6><a href="/camp/singleContentsCampingTip/${CampingTipVo.campingtip_no}">${CampingTipVo.campingtip_title}</a></h6>
					</td>
					<td>${CampingTipVo.campingtip_writer}</td>
					<td>${CampingTipVo.campingtip_date}</td>
					<td>${CampingTipVo.campingtip_view}</td>
					</tr>
				<tr>
			
				</c:forEach>
				</tbody>
			</table>
			</div>
				</div>
				<div class="col-md-1">
		</div>

	</div>
</div>
<div class="container-fluid">
	<div class="row">
	<div class="col-md-1"></div>
		<div class="col-md-10"></div>
		<div class="col-md-1"></div>
	</div>
	<div class="container-fluid">
	<div class="row">
				<div class="col-md-4">
								
				</div>
				<div class="col-md-4">
					<select name="searchCnd" id="searchCnd" class="form-group" title="검색조건선택">
						<option value="0">제목</option>
					</select>
					<input type="text" class="form-group" id="textReview"/>
					<button class="btn btn-success" id="searchReview">검색</button>
				</div>
				<div class="col-md-4"></div>
	</div>
</div>
</div>


		<div class="container-fluid">
			<div class="row">
				<div class="col-md-5"></div>
				<div class="col-md-4">
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
				<div class="col-md-3"></div>
			</div>
		</div>
		
		<div class="col-md-12 text-center">

		</div>



<%@ include file="../include/footer.jsp"%>