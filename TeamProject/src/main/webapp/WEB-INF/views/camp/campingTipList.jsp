<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<style>
	div {
		color: black;
	}
	table {
		text-align: center;
		color: black;
	}
	#td_title {
		text-align: center;
	}
	th {
		background-color: #4f6fcc25;
	}
</style>


<div class="container-fluid">
	<div class="row">
				<div class="col-md-1">
		</div>
				<div class="col-md-10">
	<h2>캠핑 수칙</h2>
			<hr>
		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th></th>
						<th width="450">제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
				</thead>
				
				<tbody>

				<c:forEach items="${list}" var ="CampingTipVo">

					<tr>
					<td>${CampingTipVo.campingtip_no}</td>
					<td><img src="/upload/displayCampingImg?fileName=${CampingTipVo.campingtip_img}" alt="사진 등록"/>
					</td>
					<td><h6><a href="/camp/singleContentsCampingTip/${CampingTipVo.campingtip_no}">${CampingTipVo.campingtip_title}</a></h6>
					</td>
					<td>${CampingTipVo.campingtip_writer}</td>
					<td>${CampingTipVo.campingtip_date}</td>
					<td>${CampingTipVo.campingtip_view}</td>
						
						
						
						
						
			
	
					</tr>
				<tr>
			
				</c:forEach>
				</tbody>
			</table>
			</div>
				</div>
				<div class="col-md-1">
		</div>

	</div>
</div>




<%@ include file="../include/footer.jsp"%>