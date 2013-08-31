<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
pageContext.setAttribute("ctx",basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>down</title>
<style type="text/css">
  #div1 {
	background-image: url('${ctx}/images/2.JPG');
	width: 440px;
	height: 180px;
	text-align : center;
}
  #div2 {
    padding-top:120px;
    padding-right:200px;
  }
  .link{
    text-decoration: none;
    color: #945600 
  }
</style>
</head>
<body>
<div align="center">
<div id="div1">
<div id="div2">
	<a href="${ctx}/strictDownload/downloadAction_check?downloadFileName=Hello.txt" class="link">Hello.txt</a>
	<br /><br />
	<a href="${ctx}/strictDownload/downloadAction_check?downloadFileName=Struts2零基础.ppt" class="link">Struts2零基础.ppt</a>
	<br /><br />
	<s:a action="downloadAction_check?downloadFileName=Hello.txt" cssClass="link">文本文件下载.txt</s:a>
</div>
</div>
</div>
</body>
</html>