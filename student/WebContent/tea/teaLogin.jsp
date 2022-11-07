<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <meta charset="UTF-8">
    <title>学生选课信息管理系统-教师入口</title>
    <link href="style.css" type="text/css" rel="stylesheet"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function check(r) { 
　　if (isNaN(r.username.value)) { 
　　　　alert("请输入教师编号"); 
　　　　r.username.focus();
　　　　return false;
　　} 
}
</script>
  </head>
  <body>
  <div class="login_bg">
			<div class="login_box">
				<div class="login_logo">
					<img class="login_logo_icon" src="img/Slogo.png" alt=""/>
					<img class="login_logo_text" src="img/StudentSelection.png" alt=""/>
				</div>
				<div class="login_line"></div>
				<div class="login_content">
					<h2>学生选课信息管理系统</h2>
					<p>Student Selection Management System</p>
					<form action="servlet/serDoLogin?type=tea" method="post" onSubmit="return check(this)">
						<div class="login_input">
							<input type="text" placeholder="请输入用户名" class="login_username" name="username">
						</div>
		
						<div class="login_input">
							<input type="password" placeholder="请输入密码" class="login_password"  name="password">
						</div>
						<div class="">
							
							<input class="login_btn sure" type="submit" value="登录">
							<input class="login_btn cancle" type="button" value="学生入口 " onclick="window.location.href='/Ten/Login.jsp'">
						</div>
					</form>
				</div>
			</div>
			<div class="text"><p>版权所有 ©2017-2018 学生选课信息系统 保留所有权利</p></div>
		</div>
	</body>

</html>
