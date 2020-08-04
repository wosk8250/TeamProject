<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
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
	#title {
		font-size : 25px;
		color: black;
	}
</style>
</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
	<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
<!-- 로그인 상태 -->


<li class="nav-item dropdown no-arrow">
	<c:choose>
		<c:when test="${not empty sessionScope.user_id}">
		
			<a class="nav-link" href="/user/updateInfo">${sessionScope.user_id}님 반갑습니다.</a>
			<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseMyPage" aria-expanded="true" aria-controls="collapseTwo">
	          <i class="fas fa-fw fa-cog"></i>
	          <span>마이 페이지</span>
	        </a>
	        <div id="collapseMyPage" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
	          <div class="bg-white py-2 collapse-inner rounded">
	            <!-- <h6 class="collapse-header">Custom Components:</h6> -->
	            <a class="collapse-item" href="/user/myReviewList"> 내가 작성한 후기</a>
	            <a class="collapse-item" href="/user/profile">프로필 </a>
	            <a class="collapse-item" href="/user/updateInfo"> 프로필 수정</a>
	            <a class="collapse-item" href="/user/updatePw"> 비밀번호 수정</a>
	          </div>
	        </div>
			<a class="nav-link" href="/user/logout">
        		<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2"></i>
        		<span>로그아웃</span>
        	</a>
		</c:when>
	<c:otherwise>
		<a class="nav-link" href="/user/login">
         			<i class="fas fa-sign-in-alt fa-sm fa-fw mr-2"></i>
         			<span>로그인</span>
         		</a>
		<a class="nav-link" href="/user/insertUser">
         			<i class="fas fa-address-card fa-sm fa-fw mr-2"></i>
         			<span>회원가입</span>
         		</a>

		<hr class="sidebar-divider my-0">
	</c:otherwise>
</c:choose>
</li>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item active">
        <a class="nav-link" href="/camp/home">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>캠핑장</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
       	캠핑이야기
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link" href="/camp/campingReviewList">
          <i class="fas fa-fw fa-table"></i>
          <span>캠핑후기</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/camp/campingToolTalkList">
          <i class="fas fa-fw fa-wrench"></i>
          <span>캠핑장비</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>캠핑후기</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <!-- <h6 class="collapse-header">Custom Components:</h6> -->
            <a class="collapse-item" href="buttons.html">후기</a>
            <a class="collapse-item" href="cards.html">Cards</a>
          </div>
        </div>
      </li>

      <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
          <i class="fas fa-fw fa-wrench"></i>
          <span>Utilities</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Custom Utilities:</h6>
            <a class="collapse-item" href="utilities-color.html">Colors</a>
            <a class="collapse-item" href="utilities-border.html">Borders</a>
            <a class="collapse-item" href="utilities-animation.html">Animations</a>
            <a class="collapse-item" href="utilities-other.html">Other</a>
          </div>
        </div>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        고객센터
      </div>

      <!-- Nav Item - Charts -->
      <li class="nav-item">
        <a class="nav-link" href="/camp/campNoticeList">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>공지사항</span></a>
      </li>

      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="/camp/campingTipList">
          <i class="fas fa-fw fa-table"></i>
          <span>캠핑 수칙</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/camp/faqList">
          <i class="fas fa-fw fa-table"></i>
          <span>자주 묻는 질문</span></a>
      </li>
      <!-- 관리자 로그인 할때 보이기 -->
      <c:choose>
      	<c:when test="${sessionScope.checkAdmin == 9}">
      		<li class="nav-item">
				<a class="nav-link" href="/admin/camp">
				<i class="fas fa-fw fa-table"></i>
				<span>관리자페이지</span></a>
			</li>
      	</c:when>
      	<c:otherwise>
      	</c:otherwise>
      </c:choose>
      
		

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow" id="topbar">

          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

<!-- Sidebar - Brand -->
<!--       <a id="headerTitle" class="sidebar-brand d-flex align-items-center justify-content-center" > -->
<!--         <span> -->
<!--           <img alt="camp" src="/resources/image/tent.svg" width="50" height="50"> -->
<!--         </span> -->
<!--         <span class="sidebar-brand-text mx-3">Camping Club<sup>2</sup></span> -->
<!--       </a> -->
      
      <a class="sidebar-brand d-flex align-items-center justify-content-center" id="title" style="width: 100%;">
        <div class="sidebar-brand-icon">
          <img alt="camp" src="/resources/image/camping_club_icon.svg" width="55" height="55">
        </div>
        <div class="sidebar-brand-text mx-3">Camping Club!</div>
      </a>

            



        </nav>
