<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
    <script src="/resources/vendor/jquery/jquery.js"></script>
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
	$("#searchReview").click(function(){
		var searchCnd = $("select[name=searchCnd]").val();
		var textReview = $("#textReview").val();
		$("#campingTipFrmPage > input[name=searchCnd]").val(searchCnd);
		$("#campingTipFrmPage > input[name=textReview]").val(textReview);
		$("#campingTipFrmPage").submit();
	});
	
	$("select[name=perPage]").change(function(){
		
		var perPage = $(this).val();
		var i = $("#campingTipFrmPage >input[name=perPage]").val(perPage);

		$("#campingTipFrmPage").submit();
	});

	
	
	$(".page-link").click(function(e){
		e.preventDefault();
// 		console.log("test");
		var page = $(this).attr("href").trim();
// 		console.log("page:", page);	
		$("#campingTipFrmPage > input[name=page]").val(page);
		$("#campingTipFrmPage").submit();
	}); 

	//현재 페이지 액티브
	$("a.page-link").each(function(){
		var page =$(this).attr("href");
		if(page == "${pagingDto.page}"){
			$(this).parent().addClass("active");
			return;
		}
	});
	
	$("a.tip_title").click(function(e){
		e.preventDefault();
		var campingTip_no =$(this).attr("data-campingtip_no");
		$("#campingTipFrmPage").attr("action", $(this).attr("href"));
		$("#campingTipFrmPage").submit();
		
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
					<td><h6><a href="/camp/singleContentsCampingTip/${CampingTipVo.campingtip_no}" class="tip_title" data-campingtip_no="${CampingTipVo.campingtip_no }">${CampingTipVo.campingtip_title}</a></h6>
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
						<option value="t"
							 <c:if test="${pagingDto.searchCnd == 't' }">selected</c:if>
						>제목</option>
						<option value="w"
						 <c:if test="${pagingDto.searchCnd == 'w' }">selected</c:if>
						>내용</option>
					</select>
					<input type="text" class="form-group" id="textReview" name ="textReview"
						 value="${pagingDto.textReview }"/>
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