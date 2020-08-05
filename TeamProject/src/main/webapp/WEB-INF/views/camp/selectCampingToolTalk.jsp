<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
 <c:when test="${sessionScope.checkBoard == 'admin'}">
 <%@ include file="../include/adminheader.jsp" %>
 </c:when>
 <c:when test="${sessionScope.checkBoard eq 'camp'}">
<%@ include file="../include/header.jsp" %>
 </c:when>
 </c:choose>
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
		
			<h3 style="padding: 10px;">캠핑 장비</h3>
			
			<div class="row" id="review_title">
				<div class="col-md-6">
						<h3>${campingTalkVo.campingtalk_title}</h3>
				</div>
				<div class="col-md-6" align="right">
									<a>${campingTalkVo.campingtalk_writer}</a>
								<a>|</a>
								<a>${campingTalkVo.campingtalk_date}</a>
								<a>|</a>
								<a>${campingTalkVo.campingtalk_view}</a>
				</div>
			</div>
			<table class="table">

				<tbody>
				<tr>
					<td>
								<div class="camping_content">
									<pre class="camping_pre">${campingTalkVo.campingtalk_content}</pre>
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
		<c:if test="${sessionScope.checkAdmin eq 9 }">
				<a href="/admin/campingTalkDelete?campingtip_no=${campingTipVo.campingtip_no}"class="btn btn-danger">삭제</a>				
 </c:if>
 
 <c:choose>
 <c:when test="${sessionScope.checkBoard eq 'admin'}">
				<a href="/admin/campingTalk"class="btn btn-success">목록</a>				
 </c:when>
 <c:when test="${sessionScope.checkBoard eq 'camp'}">
				<a href="/admin/campingTipModifyForm/${campingTipVo.campingtip_title}/${checkBoard}"class="btn btn-info">수정</a>				
				<a href="/camp/campingToolTalkList"class="btn btn-success" id= "btnList">목록</a>		
 </c:when>
 </c:choose>
		
		
		</div>
		<div class="col-md-2">

		</div>

	</div>

							

	
</div>

























<%@ include file="../include/footer.jsp" %>