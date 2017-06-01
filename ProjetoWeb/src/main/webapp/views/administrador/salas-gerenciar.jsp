<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:useBean id="turmaDAO" class="br.com.fametro.model.dao.TurmaDAO" />


<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Gerenciar Sala | Administrador</title>
<!-- Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
<!-- Custom CSS -->
<link type="text/css" rel="stylesheet"
	href="/assets/css/custom-page.css" media="screen,projection" />
</head>
<body>
	<c:set var="admin" value="${sessionScope['adminAutenticado']}" />
	<header id="cabecalho">
		<div class="row remove-margin">
			<div class="col s12">
				<img class="responsive-img" src="/assets/img/logo-fametro.jpg">
			</div>
		</div>
		<!-- Estrutura Dropdown para Tablets e Desktops -->
		<ul id="dropdown1" class="dropdown-custom">
			<li><a
				href="<c:url value ='/administrador/alocacao-manual.html'/>">Alocação
					Manual</a></li>
			<li><a
				href="<c:url value ='/administrador/alocacao-automatica.html'/>">Alocação
					Automática</a></li>
		</ul>
		<!-- Estrutura Dropdown para dispositivos Móveis -->
		<ul id="dropdown2" class="dropdown-content-mobile">
			<li><a
				href="<c:url value ='/administrador/alocacao-manual.html'/>">Alocação
					Manual</a></li>
			<li><a
				href="<c:url value ='/administrador/alocacao-automatica.html'/>">Alocação
					Automática</a></li>
		</ul>
		<nav class="green darken-custom">
			<div class="nav-wrapper">
				<a href="" class="brand-logo resize">Bem-Vindo, <c:out
						value="${admin.nome}" />!
				</a> <a href="#" data-activates="menu-mobile" class="button-collapse"><i
					class="material-icons">menu</i></a>
				<!-- Menu para Desktops -->
				<ul id="nav-mobile" class="right hide-on-med-and-down">
					<li ><a class="itens-resize itens-width"
						href="<c:url value ='/administrador/inicio.html'/>">Início</a></li>
					<!-- Dropdown Trigger para Desktops -->
					<li class="itens-even"><a class="dropdown-button itens-resize"
						href="" data-activates="dropdown1">Alocação <i
							class="material-icons right">arrow_drop_down</i></a></li>
					<li class="active"><a class="itens-resize itens-width indicator"
						href="<c:url value ='/administrador/salas.html'/>">Salas</a></li>
					<li><a class="itens-resize itens-width "
						href="<c:url value ='/administrador/turmas.html'/>">Turmas</a></li>
					<li><a class="itens-resize logout-width"
						href="<c:url value ='../logout.html'/>">Sair</a></li>
				</ul>
				<!-- Menu para Tables e Dispositivos Móveis -->
				<ul id="menu-mobile" class="side-nav">
					<li ><a
						href="<c:url value ='/administrador/inicio.html'/>">Início</a></li>
					<!-- Dropdown Trigger para Tablets e dispositivos Móveis-->
					<li><a class="dropdown-button" href=""
						data-activates="dropdown2">Alocação <i
							class="material-icons right">arrow_drop_down</i></a></li>
					<li class="active"><a href="<c:url value ='/administrador/salas.html'/>">Salas</a></li>
					<li><a href="<c:url value ='/administrador/turmas.html'/>">Turmas</a></li>
					<li><a href="<c:url value ='../logout.html'/>">Sair</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<main>
	<c:set var="sala" value="${salaSelect}" /> <!-- Breadcrumb -->
	<nav class="transparent-bg">
		<div class="row margin10">
			<div class="col s12">
				<a href="<c:url value ='/administrador/salas.html'/>"
					class="breadcrumb green-darken-6">Salas</a> <a href="#!"
					class="breadcrumb green-darken-6">Gerenciar</a>
			</div>
		</div>
	</nav>
	
	<c:set var="msgSucess" value="${msgSucess}" />
	
	<div class="row">
		<div class="col s12 m4 offset-m4 l4 offset-l4">
			<div class="col s12 m8 offset-m2 l8 offset-l2">
			
			
			  		<c:if test="${msgSucess != null}">
						<div style="margin-bottom: 0;" class="row">
					      	<div class="col s12 m8 offset-m2 l8 offset-l2">
					        	<div class="card-panel green darken-1 resize-alert center-align valign-wrapper">
						    		<span style="width: 100%;" class="white-text font-alert">
						         		<c:out value="${msgSucess}"/><br>
						       	 	</span>
					       		 </div>
					     	 </div>
					    </div>
					</c:if>
			
			
				<!-- Menu de exibição para sala selecionada -->
				<img id="img-sala" class="responsive-img" src="/assets/img/sala-<c:out value="${sala.status}"/>.png"> 
				<label class="col s12 dynamic-label">SALA <c:out value="${sala.numero}"/></label> 
				<label class="col s12 dynamic-label-red">Capacidade <c:out value="${sala.capacidade}"/> Alunos</label>
				<div class=" col s12 m10 offset-m1 l10 offset-l1 margin10">
				<c:choose>
				
					<c:when test="${sala.status == 'disponível'}">
						<form>
							<button class="button-custom">Alocar</button>
						</form>
						<div class="margin10"></div>
						<form>
							<button class="button-custom">Reservar</button>
						</form>
						<div class="margin10"></div>
						<form action="/administrador/interditar-sala.html" method="POST">
							<input type="hidden" name="numero" value="<c:out value="${sala.numero}"/>">
							<button class="button-custom">Interditar</button>
						</form>
					</c:when>
					<c:when test="${sala.status == 'interditada'}">
						<form>
							<button disabled class="button-custom not-able">Alocar</button>
						</form>
						<div class="margin10"></div>
						<form>
							<button disabled class="button-custom not-able">Reservar</button>
						</form>
						<div class="margin10"></div>
						<form>
							<button class="button-custom">Desinterditar</button>
						</form>
					</c:when>
					<c:otherwise>
							<form>
							<button disabled class="button-custom not-able">Alocar</button>
						</form>
						<div class="margin10"></div>
						<form>
							<button disabled class="button-custom not-able">Reservar</button>
						</form>
						<div class="margin10"></div>
						<form action="/administrador/interditar-sala.html" method="POST">
							<input type="hidden" name="numero" value="<c:out value="${sala.numero}"/>">
							<button class="button-custom">Interditar</button>
						</form>
					</c:otherwise>

				</c:choose>
				
				</div>
			</div>
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
</body>
</html>