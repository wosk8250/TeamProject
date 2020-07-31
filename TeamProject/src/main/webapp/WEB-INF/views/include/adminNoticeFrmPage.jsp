<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form id="noticeFrmPage" action="/admin/notice" method="get">
	<input type="hidden" name="notice_no" value="${noticeVo.notice_no}"/>
	<input type="hidden" name="page" value="${pagingDto.page}"/>
	<input type="hidden" name="perPage" value="${pagingDto.perPage}"/>
	<input type="hidden" name="location" value="${pagingDto.location}"/>
	<input type="hidden" name="area" value="${pagingDto.area}"/>
</form>