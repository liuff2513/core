<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'colorboxView.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="plugins/jquery/colorbox/colorbox.css">
<script type="text/javascript"
	src="plugins/jquery/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="plugins/jquery/colorbox/colorbox.js"></script>
<style>
body {
	font-size: 14px;
	font-family: Microsoft YaHei, 微软雅黑, Verdana, sans-serif, 宋体;
	line-height: 18px;
}

.section {
	position: relative;
	width: 50%;
	float: left;
}

.title {
	font-size: 16px;
}

.clear {
	clear: both;
	font-size: 1px;
	line-height: 0;
}
</style>
</head>
<body>
	<p>
		jQuery 弹出窗口 <a href="http://www.oschina.net/p/colorbox"
			target="_blank"> ColorBox </a>
	</p>
	<h4>效果：</h4>
	<h4>ColorBox 演示</h4>
	<div class="section">
		<div class="title">弹性过渡</div>
		<p>
			<a class="group1"
				href="http://sandbox.runjs.cn/uploads/rs/74/nlhieis0/girl.jpg"
				title="图片"> 图片 </a>
		</p>
		<p>
			<a class="group1"
				href="http://sandbox.runjs.cn/uploads/rs/74/nlhieis0/girl.jpg"
				title="图片"> 图片 </a>
		</p>
		<p>
			<a class="group1"
				href="http://sandbox.runjs.cn/uploads/rs/74/nlhieis0/girl.jpg"
				title="图片"> 图片 </a>
		</p>
	</div>
	<div class="section">
		<div class="title">渐入过渡</div>
		<p>
			<a class="group2"
				href="http://sandbox.runjs.cn/uploads/rs/74/nlhieis0/girl.jpg"
				title="图片"> 图片 </a>
		</p>
		<p>
			<a class="group2"
				href="http://sandbox.runjs.cn/uploads/rs/74/nlhieis0/girl.jpg"
				title="图片"> 图片 </a>
		</p>
		<p>
			<a class="group2"
				href="http://static.oschina.net/uploads/space/2012/0607/142131_2PqS_28.jpg"
				title="图片"> 图片 </a>
		</p>
	</div>
	<div class="section">
		<div class="title">无过渡，固定宽高（75%屏幕高宽）</div>
		<p>
			<a class="group3"
				href="http://sandbox.runjs.cn/uploads/rs/74/nlhieis0/girl.jpg"
				title="图片"> 图片 </a>
		</p>
		<p>
			<a class="group3"
				href="http://sandbox.runjs.cn/uploads/rs/74/nlhieis0/girl.jpg"
				title="图片"> 图片 </a>
		</p>
		<p>
			<a class="group3"
				href="http://sandbox.runjs.cn/uploads/rs/74/nlhieis0/girl.jpg"
				title="图片"> 图片 </a>
		</p>
	</div>
	<div class="section">
		<div class="title">滑动显示</div>
		<p>
			<a class="group4"
				href="http://sandbox.runjs.cn/uploads/rs/74/nlhieis0/girl.jpg"
				title="图片"> 图片 </a>
		</p>
		<p>
			<a class="group4"
				href="http://static.oschina.net/uploads/space/2012/0709/105428_4aoW_28.jpg"
				title="图片"> 图片 </a>
		</p>
		<p>
			<a class="group4"
				href="http://static.oschina.net/uploads/space/2012/0607/142131_2PqS_28.jpg"
				title="图片"> 图片 </a>
		</p>
	</div>
	<div class="section">
		<div class="title">其他类型</div>
		<p>
			<a class='ajax' href="ajaxColorBox" title="Homer Defined">
				外部HTML(Ajax) </a>
		</p>
		<p>
			<a class='youtube'
				href="http://player.youku.com/player.php/sid/XMzI2NTUzMjcy/v.swf"
				title="Apologize现场版"> 嵌入视频 </a>
		</p>
		<p>
			<a class='iframe' href="http://osctools.net"> 外部网页(Iframe) </a>
		</p>
		<p>
			<a class='inline' href="#inline_content"> 内嵌HTML </a>
		</p>
	</div>

	<div class="section">
		<div class="title">使用回调函数示例</div>
		<p>
			<a class='callbacks'
				href="http://sandbox.runjs.cn/uploads/rs/74/nlhieis0/girl.jpg"
				title="图片"> 带有alert示例 </a> . 回调函数使得用户能够扩展插件的一部分功能.
		</p>
		<div style="display:none">
			<div id="inline_content" style="padding:10px; background:#fff;">
				<p>
					<strong> This content comes from a hidden element on this
						page. </strong>
				</p>
				<p>The inline option preserves bound JavaScript events and
					changes, and it puts the content back where it came from when it is
					closed.</p>
				<p>
					<a id="click" href="#" style="padding:5px; background:#ccc;">
						Click me, it will be preserved! </a>
				</p>

				<p>
					<strong> If you try to open a new ColorBox while it is
						already open, it will update itself with the new content. </strong>
				</p>
				<p>
					Updating Content Example: <br> <a class="ajax cboxElement"
						href="http://static.oschina.net/uploads/space/2012/0607/142131_2PqS_28.jpg">
						Click here to load new content </a>
				</p>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</body>
</html>
