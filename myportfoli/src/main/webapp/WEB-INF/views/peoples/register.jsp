<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../share/header.jsp"%>
<section class = "content">
<!-- 회원가입 -->
<form id="registerform" enctype="multipart/form-data" method="post" onsubmit="return check()">
<p align="center">
<table border="1" width="50%" height="80%" align="center">
<tr>
<td colspan="3" align="center"><h2>회원가입</h2></td>
</tr>
<tr><td rowspan="5" align="center">
<p></p><img id="img" width="100" height="100" border="1" /><br/>
<br/><input type='file' id="image" name="image" /><br/>
</td>
</table>

</form>
</section>