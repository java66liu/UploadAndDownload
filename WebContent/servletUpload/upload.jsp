<%@ page language="java" pageEncoding="utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
pageContext.setAttribute("ctx",basePath);
%>
<html>
  <head>
    <title>文件上传</title>
  </head>
  <body>
  	<center>
  	<h1>通过Common-FileUpload框架完成上传</h1>
	  <form action="${ctx}/upload.servlet" method="post" enctype="multipart/form-data">
	  	<table>
	  		<tr>
	  			<td>用户名:</td>
	  			<td><input type="text" name="username" ></td>
	  		</tr>
	  		<tr>
	  			<td>上传文件1:</td>
	  			<td><input type="file" name="myFile1"></td>
	  		</tr>
	  		<tr>
	  			<td>上传文件2:</td>
	  			<td><input type="file" name="myFile2"></td>
	  		</tr>
	  		<tr>
	  			<td>上传文件3:</td>
	  			<td><input type="file" name="myFile3"></td>
	  		</tr>
	  		<tr>
	  			<td>上传文件4:</td>
	  			<td><input type="file" name="myFile4"></td>
	  		</tr>
	  		<tr>
	  			<td>上传文件5:</td>
	  			<td><input type="file" name="myFile5"></td>
	  		</tr>
	  		<tr>
	  			<td>上传文件6:</td>
	  			<td><input type="file" name="myFile6"></td>
	  		</tr>	  		
	  		<tr>
	  			<td><input type="submit" value="上传"></td>
	  			<td><input type="reset"></td>
	  		</tr>
	  	</table>
	  </form>
  </center>
  </body>
</html>
