<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	        <link href="css/frases.css" rel="stylesheet" type="text/css" />
	        <link href="favicon.ico" rel="icon" type="image/x-icon" />
	        <title>Frases do Leandro</title>
	</head>
	<body>
	  	<jsp:include page="topo.jsp" />	
	    <div id="corpo">
		<br/>
		<form method="post" action="/frase?f=inserir">Nova frase:</br>
		
			<input type="hidden" name="acao" id="acao" value="inserir"/>
			<textarea name="texto" id="texto" cols=40 rows=6></textarea></br>
			<input type="submit" value="Inserir" />
		
		</form>
		</div>
				
		<jsp:include page="rodape.jsp" />	
	</body>
</html>  