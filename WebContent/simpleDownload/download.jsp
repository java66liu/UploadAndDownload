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
		<title>下载页面</title>
	</head>
	<body>
	<div>
		<a href="${ctx}/simpleDownload/downloadAction?fileName=Struts2零基础.ppt">下载一</a> <br />
		<a href="${ctx}/simpleDownload/downloadAction?fileName=Hello.txt">下载二</a>
	</div>
	</body>
</html>