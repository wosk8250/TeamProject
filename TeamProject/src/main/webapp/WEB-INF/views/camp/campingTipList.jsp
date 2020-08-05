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
				<div class="col-md-2">
				<h3>캠핑장 수칙</h3>
				</div>
				<div class="col-md-5"></div>
				<div class="col-md-5"></div>
	</div>
</div>

<div class="container-fluid">
	<div class="row">
				<div class="col-md-12">

			<table class="table" >

				<tbody>

				<c:forEach items="${list}" var ="CampingTipVo">

					<tr>
						<td  colspan="2">
							<img src="/upload/displayCampingImg?fileName=${CampingTipVo.campingtip_img}" alt="사진 등록"/>
						</td>
	
						<td colspan="2">
						<div class="warting">
							<h6><a href="/camp/singleContentsCampingTip/${CampingTipVo.campingtip_no}/${checkBoard}">${CampingTipVo.campingtip_title}</a></h6>
							<p>${CampingTipVo.campingtip_content} <br/>
	
							
							</p>
					</div>
						<div class="admin_sort" >
						<a>${CampingTipVo.campingtip_writer}</a>
						<a>|</a>
						<a>${CampingTipVo.campingtip_date}</a>
						<a>|</a>
						<a>${CampingTipVo.campingtip_view}</a>
				</div>
						</td>
	
					</tr>
				<tr>
			
				</c:forEach>
				</tbody>
			</table>
				</div>

	</div>
</div>



<%@ include file="../include/footer.jsp" %>