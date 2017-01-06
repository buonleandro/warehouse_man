<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Modifica Prodotto</title>
<link href="css/bootstrap-3.3.4.css" rel="stylesheet" type="text/css">
<link href="css/admin.css" rel="stylesheet" type="text/css">
</head>

<body>
	<header>
		<h1 style="text-align: center">
			<strong>MODIFICA PRODOTTO</strong>
		</h1>
	</header>
	<div class="container-fluid">
		<div class="row">
			<div>
				<div class="thumbnail">
					<img alt="Immagine del prodotto" style="height: 265px"
						src="<%=session.getAttribute("img")%>">
				</div>
			</div>
			<form class="col-sm-12" action="ModificaProdotto" method="GET"
				enctype="multipart/form-data">
				<center class="campi">
					<span spellcheck="col-xs-12"><span style="font-weight: bold">Numero
							Seriale:</span><br> <input type="text" name="SN" size="60"
						required="" value="<%=session.getAttribute("sn")%>"> <br>
						<span style="font-weight: bold">Nome prodotto:</span><br> <input
						type="text" name="nomeprod" size="40" required=""
						value="<%=session.getAttribute("nome")%>"> <br> <span
						style="font-weight: bold">Categoria (selezionare di nuovo):</span><br><strong>Categoria precedente: <%=session.getAttribute("tipo")%></strong><br><select
						name="categoria">
							<option value="TV">TV</option>
							<option value="COMPUTER & TABLET">COMPUTER & TABLET</option>
							<option value="TELEFONIA & SMARTPHONE">TELEFONIA &
								SMARTPHONE</option>
							<option value="ELETTRODOMESTICI">ELETTRODOMESTICI</option>
							<option value="FOTOCAMERE">FOTOCAMERE</option>
							<option value="CONSOLE">CONSOLE</option>
					</select> <br> <span style="font-weight: bold">Marca:</span><br> <input
						type="text" name="marca" size="40" required=""
						value="<%=session.getAttribute("marca")%>"> <br> <span
						style="font-weight: bold">Prezzo:</span><br> <input
						type="text" name="prezzo" size="10" required=""
						value="<%=session.getAttribute("prez")%>"> <br> </span>
				</center>
				<div>
					<center>
						<span style="font-weight: bold">Pezzi:</span><br> <input
							type="number" name="pezzi" min="0" max="999" required=""
							value="<%=session.getAttribute("num")%>"><br>
					</center>
				</div>
				<br> <br> <br>
				<center>
					<span class="desb" style="font-weight: bold">Descrizione
						breve:</span><br>
					<textarea name="desb" cols="100" rows="4" required="" class="desb"
						style="resize: none"><%=session.getAttribute("desb")%></textarea>
					<br> <br> <span style="font-weight: bold">Descrizione
						lunga:</span><br>
					<textarea name="desl" rows="4" cols="100" style="resize: none"
						required=""><%=session.getAttribute("desl")%></textarea>
					<br> <br>
				</center>
				<center>
					<button style="background-color: white; border: none" type="submit">
						<img src="images/643368_good_512x512.png" alt="Fatto" />
					</button>
				</center>
				<br> <br>
			</form>
		</div>
	</div>
</body>
</html>