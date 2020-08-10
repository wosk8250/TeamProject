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

	var insert = ["#camp_name","#camp_address","#camp_phone","#camp_http","#camp_area","#camp_location","#camp_content","#power","#wifi","#hotwater","#trail","#mart","#park"];
	var write = ["#camping_name","#roadFullAddr","#camping_phone","#camping_http","#siNm","#sggNm","#camping_content","#camping_power","#camping_wifi","#camping_hotwater","#camping_trail","#camping_mart","#camping_park"];
	var writecheck = ["#camping_name","#roadFullAddr","#camping_phone","#camping_http","#camping_content"];
	$("#campRun").submit(function(e) {
// 		e.preventDefault();
		for (var i = 0; i < writecheck.length; i++) { //null체크
			if($(writecheck[i]).val() == null || $(writecheck[i]).val() == ""){
				var id = $(writecheck[i]).attr("id");
				console.log(id);
				alert("공란없이 작성해주세요");
				return false;
			}
		}
		
		for (var i = 0; i < write.length; i++) {//작성한 내용 insertCampFem에 입력
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
						<td class="td_title" width="140">소개 : </td>
						<td><textarea class="form-control" id="camping_content" rows="25" style="resize:none; width:100%;" ></textarea></td>
					</tr>
				</table>
				</div>
				<%@ include file="../include/insertCampFrm.jsp" %>
		</div>
		<div class="col-md-1"></div>
	</div>
</div>



<%@include file="../include/adminfooter.jsp"%>

