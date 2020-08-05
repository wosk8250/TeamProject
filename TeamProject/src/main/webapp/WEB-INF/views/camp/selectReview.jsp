<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
 <c:when test="${sessionScope.checkBoard == 'admin'}">
 <%@ include file="../include/adminheader.jsp" %>
 </c:when>
 <c:when test="${sessionScope.checkBoard eq 'camp'}">
<%@ include file="../include/header.jsp" %>
 </c:when>
 </c:choose>
<style>
.camping_content{
text-align: center;


}
.camping_img{
text-align: center;

}
.oriImg{
 
	width : 200px; 
 	height: auto; 
 	line-height : 100px;
 	margin-left:  200px;
	vertical-align: middle;
	margin-bottom:  100px;

}
.content_first{
	vertical-align: middle;
	 	margin-left:  200px;
}
.btn{
float:right;
margin-left:  20px;
margin-bottom:  200px;
}
.camping_pre{

	font-size: 20px;
	
}
#review_title {
	border-top: 3px solid;
	border-bottom : 1px solid;
	padding: 10px 30px;
}
#btnReview_Comment{

	float:right;
margin-left:  50px;
   width: 100px;
   height: 100px; 
   margin-bottom:  100px;    
}   
#comment_content{

	margin-right:  70px;
	width : 120%;
	 height: 100px; 
}
#imgDel{
	width: 10px;
	height: 10px;
	float: right;
	vertical-align: middle;
}
#commentTable{
	margin-bottom : 10px;
	vertical-align: top;
}
</style>
<script>

$(function(){
	getCommentList();
	
	function getCommentList(){
			var url ="/comment/reviewCommentList/${reviewVo.review_no}";
	
			console.log("url2:", url);
			$.getJSON(url, function(rData){
				console.log("rData2:", rData);

				$("#commentTable tr").remove();
				var tr ='';
				$("#tableComment ").remove();
			
				$.each(rData,function(){
					tr += '<table class="table" id="tableComment">';			
					tr += '<tr>';
					tr += '<td>'+this.comment_id+'</td>';
					tr += '<td>'+this.comment_date+'</td>';
					tr += '<td>'+this.comment_content+'</td>';
					tr += '<td><button type="button" class="btn_del" title="삭제" data-comment_no="'+this.comment_no+'" >';
					tr += '<img src="/resources/image/delete.png" title="삭제" id="imgDel"></td>'
					tr +='</button>';
					tr += '</tr>';
					tr += '</table>';
				});	
				$("#commentTable ").prepend(tr);
			});
			
	};
	$("#btnReview_Comment").click(function(){
		var review_no = "${reviewVo.review_no}";
	
		var comment_content = $("#comment_content").val();
	
		console.log("review_no:", review_no);
		
		console.log("comment_content:", comment_content);
	
		var sendData = {
			"review_no"	: review_no,
		
			"comment_content" : comment_content,
		};
		console.log("sendData:" , sendData);
		var url = "/comment/reviewCommentInsert";
		$.ajax({
			"type" : "post",
			"url"  : url,
			"dataType" : "text",
			"data" : JSON.stringify(sendData),
			"headers" : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "post"
			},
			"success" : function(rData){
				console.log("3:",rData);
				if(rData == "success"){
				
				$("#commentTable tr.cl_tr").remove();
		
				getCommentList();
								
					$('[name=comment_content]').val('');
				}
				
			}
		});
	});
	$("#commentTable").on("click", ".btn_del" , function(){
			var that = $(this);
			var comment_no = $(this).attr ("data-comment_no");
			console.log("that:", that);
			console.log("comment_no:", comment_no);
			var url ="/comment/reviewCommentDelete/${reviewVo.review_no}/" +  comment_no;
			console.log("url:", url);
			$.ajax({
				"type" : "delete",
				"url"  : url,
				"dataType" : "text",
				"headers" : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "delete"
				},
				"success" : function(rData){
					console.log("rData:", rData);
					that.parent().parent().hide(1000);	
					}
				});
			});


	
});
</script>



<div class="container-fluid">
	<div class="row" style="color: black;" >
	<br>
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
		
			<h3 style="padding: 10px;">캠핑장 후기</h3>
			
			<div class="row" id="review_title">
				<div class="col-md-6">
						<h3>${reviewVo.review_title }</h3>
				</div>
				<div class="col-md-6" align="right">
								<a>${reviewVo.review_id}</a>
								<a>|</a>
								<a>${reviewVo.review_date}</a>
								<a>|</a>
								<a>${reviewVo.review_view}</a>
				</div>
			</div>
			<table class="table">

				<tbody>
				<tr>
					<td>
								<div class="camping_content">
									<pre class="camping_pre">${reviewVo.review_content}</pre>
								</div>
							<div class="camping_img">
								<c:forEach items="${fileNoListImg}" var="filesVo">
									<img src="/upload/displayImg?fileName=${filesVo.files }" alt="사진 미등록" class="oriImg"/>
								</c:forEach>

							</div>
					</td>
				</tr>

				</tbody>
			</table>
<form id="commentForm" action="/comment/reviewCommentInsert" method="post">
		
			<table class="table" >

				<tbody>
				<tr style="background-color: rgba(204, 204, 204, 0.3);">
					<td colspan="4" ><h5>댓글쓰기</h5></td>			
				</tr>
				<tr>
					<td>
					<textarea  class="form-control" id="comment_content" name="comment_content"></textarea>
					</td>

					<td>
						<button type="button" class="btn btn-md btn-secondary" id="btnReview_Comment">
						입력
						</button>
					</td>
			
				</tr>	
				</tbody>
			</table>	
	
	</form>	
	
	<div class="row" 	id="commentDiv">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-8">
				<table id="commentTable"> 
		
					<tr>
						<td></td>
					</tr>
	
				</table>
				
				</div>
				<div class="col-md-2">
				</div>
			</div>
		</div>
	</div>

		<c:if test="${sessionScope.checkAdmin eq 9 }">
				<a href="/admin/campingTalkDelete?campingtip_no=${campingTipVo.campingtip_no}"class="btn btn-danger">삭제</a>				
 </c:if>

 <c:choose>
 <c:when test="${sessionScope.checkBoard eq 'admin'}">
				<a href="/admin/review"class="btn btn-success">목록</a>				
 </c:when>
 <c:when test="${sessionScope.checkBoard eq 'camp'}">
					<a href="/camp/campingReviewList"class="btn btn-success" id= "btnList">목록</a>		
 </c:when>
 </c:choose>
 
 
			<c:if test="${sessionScope.user_id==reviewVo.review_id}">
				<a  href="/camp/campingReviewModifyForm/${review_no}" class="btn btn-warning" id ="btnUpdate">수정</a>		
				<a  href="/camp/campingReviewDelete/${review_no}" class="btn btn-danger" id="btnDelete">삭제</a>	
			</c:if>
		</div>
		<div class="col-md-2">

		</div>

	</div>


	
</div>




<%@ include file="../include/footer.jsp" %>