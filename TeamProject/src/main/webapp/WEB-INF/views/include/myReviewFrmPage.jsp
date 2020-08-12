<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 페이지 정보 폼(링크용) -->
<form id="myReviewFrmPage" action="/user/myReviewList" method="get">
	<input type="hidden" name="page" value="${pagingDto.page}"/>
</form>