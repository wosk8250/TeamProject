<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script src="/resources/vendor/jquery/jquery.js"></script>
 <style>
 .btn{
float:right;
margin-left:  20px;
margin-bottom:  200px;
}	
#reviewTip_title {
	border-top: 3px solid;
	border-bottom : 1px solid;
	padding: 10px 30px;
} 
.campingTip_content{
text-align: center;
position:  relative;

}
.campingTip_img{
text-align: center;
position:  relative;

}
.oriImg{
 
	width : 200px; 
 	height: auto; 
  	line-height : 100px; 
    left:50%;
    top:50%;
    margin-left:150px;
    margin-right:150px;
    margin-top:100px;
	vertical-align: middle;
	margin-bottom:  100px; 

}
 </style>
 <script>
 $(function(){
		$("#campTip").click(function(e){
			e.preventDefault();
//	 		console.log("클릭");
			if("${sessionScope.admin}" == "camp"){
				$("#campingTipFrmPage").submit();
			}else{
				$("#adminCampingTipFrmPage").submit();
			}
			
			
		});
	 });
 </script>
 
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:choose>
 <c:when test="${sessionScope.checkBoard == 'admin'}">
 <%@ include file="../include/adminheader.jsp" %>
 </c:when>
 <c:when test="${sessionScope.checkBoard eq 'camp'}">
<%@ include file="../include/header.jsp" %>
 </c:when>
 </c:choose>
 


<%@ include file="../include/campingTipFrmPage.jsp" %>
<%@ include file="../include/adminCampingTipFrmPage.jsp" %>

<div class="container-fluid">
	<div class="row" style="color: black;" >
	<br>
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
		
			<h3 style="padding: 10px;">캠핑장 수칙</h3>
			
			<div class="row" id="reviewTip_title">
				<div class="col-md-6">
						<h3>${campingTipVo.campingtip_title }</h3>
				</div>
				<div class="col-md-6" align="right">
								<a>${campingTipVo.campingtip_writer}</a>
								<a>|</a>
								<a>${campingTipVo.campingtip_date}</a>
								<a>|</a>
								<a>${campingTipVo.campingtip_view}</a>
				</div>
			</div>
			<table class="table">

				<tbody>
				<tr>
					<td>
			
							<div class="campingTip_img">
								<c:forEach items="${fileNoListImg}" var="filesVo">
									<img src="/upload/displayImg?fileName=${filesVo.files}" alt="사진 미등록" class="oriImg"/>
								</c:forEach>
								
							</div>
							<div class="campingTip_content">
							<h3 style="margin-bottom: 30px; color: black;">${campingTipVo.campingtip_title }</h3>
									<pre class="camping_pre">${campingTipVo.campingtip_content}</pre>
							</div>
					</td>
				</tr>

				</tbody>
			</table>
		


		<c:if test="${sessionScope.checkAdmin eq 9 }">

				<a href="/admin/campingTipModifyForm/${campingTipVo.campingtip_title}"class="btn btn-info">수정</a>				
				<a href="/admin/campingTipDelete?campingtip_no=${campingTipVo.campingtip_no}"class="btn btn-danger">삭제</a>		
		</c:if>		

 <c:choose>
 <c:when test="${sessionScope.checkBoard == 'admin'}">
				<a href="/admin/campingTip"class="btn btn-success" id="campTip">목록</a>				
 </c:when>
 <c:when test="${sessionScope.checkBoard eq 'camp'}">
				<a href="/camp/campingTipList"class="btn btn-success" id="campTip">목록</a>				
 </c:when>
 </c:choose>
		

		</div>
		<div class="col-md-2">

		</div>

	</div>


	
</div>


























<%@ include file="../include/footer.jsp" %>