<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<style>
.camping_content{
text-align: center;


}
.camping_img{
text-align: center;

}
.oriImg{
 
	width : 200px; 
 	height: auto; 
 	line-height : 100px;
 	margin-left:  200px;
	vertical-align: middle;
	margin-bottom:  100px;

}
.content_first{
	vertical-align: middle;
	 	margin-left:  200px;
}
.btn{
float:right;
margin-left:  20px;
}
.camping_pre{

	font-size: 20px;
	
}
#review_title {
	border-top: 3px solid;
	border-bottom : 1px solid;
	padding: 10px 30px;
}
</style>

<div class="container-fluid">
	<div class="row" style="color: black;" >
	<br>
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
		
			<h3 style="padding: 10px;">캠핑장 후기</h3>
			
			<div class="row" id="review_title">
				<div class="col-md-6">
						<h3>${reviewVo.review_title }</h3>
				</div>
				<div class="col-md-6" align="right">
								<a>${reviewVo.review_id}</a>
								<a>|</a>
								<a>${reviewVo.review_date}</a>
								<a>|</a>
								<a>${reviewVo.review_view}</a>
				</div>
			</div>
			<table class="table">

				<tbody>
				<tr>
					<td>
								<div class="camping_content">
									<pre class="camping_pre">${reviewVo.review_content}</pre>
								</div>
							<div class="camping_img">
								<c:forEach items="${fileNoListImg}" var="filesVo">
									<img src="/upload/displayImg?fileName=${filesVo.files }" alt="사진 미등록" class="oriImg"/>
								</c:forEach>

							</div>
					</td>
				</tr>

				</tbody>
			</table>
		</div>
		<div class="col-md-2">

		</div>

	</div>

								<a href="/camp/campingReviewList"class="btn btn-success" id= "btnList">목록</a>		
	<c:if test="${sessionScope.user_id==reviewVo.review_id}">
				<a  href="/camp/campingReviewModifyForm/${review_no}" class="btn btn-warning" id ="btnUpdate">수정</a>		
				<a  href="/camp/campingReviewDelete/${review_no}" class="btn btn-danger" id="btnDelete">삭제</a>	
	</c:if>
	
</div>



<%@ include file="../include/footer.jsp" %>