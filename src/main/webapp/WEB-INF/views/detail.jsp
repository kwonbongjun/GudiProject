<%@page import="com.java.web.Bean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../resources/css/springNotice.css">
<script>

<%
	Bean detail=(Bean) request.getAttribute("detail");	
	String title;
	String val;
	int no;
	String filename;
	if(detail==null){
		title="";
		val="";
		no=0;
		filename="";
	}else{
		no=detail.getNo();
		title=detail.getTitle();
		val=detail.getVal();
		filename=detail.getFileName();
	}
%>
var dt = new DataTransfer();
function load() {
	document.getElementById("title").value=<%="\""+title+"\""%>;
	document.getElementById("val").value=<%="\""+val+"\""%>;
	
}
function formList() {
	console.log(dt);
}
function file_Event(obj){
	console.log(obj.files);
	for (var i =0; i< obj.files.length;i++) {
		var fileName = obj.files[i].name;
		var ext = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length);
		console.log(fileName,ext);
		dt.items.add(obj.files[i]);
	}
	//obj.files = dt.files;
	//console.log(obj.files); 
} 
function formCheck() {
	if(document.getElementsByTagName("form")[0].getElementsByTagName("input")[1].value==""
			|| document.getElementsByTagName("form")[0].getElementsByTagName("input")[2].value=="" ) {
		return false;
	}
}
</script>
</head>
<body onload="load()">

	<div id="write">
		<form method="POST" enctype="multipart/form-data">
			<input type="hidden" name="no" value="<%=no%>">
			<input id="title" type="text" name="title">
			<input id="val" class="text" type="text" name="val">
			<% if(detail!=null){%><a href="/download?boardnum=<%=no%>"><%=detail.getFileName()%></a><%} %>
			<input id="file" type="file" name="file" multiple="multiple"  onchange="file_Event(this)">
			<input type="submit"  <%if(session.getAttribute("login")!=null){%>formaction="/create" value="추가" method="POST" onclick="return formCheck()"<%}%>>
			<input type="submit"  <%if(session.getAttribute("login")!=null){%>formaction="/update" value="업데이트" method="POST"<%}%>method="GET" onsubmit="formCheck()" value="업데이트">
			<input type="submit"  <%if(session.getAttribute("login")!=null){%>formaction="/delete" value="삭제" method="POST"<%}%>method="GET" onclick="loginCheck()" value="삭제">
			<button type="button" formaction="/" onclick="load()">뒤로가기</button>
		</form>
	</div>
</body>
</html>