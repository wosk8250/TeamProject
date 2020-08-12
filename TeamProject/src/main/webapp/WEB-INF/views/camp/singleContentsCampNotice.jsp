<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <script src="/resources/vendor/jquery/jquery.js"></script>
  <style>
 .btn{
 	float:right; 
 	margin: 20px;
 }
 #faq_title {
	border-top: 3px solid;
	border-bottom : 1px solid;
	padding: 10px 30px;
}
#faq_content {
	padding: 50px 50px;
}
pre {
	font-size: 15px;
}
  
 </style>
  <c:choose>
 <c:when test="${sessionScope.checkBoard eq 'admin'}">
 <%@ include file="../include/adminheader.jsp" %>
 </c:when>
 <c:when test="${sessionScope.checkBoard eq 'camp'}">
<%@ include file="../include/header.jsp" %>

 </c:when>
 </c:choose>
 <script>
 $(function(){
		$("#campNotice").click(function(e){
			e.preventDefault();
			if("${sessionScope.admin}" == "camp"){
				$("#campingNoticeFrmPage").submit();
			}else{
				$("#adminNoticeFrmPage").submit();
			}
			
		});
		
		$("#modifyBtn").click(function(e) {
			e.preventDefault();
			$("#adminNoticeFrmPage").attr("action", $(this).attr("href")).submit();
		});
		$("#deleteBtn").click(function(e) {
			e.preventDefault();
			$("#adminNoticeFrmPage").attr("action", $(this).attr("href")).submit();
		});
 });
 </script>
<%@ include file="../include/campingNoticeFrmPage.jsp" %>
<%@ include file="../include/adminNoticeFrmPage.jsp" %>
<div class="container-fluid">
	<div class="row" style="color: black;" >
	<br>
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
		
			<h3 style="padding: 10px;">
				공지사항
			</h3>
			<div class="row" id="faq_title">
				<div class="col-md-6">
					<h3 class="text-left">
					${campNoticeVo.notice_title}
					</h3>
				</div>
				<div class="col-md-6" align="right">
						${campNoticeVo.notice_writer} | ${campNoticeVo.notice_date}| 조회수 ${campNoticeVo.notice_view}
				</div>
			</div>
			<div id="faq_content">
			<h4 class="text-center" style="margin-bottom: 30px;">
				<b>${campNoticeVo.notice_content}</b>
			</h4>
			
			</div>
			<div style="text-align: right;">
			<c:if test="${sessionScope.checkAdmin eq 9 }">
			<a id="deleteBtn" href="/admin/noticeDelete?notice_no=${campNoticeVo.notice_no}" class="btn btn-info" >삭제</a>
			<a id="modifyBtn" href="/admin/noticeModifyForm?notice_no=${campNoticeVo.notice_no}" class="btn btn-danger" >수정</a>
 </c:if>
 <c:choose>
 <c:when test="${sessionScope.checkBoard == 'admin'}">
			<a href="/admin/notice" class="btn btn-success" id="campNotice" >목록</a>
 </c:when>
<c:when test="${sessionScope.checkBoard eq 'camp'}">
			<a  href="/camp/campingNoticeList"class="btn btn-success" id="campNotice">목록</a>
 </c:when>
 </c:choose>
			</div>
		</div>
		<div class="col-md-2">
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp" %>