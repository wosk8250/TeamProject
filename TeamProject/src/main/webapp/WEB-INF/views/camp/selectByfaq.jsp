<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <style>
 .btn{
 	float:right; 
 	margin: 20px;
 }
 
 </style>
 
 <c:choose>
 <c:when test="${sessionScope.checkBoard == 'admin'}">
 <%@ include file="../include/adminheader.jsp" %>
 </c:when>
 <c:when test="${sessionScope.checkBoard eq 'camp'}">
<%@ include file="../include/topImgHeader.jsp" %>
 </c:when>
 </c:choose>
<style>
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
<div class="container-fluid">
	<div class="row" style="color: black;" >
	<br>
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
		
			<h3 style="padding: 10px;">
				자주 묻는 질문 1231 ${checkBoard}
			</h3>
			<div class="row" id="faq_title">
				<div class="col-md-6">
					<h3 class="text-left">
						${faqVo.faq_title}
					</h3>
				</div>
				<div class="col-md-6" align="right">
						${faqVo.faq_writer} | ${faqVo.faq_date} | 조회수 ${faqVo.faq_view}
				</div>
			</div>
			<div id="faq_content">
			<h4 class="text-center" style="margin-bottom: 30px;">
				<b>${faqVo.faq_title}</b>
			</h4>
			<pre>${faqVo.faq_content}</pre>
			</div>
			<div style="text-align: right;">
 <c:if test="${sessionScope.checkAdmin eq 9 }">
			<a href="/admin/faqModifyForm/${faqVo.faq_no}" class="btn btn-info" >수정</a>
			<a href="/admin/faqDelete/${faqVo.faq_no}" class="btn btn-danger" >삭제</a>
 </c:if>
 <c:choose>
 <c:when test="${sessionScope.checkBoard == 'admin'}">
			<a href="/admin/faq" class="btn btn-success" >목록</a>
 </c:when>
 <c:when test="${sessionScope.checkBoard eq 'camp'}">
			<a href="/camp/faqList" class="btn btn-success" >목록</a>
 </c:when>
 </c:choose>
			</div>
		</div>
		<div class="col-md-2">
		</div>
	</div>
</div>


<%@ include file="../include/footer.jsp" %>