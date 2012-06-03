<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<html>
	<head>
	        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	        <link href="css/frases.css" rel="stylesheet" type="text/css" />
	        <link href="favicon.ico" rel="icon" type="image/x-icon">
	       	<title>Frases do Leandro</title>
	       	<script type="text/javascript">
				function confirmaExclusao(codigo) {    
				    if (confirm('Confirma exclusão da frase?')) {    
				        location.href = 'frase?acao=excluir&id=' + codigo;  
				    }  
				} 
			</script>
	</head>
	<body>
		<jsp:include page="topo.jsp" />	
	        <div id="corpo">
				<br/>
				<c:forEach items="${frases}" var="frase">
	    			<li>
	    				${frase.texto} - 
	    				<a href="alterar.jsp?id=${frase.id}&frase=${frase.texto}">Alterar</a> -- 
	    				<a href="javascript:confirmaExclusao(${frase.id})">Excluir</a>
	    			</li>
				</c:forEach>
				<br/>
				<a href="inserir.jsp">Nova frase</a>
			</div>
		<jsp:include page="rodape.jsp" />	
	</body>
</html>  