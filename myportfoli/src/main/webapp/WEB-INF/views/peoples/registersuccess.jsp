<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../share/header.jsp"%>
<script>
alert("회원가입에 성공하셨습니다.\n확인버튼을 누르면 메인 페이지로 이동합니다.")
if(window.location == 'http://localhost:8080/aisdugo/peoples/registersuccess'){
	setTimeout(location.href='../', 10)
}

</script>
<%@include file="../share/footer.jsp"%>