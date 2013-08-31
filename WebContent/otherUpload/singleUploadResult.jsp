<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />   
    <title>文件上传</title>
  </head>
  <body>
  <center>
  	<h1>Sturts 2完成上传</h1>
	标题:<s:property value="title"/><br />
	上传文件名：<s:property value="uploadFileName"/><br />
	文件类型：<s:property value="uploadContentType"/>
  </center>
  </body>
</html>
