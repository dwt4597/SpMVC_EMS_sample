<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<c:set var="rootPath" 
		value="${pageContext.request.contextPath}" />
<script>
	$(function() {
		$("#btn_save").click(function() {
			$("form").submit()
		})
		$("#btn_delete").click(function(){
			let id=$("#id").val() 
			location.href="${rootpath}/email/delete?id="+id 
		})
	})
</script>

<section>
<!-- 
<c:if test="${button=='update'}">
	<form method="POST" enctype="multipart/form-data" action="${rootpath}/email/update">
	
</c:if>
<c:if test="${button=='insert'}">
	<form method="POST" enctype="multipart/form-data">
	
</c:if>
 -->
	<form method="POST" enctype="multipart/form-data">

	<fieldset>
	<legend>Email Write</legend>
	
	<input type="hidden" id="id" value="<c:out value='${VO.id}' default='0' />" name="id">
	
	<label>발송Email</label>
	<input type="text" name="from_email" 
			id="from_email" value="${VO.from_email}"><br/>
	<label>받는Email</label>
	<input type="text" name="to_email" 
			id="to_email" value="${VO.to_email}"><br/>
	<label>발송일자</label>
	<input type="text" name="s_date" 
			id="s_date" value="${VO.s_date}"><br/>
	<label>발송시각</label>
	<input type="text" name="s_time" 
			id="s_time" value="${VO.s_time}"><br/>
	<label>메일제목</label>
	<input type="text" name="s_subject" 
			id="s_subject" value="${VO.s_subject}"><br/>
	<label>메일내용</label>
	<input type="text" name="s_content" 
			id="s_content" value="${VO.s_content}"><br/>
	
	<div>
	<label>첨부파일1</label>
	<input type="file" name="s_filea" 
			id="s_filea"><br/>
	<label>첨부파일2</label>
	<input type="file" name="s_fileb" 
			id="s_fileb"><br/>
	</div>
	<br/>
	<c:if test="${button=='insert' }">
	<button type="button" id="btn_save">보내버리기</button>
	</c:if>
	</fieldset>
	<c:if test="${button=='update' }">
		<button>수정</button>
		<button type="button" id="btn_delete">삭제</button>
	</c:if>
</form>
</section>