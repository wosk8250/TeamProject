<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<style>
.warting {
	padding :50px 20;
 }
.writer_sort{
	float:right;
}
#a_btn{
	float:right;
}
#btnReviewWriting{
	float:right;
}
.pagination{
	margin-left: auto;
	margin-right: auto;
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

				<c:forEach items="${list}" var="campingTipVo">

					<tr>
						<td  colspan="2">
							<img src="/upload/displayImg?fileName=${campingTipVo.campingtip_img}" alt="사진 미등록"/>
						</td>
	
						<td colspan="2">
						<div class="warting">
							<h6><a href="/camp/singleContentsCampingTip/${campingTipVo.campingtip_no}">${campingTipVo.campingtip_title}</a></h6>
							<p>${campingTipVo.campingtip_content}<br/>
							
							
							
							</p>
					</div>
						<div class="writer_sort" >
						<a>${campingTipVo.campingtip_writer}</a>
						<a>|</a>
						<a>${campingTipVo.campingtip_date}</a>
						<a>|</a>
						<a>${campingTipVo.campingtip_view}</a>
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