<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<html>
	<head>
	        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	        <link href="css/frases.css" rel="stylesheet" type="text/css" />
	        <link href="favicon.ico" rel="icon" type="image/x-icon">
	        <title>Frases do Leandro</title>
	</head>
	<body>
	  	<jsp:include page="topo.jsp" />	
	    <div id="corpo">
		<br/>
		<form method="post" action="/frase">Nova frase:</br>
		
			<input type="hidden" name="acao" id="acao" value="inserir"/>
			<textarea name="texto" id="texto" cols=40 rows=6></textarea></br>
			<input type="submit" value="Inserir" />
		
		</form>
		</div>
				
		<jsp:include page="rodape.jsp" />	
	</body>
</html>  