
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.2.0/main.css">
<script src="https://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>

<script src="/resources/vendor/jquery/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.2.0/main.js"></script>
<script>
  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: ''
      },
      initialDate: '2020-08-03',
      selectable: true,
      
      
      
      events: [
        {	
          title: '예약',
          textColor : '#000000',
          start: '2020-08-08',
          end: '2020-08-10',
        },
        {
        	title: '예약',
            textColor : '#000000',
        	start: '2020-08-15',
          end: '2020-08-18',
        }
      ]
    });

    calendar.render();
  });

</script>
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-4">
			<td><img width="400" height="400" src="/resources/image/1594178025406.jpg"></td>
		</div>
		<div class="col-md-4">
			<table class="table">
				<thead>
					<tr>
						<th>주소</th>
						<td>울산 남구</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>문의처</th>
						<td>052-0000-0000</td>
					</tr>
					<tr>
						<th>캠핑장 유형</th>
						<td>일반야영장</td>
					</tr>
					<tr>
						<th>운영기간</th>
						<td>365일</td>
					</tr>
					<tr>
						<th>운영일</th>
						<td>평일 + 주말</td>
					</tr>
					<tr>
						<th>홈페이지 바로가기</th>
						<td><a href="https://www.gocamping.or.kr/">홈페이지</a></td>
					</tr>
				</tbody>
			</table>
			
		</div>
		<div class="col-md-4">
		
		</div>
	</div>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
		<div id='calendar'></div>
		</div>
		<div class="col-md-2"></div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr>
						<th>
							<h2>캠핑장 소개</h2>
						</th>
						<th>
							Product
						</th>
						<th>
							Payment Taken
						</th>
						<th>
							Status
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Default
						</td>
					</tr>
					<tr class="table-active">
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Approved
						</td>
					</tr>
					<tr class="table-success">
						<td>
							2
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							02/04/2012
						</td>
						<td>
							Declined
						</td>
					</tr>
					<tr class="table-warning">
						<td>
							3
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							03/04/2012
						</td>
						<td>
							Pending
						</td>
					</tr>
					<tr class="table-danger">
						<td>
							4
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							04/04/2012
						</td>
						<td>
							Call in to confirm
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>


<%@ include file="../include/footer.jsp"%>