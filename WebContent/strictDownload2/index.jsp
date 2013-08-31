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
	background-image: url('${ctx}/images/3.jpg');
	width: 424px;
	height: 250px;
	text-align : center;
  }
  #div2 {
    padding-top:150px;
    padding-right:1px;
  }
</style>
</head>
<body>
<div align="center">
	<div id="div1">
		<div id="div2">
			<s:form action="downloadAction2_login" method="post">
				<s:textfield name="userName" label="用户名"></s:textfield>
				<s:password name="password" label="密   码"></s:password>
				<s:submit value="登 录"></s:submit>
			</s:form>
		</div>
	</div>
</div>
</body>
</html>