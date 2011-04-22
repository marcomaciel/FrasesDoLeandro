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
        <div id="leandro-direita"></div>
        <div id="leandro-esquerda"></div>
        <div id="tudo">
            <div id="topo">
                <h1>
                    <a href=".">Frases do <strong>Leandro</strong></a>
                </h1>
            </div>
            <div id="corpo">
                <blockquote>
                    <p>${sessionScope["frase"]}</p>
                </blockquote>
            </div>

            <div id="div-botao">
                <p>
                    <a class="button" href="./frase" title="Outra frase">Outra frase</a>
                </p>    
            </div>
            <div id="rodape">
                <p>
                    <img src="http://code.google.com/appengine/images/appengine-silver-120x30.gif" 
                         alt="Powered by Google App Engine" />
                </p>
            </div>
        </div>
		<jsp:include page="analytics.html" />
    </body>
</html>  