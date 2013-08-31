<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<title>SWFUpload Demos - Simple Demo</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/swfupload/swfupload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/swfupload/swfupload.queue.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/swfupload/fileprogress.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/swfupload/handlers.js"></script>
<script type="text/javascript">
		var swfu;

		window.onload = function() {
			var settings = {
				flash_url : "${pageContext.request.contextPath}/js/swfupload/swfupload.swf",
				upload_url: "${pageContext.request.contextPath}/multiUpload",
				file_post_name: "uploadFile",     //上传文件框里的name属性的值
				file_size_limit : "1000 MB",
				file_types : "*.*",
				file_types_description : "All Files",
				file_upload_limit : 100,
				file_queue_limit : 0,
				custom_settings : {
					progressTarget : "fsUploadProgress",
					cancelButtonId : "btnCancel"
				},
				debug: false,

				// Button settings  设置上传按钮
				button_image_url: "${pageContext.request.contextPath}/images/TestImageNoText_65x29.png",
				button_width: "65",
				button_height: "29",
				button_placeholder_id: "spanButtonPlaceHolder",  //充当按钮的标记的id属性值为spanButtonPlaceHolder
				button_text: '<span class="theFont">浏览</span>',
				button_text_style: ".theFont { font-size: 16; }",
				button_text_left_padding: 12,
				button_text_top_padding: 3,
				
				// The event handler functions are defined in handlers.js
				file_queued_handler : fileQueued,
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,

				upload_start_handler : uploadStart,
				upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : uploadSuccess,
				upload_complete_handler : uploadComplete,
				queue_complete_handler : queueComplete	// Queue plugin event
			};

			swfu = new SWFUpload(settings); //这句代码的功能是：上传工具会在id属性值为spanButtonPlaceHolder的标记处插入上传按钮
	     };
	</script>
</head>
<body>
<div id="header">
	<h1 id="logo"><a href="../">SWFUpload</a></h1>
	<div id="version">v2.2.0</div>
</div>

<div id="content">
	<h2>Simple Demo</h2>
	<form>
		<p>This page demonstrates a simple usage of SWFUpload.  It uses the Queue Plugin to simplify uploading or cancelling all queued files.</p>

		<div class="fieldset flash" id="fsUploadProgress">
			<span class="legend">Upload Queue</span>
		</div>
		<div id="divStatus">0 Files Uploaded</div>
		<div>
			<span id="spanButtonPlaceHolder"></span><!-- 上传工具会在这里插入上传按钮代码 -->
			<!-- &nbsp;<a href="javascript:void(0)" id="uploadLink" onclick="triggerUpload()">上传</a>&nbsp;  -->
			<input type="button" id="uploadLink" onclick="triggerUpload()" value="上传"/>
			<input id="btnCancel" type="button" value="Cancel All Uploads" onclick="swfu.cancelQueue();" disabled="disabled" style="margin-left: 2px; font-size: 8pt; height: 29px;" />
		</div>

	</form>
</div>
</body>
</html>
