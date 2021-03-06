<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Warehouse Connect - Admin</title>
<link href="css/bootstrap-3.3.4.css" rel="stylesheet" type="text/css">
<link href="css/index.css" rel="stylesheet" type="text/css">
<link href="css/admin.css" rel="stylesheet" type="text/css">
<script>
	function resizeIframe(obj) {
		obj.style.height = ((window.innerHeight / 100) * 93) + 'px';
	}
</script>
<script>
	function iframechange(i) {
		if (i == 1) {
			document.getElementById("ifr").setAttribute('src', "./add.jsp");
		}
		if (i == 2) {
			document.getElementById("ifr").setAttribute('src', "./mod.jsp");
		}
	}
</script>
<script>
	function controllo() {
<%String acc = (String) session.getAttribute("log");
			System.out.println(acc);%>
	
<%if (acc.equals("0")) {%>
	alert("Eseguire l'accesso per usufruire delle funzioni da admin!");
		window.open("./index.jsp", "_self");
<%}%>
	}
</script>
<script>
	function logout(i) {
<%session.setAttribute("log", "0");%>
	window.open("./index.jsp", "_self");
	}
</script>
</head>

<body style="background-color: #E1E1E1" onload="controllo()">
	<div class="container-fluid">
		<header class="col-sm-offset-5 col-sm-7"> &nbsp;</header>
		<section class="col-sm-5">
			<img src="./images/trasparentone.png" width="13559" height="8000"
				class="img-responsive">
			<ul class="list">
				<li class="primo" onclick="iframechange(1)">AGGIUNGI</li>
				<li onclick="iframechange(2)">MODIFICA</li>
				<li class="ult">RESOCONTO INCASSI</li>
			</ul>
			&nbsp;
		</section>
		<iframe id="ifr"
			style="color: #FFFFFF; font-size: 16px; border-style: none; background-color: white"
			onload="resizeIframe(this)"></iframe>
	</div>
	<a onclick="logout(1)">Logout</a>
</body>

</html>