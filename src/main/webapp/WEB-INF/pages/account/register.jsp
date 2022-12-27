<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="../css/login.css">	
</head>
<body>

	<form action="/MobileCity/Account/register">
		<div class="login-wrap">
		  <div class="login-html">
		    <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Register</label>
		    <input id="tab-" type="radio"  class="sign-up"><label for="tab-2" class="tab"></label>
		    <div class="login-form">
		      <div class="sign-in-htm">
		        <div class="group">
		          <label for="user" class="label">Họ tên</label>
		          <input id="use" name="hoten" type="text" class="input">
		        </div>
		        <div class="group">
		          <label for="pass" class="label">Eamil</label>
		          <input id="use" name="email" type="text" class="input" >
		        </div>
		          <div class="group">
		          <label for="pass" class="label">Địa chỉ</label>
		          <textarea class="input" name="diachi" rows="4" cols="25 "></textarea>
		          
		        </div>
		          <div class="group">
		          <label for="pass" class="label">Số điện thoại</label>
		          <input id="pass" name="sdt" type="text" class="input" >
		        </div>
		          <div class="group">
		          <label for="pass" class="label">Mật khẩu</label>
		          <input id="pass" name="matkhau" type="password" class="input" data-type="password">
		        </div>
		        <div class="group">
		          <input id="check" type="checkbox" class="check" checked>
		          <label for="check"><span class="icon"></span> Keep me Signed in</label>
		        </div>
		         <div class="group">
		          <p style="color: red"> ${err}</p>
		        </div>
		        <div class="group">
		          <input type="submit" class="button" value="Sign In">
		        </div>
		        
		        
		      </div>
		  
		      </div>
		    </div>
		  </div>
		
	</form>
</body>
</html>