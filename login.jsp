<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<header>
		<h1 style="text-align: center">
			<strong>LOGIN</strong>
		</h1>
	</header>
	<div class="container-fluid">
		<div class="row">
			<form class="col-sm-12" action="login" target="_parent" method="GET"
				enctype="multipart/form-data">
					<center>
						<br><br>USERNAME:<br>
						<input type="text" name="user"><br><br>
						PASSWORD:<br>
						<input type="password" name="pass"><br><br>
						<button type="submit" style="height:50px; width:150px">LOGIN</button>
					</center>
				<br> <br>
			</form>
		</div>
	</div>
</body>
</html>