<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../share/header.jsp"%>
<section class="content">
	<div class="box">
		<div class="box-header with-border">
			<table border="1" text-align="center">
				<th>title</th>
				<th>pubdate</th>
				<c:forEach var="data" items="${data}">
					<tr>
						<td><a href="${data.link}">${data.title}</a></td>
						<td rowspan="2">${data.pubdate}</td>
					</tr>
					<tr>
						<td>설명: ${data.content}</td>
					</tr>
						
					
					
				</c:forEach>
			</table>
		</div>
	</div>
	<%@include file="../share/footer.jsp"%>