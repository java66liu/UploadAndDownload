<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
pageContext.setAttribute("ctx",basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />    
		<title>多文件上传</title>
	</head>
	<body>
		<form action="${ctx}/multiUpload" method="post" enctype="multipart/form-data">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>文件标题：</td>
					<td><input type="text" name="title" size="50"/></td>
				</tr>
				<tr>
		  			<td>上传文件1:</td>
		  			<td><input type="file" name="uploadFile" size="50"/></td>
		  		</tr>			
				<tr>
		  			<td>上传文件2:</td>
		  			<td><input type="file" name="uploadFile" size="50"/></td>
		  		</tr>
	  		</table>
		   <input type="submit" value=" 上传 "/>        
		</form>
	</body>
</html>