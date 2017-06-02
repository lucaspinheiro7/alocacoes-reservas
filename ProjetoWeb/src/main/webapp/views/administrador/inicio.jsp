<%@page import="br.com.fametro.model.entity.Administrador"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<jsp:useBean id="admin" class="br.com.fametro.model.entity.Administrador" />
<jsp:useBean id="turma" class="br.com.fametro.model.entity.Turma" />

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Inicio | Administrador</title>
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
	<c:set var="admin" value="${sessionScope['adminAutenticado']}" />

	<header id="cabecalho">
		<div class="row remove-margin">
			<div class="col s12">
				<img class="responsive-img" src="/assets/img/logo-fametro.jpg">
			</div>
		</div>
		<!-- Estrutura Dropdown para Tablets e Desktops -->
		<ul id="dropdown1" class="dropdown-custom">
			<li><a href="<c:url value ='/administrador/alocacao-manual.html'/>">Alocação Manual</a></li>
			<li><a href="<c:url value ='/administrador/alocacao-automatica.html'/>">Alocação Automática</a></li>
		</ul>
		<!-- Estrutura Dropdown para dispositivos Móveis -->
		<ul id="dropdown2" class="dropdown-content-mobile">
			<li><a href="<c:url value ='/administrador/alocacao-manual.html'/>">Alocação Manual</a></li>
			<li><a href="<c:url value ='/administrador/alocacao-automatica.html'/>">Alocação Automática</a></li>
		</ul>
		<nav class="green darken-custom">
			<div class="nav-wrapper">
				<a href="#" class="brand-logo resize">Bem-Vindo, <c:out value="${admin.nome}" />!
				</a> <a href="#" data-activates="menu-mobile" class="button-collapse"><i
					class="material-icons">menu</i></a>
				<!-- Menu para Desktops -->
				<ul id="nav-mobile" class="right hide-on-med-and-down">
					<li class="active"><a
						class="itens-resize itens-width indicator" href="<c:url value ='/administrador/inicio.html'/>">Início</a></li>
					<!-- Dropdown Trigger para Desktops -->
					<li class="itens-even"><a class="dropdown-button itens-resize"
						href="" data-activates="dropdown1">Alocação <i
							class="material-icons right">arrow_drop_down</i></a></li>
					<li><a class="itens-resize itens-width" href="<c:url value ='/administrador/salas.html'/>">Salas</a></li>
					<li><a class="itens-resize itens-width" href="<c:url value ='/administrador/turmas.html'/>">Turmas</a></li>
					<li><a class="itens-resize logout-width" href="<c:url value ='../logout.html'/>">Sair</a></li>
				</ul>
				<!-- Menu para Tables e Dispositivos Móveis -->
				<ul id="menu-mobile" class="side-nav">
					<li class="active"><a href="<c:url value ='/administrador/inicio.html'/>">Início</a></li>
					<!-- Dropdown Trigger para Tablets e dispositivos Móveis-->
					<li><a class="dropdown-button" href=""
						data-activates="dropdown2">Alocação <i
							class="material-icons right">arrow_drop_down</i></a></li>
					<li><a href="<c:url value ='/administrador/salas.html'/>">Salas</a></li>
					<li><a href="<c:url value ='/administrador/turmas.html'/>">Turmas</a></li>
					<li><a href="<c:url value ='/administrador/logout.html'/>">Sair</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<main> 
	<div class="row">
		<div class="col s11 offset-m1 offset-m1">
			<!-- Tabela que apresentará os resultados que virão do banco de dados -->
		<c:set var="msg" value="${fn:toUpperCase('Nenhuma Turma disponível até o  momento')}"/>	
		
			<c:forEach var="turma" items="${turmas}">
			
			<form action="/administrador/turmas-gerenciar.html" method="POST">

				<table class="col s12 m4 l2 margin20">

						<thead class="remove-border">
							<tr>
								<td>
									<!-- Imagem com tag de disponibilidade --> 
									<c:choose>
										<c:when test="${turma.curso.nome == 'Análise e Desenvolvimento de Sistemas'}">
											<img id="img-ads" class="responsive-img" src="/assets/img/turma-<c:out value="${turma.status}"/>.png">
										</c:when>
										<c:when test="${turma.curso.nome == 'Gestão Comercial'}">
											<img id="img-gescom" class="responsive-img" src="/assets/img/turma-<c:out value="${turma.status}"/>.png">
										</c:when>
										<c:when test="${turma.curso.nome == 'Odontologia'}">
											<img id="img-odonto" class="responsive-img" src="/assets/img/turma-<c:out value="${turma.status}"/>.png">
										</c:when>
										<c:when test="${turma.curso.nome == 'Sistemas de Informação'}">
											<img id="img-sisinf" class="responsive-img" src="/assets/img/turma-<c:out value="${turma.status}"/>.png">
										</c:when>
										<c:when test="${turma.curso.nome == 'Gestão de Recursos Humanos'}">
											<img id="img-gesrh" class="responsive-img" src="/assets/img/turma-<c:out value="${turma.status}"/>.png">
										</c:when>
										<c:when test="${turma.curso.nome == 'Administração'}">
											<img id="img-adm" class="responsive-img" src="/assets/img/turma-<c:out value="${turma.status}"/>.png">
										</c:when>
										<c:when test="${turma.curso.nome == 'Psicologia'}">
											<img id="img-psic" class="responsive-img" src="/assets/img/turma-<c:out value="${turma.status}"/>.png">
										</c:when>
										<c:otherwise>
											<img id="img-dir" class="responsive-img" src="/assets/img/turma-<c:out value="${turma.status}"/>.png">
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<!-- Nome da turma com botão gerenciar -->
									<div class="col s12">
										<label class="col s12 dynamic-label">
										<marquee scrolldelay=100 >
											<c:out value="${fn:toUpperCase(turma.disciplina)}"></c:out>
											<input type="hidden" name="disciplina" value="<c:out value="${turma.disciplina}"/>" >
										</marquee>
										</label>
									</div>
									<button class="button-custom">Gerenciar</button>
								</td>
							</tr>
						</tbody>
						
					</table>
				
				</form>

			</c:forEach>
			
		</div>
			<c:if test="${turmas.size() == 0}">
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