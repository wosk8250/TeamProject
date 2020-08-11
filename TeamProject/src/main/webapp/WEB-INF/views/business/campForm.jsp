<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../include/header.jsp" %>
<style>

#uploadedList > div {
	float : left;
	margin : 20px;
}

.btn {
	resize: both;
	float: right;
}

.form-control{
	margin: 2px;
	padding: 1px 10px;
}

.checkbox{
	margin-left: 15px;
}
</style>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>
$(function () {
	$("#file").change(function (e) {
		var	file = e.target.files;
		var formData = new FormData();
		var url = "/upload/image";
		for (var i = 0; i < file.length; i++) {
		formData.set('file', file[i]);
		
		$.ajax({
			"processData" : false,
			"contentType" : false,
			"type" : "post",
			"url" : url,
			"data" : formData,
			"success" : function(rData) {
				var slashIndex = rData.lastIndexOf("/");
				var front = rData.substring(0, slashIndex + 1);
				var rear = rData.substring(slashIndex + 1);
				var thumbnailName = front + "sm_" + rear;
				
					if(rData == "notImg"){
					alert("사진만 첨부 가능합니다");
					} else{
						var originalFilename = rData.substring(rData.indexOf("_") + 1);
						
						var html = "<div data-filename=" + rData + ">";
						html += "<img src='/upload/displayImg?fileName=" + thumbnailName + "'/><br/>";
						html += "<span>"+originalFilename+"</span>";
						html += "<a href='"+rData+"' class='attach-del'><span class='pull-right'>x</span></a>";
						html += "</div>";
						$("#uploadedList").append(html);
					}//else
				}//success
			});//ajax
		}//for
	});//#file
	$("#uploadedList").on("click",".attach-del",function(e){
		e.preventDefault();
		var that = $(this);
		var filename = that.attr("href");
		var url = "/upload/deleteFile";
		sendData = {"filename" : filename};
		$.get(url, sendData, function(rData) {
			that.parent().remove();
		});		
	});
	
	//부대시설 체크박스
	var amenities = ["#camping_power","#camping_wifi","#camping_hotwater","#camping_trail","#camping_mart","#camping_park"];
	for (var i = 0; i < amenities.length; i++) {
		$(amenities[i]).change(function () {
			if($(this).is(":checked")){
				$(this).val("1");
			} else {
				$(this).val("0");
			}
		});
	}

	var insert = ["#camp_name","#camp_address","#camp_phone","#camp_http","#camp_area","#camp_location","#camp_content","#power","#wifi","#hotwater","#trail","#mart","#park", "#camp_peakweekdays", "#camp_peakweekend", "#camp_weekdays", "#camp_weekend"];
	var write = ["#camping_name","#roadFullAddr","#camping_phone","#camping_http","#sggNm","#siNm","#camping_content","#camping_power","#camping_wifi","#camping_hotwater","#camping_trail","#camping_mart","#camping_park", "#camping_peakweekdays", "#camping_peakweekend", "#camping_weekdays", "#camping_weekend"];
	var writecheck = ["#camping_name","#roadFullAddr","#camping_phone","#camping_http","#camping_content"];
	//요금표
	var campFare = ["#camp_peakweekdays", "#camp_peakweekend", "#camp_weekdays", "#camp_weekend"];
	var fare = ["#camping_peakweekdays", "#camping_peakweekend", "#camping_weekdays", "#camping_weekend"];
	//계절
	var season = ["#spring","#summer","#autumn","#winter"];
	
	
	
	for (var i = 0; i < fare.length; i++) {
		$(fare[i]).focusin(function() {
			$(this).val("");
		});
		
		//요금표 3자리마다 콤마 찍기
		$(fare[i]).focusout(function() {
			
			function addComma(num) {
				  var regexp = /\B(?=(\d{3})+(?!\d))/g;
				  return num.toString().replace(regexp, ',');
				}
			var addnum = addComma($(this).val());
			$(this).val(addnum);
		});
	}
	
	$("#campRun").submit(function(e) {
// 		e.preventDefault();
		
		//영업 날짜
		var operating = $("#operating option:selected").val();
		$("#operatingday").val(operating);
		//영업 날짜 끝
		
		//영업기간 선택
		var operation = "";
		for (var i = 0; i < season.length; i++) {
			if($(season[i]).is(":checked") == true){
				operation += $(season[i]).val() + ",";
			}
		}
		var last = operation.lastIndexOf(",");
		var camp_operation = operation.substring(0,last);
		$("#camp_operation").val(camp_operation);
		//영업기간 선택 끝
		
		//null체크
		for (var i = 0; i < writecheck.length; i++) { 
			if($(writecheck[i]).val() == null || $(writecheck[i]).val() == ""){
				var id = $(writecheck[i]).attr("id");
				alert("공란없이 작성해주세요");
				return false;
			}
		}
		
		//작성한 내용 insertCampFem에 입력
		for (var i = 0; i < write.length; i++) {
			$(insert[i]).val($(write[i]).val());
		}
		
		var upDiv = $("#uploadedList > div");
		upDiv.each(function(index) {
			var filename = $(this).attr("data-filename");
			var hiddenInput = "<input type='hidden' name='files["+index+"]' value='"+filename+"'/>";
			$("#campRun").prepend(hiddenInput);
		});
	});
	
	
});//$function
</script>
<script language="javascript">

function goPopup(){
	var pop = window.open("/popup/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
}

function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		document.form.roadFullAddr.value = roadFullAddr;//주소
		document.form.siNm.value = siNm;//지역
		document.form.sggNm.value = sggNm;//시도 명
}

</script>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
				<div class="form-group">
				<table class="table table-boardered">
					<tr>
						<td class="td_title" width="140"> 캠핑장 이름 : </td>
						<td><input type="text" class="form-control" id="camping_name" placeholder="캠핑장 이름"/></td>
					</tr>
					<tr>
						<td class="td_title" width="140">주소 : </td>
						<td>
							<form name="form" id="form" method="post">
								<input class="btn btn-primary btn-sm" type="button" onClick="goPopup();" value="검색" style="margin-right: 10px; float: left; "/>
								<div id="list"></div>
								<div id="callBackDiv">
										<input type="text" class="form-control" style="width:500px;" id="roadFullAddr"  name="roadFullAddr" readonly />
										<input type="hidden"  style="width:500px;" id="siNm"  name="siNm" />
										<input type="hidden"  style="width:500px;" id="sggNm"  name="sggNm" />
								</div>
							</form>
						</td>
					</tr>
					<tr>
						<td class="td_title" width="140">휴대폰 번호 : </td>
						<td><input type="text" class="form-control" id="camping_phone" placeholder="휴대폰 번호"/></td>
					</tr>
					<tr>
						<td class="td_title" width="140">홈페이지 주소 : </td>
						<td><input type="text" class="form-control" id="camping_http" placeholder="홈페이지 주소"/></td>
					</tr>
					<tr>
						<td class="td_title" width="140">부대시설 : </td>
						<td>
							<input type="checkbox" id="camping_power" value="0">전기
							<input class="checkbox" type="checkbox" id="camping_wifi" value="0">와이파이
							<input class="checkbox" type="checkbox" id="camping_hotwater" value="0">온수
							<input class="checkbox" type="checkbox" id="camping_trail" value="0">산책로
							<input class="checkbox" type="checkbox" id="camping_mart" value="0">마트
							<input class="checkbox" type="checkbox" id="camping_park" value="0">주차장
						</td>
					</tr>
					<tr>
						<td class="td_title" width="140">영업기간 : </td>
						<td>
							<input type="checkbox" id="spring" value="봄">봄
							<input type="checkbox" class="checkbox" id="summer" value="여름">여름
							<input type="checkbox" class="checkbox" id="autumn" value="가을">가을
							<input type="checkbox" class="checkbox" id="winter" value="겨울">겨울
						</td>
					</tr>
					<tr>
						<td class="td_title" width="140">영업일 : </td>
						<td>
							<select style="margin-bottom: 10px;" id="operating">
								<option>평일</option>
								<option>주말</option>
								<option>평일 + 주말</option>
							</select>
							<table style="text-align: center;">
								<thead>
									<tr>
										<th>가격</th>
										<th>주간</th>
										<th>주말(공휴일)</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>
											성수기
										</td>
										<td>
											<input type="text" class="form-control" id="camping_peakweekdays" value="0">
										</td>
										<td>
											<input type="text" class="form-control" id="camping_peakweekend" value="0">
										</td>
									</tr>
									<tr>
										<td>
											비성수기
										</td>
										<td>
											<input type="text" class="form-control" id="camping_weekdays" value="0">
										</td>
										<td>
											<input type="text" class="form-control" id="camping_weekend" value="0">
										</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<td class="td_title" width="140">소개 : </td>
						<td><textarea class="form-control" id="camping_content" rows="20" style="resize:none; width:100%;" ></textarea></td>
					</tr>
				</table>
				</div>
				<%@ include file="../include/insertCampFrm.jsp" %>
		</div>
		<div class="col-md-1"></div>
	</div>
</div>



<%@include file="../include/adminfooter.jsp"%>

