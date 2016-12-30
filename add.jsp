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
  <h1 style="text-align:center"><strong>AGGIUNGI PRODOTTO</strong></h1>
</header>
<div class="container-fluid">
<div class="row">
<form class="col-sm-12">
      <div class="col-md-4 col-sm-6">
      <div class="thumbnail"><img src="images/ImgResponsive_Placeholder.png" alt="Miniatura">
        <div class="caption">
          <center><p><a href="#" class="btn btn-primary" role="button">CARICA IMMAGINE...</a></p></center>
        </div>
         <center> 
           <span style="font-weight: bold">Pezzi:</span><br>
	  <input type="number" name="pezzi" min="1" max="999"><br></center>
      </div>
    </div>
      <center class="campi">
	  <span style="font-weight: bold">Numero Seriale:</span><br>
	  <input type="text" name="SN" size="60"><br>
      <span style="font-weight: bold">Nome prodotto:</span><br>
 	  <input type="text" name="nomeprod" size="40"><br>
<span style="font-weight: bold">Tipologia:</span><br>
	  <input type="text" name="tipologia" size="40"><br>
      <span style="font-weight: bold">Marca:</span><br>
 	  <input type="text" name="marca" size="40"><br>
      <span style="font-weight: bold">Prezzo:</span><br>
 	  <input type="text" name="prezzo" size="10"><br><br><br><br><br><br></center>
	  <span style="font-weight: bold">Descrizione breve:</span><br>
	  <textarea rows="4" cols="100" style="resize:none"></textarea><br><br>
      <span style="font-weight: bold">Descrizione lunga:</span><br>
	  <textarea rows="4" cols="100" style="resize:none"></textarea><br><br>
	  <center><button style="background-color:white; border:none" type="submit"><img src="images/piu.png" alt="" width="150" height="149"/></button></center><br>
<br>
</form>
</div>
</div>
</body>
</html>