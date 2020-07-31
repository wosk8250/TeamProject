<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<script src="/resources/vendor/jquery/jquery.js"></script>

<style>
.warting {
	padding :50px 20;
 }
.writer_sort{
	float:right;
}
#a_btn{
	float:right;
}
#btnReviewWriting{
	float:right;
}
.pagination{
	margin-left: auto;
	margin-right: auto;
}

</style>

<script>
$(function(){
	$(".page-link").click(function(e){
		e.preventDefault();
// 		console.log("test");
		var page = $(this).attr("href").trim();
// 		console.log("page:", page);	
		$("#reviewFrmPage > input[name=page]").val(page);
		$("#reviewFrmPage").submit();
	});
	$("select[name=perPage]").change(function(){
		var perPage = $(this).val();
// 	console.log("perPage:", perPage);
	var i = $("#reviewFrmPage > input[name=perPage]").val(perPage);
	$("#reviewFrmPage").submit();
	});
	$("#searchReview").click(function(){
		var reviewTitle = $("#textReview").val();
		console.log("reviewTitle:",reviewTitle);
		location.href="/camp/campingReviewList?review_title=" + reviewTitle;
	});
});	
</script>





<%@ include file = "../include/campingReviewFrmPage.jsp" %>
<div class="container-fluid">
	<div class="row">
				<div class="col-md-2">
				<h3>캠핑후기</h3>
				</div>
				<div class="col-md-5"></div>
				<div class="col-md-5"></div>
	</div>
</div>
<div class="container-fluid">
	<div class="row">
				<div class="col-md-4">
									<select name="perPage" class="form-inline">
						<c:forEach begin="5" end="30" step="5" var="i">
							<option value="${i}"
								<c:if test="${i == pagingDto.perPage}">selected</c:if>
								>${i}줄씩 보기</option>
						</c:forEach>
					</select>	
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

<div class="container-fluid">
	<div class="row">
				<div class="col-md-12">

			<table class="table" >

				<tbody>

				<c:forEach items="${list}" var="reviewVo">

					<tr>
						<td  colspan="2">
							<img src="/upload/displayImg?fileName=${reviewVo.review_img}" alt="사진 미등록"/>
						</td>
	
						<td colspan="2">
						<div class="warting">
							<h6><a href="/camp/selectReview/${reviewVo.review_no}">[${reviewVo.review_campingname}]${reviewVo.review_title}</a></h6>
							<p>${reviewVo.review_content } <br/>
	
							
							</p>
					</div>
						<div class="writer_sort" >
						<a>${reviewVo.review_id}</a>
						<a>|</a>
						<a>${reviewVo.review_date}</a>
						<a>|</a>
						<a>${reviewVo.review_view}</a>
				</div>
						</td>
	
					</tr>
				<tr>
			
				</c:forEach>
				</tbody>
			</table>
				</div>

	</div>
</div>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<a href="/camp/campingReviewWritingForm"class="btn btn-primary" id="a_btn" >
				글쓰기
			</a>
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

<%@ include file="../include/footer.jsp" %>