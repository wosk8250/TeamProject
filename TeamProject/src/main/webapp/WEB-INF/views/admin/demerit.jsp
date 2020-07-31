<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="../include/adminheader.jsp" %>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>
$(function() {
	
	
	
	$(".btnModal").click(function(e) {
		var demerit_code = $(this).parent().parent().find("td").eq(0).text();
		var demerit_content = $(this).parent().parent().find("td").eq(1).text();
		var demerit_value = $(this).parent().parent().find("td").eq(2).text();
		
		var inputContent = "<div>"
			inputContent += "<span>코드</span> <input type='text' class='form-control' name='demerit_code' value='"+demerit_code+"'/>";
			inputContent += "<span>내용</span> <input type='text' class='form-control' name='demerit_content' value='"+demerit_content+"'/>";
			inputContent += "<span>벌점</span> <input type='number' class='form-control' max='100' name='demerit_value' value='"+demerit_value+"'/>";
			inputContent += "</div>"
		$("#myModalLabel > div").remove();
		$("#myModalLabel").append("<div>" + demerit_code + " 수정 </div>");
		$(".modal-body > div").remove();
		$(".modal-body").append(inputContent);
			
	});
	
});

</script>

<%@include file ="../include/adminFaqFrmPage.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
		
			<table class="table">
				<thead>
					<tr>
						<th>코드</th>
						<th>내용</th>
						<th>벌점</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="demeritCodeVo">
					<tr>
						<td>${demeritCodeVo.demerit_code}</td>
						<td>${demeritCodeVo.demerit_content}</td>
						<td>${demeritCodeVo.demerit_value}</td>
						<td>
	
						 <a id="modal-129046" href="#modal-container-129046" role="button"
								class="btn btn-success btnModal" data-toggle="modal">수정</a>
								<div class="modal fade" id="modal-container-129046"
									role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="myModalLabel"></h5>
												<button type="button" class="close" data-dismiss="modal">
													<span aria-hidden="true">×</span>
												</button>
											</div>
											<form action="/admin/modifyDemeritCode">
											<div class="modal-body"></div>
											<div class="modal-footer">

												<button type="submit" class="btn btn-primary">수정</button>
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">닫기</button>
											</div>
											</form>
										</div>

									</div>

								</div>

							</td>
						<td><a href="/admin/demeritDelete?demerit_code=${demeritCodeVo.demerit_code}" class="btn btn-warning">삭제</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>
	<a id="modal-338047" href="#modal-container-338047" role="button"
		class="btn btn-dark" data-toggle="modal">벌점 등록</a>

	<div class="modal fade" id="modal-container-338047" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-headerInput">
					<h5 class="modal-title" id="myModalLabel">벌점 등록</h5>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<form action="/admin/insertDemeritCode" method="get">
				<div class="modal-bodyInput">
				<input class="form-control" name="demerit_code" type="text" placeholder="코드"/>
				<input class="form-control" name="demerit_content" type="text" placeholder="내용"/>
				<input class="form-control" name="demerit_value" type="number" placeholder="벌점" max="100"/>
				</div>
				<div class="modal-footer">

					<button  id="insertDemerit" type="submit" class="btn btn-primary">등록
					</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">닫기</button>
				</div>
				</form>
			</div>

		</div>

	</div>

</div>
    


<%@include file="../include/adminfooter.jsp"%>