<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Camping Club</title>

<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">
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
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center">
				<span class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</span>
				<span class="sidebar-brand-text mx-3">
					관리자님 반갑습니다
					<!-- <sup>2</sup> -->
				</span>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">
			<div class="sidebar-heading">캠핑장 및 회원 관리</div>
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseOne"
				aria-expanded="true" aria-controls="collapseOne"> <i
					class="fas fa-fw fa-cog"></i> <span>캠핑장</span>
			</a>
				<div id="collapseOne" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/admin/camp">목록</a> 
						<a class="collapse-item" href="/admin/waitForRegistrationCamp">등록대기</a> 
						<a class="collapse-item" href="/admin/deleteCamp">이용중지</a>
					</div>
				</div></li>
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-cog"></i> <span>사용자</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<!-- <h6 class="collapse-header">Custom Components:</h6> -->
						<a class="collapse-item" href="/admin/user">사용자</a> <a
							class="collapse-item" href="/admin/blockUser">정지된 사용자</a>
					</div>
				</div></li>
			<li class="nav-item"><a class="nav-link"
				href="/admin/demerit"> <i class="fas fa-fw fa-tachometer-alt"></i> <span>벌점</span></a>
			</li>
		

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">캠핑후기</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link" href="/admin/review">
					<i class="fas fa-fw fa-table"></i> <span>캠핑후기</span>
			</a></li>
			

			<!-- Nav Item - Utilities Collapse Menu -->
			
			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">고객센터</div>

			<!-- Nav Item - Pages Collapse Menu -->
			

			<!-- Nav Item - Charts -->
			<li class="nav-item"><a class="nav-link" href="/admin/notice">
					<i class="fas fa-fw fa-chart-area"></i> <span>공지사항</span>
			</a></li>

			<!-- Nav Item - Tables -->
			<li class="nav-item"><a class="nav-link"
				href="/admin/campingTip"> <i class="fas fa-fw fa-table"></i> <span>캠핑
						수칙</span></a></li>
			<li class="nav-item"><a class="nav-link"
				href="/admin/faq"> <i
					class="fas fa-fw fa-table"></i> <span>자주 묻는 질문</span></a></li>

			

			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">
			<div class="sidebar-heading">기타</div>
			
			
			<li class="nav-item"><a class="nav-link" href="/camp/main">
					<i class="fas fa-fw fa-table"></i> <span>메인</span>
			</a></li>
			<hr class="sidebar-divider">
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
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
			
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Nav Item - User Information -->
				 <a class="sidebar-brand d-flex align-items-center justify-content-center" id="title" style="width: 100%;">
        <div class="sidebar-brand-icon">
         <img alt="camp" src="/resources/image/camping_club_icon.svg" width="55" height="55">
			         </div>
        <div class="sidebar-brand-text mx-3">Camping Club!</div>
      </a>


				</nav>
				<div>
			<img id="topImg" alt="myPage_top" src="/resources/image/myPage_top.jpg" style="margin-bottom: 30px;">		<!-- Sidebar Toggle (Topbar) -->
			</div>
				
