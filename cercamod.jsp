<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CERCA modifica</title>
</head>
<body>
	<header>
		<h1 style="text-align: center">
			<strong>CERCA</strong>
		</h1>
	</header>
	<div class="container-fluid">
		<div class="row">
			<form class="col-sm-12" action="ricercamod" method="GET"
				enctype="multipart/form-data">
				<center>
					<br>
					<br>SERIALE:<br> <input type="text" name="sncerca"><br>
					<br>
					<button type="submit" style="height: 50px; width: 150px">CERCA
						PER SERIALE</button>
				</center>
				<br> <br>
			</form>
			<hr>
			<form class="col-sm-12" action="ricercanomemod" method="GET"
				enctype="multipart/form-data">
				<center>
					<br>NOME:<br> <input type="text" name="nacerca"
						required=""><br>
					<br> MARCA:<br> <input type="text" name="mccerca"
						required=""><br><br>
					<button type="submit" style="height: 50px; width: 150px">CERCA</button>
				</center>
				<br> <br>
			</form>
		</div>
	</div>

</body>
</html>