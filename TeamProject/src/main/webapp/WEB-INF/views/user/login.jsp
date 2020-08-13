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
	.d-lg-block {
		background-image: url("/resources/image/login_bg.png");
		background-repeat: no-repeat;
		background-position: center;
	}
	#login {
		background-color: rgba(245, 246, 249, 0.2);
	}
</style>
<script>
$(function () {
	var msg = "${message}";
	if(msg == "userBlock"){
		alert("${userStopTime} 까지 이용불가");
	}
	if(msg == "fail"){
		alert("아이디 비밀번호를 확인해 주세요");
	}
	if(msg == "find"){
		alert("전송된 임시 비밀번호를 확인하세요");
	}
});
</script>

</head>

<body class="bg-gradient-primary">

  <div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row" id="login">
              <div class="col-lg-6 d-none d-lg-block"></div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">로그인</h1>
                  </div>
                  <form class="user"  action="/user/login" method="post">
                    <div class="form-group">
                    <input type="text" class="form-control form-control-user" id="user_id" name="user_id" placeholder="아이디">
                    </div>
                    <div class="form-group">
                      <input type="password" class="form-control form-control-user" id="user_pw" name="user_pw" placeholder="비밀번호">
                    </div>
                    <button type="submit" class="btn btn-primary btn-user btn-block">로그인</button>
                  </form>
                  <hr>
                  <div class="text-center">
                    <a class="small" href="/camp/home">메인페이지로 이동</a>
                    |
                    <a class="small" href="/user/insertUser">회원가입 하기</a>
                    |
                    <a class="small" href="/user/findPw">비밀번호 찾기</a>
                  </div>
                </div>
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
