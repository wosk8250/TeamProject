<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<style>
.totaltext {
 	text-align: center;
 }
.admin_sort{
	float:right;
}
</style>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">

			<table class="table">
				<thead>
					<tr>
						<th>
							<h3>캠핑장 수칙</h3>
						</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var ="CampingTipVo">
		
					<tr>
						<th>
				<div class="media">
				<img class="mr-3" alt="Bootstrap Media Preview" src="https://www.layoutit.com/img/sports-q-c-64-64-8.jpg" />
				<div class="totaltext" >
						<p class="title"><a href="/camp/singleContentsCampingTip/${CampingTipVo.campingtip_no}/${checkBoard}">${CampingTipVo.campingtip_title}</a></p>
						<p class="content">${CampingTipVo.campingtip_content}</p>
				</div>

			</div>
					<div class="admin_sort">
						<a>${CampingTipVo.campingtip_writer}</a>
						<a>|</a>
						<a>${CampingTipVo.campingtip_date}</a>
						<a>|</a>
						<a>${CampingTipVo.campingtip_view}</a>
				</div>
						</th>
					</tr>



				</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</div>

<%@ include file="../include/footer.jsp" %>