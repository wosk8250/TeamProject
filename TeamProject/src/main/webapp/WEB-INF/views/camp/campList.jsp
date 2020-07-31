<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col-md-12">
			<table class="table" id="camPingTable" style="display:none">
				<thead>
					<tr>
						<th>캠핑장 이름</th>
						<th>캠핑장 이름</th>
						<th>캠핑장 이름</th>
						<th>캠핑장 이름</th>
						<th>캠핑장 이름</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${campList}" var="vo">
					<tr>
						<td>${vo.camp_no}</td>
						<td>${vo.camp_name}</td>
						<td>${vo.camp_phone}</td>
						<td>${vo.camp_location}</td>
						<td>
						<div class="camp_item_box">
						<th>
							<ul>
								<li><i class="ico_volt"><span>전기</span></i></li>
								<li><i class="ico_wifi"><span>와이파이</span></i></li>
								<li><i class="ico_wood"><span>장작판매</span></i></li>
								<li><i class="ico_hotwater"><span>온수</span></i></li>
								<li><i class="ico_walk"><span>산책로</span></i></li>
								<li><i class="ico_mart"><span>마트.편의점</span></i></li>
							</ul>
						</th>
						</div>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>