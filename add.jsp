<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Aggiungi Prodotto</title>
<link href="css/bootstrap-3.3.4.css" rel="stylesheet" type="text/css">
<link href="css/admin.css" rel="stylesheet" type="text/css">
</head>

<body>
	<header>
		<h1 style="text-align: center">
			<strong>AGGIUNGI PRODOTTO</strong>
		</h1>
	</header>
	<div class="container-fluid">
		<div class="row">
			<div>
				<div class="thumbnail">
					<img alt="ATTENZIONE"
						src="images/^25B261F7DE3BA212F6505F4E32392692B39B8EC8984D62E916^pimgpsh_fullsize_distr.png">
					<div class="caption">
						<center>
							<form method="POST" action="UploadImage"
								enctype="multipart/form-data">
								Seleziona immagine da caricare: <input type="file" name="file"
									size="60" /> <input type="submit" value="Upload" />
								<%
									if (session.getAttribute("file") != null) {
								%><label>Upload completato</label>
								<%
									}
								%>
			<div class="col-md-4 col-sm-6">
				<div class="thumbnail">
					<img src="images/ImgResponsive_Placeholder.png" alt="Miniatura">
					<div class="caption">
						<center>
							<form method="POST" action="UploadImage"
								enctype="multipart/form-data">
								Seleziona immagine da caricare: <input type="file" name="file"
									size="60" /> <input type="submit" value="Upload" />
								<%if (session.getAttribute("file")!=null){ %><label>Upload completato</label><% } %>
							</form>
						</center>
					</div>
				</div>
			</div>
			<form class="col-sm-12" action="AggiungiProdotto" method="GET"
				enctype="multipart/form-data">
				<center class="campi">
					<span spellcheck="col-xs-12"><span style="font-weight: bold">Numero
							Seriale:</span><br> <input type="text" name="SN" size="60"
						required=""> <br> <span style="font-weight: bold">Nome
							prodotto:</span><br> <input type="text" name="nomeprod" size="40"
						required=""> <br> <span style="font-weight: bold">Categoria:</span><br>
						<select name="categoria">
							<option value="TV">TV</option>
							<option value="COMPUTER & TABLET">COMPUTER & TABLET</option>
							<option value="TELEFONIA & SMARTPHONE">TELEFONIA &
								SMARTPHONE</option>
							<option value="ELETTRODOMESTICI">ELETTRODOMESTICI</option>
							<option value="FOTOCAMERE">FOTOCAMERE</option>
							<option value="CONSOLE">CONSOLE</option>
					</select> <br> <span style="font-weight: bold">Marca:</span><br> <input
						type="text" name="marca" size="40" required=""> <br>
						<span style="font-weight: bold">Prezzo:</span><br> <input
						type="text" name="prezzo" size="10" value="0.0" required="">
						<br> </span>
				</center>
				<div>
			<form class="col-sm-12" action="AggiungiProdotto" method="GET" enctype="multipart/form-data">
				<div class="col-md-4 col-sm-6">
					<center>
						<span style="font-weight: bold">Pezzi:</span><br> <input
							type="number" name="pezzi" min="1" max="999" value="0"
							required=""><br>
					</center>
				</div>
				<br>
				<br>
				<br>
				<center>
					<span class="desb" style="font-weight: bold">Descrizione
						breve:</span><br>
					<textarea name="desb" cols="100" rows="4" required="" class="desb"
						style="resize: none"></textarea>
					<br> <br> <span style="font-weight: bold">Descrizione
						lunga:</span><br>
					<textarea name="desl" rows="4" cols="100" style="resize: none"
						required=""></textarea>
					<br> <br>
				</center>
				<center>
					<button style="background-color: white; border: none" type="submit">
						<img src="images/piu.png" alt="Aggiungi" width="150" height="149" />
					</button>
				</center>
				<br> <br>
			</form>
		</div>
		</div>
		<center class="campi">
			<span style="font-weight: bold">Numero Seriale:</span><br> <input
				type="text" name="SN" size="60" required=""><br> <span
				style="font-weight: bold">Nome prodotto:</span><br> <input
				type="text" name="nomeprod" size="40" required=""><br>
			<span style="font-weight: bold">Categoria:</span><br> <select
				name="categoria">
				<option>TV</option>
				<option>COMPUTER & TABLET</option>
				<option>TELEFONIA & SMARTPHONE</option>
				<option>ELETTRODOMESTICI</option>
				<option>FOTOCAMERE</option>
				<option>CONSOLE</option>
			</select><br> <span style="font-weight: bold">Marca:</span><br> <input
				type="text" name="marca" size="40" required=""><br> <span
				style="font-weight: bold">Prezzo:</span><br> <input type="text"
				name="prezzo" size="10" value="0.0" required=""><br> <br>
			<br> <br> <br> <br>
		</center>
		<span style="font-weight: bold">Descrizione breve:</span><br>
		<textarea name="desb" rows="4" cols="100" style="resize: none"
			required=""></textarea>
		<br> <br> <span style="font-weight: bold">Descrizione
			lunga:</span><br>
		<textarea name="desl" rows="4" cols="100" style="resize: none"
			required=""></textarea>
		<br> <br>
		<center>
			<button style="background-color: white; border: none" type="submit">
				<img src="images/piu.png" alt="" width="150" height="149" />
			</button>
		</center>
		<br> <br>
		</form>
	</div>
	</div>
</body>
</html>