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
	<button type="button" class="layui-btn">数据处理平台(测试版)</button>
	<div class="layui-upload">
  		<button type="button" class="layui-btn layui-btn-normal" id="testList">选择多文件</button>
  		<input type="text" id="relation" name="searchContent" required
					lay-verify="required" placeholder="关联字段(only one)" autocomplete="off"
					class="layui-input">
		<input type="text" id="populate" name="searchContent" required
					lay-verify="required" placeholder="填充字段(多个用 | 隔开)" autocomplete="off"
					class="layui-input">			
  		<div class="layui-upload-list">
    	<table class="layui-table">
        <thead>
        <tr><th>文件名</th>
        <th>大小</th>
        <th>状态</th>
        <th>操作</th>
        </tr></thead>
        <tbody id="demoList"></tbody>
    	</table>
  	</div>
  <button type="button" class="layui-btn" id="testListAction">开始解析</button>
  <button class="layui-btn" onclick="exportData();">导出结果数据</button>
</div> 
 <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">操作注意事项</label>
    <div class="layui-input-block">
    <blockquote class="layui-elem-quote">1 上传的主表excel文件名必须包含  主表  关键字，辅表文件名 必须包含  辅表  关键字</blockquote>
    <blockquote class="layui-elem-quote">2 主辅表必须给每列命名，且必须为英文，第一个输入框输入2个表关联字段，第二个输入框输入需要在辅表填充的字段，多个字段用  | 隔开</blockquote>
    </div>
  </div>
	<br></br>
<!-- 	<form class="layui-form" action="http://192.168.1.198:8082/opensearch-web/bond/queryCompanyInfoBondInter.dhtml">
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
	</form> -->
<!-- 	<div class="layui-form-item layui-form-text">
		<label class="layui-form-label">文本域</label>
		<div class="layui-input-block">
			<textarea name="content" placeholder="请输入内容" id="content"
				class="layui-textarea"></textarea>
		</div>
	</div> -->
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

layui.use('upload', function(){
	  var $ = layui.jquery
	  ,upload = layui.upload;
	  //多文件列表示例
	  var demoListView = $('#demoList')
	  ,uploadListIns = upload.render({
	    elem: '#testList'
	    ,url: 'parseExcel/excel' //改成您自己的上传接口
	    ,accept: 'file'
	    ,multiple: true
	    ,auto: false
	    ,bindAction: '#testListAction'
	    ,choose: function(obj){   
	      var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
	      //读取本地文件
	      obj.preview(function(index, file, result){
	        var tr = $(['<tr id="upload-'+ index +'">'
	          ,'<td>'+ file.name +'</td>'
	          ,'<td>'+ (file.size/1024).toFixed(1) +'kb</td>'
	          ,'<td>等待上传</td>'
	          ,'<td>'
	            ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
	            ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
	          ,'</td>'
	        ,'</tr>'].join(''));
	        
	        //单个重传
	        tr.find('.demo-reload').on('click', function(){
	          obj.upload(index, file);
	        });
	        
	        //删除
	        tr.find('.demo-delete').on('click', function(){
	          delete files[index]; //删除对应的文件
	          tr.remove();
	          uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
	        });
	        
	        demoListView.append(tr);
	      });
	    }
	    ,
	    before: function(obj){
	        this.data={
	        		'relationfield':$('#relation').val(),
	        		'populatefield':$('#populate').val(),
	        		
	        };//上传文件并传递附加参数
	        } 
	    ,done: function(res, index, upload){
	    	debugger
	      if(res.code == 1){ //上传成功
	        var tr = demoListView.find('tr#upload-'+ index)
	        ,tds = tr.children();
	        tds.eq(2).html('<span style="color: #5FB878;">数据解析成功</span>');
	        tds.eq(3).html(''); //清空操作
	        return delete this.files[index]; //删除文件队列已经上传成功的文件
	      }
	      this.error(index, upload);
	    }
	    ,error: function(index, upload){
	      var tr = demoListView.find('tr#upload-'+ index)
	      ,tds = tr.children();
	      tds.eq(2).html('<span style="color: #FF5722;">解析失败</span>');
	      tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
	    }
	  });
	});
	
//导出
function exportData() {
	window.open("parseExcel/exportData");
/*     $.ajax({
        type: "post", url: "parseExcel/exportData", data: {}, success: function (result) {
            if (result.status == 0) {
                window.open(result.data)
            }
            if (result.message != null) {
                layer.msg(result.message)
            }
        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
            layer.msg('{"status":"' + XMLHttpRequest.status + '","readyState":"' + XMLHttpRequest.readyState + '","textStatus":"' + textStatus + '","errorThrown":"' + errorThrown + '"}')
        }
    }) */
};
	</script>
</body>
</html>
