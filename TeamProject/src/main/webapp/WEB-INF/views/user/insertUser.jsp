<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Camping Club</title>
  <!-- Custom fonts for this template-->
  <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<style>
	#joinImg {
	position: relative;
	left: 30%;
	top: 100px;
	}
	#insert {
		background-color: rgba(245, 246, 249, 0.2);
	}
	#text {
		position:relative;
		top: 200px; 
		color: black;
	}
</style>
  
<script>


//전화번호 숫자만 입력
function onlyNumber() {
	if((event.keyCode<48)||(event.keyCode>57))
        event.returnValue=false;
};

$(function () {
	$("#insertUserPost").submit(function () {
		var pw = $("#user_pw").val();
		var pw2 = $("#user_pw2").val();
		//비밀번호 영소문자, 숫자만 입력
		for(var v= 0 ; v < pw.length ; v++){
			var ch = pw.charCodeAt(v);
			if((ch < 97 || ch > 122) && (ch < 48 || ch > 57)) {
				alert("영어 소문자, 숫자로 입력하세요.");
				return false;
			}
		}
		//비밀번호 일치 여부 확인
		if(pw != pw2){
			alert("비밀번호 불일치");
			return false;
		}
		
		//비번 최소 글자수 4글자
		if(pw.length <= 3){
			alert("비밀번호는 4글자부터 사용 가능합니다");
			return false;
		}
	});
	
	//아이디 확인
	$("#btnCheckId").click(function () {
		var user_id = $("#user_id").val();
		//아이디 영소문자, 숫자
		for(var v= 0 ; v < user_id.length ; v++){
			var ch = user_id.charCodeAt(v);
			if((ch < 97 || ch > 122) && (ch < 48 || ch > 57)) {
				$("#checkId").text("영어 소문자, 숫자로 입력하세요.").css("color","red");
				$("#btnInsert").attr("disabled",true);
				return;
			}
		}
		
		//아이디 최소 글자수 제한
		if(user_id.length <= 3){
			$("#checkId").text("아이디는 4글자부터 15글자 사이입니다.").css("color","red");
			$("#btnInsert").attr("disabled",true);
			return;
		}
		
		//아이디 중복 체크
		var url = "/user/checkId";
		var sendData = {
				"user_id" : user_id 
		}
		$.get(url, sendData, function (rData) {
			console.log(rData);
			if (rData == "impossible"){
				$("#checkId").text("이미 사용중인 아이디 입니다.").css("color","red");
				$("#btnInsert").attr("disabled",true);
				return;
			} else {
				$("#checkId").text("사용 가능한 아이디 입니다.").css("color","blue");
				//아이디 사용가능일때 가입버튼 활성화
				$("#btnInsert").attr("disabled",false);
				return;
			}
		});

	});
	
});
</script>

</head>

<body class="bg-gradient-primary">

  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row" id="insert">
          <div class="col-lg-5 d-none d-lg-block">
	          <div>
	          	<img alt="join_img" src="/resources/image/join.svg" id="joinImg" width="200" height="200">
	          </div>
	          <div class="text-center" id="text">
	          	<h4>Camping Club에 오신걸 환영합니다!</h4>
	          	<p>Camping Club은 무료 회원제 입니다</p>
	          </div>
          </div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">회원가입</h1>
              </div>
              <form class="user" id="insertUserPost" action="/user/insertUser" method="post">
                <div class="form-group row">
                  <div class="col-sm-12">
                    <input type="text" class="form-control form-control-user" id="user_id" name="user_id" placeholder="아이디" maxlength="15" required>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-12">
                    <button type="button" id="btnCheckId" class="btn btn-primary btn-user">아이디 확인</button>
                    <span id="checkId"></span>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="password" class="form-control form-control-user" id="user_pw" name="user_pw" placeholder="비밀번호" maxlength="15" required>
                  </div>
                  <div class="col-sm-6">
                    <input type="password" class="form-control form-control-user" id="user_pw2" name="user_pw2" placeholder="비밀번호 확인" maxlength="15" required>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-12">
                  <span id="checkPw"></span>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-12">
                  <input type="email" class="form-control form-control-user" id="user_email" name="user_email" placeholder="이메일" maxlength="30" required>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-12">
                    <input type="text" class="form-control form-control-user" id="user_phone" name="user_phone" placeholder="전화번호" onkeypress="onlyNumber();" maxlength="11" required>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-12">
                    <input type="text" class="form-control form-control-user" id="user_name" name="user_name" placeholder="이름" required>
                  </div>
                </div>
                <hr>
                <button type="submit" id="btnInsert" class="btn btn-primary btn-user btn-block" disabled="disabled" >회원가입</button>
                <hr>
              </form>
              <div class="text-center">
                <a class="small" href="/camp/home">메인페이지로 이동</a>
                |
                <a class="small" href="/user/login">로그인</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="/resources/js/sb-admin-2.min.js"></script>

</body>

</html>