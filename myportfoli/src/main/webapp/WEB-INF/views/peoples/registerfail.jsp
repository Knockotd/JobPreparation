<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../share/header.jsp"%>
<script>
alert("화원가입에 실패하셨습니다.\n다시 시도하시거나 관리자에게 문의하세요")
if(window.location == 'http://localhost:8080/aisdugo/peoples/registersuccess'){
	setTimeout(location.href='../', 10)
}

</script>
<%@include file="../share/footer.jsp"%>