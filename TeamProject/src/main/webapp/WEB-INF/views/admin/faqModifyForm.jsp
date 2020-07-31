<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/adminheader.jsp"%>


<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="/admin/faqModifyRun" method="get">
				<div class="form-group">

					<label for="faq_title"> 제목 </label> 
					<input type="text" class="form-control id="faq_title" name="faq_title" value="${faqVo.faq_title}"/>
					<input type="hidden" class="form-group" id="faq_no" name="faq_no" value="${faqVo.faq_no }"/>
				</div>
				<div class="form-group">

				<textarea class="form-control id="faq_content" name="faq_content" rows="25"  style="resize:none; width:100%;" >${faqVo.faq_content}</textarea>
					
				</div>
				<button type="submit" class="btn btn-primary">완료</button>
			</form>
		</div>
	</div>
</div>



<%@include file="../include/adminfooter.jsp"%>