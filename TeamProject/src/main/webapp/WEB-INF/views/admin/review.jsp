<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/adminheader.jsp"%>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.2.0/main.css">


<script src="https://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>
	$(function() {

		var msg = "${msg}"
		if (msg == "delete") {
			alert("게시글 삭제완료");
		}

		$(".page-link").click(function(e) {
			e.preventDefault();
			var page = $(this).attr("href").trim();
			$("#adminReviewFrmPage > input[name=page]").val(page);
			$("#adminReviewFrmPage").submit();
		});

		$("select[name=perPage]").change(
				function() {
					var perPage = $(this).val();
					var i = $("#adminReviewFrmPage > input[name=perPage]").val(
							perPage);
					$("#adminReviewFrmPage").submit();
				});

		$(".searchReview").click(function() {
			var reviewTitle = $("#textReview").val();
			location.href = "/admin/review?review_title=" + reviewTitle;
		});

	});
</script>

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

<%@include file="../include/adminReviewFrmPage.jsp"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">

  <div id="contextMenu" class="dropdown clearfix">
            <ul class="dropdown-menu dropNewEvent" role="menu" aria-labelledby="dropdownMenu"
                style="display:block;position:static;margin-bottom:5px;">
                <li><a tabindex="-1" href="#">카테고리1</a></li>
                <li><a tabindex="-1" href="#">카테고리2</a></li>
                <li><a tabindex="-1" href="#">카테고리3</a></li>
                <li><a tabindex="-1" href="#">카테고리4</a></li>
                <li class="divider"></li>
                <li><a tabindex="-1" href="#" data-role="close">Close</a></li>
            </ul>
        </div>


			 <div id='calendar'></div>
			
			




			<div id="map" style="width: 100%; height: 400px;"></div>
			<!-- 지도크기 -->

			<script type="text/javascript"
				src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=a3pn1ogugq"></script>
			<script>
				var map = new naver.maps.Map('map', mapOptions);
				
				var mapOptions = {
					center : new naver.maps.LatLng(35.554606, 129.322896),//위도,경도
					zoom : 15
				};
			</script>




			<select name="perPage" class="form-inline">
				<c:forEach begin="5" end="30" step="5" var="i">
					<option value="${i}"
						<c:if test="${i == pagingDto.perPage}">selected</c:if>>${i}줄씩
						보기</option>
				</c:forEach>
			</select>
			<table class="table">
				<thead>
					<tr>
						<th>글번호</th>
						<th>이미지</th>
						<th>제목</th>
						<th>아이디</th>
						<th>날짜</th>
						<th>캠핑장</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="reviewVo">
						<c:if test="${reviewVo.review_admin == 0}">
							<tr>
								<td>${reviewVo.review_no}</td>
								<td><img
									src="/upload/displayImg?fileName=${reviewVo.review_img}"
									alt="사진없음" /></td>
								<td><a href="/camp/selectReview/${reviewVo.review_no}">${reviewVo.review_title}</a></td>
								<td>${reviewVo.review_id}</td>
								<td>${reviewVo.review_date}</td>
								<td>${reviewVo.review_campingname}</td>

							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<input type="text" class="form-group" id="textReview" />
					<button class="btn btn-success searchReview">검색</button>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 text-center">
				<nav>
					<ul class="pagination">
						<c:if test="${pagingDto.startPage != 1}">
							<li class="page-item"><a class="page-link"
								href="${pagingDto.startPage - 1}">이전</a></li>
						</c:if>
						<c:forEach begin="${pagingDto.startPage}"
							end="${pagingDto.endPage}" var="page">
							<li class="page-item"><a class="page-link" href="${page}">${page}</a>
							</li>
						</c:forEach>
						<c:if test="${pagingDto.endPage < pagingDto.totalPage}">
							<li class="page-item"><a class="page-link"
								href="${pagingDto.endPage + 1}">다음</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</div>


<%@include file="../include/adminfooter.jsp"%>