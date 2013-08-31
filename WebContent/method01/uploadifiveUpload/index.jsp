<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	pageContext.setAttribute("ctx",basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />    
    <title>uploadify上传--测试中</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/uploadifive/uploadifive.css" />
    <script type="text/javascript" src="${ctx}/js/jquery.min.js"></script> 
    <script type="text/javascript" src="${ctx}/js/uploadifive/jquery.uploadifive.min.js"></script> 
    <script type="text/javascript">
	jQuery(document).ready(function($){
		//下面代码的功能是：上传工具会在id属性值为file_upload的上传文本框处插入上传按钮
		$('#file_upload').uploadifive({
			'fileObjName'      : 'uploadFile',
			'auto'             : false,
    		'removeCompleted' : true,
			'formData'         : {
					'timestamp' : '1354692360',
					'token'     : '0155c96793a6ccd6ba1b8498f4953799'
			},
			'queueID'          : 'queue',
			'uploadScript'     : '${ctx}/singleUpload',
			'onUploadComplete' : function(file, data) { console.log(data); }
		});
	});    
    </script>
    <style type="text/css">
	body {
		font: 13px Arial, Helvetica, Sans-serif;
	}
	.uploadifive-button {
		float: left;
		margin-right: 10px;
	}
	#queue {
		border: 1px solid #E5E5E5;
		height: 177px;
		overflow: auto;
		margin-bottom: 10px;
		padding: 0 3px 3px;
		width: 300px;
	}
    </style>
</head>
<body>
	<!-- 文件上传的表单 -->
	<h1>UploadiFive Demo</h1>
	<form>
		<div id="queue" ></div>
		<input id="file_upload"  type="file" /><!-- 上传工具会在这里插入上传按钮代码 -->
		<a style="position: relative; top: 8px;" href="javascript:$('#file_upload').uploadifive('upload')">&nbsp;上&nbsp;传&nbsp;</a>
	</form>
	
	

</body>
</html>