<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 페이지 정보 폼(링크용) -->
<form id="campRun" role="form" action="/business/campRun" method="post" enctype="multipart/form-data">
	<!-- 부대시설 -->
	<input type="hidden" name="power" id="power"/>                <!-- 전기 -->
	<input type="hidden" name="wifi" id="wifi"/>                  <!-- 와이파이 -->
	<input type="hidden" name="hotwater" id="hotwater"/>          <!-- 온수 -->
	<input type="hidden" name="trail" id="trail"/>                <!-- 산책로 -->
	<input type="hidden" name="mart" id="mart"/>                  <!-- 마트 -->
	<input type="hidden" name="park" id="park"/>                  <!-- 주차장 -->
	<!-- 캠핑장 정보 -->
	<input type="hidden" name="camp_name" id="camp_name" />       <!-- 캠핑장 이름 -->
	<input type="hidden" name="camp_address" id="camp_address" /> <!-- 주소 -->
	<input type="hidden" name="camp_phone" id="camp_phone" />     <!-- 휴대폰 번호 -->
	<input type="hidden" name="camp_http" id="camp_http" />       <!-- 홈페이지 주소 -->
	<input type="hidden" name="camp_area" id="camp_area" />       <!-- 지역 ex)울산,부산 -->
	<input type="hidden" name="camp_location" id="camp_location" /><!-- 시도명ex)남구, 북구 -->
	<input type="hidden" name="camp_content" id="camp_content"/>  <!-- 소개 -->
	
	<input type="hidden" name="operatingday" id="operatingday"/>  <!-- 영업일 -->
	<input type="hidden" name="camp_operation" id="camp_operation"/>  <!-- 계절 -->
	<input type="hidden" name="camp_peakweekdays" id="camp_peakweekdays"/>  <!-- 주간 성수기 -->
	<input type="hidden" name="camp_peakweekend" id="camp_peakweekend"/>  <!-- 주말 성수기 -->
	<input type="hidden" name="camp_weekdays" id="camp_weekdays"/>  <!-- 주간 비성수기 -->
	<input type="hidden" name="camp_weekend" id="camp_weekend"/>  <!-- 주말 비성수기 -->
	
	<input type="file" id="file" name="file[]" multiple="multiple"><!-- 파일 -->
		<div id="uploadedList"></div>
	<br/>
	<div>
	<button type="submit" class="btn btn-primary">완료</button>
	</div>

</form>