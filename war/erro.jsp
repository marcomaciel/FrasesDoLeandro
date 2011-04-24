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
		<p>${param.mensagem}</p>
		<a href="admin">Lista ADM</a>
		<jsp:include page="rodape.jsp" />	
    </body>
</html>  