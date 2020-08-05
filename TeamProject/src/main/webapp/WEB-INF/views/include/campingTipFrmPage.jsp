<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form id="reviewFrmPage" action="/camp/campingTipList" method="get">
	<input type="hidden" name="campingtip_no" value="${campingTipVo.campingtip_no}"/>
	<input type="hidden" name="page" value="${pagingDto.page}"/>
	<input type="hidden" name="perPage" value="${pagingDto.perPage}"/>
	
</form>