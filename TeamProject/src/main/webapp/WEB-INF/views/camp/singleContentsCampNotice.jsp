<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<style>
dd{
	text-indent:10%;
}
a{
	float:right;
}
</style>
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
			<a  href="/camp/campNoticeList"class="btn btn-success">목록</a>
			
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp" %>