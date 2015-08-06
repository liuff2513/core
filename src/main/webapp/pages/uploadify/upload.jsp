<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="<%=basePath%>plugins/uploadify/uploadify.css"/>
	<script type="text/javascript" src="<%=basePath%>plugins/jquery/js/jquery-1.8.3.min.js"></script>
 	<script type="text/javascript" src="<%=basePath%>plugins/uploadify/jquery.uploadify.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
	#uploader {
		position: relative;
	}
	
	#uploader_queue {
		position: absolute;
		width: 600px;
		left: 200px;
		top: 0;
	}
</style>
<script>
	$(document).ready(function() {
		$("#file_upload").uploadify({
			'auto' : false,//是否选择文件后自动上传
			'method' : "get",//提交方式
			'formData' : {'folder' : 'file'},//指定文件存放文件夹名称
			'height' : 30,
			'swf' : '<%=basePath%>plugins/uploadify/uploadify.swf', // flash
	        'uploader' : '<%=basePath%>uploadify', // 数据处理url
		    'width' : 120,
			'fileTypeDesc' : '*.png',
			'fileTypeExts' : '*.png',
			'fileSizeLimit' : '700MB',
			'buttonText' : '选择文件',
			'uploadLimit' : 10,//上传文件个数限制
			'successTimeout' : 5,
			'requeueErrors' : false,
			'removeTimeout' : 10,
			'removeCompleted' : false,
			'queueSizeLimit' : 10,
			'queueID' : 'uploader_queue',
			'progressData' : 'speed',
			'cancelImg' : '<%=basePath%>plugins/uploadify/uploadify-cancel.png',
			'onInit' : function() {},
			// 单个文件上传成功时的处理函数
			'onUploadSuccess' : function(file, data, response) {
				//alert(data+"=="+file+"=="+response);
				$("#uploader_view").append('<img height="60" alt="" src="<%=basePath%>upload/source/'+ data + '"/>');
			},
			'onQueueComplete' : function(queueData) {
				$('#uploader_msg').html(queueData.uploadsSuccessful+ ' files were successfully uploaded.');
			}
		});
	});
</script>
</head>
  
  <body>
	<div id="uploader">
		<p>
			<input type="file" name="file_upload" id="file_upload" />
		</p>
		<a href="javascript:$('#file_upload').uploadify('upload','*')">上传</a>&nbsp;
		<a href="javascript:$('#file_upload').uploadify('stop')">取消上传</a>
		<div id="uploader_queue"></div>
		<div id="uploader_msg"></div>
		<div id="uploader_view"></div>
	</div>
</body>
</html>
