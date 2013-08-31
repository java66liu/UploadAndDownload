<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
pageContext.setAttribute("ctx",basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />   
	<title>Struts2 File Upload</title>
</head>
<body>
	<form action="${ctx}/singleUpload.action" method="post" enctype="multipart/form-data">
		文件标题：<input type="text" name="title" size="50"/><br/>
		选择文件：<input type="file" name="upload" size="50"/><br/>
	   <input type="submit" value=" 上传 "/>        
	</form>
</body>
</html> 