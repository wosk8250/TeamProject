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
				var textReview = $("#textReview").val();
				$("#adminReviewFrmPage > input[name=textReview]").val(textReview);
				$("#adminReviewFrmPage").submit();
				});													
			$("a.page-link").each(function(){
				var page =$(this).attr("href");
				if(page == "${pagingDto.page}"){
					$(this).parent().addClass("active");
					return;
				}
			});
			$("a.review_title").click(function(e){
				e.preventDefault();		
				var campingReview_no = $(this).attr("data-review_no");
				$("#adminReviewFrmPage").attr("action", $(this).attr("href"));
				$("#adminReviewFrmPage").submit();		
				
			});										
														
	});															
																
																
																
	</script>															
																
																
																
																
	<%@include file="../include/adminReviewFrmPage.jsp"%>															
																
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
									<td><a href="/camp/selectReview/${reviewVo.review_no}" class="review_title" data-review_no="${reviewVo.review_no}">[${reviewVo.review_campingname}]${reviewVo.review_title}</a></td>
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
			<div class="col-md-5">													
			</div>													
				<div class="col-md-4 text-center">												
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
				<div class="col-md-3">												
			</div>													
			</div>													
			</div>													
		</div>														
	</div>															
																
																
	<%@include file="../include/adminfooter.jsp"%>															
				