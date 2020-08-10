<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <style>
		.btn{
			float:right; 
			margin: 20px;
		}
			dd{
			text-indent:10%;
		 }
		a{
			float:right;
		}
 </style>
  <c:choose>
 <c:when test="${sessionScope.checkBoard == 'admin'}">
 <%@ include file="../include/adminheader.jsp" %>
 </c:when>
 <c:when test="${sessionScope.checkBoard eq 'camp'}">
<%@ include file="../include/header.jsp" %>
 </c:when>
 </c:choose>
 <script>
 $(function(){
		$("#campList").click(function(e){
			e.preventDefault();
			$("#reviewNoitceFrmPage").submit();
		});
 });
 </script>
<%@ include file="../include/campingNoticeFrmPage.jsp" %>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
					<h3>공지사항</h3>
			<ul class="nav">
				<li class="nav-item">
					<h4>${campNoticeVo.notice_title}</h4> 
				</li>

				<li class="nav-item dropdown ml-md-auto">
				<li class="nav-item">
					<a class="nav-link active" >${campNoticeVo.notice_writer}</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" >${campNoticeVo.notice_date}</a>
				</li>
				<li class="nav-item">
					<a class="nav-link disabled">${campNoticeVo.notice_view}</a>
				</li>
				
			</ul>
			
			
			
			<dl>
				<dd>${campNoticeVo.notice_content}</dd>
			</dl>
			
			<c:if test="${sessionScope.checkAdmin eq 9 }">
			<a href="/admin/noticeDelete?notice_no=${campNoticeVo.notice_no}" class="btn btn-info" >삭제</a>
			<a href="/admin/noticeModifyForm?notice_no=${campNoticeVo.notice_no}" class="btn btn-danger" >수정</a>
 </c:if>
 <c:choose>
 <c:when test="${sessionScope.checkBoard == 'admin'}">
			<a href="/admin/notice" class="btn btn-success" >목록</a>
 </c:when>
 <c:when test="${sessionScope.checkBoard eq 'camp'}">
			<a  href="/camp/campingNoticeList"class="btn btn-success" id="campList">목록</a>
 </c:when>
 </c:choose>
			
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp" %>