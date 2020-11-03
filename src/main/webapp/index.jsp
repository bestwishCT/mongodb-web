<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <link rel="stylesheet" href="js/layui-2.5.4/css/layui.css">
  <script src="js/layui-2.5.4/layui.js"></script>
</head>

<body>
	<button type="button" class="layui-btn">视野开放搜索</button>
	<!-- <button type="button" class="layui-btn layui-btn-normal">Opensearch搜素引擎</button>
	<button type="button" class="layui-btn layui-btn-warm">高效稳定</button>
	<a href="https://www.seeyii.com" class="layui-btn">查看视野官网</a> -->
	<br></br>
	<form class="layui-form" action="http://192.168.1.198:8082/opensearch-web/bond/queryCompanyInfoBondInter.dhtml">
		<input type="hidden" name="userId" value="1">
		<div class="layui-form-item">
			<label class="layui-form-label">开放搜素</label>
			<div class="layui-input-block">
				<input type="text" name="searchContent" required
					lay-verify="required" placeholder="搜索内容" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">文本域</label>
			<div class="layui-input-block">
				<textarea name="companyName" placeholder="请输入内容"
					class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	<div class="layui-form-item layui-form-text">
		<label class="layui-form-label">文本域</label>
		<div class="layui-input-block">
			<textarea name="content" placeholder="请输入内容" id="content"
				class="layui-textarea"></textarea>
		</div>
	</div>
	<script>
layui.use('form', function() {
	 function login() {
         $.ajax({
         //几个参数需要注意一下
             type: "POST",//方法类型
             dataType: "json",//预期服务器返回的数据类型
             //url: "http://192.168.1.198:8082/opensearch-web/bond/queryCompanyInfoBondInter.dhtml" ,//url
             data: $('#layui-form').serialize(),
             success: function (result) {
            	 alert("mmmm");
            	 $("#content").val(result);
            	 debugger
                 if (result.resultCode == 200) {
                     alert("SUCCESS");
                 }
             },
             error : function() {
                 alert("异常！");
             }
         });
     }
		});
	</script>
</body>
</html>
