<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!--JSTL 사용을 위한 코드 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 모든 곳에 적용할 제목 -->
<title>Spring MVC Board</title>

<!-- 너비를 디바이스의 크기에 맞추도록 설정 -->
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>

<!-- 부트스트랩 css파일의 링크를 설정한 것
	${pageContext.request.contextPath} : webapp-root 디렉토리의 절대 경로
	이 설정을 이용하면 모든 곳에서 일정한 URL을 만들 수 있음 -->
	<!-- min이 붙은건 공백을 제거하겠다는 거라서 상관없음 -->
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css" />

<!-- IE9버전 이하에서 HTML5태그를 출력하기 위한 설정 -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.comrespond/1.4.2respond.min.js"></script>
    <![endif]-->

</head>
<!-- jQuery 링크 설정 -->
<!-- jQuery 2.1.4 -->
<script
	src="${pageContext.request.contextPath}/resources/jquery/jquery.js"></script>

<!-- 기본화면 설정 -->
<body class="skin-blue sidebar-mini">
	<div class="wrapper">
		<header class="main-header">
			<div class="page-header">
				<h1>Spring MVC 게시판</h1>
			</div>
		</header>
	</div>
	
	<!-- 기본메뉴 -->
	<aside class="main-sidebar">
		<section class="sidebar">
			<ul class="nav nav-tabs">
				<li role="presentation" class="active"><a href="#">메인</a></li> <!-- active는 처음이 이게 선택되어 있도록 하는 설정이다. -->
				<li role="presentation"><a href="#">목록보기</a></li>
				<li role="presentation"><a href="#">게시물 쓰기</a></li>
				<li role="presentation"><a href="${pageContext.request.contextPath}/user/register">회원가입</a></li>
			</ul>
		</section>
	</aside>
	<div>
</body>
</html>