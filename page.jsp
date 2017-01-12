<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PAGINA</title>
</head>
<body>
	<jsp:include page='InDBpage'></jsp:include>
	<header>
		<h1 style="text-align: center">
			<strong><%=session.getAttribute("marcapg")%> <%=session.getAttribute("nomepg")%></strong>
		</h1>
	</header>
	<div class="container-fluid">
		<div class="row">
			<div>
				<center>
					<div class="thumbnail">
						<img alt="Immagine del prodotto" style="height: 265px"
							src="<%=session.getAttribute("imgpg")%>">
					</div>
				</center>
			</div>
			<center class="campi">
				<br>
				<h3><%=session.getAttribute("nomepg")%></h3>
				<br>
				<h3><%=session.getAttribute("dlpg")%></h4>
				<br>
				<h3>
					Prezzo 
					<%=session.getAttribute("prezpg")%> &#8364</h3>
				<br>
				<h3>
					Pezzi disponibili:
					<%=session.getAttribute("copiepg")%></h3>
				<br> <br>
			</center>
			<br> <br>
		</div>
	</div>
</body>
</html>