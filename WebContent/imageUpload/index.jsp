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
<title>fileUpload</title>
<style type="text/css">
  #div1 {
	background-image: url('${ctx}/images/1.jpg');
	width: 780px;
	height: 490px;
	text-align : center;
}
  #div2 {
    padding-top:115px;
    padding-right:200px;
    padding-left:100px;
  }
</style>
</head>
<body>
<div id="div1">
<div id="div2">
<s:form action="imageUpload" namespace="/" method="post" enctype="multipart/form-data">
   <s:file name="uploadFile" label="上传图片"></s:file>
   <s:submit value="上传图片"></s:submit>
</s:form>
</div>
</div>
</body>
</html>