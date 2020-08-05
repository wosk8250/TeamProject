<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <style>
 .btn{
 	float:right; 
 	margin: 20px;
 }
 
 </style>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:choose>
 <c:when test="${sessionScope.checkBoard == 'admin'}">
 <%@ include file="../include/adminheader.jsp" %>
 </c:when>
 <c:when test="${sessionScope.checkBoard eq 'camp'}">
<%@ include file="../include/topImgHeader.jsp" %>
 </c:when>
 </c:choose>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h3>캠핑장 수칙</h3>
			<table class="table">
				<thead>
					<tr>
						<th colspan="3">
							<h3>${campingTipVo.campingtip_title }</h3>
						</th>
						
						<th>
							<div class="admin_info" style="float:right;">
								<a>${campingTipVo.campingtip_writer}</a>
								<a>|</a>
								<a>${campingTipVo.campingtip_date}</a>
								<a>|</a>
								<a>${campingTipVo.campingtip_view}</a>
							</div>
						</th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<div class="campingtip">
								<img class="mr-3" alt="Bootstrap Media Preview" src="https://www.layoutit.com/img/sports-q-c-64-64-8.jpg" />
							</div>
						</td>
						<td>
								<div class="media-body">
									<h5 class="mt-0">${campingTipVo.campingtip_content}</h5>
								</div>
						</td>
	
					</tr>
				</tbody>
			</table>
		<c:if test="${sessionScope.checkAdmin eq 9 }">
				<a href="/admin/campingTipModifyForm/${campingTipVo.campingtip_title}/${checkBoard}"class="btn btn-info">수정</a>				
				<a href="/admin/campingTipDelete?campingtip_no=${campingTipVo.campingtip_no}"class="btn btn-danger">삭제</a>				
 </c:if>
 <c:choose>
 <c:when test="${sessionScope.checkBoard == 'admin'}">
				<a href="/admin/campingTip"class="btn btn-success">목록</a>				
 </c:when>
 <c:when test="${sessionScope.checkBoard eq 'camp'}">
				<a href="/camp/campingTipList"class="btn btn-success">목록</a>				
 </c:when>
 </c:choose>
		
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp" %>