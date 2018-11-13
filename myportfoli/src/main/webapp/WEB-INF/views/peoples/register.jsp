<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../share/header.jsp"%>
<section class="content">
	<!-- 회원가입 -->
	<form id="registerform" enctype="multipart/form-data" method="post"
		onsubmit="return check()">
		<p align="center">
		<table border="1" width="50%" height="80%" align="center">
			<tr>
				<td colspan="3" align="center"><h2>회원가입</h2></td>
			</tr>
			<tr>
				<td rowspan="5" align="center">
					<p></p>
					<img id="img" width="100" height="100" border="1" /><br /> <br />
				<input type='file' id="image" name="image" /><br />
				</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;이메일</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="email" name="email"
					id="email" size="30" maxlength=50 onblur="confirmId()"
					required="required" />
					<div id="emailDiv"></div>
				</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;비밀번호</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="password" name="pw" id="pw"
					size="20" required="required" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;비밀번호
						확인</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="password" id="pwconfirm"
					size="20" required="required" />
				</td>
			</tr>
			<tr>
				<td width="17%" bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;이름</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="text" name="nickname"
					size="20" pattern="([a-z, A-Z, 가-힣]){2,}" required="required"
					title="닉네임은 문자 2자 이상입니다." />
				</td>
			</tr>
			<tr>
				<td align="center" colspan="3">
					<p></p> <input type="submit" value="회원가입" class="btn btn-warning" />
					<input type="button" value="메인으로" class="btn btn-success"
					onclick="javascript:window.location='../'">
					<p></p>
				</td>
			</tr>
		</table>
	</form>
	<br /> <br />
</section>
<script>
var filename = ''
//change 이벤트가 발생하면 readURL 호출
//change는 내용이 변경되면 호출되는 이벤트다.
document.getElementById("image").addEventListener('change', function(){
	readURL(this);
})
//이미지파일을 선택했을 때 미리보기를 수행해주는 메소드
function readURL(input){
	if(input.files && input.files[0]){
		filename = input.files[0].name;
		//확장자 뽑아내기
	//alert(filename) //스크린샷 2018-10-25 오후 4.18.25.png
		var ext = filename.substr(filename.length - 3, filename.length);
		//특정 확장자의 파일만 등록할 수 있게 필터링
		var idCheck = false;
		if((ext.toLowerCase() == "jpg" || ext.toLowerCase() == "gif" || ext.toLowerCase() == "png")){
			isCheck = true;
		}
		if(isCheck == false){
			alert("jpg 나 gif, png 파일만 업로드 가능합니다.");
			return;
		}
		
		var reader = new FileReader();
		reader.onload = function(e){
			document.getElementById('img').src = e.target.result;
			
			//alert(e.target.result)// 스크린샷 2018-10-21 오후 8.44.08.png
		}
			reader.readAsDataURL(input.files[0]);
			
	}
};
</script>
<%@include file="../share/footer.jsp"%>
