<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
                <blockquote>
                    <p>${sessionScope["frase"]}</p>
                </blockquote>
            </div>

            <div id="div-botao">
                <p>
                    <a class="button" href="./frase?f=nova" title="Outra frase">Outra frase</a>
                </p>    
            </div>
		<jsp:include page="rodape.jsp" />	
    </body>
</html>  