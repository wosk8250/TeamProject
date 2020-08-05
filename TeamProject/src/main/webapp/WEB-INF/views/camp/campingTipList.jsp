<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<style>
.totaltext {
	text-align: center;
}

.admin_sort {
	float: right;
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
		var i = $("#reviewFrmPage >input[name=perPage]").val(perPage);
		$("#reviewFrmPage").submit();
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
				<h3>캠핑장 수칙</h3>
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

				<c:forEach items="${list}" var ="CampingTipVo">

					<tr>
						<td  colspan="2">
							<img src="/upload/displayCampingImg?fileName=${CampingTipVo.campingtip_img}" alt="사진 등록"/>
						</td>
	
						<td colspan="2">
						<div class="warting">
							<h6><a href="/camp/singleContentsCampingTip/${CampingTipVo.campingtip_no}">${CampingTipVo.campingtip_title}</a></h6>
							<p>${CampingTipVo.campingtip_content} <br/>
	
							
							</p>
					</div>
						<div class="admin_sort" >
						<a>${CampingTipVo.campingtip_writer}</a>
						<a>|</a>
						<a>${CampingTipVo.campingtip_date}</a>
						<a>|</a>
						<a>${CampingTipVo.campingtip_view}</a>
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




<%@ include file="../include/footer.jsp"%>