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
		background-image: url("/resources/image/findingpw.svg");
		background-repeat: no-repeat;
		background-position: top;
		background-size: 250px;
		margin-top: 10px;
	}
	#login {
		background-color: rgba(245, 246, 249, 0.2);
	}
	p {
	padding-top: 270px;
	color: black;
	text-align: center;
	}
</style>
<script>
$(function () {
	var msg = "${message}";

	if(msg == "unfind"){
		alert("아이디와 이메일가 일치하는 정보가 없습니다.");
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
              <div class="col-lg-6 d-none d-lg-block">
                    <p>이메일로 임시 비밀번호가 전송 됩니다.</p>
              </div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">비밀번호 찾기</h1>
                  </div>
                  <form class="user"  action="/email/findPw" method="post">
	                  <div class="form-group">
	                  	<input type="text" class="form-control form-control-user" value="qwer" id="user_id" name="user_id" placeholder="아이디">
	                  </div>
	                  <div class="form-group">
	                  	<input type="email" class="form-control form-control-user" value="rlatkdrl321@gmail.com" id="user_email" name="user_email" placeholder="이메일">
	                  </div>
	                  <button type="submit" class="btn btn-primary btn-user btn-block">확인</button>
                  </form>
                  <hr>
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