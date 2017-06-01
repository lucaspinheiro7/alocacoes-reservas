<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<!-- Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
<!-- Custom CSS -->
<link type="text/css" rel="stylesheet" href="assets/css/login-page.css"
	media="screen,projection" />
	<style>
		.font-alert{ font-size: 20px; font-weight: bold;}
		.resize-alert{ width: 100%; height: 50px; line-height: 50px; }
	</style>
</head>
<body>
	<c:set var="msg" value="${msg}" />
	<div class="container positioner">
	
	<c:if test="${msg != null}">
		<div style="margin-bottom: 0;" class="row">
	      <div class="col s12 m8 offset-m2 l8 offset-l2">
	        <div class="card-panel red darken-2 resize-alert center-align valign-wrapper">
		    	<span style="width: 100%;" class="white-text font-alert">
	         		<c:set var="msg" value="${msg}" />
	         		<c:out value="${msg}"/>
		       	</span>
	        </div>
	      </div>
	    </div>
	</c:if>
		<div class="row">
			<div class="col s12 m8 offset-m2 l8 offset-l2">
				<div class="card-panel grey lighten-custom z-depth-4">
					<div class="row">
					
						<form class="col s12" action="/autenticacao.html" method="POST">
						
							<div class="row">
								<div class="col s12 m6 l6">
									<!-- Título para dispositivos móveis -->
									<div class="center-align margin20 hide-on-med-and-up">
										<h5>FAÇA O LOGIN</h5>
									</div>
									<!-- Título para tablets e Desktops -->
									<div class="hide-on-small-only">
										<h5>FAÇA O LOGIN</h5>
									</div>
									<div class="margin20"></div>
								</div>
								<!-- Imagem para dispositivos Móveis -->
								<div class="col s12">
									<img class="responsive-img hide-on-med-and-up"
										src="assets/img/logo-fametro2.png">
								</div>
							</div>
							<div class="row">
							
								<!-- Divisão da Esquerda -->
								<div class="col s12 m6 l6">
									<br>
									<label for="email">Email</label>
							        <input id="email" type="text" name="email"> 
							        <label for="email">Senha</label>
							        <input id="email" type="password" name="senha"> 	
							        <div class="margin20"></div>							  
							    	<label for="tipoDeUsuario">Tipo de usuário</label>
								    <select class="white-bg" name="identificador">
								     	<option value="1" selected> Administrador</option>
								      	<option value="2"> Professor</option>
						    		</select>  		        
								</div>
								
								<!-- Divisão da Direita -->
								<div class="col s12 m6 l6">
									<!-- Imagem para Tablets e Desktops -->
									<img class="responsive-img hide-on-small-only"
										src="assets/img/logo-fametro2.png">
									<div class="margin25"></div>
									<div class="container">
										<button class="button-custom">Acessar</button>
									</div>
								</div>
							</div>
							
						</form>
						
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- JQuery -->
	<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
	<!-- Compiled and minified JavaScript -->
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
	<script type="text/javascript"> 
	  	$(document).ready(function() {
	    	$('select').material_select();
	  	});
  	</script>
</body>
</html>