<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>

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
				<c:forEach items="${frases}" var="frase">
	    			<li>${frase.texto}</li>
				</c:forEach>
				<br/>
			</div>
		<jsp:include page="rodape.jsp" />	
	</body>
</html>  