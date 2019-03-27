<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<c:set var="rootPath" 
		value="${pageContext.request.contextPath}" />
<title>Insert title here</title>
</head>
<style>
table {
	border: 1px solid #ccc;
	border-spacing: 1;
}

th, td {
	border: 1px solid #ccc;
	text-align: right;
}
</style>
<script>
	$(function() {
		$("#btn_write").click(function() {
			location.replace("<c:url value='/email_form'/>")
		})
		
		$(".email_tr").click(function() {
			let id = $(this).attr("data-id")
			location.href="${rootpath}/email/update?id="+id 
		})

	})
</script>
<body>
	<header>Email</header>
	<section>
		<form action=<c:url value="/email_write"/> method="POST">
		<table>
			<tr>
				<th>ID</th>
				<th>발송Email</th>
				<th>받는Email</th>
				<th>발송일자</th>
				<th>발송시각</th>
				<th>메일제목</th>
				<th>메일내용</th>
				<th>첨부파일1</th>
				<th>첨부파일2</th>
			</tr>
			<c:choose>
				<c:when test="${empty EMAILS}">
					<tr>
						<td colspan=9>데이터 없음</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="vo" items="${EMAILS}" varStatus="i">
						<tr class="email_tr" data-id="${vo.id}">
							<td>${i.count}</td>
							<td>${vo.from_email}</td>
							<td>${vo.to_email}</td>
							<td>${vo.s_date}</td>
							<td>${vo.s_time}</td>
							<td>${vo.s_subject}</td>
							<td>${vo.s_content}</td>
							<td>${vo.s_file1}</td>
							<td>${vo.s_file2}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		</form>
	</section>
	<br/>
	<button id="btn_write">Write</button>
</body>
</html>