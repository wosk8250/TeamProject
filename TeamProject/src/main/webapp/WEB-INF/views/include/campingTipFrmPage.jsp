<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form id="campingTipFrmPage" action="/camp/campingTipList" method="get">
<%-- 	<input type="hidden" name="campingtip_no" value="${campingTipVo.campingtip_no}"/> --%>
	<input type="hidden" name="page" value="${pagingDto.page}"/>
	<input type="hidden" name="perPage" value="${pagingDto.perPage}"/>
	<input type="hidden" name="searchCnd" value="${pagingDto.searchCnd}"/>
	<input type="hidden" name="textReview" value="${pagingDto.textReview}"/>
	
</form>