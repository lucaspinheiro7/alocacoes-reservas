<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Reservar Laboratório| Professor</title>
<!-- Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
<!-- Custom CSS -->
<link type="text/css" rel="stylesheet"
	href="/assets/css/custom-page.css" media="screen,projection" />
	<style type="text/css">
	select{ overflow-y:auto; }
	 .font-alert{ font-size: 15px; font-weight: bold;}
	 .resize-alert{ width: 100%; height: 50px; line-height: 50px; }
	 .dropdown-content { max-height: 200px;}
	 .select-wrapper input.select-dropdown {text-overflow: ellipsis;}
	</style>



</head>
<body>
	<c:set var="prof" value="${sessionScope['profAutenticado']}" />

	<header id="cabecalho">
		<div class="row remove-margin">
			<div class="col s12">
				<img class="responsive-img" src="/assets/img/logo-fametro.jpg">
			</div>
		</div>
		<!-- Estrutura Dropdown para Tablets e Desktops -->
		<ul id="dropdown1" class="dropdown-custom">
			<li><a href="<c:url value ='/professor/reservar.html'/>">Reservar</a></li>
			<li><a href="<c:url value ='/professor/minhas-reservas.html'/>">Minhas Reservas</a></li>
		</ul>
		<!-- Estrutura Dropdown para dispositivos Móveis -->
		<ul id="dropdown2" class="dropdown-content-mobile">
			<li><a href="<c:url value ='/professor/reservar.html'/>">Reservar</a></li>
			<li><a href="<c:url value ='/professor/minhas-reservas.html'/>">Minhas Reservas</a></li>
		</ul>
		<nav class="green darken-custom">
			<div class="nav-wrapper">
				<a href="#" class="brand-logo resize">Bem-Vindo, <c:out value="${prof.nome}" />!
				</a> <a href="#" data-activates="menu-mobile" class="button-collapse"><i
					class="material-icons">menu</i></a>
				<!-- Menu para Desktops -->
				<ul id="nav-mobile" class="right hide-on-med-and-down">
					<li ><a
						class="itens-resize itens-width" href="<c:url value ='/professor/inicio.html'/>">Início</a></li>
					<!-- Dropdown Trigger para Desktops -->
					<li class="itens-even"><a class="dropdown-button itens-resize indicator"
						href="" data-activates="dropdown1">Reservas <i
							class="material-icons right">arrow_drop_down</i></a></li>
					<li><a class="itens-resize itens-width" href="<c:url value ='/professor/salas.html'/>">Salas</a></li>
					<li><a class="itens-resize itens-width" href="<c:url value ='/professor/turmas.html'/>">Turmas</a></li>
					<li><a class="itens-resize logout-width" href="<c:url value ='../logout.html'/>">Sair</a></li>
				</ul>
				<!-- Menu para Tables e Dispositivos Móveis -->
				<ul id="menu-mobile" class="side-nav">
					<li ><a href="<c:url value ='/professor/inicio.html'/>">Início</a></li>
					<!-- Dropdown Trigger para Tablets e dispositivos Móveis-->
					<li><a class="dropdown-button" href=""
						data-activates="dropdown2">Reservas <i
							class="material-icons right">arrow_drop_down</i></a></li>
					<li><a href="<c:url value ='/professor/salas.html'/>">Salas</a></li>
					<li><a href="<c:url value ='/professor/turmas.html'/>">Turmas</a></li>
					<li><a href="<c:url value ='../logout.html'/>">Sair</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<main>
		<nav class="transparent-bg">
		    <div class="row margin10">
		      	<div class="col s12">
		      	</div>
		    </div>
	  	</nav>
	  	<c:set var="msgSucess" value="${mensagens.msgSucess}" />
	  	<c:set var="msgError" value="${mensagens.msgError}" />
		  	
		  	<c:choose>
					<c:when test="${msgSucess != null}">
						<div class="row remove-margin">
					      	<div class="col s12 m8 offset-m2 l8 offset-l2">
					        	<div class="card-panel green darken-1 resize-alert center-align valign-wrapper">
						    		<span style="width: 100%;" class="white-text font-alert">
						         		<c:out value="${msgSucess}"/><br>
						       	 	</span>
					       		 </div>
					     	 </div>
					    </div>
					</c:when>
					<c:when test="${msgError != null}">
						<div style="margin-bottom: 0;" class="row">
				     		<div class="col s12 m8 offset-m2 l8 offset-l2">
				        		<div class="card-panel red darken-1 resize-alert center-align valign-wrapper">
							    	<span style="width: 100%; font-size:12px;" class="white-text font-alert">
						         		<c:out value="${msgError}"/><br>
							       	</span>
				        		</div>
				      		</div>
					    </div>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
		  	<div class="row">
			  	<div class="container">
			  		<form action="/professor/reservar-laboratorio.html" method="POST">
			  		
					  	<div class="col s12">
					  		<div class="col s12 m3 offset-m2 l3 offset-l2">
					  		<!-- Seleção de turma -->
					  			<label class="col s12 dynamic-label">DATA DA RESERVA</label>
					  			<img class="responsive-img" src="/assets/img/reserva.jpg">
							    <div>
					    			<input type="date" name="dataReserva" required>  
					    		</div>
					  		</div>
					  		<div class="col s12 m2 l2">
					  			<div class="col s12 m8 offset-m2 l8 offset-l2 hide-on-small-only">
					  			<!-- Seta de indicação para tablets e Desktops -->
						  			<i class="material-icons icon-custom green-darken-6 margin-top40">forward</i>
						  		</div>
						  		<div class="col s6 offset-s3 m8 offset-m2 l8 offset-l2 hide-on-med-and-up">
						  		<!-- Seta de indicação para dispositivos móveis -->
						  			<i class="material-icons icon-custom green-darken-6 remove-margin">arrow_downward</i>
						  		</div>
						  	</div>
					  		<div class="col s12 m3 l3 ">
					  			<label class="col s12 dynamic-label">LABORATÓRIO</label>
					  			<img class="responsive-img" src="/assets/img/laboratorio.jpg">
					  			<label class="col s12 dynamic-label">
									<marquee scrolldelay=100 >
										LABORATÓRIO <c:out value="${lab.numero}"></c:out>
										<input type="hidden" name="numero" value="<c:out value="${lab.numero}"/>" >
									</marquee>
								</label>
					  		</div>
					  	</div>
					  	<div class="row">
					  		<div class="col s12">
						  		<div class="margin20 col s10 offset-s1 m4 offset-m4 l4 offset-l4">
						  			<button class="button-custom">Reservar</button>
						  		</div>
						  	</div>
					  	</div>
					</form>
					
				</div>
			</div>
		</main>
	
	<footer class="page-footer grey lighten-1">
		<div class="footer-copyright green darken-5">
			<div class="container">
				<p>©2017 Sistema Gerenciador de Alocações e Reservas</p>
			</div>
		</div>
	</footer>
	<!-- JQuery -->
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<!-- Compiled and minified JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
	<script type="text/javascript">
		//Menu Mobile
		$(".button-collapse").sideNav();
	</script>
		<script type="text/javascript"> 
	  	$(document).ready(function() {
	    	$('select').material_select();
	  	});
  	</script>
</body>
</html>