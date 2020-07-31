<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/adminheader.jsp"%>


<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="/admin/noticeModifyRun" method="get">
				<div class="form-group">

					<label for="notice_title"> 제목 </label> 
					<input type="text" class="form-control id="notice_title" name="notice_title" value="${campNoticeVo.notice_title}"/>
					<input type="hidden" class="form-group" id="notice_writer" name="notice_writer" value="관리자"/>
					<input type="hidden" class="form-group" id="notice_no" name="notice_no" value="${campNoticeVo.notice_no }"/>
				</div>
				<div class="form-group">

				<textarea class="form-control id="notice_content" name="notice_content" rows="25"  style="resize:none; width:100%;" >${campNoticeVo.notice_content}</textarea>
					
				</div>
				<button type="submit" class="btn btn-primary">완료</button>
			</form>
		</div>
	</div>
</div>



<%@include file="../include/adminfooter.jsp"%>