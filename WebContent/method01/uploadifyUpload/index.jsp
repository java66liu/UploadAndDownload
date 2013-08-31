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
    <link rel="stylesheet" type="text/css" href="${ctx}/js/uploadify/uploadify.css" />
    <script type="text/javascript" src="${ctx}/js/jquery.min.js"></script> 
    <script type="text/javascript" src="${ctx}/js/uploadify/jquery.uploadify.min.js"></script> 
    <script type="text/javascript">
	jQuery(document).ready(function($){
		 $('#file_upload').uploadify ({
	        'swf': '${ctx}/js/uploadify/uploadify.swf',
	        'uploader': '${ctx}/singleUpload',
	        'fileObjName':'uploadFile',
	        'queueID':'uploadfileQueue',  //文件选择后的容器ID--与某个标签的id属性值一致
	        'multi': true,	        
	        'queueSizeLimit' : 1000,	//上传数量   
	        'auto': false,	        
	        'fileTypeExts': '*.png;*.gif;*.jpg;*.bmp;*.jpeg',  
	        'fileTypeDesc': '图片文件(*.png;*.gif;*.jpg;*.bmp;*.jpeg)', 
	        'fileSizeLimit':'100MB',
	        'buttonImage':'upbutton.gif',
	        'buttonText': '文件上传',
	        'width':'100',
	        'height':'32',	 
	      	//不执行默认的onSelect事件
	        'overrideEvents' : ['onDialogClose'],
	        //每次更新上载的文件的进展
	        'onUploadProgress' : function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {
	             //有时候上传进度什么想自己个性化控制，可以利用这个方法
	             //使用方法见官方说明
	        },
	        //选择上传文件后调用
	        'onSelect' : function(file) {
	                 
	        },
	        //返回一个错误，选择文件的时候触发
	        'onSelectError':function(file, errorCode, errorMsg){
	            switch(errorCode) {
	                case -100:
	                    alert("上传的文件数量已经超出系统限制的"+$('#file_upload').uploadify('settings','queueSizeLimit')+"个文件！");
	                    break;
	                case -110:
	                    alert("文件 ["+file.name+"] 大小超出系统限制的"+$('#file_upload').uploadify('settings','fileSizeLimit')+"大小！");
	                    break;
	                case -120:
	                    alert("文件 ["+file.name+"] 大小异常！");
	                    break;
	                case -130:
	                    alert("文件 ["+file.name+"] 类型不正确！");
	                    break;
	            }
	        },
	        //检测FLASH失败调用
	        'onFallback':function(){
	            alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
	        },
	        //上传到服务器，服务器返回相应信息到data里
	        'onUploadSuccess':function(file, data, response){
	            //alert(data);
	        }
	    });
	});    
    </script>
    <style type="text/css">
            <!-- 
              td {text-align:left;}
           -->
    </style>
</head>
<body>
	<!-- 文件上传的表单 -->
	<form>
		<div id="uploadfileQueue" ></div>
		<input id="file_upload"  type="file" />
		<input type="button" onclick="javascript:$('#file_upload').uploadify('upload','*');" value="上传" />
		<br /><a style="position: relative; top: 8px;" href="javascript:$('#file_upload').uploadify('upload','*')">&nbsp;上&nbsp;传&nbsp;</a>
	</form>
	
	

</body>
</html>