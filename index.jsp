<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Warehouse Connect - Home</title>
<link href="css/bootstrap-3.3.4.css" rel="stylesheet" type="text/css">
<link href="css/index.css" rel="stylesheet" type="text/css">
<script>
	function resizeIframe(obj) {
		obj.style.height = ((window.innerHeight / 100) * 90) + 'px';
	}
</script>
<script>
	function change() {
		document.getElementById("ifr").setAttribute('src', "./login.jsp");
	}
</script>
<script>
	function search() {
		document.getElementById("ifr").setAttribute('src', "./cerca.jsp");
	}
</script>
<script>
	function show(i) {
		if(i==1){document.getElementById("ifr").setAttribute('src', "./elenco.jsp?TV");}
		if(i==2){document.getElementById("ifr").setAttribute('src', "./elenco.jsp?PC");}
		if(i==3){document.getElementById("ifr").setAttribute('src', "./elenco.jsp?TS");}
		if(i==4){document.getElementById("ifr").setAttribute('src', "./elenco.jsp?EL");}
		if(i==5){document.getElementById("ifr").setAttribute('src', "./elenco.jsp?FO");}
		if(i==6){document.getElementById("ifr").setAttribute('src', "./elenco.jsp?CO");}
	}
</script>
</head>

<body style="background-color: #E1E1E1">
	<div class="container-fluid">
		<header class="col-sm-offset-5 col-sm-7">
			<button type="button" onclick="search()" class="btn btn-sm btn-default button_search">
				<img src="images/Minimal-Magnifying-Glass.png" width="25"
					height="21" alt="Cerca..."/><strong>CERCA... </strong>
			</button>
			&nbsp;
		</header>
		<section class="col-sm-5">
			<img src="./images/trasparentone.png" width="13559" height="8000"
				class="img-responsive">
			<ul class="list">
				<li class="primo" onclick="show(1)">TV</li>
				<li onclick="show(2)">COMPUTER & TABLET</li>
				<li onclick="show(3)">TELEFONIA & SMARTPHONE</li>
				<li onclick="show(4)">ELETTRODOMESTICI</li>
				<li onclick="show(5)">FOTOCAMERE</li>
				<li class="ult" onclick="show(6)">CONSOLE</li>
			</ul>
			&nbsp;
		</section>
		<iframe
			style="color: #FFFFFF; font-size: 16px; border-style: none; background-color: white"
			onload="resizeIframe(this)" src="elenco.jsp?all" id="ifr"> </iframe>
	</div>
	<form>
		<a onclick="change()">Login</a>
	</form>
</body>
</html>