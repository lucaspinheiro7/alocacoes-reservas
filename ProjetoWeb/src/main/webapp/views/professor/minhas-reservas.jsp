<%@page import="br.com.fametro.model.entity.Administrador"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Inicio | Professor</title>
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
		.hidden-over { max-height:20px; overflow: hidden; text-overflow: ellipsis;  }
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
			<li ><a href="<c:url value ='/professor/minhas-reservas.html'/>">Minhas Reservas</a></li>
		</ul>
		<!-- Estrutura Dropdown para dispositivos Móveis -->
		<ul id="dropdown2" class="dropdown-content-mobile">
			<li><a href="<c:url value ='/professor/reservar.html'/>">Reservar</a></li>
			<li ><a href="<c:url value ='/professor/minhas-reservas.html'/>">Minhas Reservas</a></li>
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
					<li><a href="<c:url value ='/professor/inicio.html'/>">Início</a></li>
					<!-- Dropdown Trigger para Tablets e dispositivos Móveis-->
					<li><a class="dropdown-button indicator" href=""
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
		<div class="row">
		<c:set var="msg" value="${fn:toUpperCase('Nenhuma Reserva feita até o momento')}"/>	
		<c:if test="${reservas.size() != 0}">

			<div class="col s11 offset-m1 offset-m1">
			
				<c:forEach var="reserva" items="${reservas}">
			
				<form action="" method="POST">

					<table class="col s12 m4 l2 margin20">
					
						<thead class="remove-border"> 
							<tr>
								<td>
									<img class="responsive-img" src="/assets/img/laboratorio.jpg">
																							
								</td>
							</tr>
						</thead>
						<tbody>
						  	<tr>
						       	<td>
						       		<div class="col s12">
										<label class="col s12 dynamic-label">LABORATÓRIO <c:out value="${reserva.laboratorio.numero }"/></label>
									</div>
										<label class="col s12 dynamic-label">DATA: 
											<label class="dynamic-label-red">
												<c:set var = "data" value = "${reserva.dataReserva}" />
												<fmt:formatDate type ="date" dateStyle ="short" value ="${data}"/>
											</label>
										</label>		
								</td>
							</tr>
						</tbody>
					
					</table>
				
				</form>
				
				</c:forEach>
				
			</div>
	  	</c:if>
			  
		<c:if test="${reservas.size() == 0}">
		<nav class="transparent-bg">
		    <div class="row margin10">
		      	<div class="col s12">
		      	</div>
		    </div>
	  	</nav>
			<label class="col s12 dynamic-label margin-top20">
				<c:out value="${msg}"/>
			</label>
		</c:if>
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
</body>
</html>