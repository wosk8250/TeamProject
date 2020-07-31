<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 페이지 정보 폼(링크용) -->
<form id="mainFrmPage" action="/camp/home" method="get">
	<input type="hidden" name="camp_no" value="${CampVo.camp_no}"/>
	<input type="hidden" name="page" value="${pagingDto.page}"/>
	<input type="hidden" name="perPage" value="${pagingDto.perPage}"/>
</form>