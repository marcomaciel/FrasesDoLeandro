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
                <blockquote>
                    <p>${sessionScope["frase"]}</p>
                </blockquote>
            </div>

            <div id="botao-twitter">
                <p>  
                <a href="https://twitter.com/share" class="twitter-share-button" data-text="${sessionScope["frase"]}" data-url="none" data-via="FrasesDoLeandro" data-lang="pt" data-count="none" data-size="large">Tweetar</a>
                <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src="//platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
                </p>  
            </div>

            <div id="div-botao">
                <p>
                    <a class="button" href="./frase" title="Outra frase...">Outra frase</a>
                </p>    
            </div>
		<jsp:include page="rodape.jsp" />	
    </body>
</html>  