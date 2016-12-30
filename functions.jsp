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
    obj.style.height = ((window.innerHeight/100)*93) + 'px';
   }
</script>
<script>
	function iframechange(i) {
		if (i==1) { document.getElementById("ifr").setAttribute('src', "./add.jsp"); }
	}
</script>
</head>

<body style="background-color:#E1E1E1">
<div class="container-fluid">
<header class="col-sm-offset-5 col-sm-7"> &nbsp;</header>
<section class="col-sm-5"> <img src="./images/trasparentone.png" width="13559" height="8000" class="img-responsive">
  <ul class="list">
    <li class="primo" onclick="iframechange(1)">AGGIUNGI</li>
    <li> MODIFICA</li>
    <li class="ult">RESOCONTO INCASSI</li>
  </ul>
&nbsp;</section>
<iframe id="ifr" style="color: #FFFFFF; font-size: 16px; border-style: none; background-color: white" onload="resizeIframe(this)" ></iframe>
</div>
<a href="#">Logout</a>
</body>

</html>