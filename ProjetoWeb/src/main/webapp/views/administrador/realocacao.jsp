<%@page import="br.com.fametro.model.entity.Administrador"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Alocação Automática | Administrador</title>
	<!-- Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!-- Compiled and minified CSS -->
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
    <!-- Custom CSS -->
    <link type="text/css" rel="stylesheet" href="/assets/css/custom-page.css"  media="screen,projection"/>
</head>
<style>
	select{
   		overflow-y:auto;
	 }
	 .font-alert{ font-size: 15px; font-weight: bold;}
	 .resize-alert{ width: 100%; height: 50px; line-height: 50px; }
	 .dropdown-content { max-height: 200px;}
	 .select-wrapper input.select-dropdown {text-overflow: ellipsis;}
</style>
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
			    <a href="" class="brand-logo resize">Bem-Vindo, <c:out value="${admin.nome}"/>!</a>
			    <a href="#" data-activates="menu-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
			    <!-- Menu para Desktops -->
			    <ul id="nav-mobile" class="right hide-on-med-and-down">
			      	<li ><a class="itens-resize itens-width" href="<c:url value ='/administrador/inicio.html'/>">Início</a></li>
			      	<!-- Dropdown Trigger para Desktops -->
		      		<li class="itens-even active"><a class="dropdown-button itens-resize indicator" href="" data-activates="dropdown1">Alocação
		      		<i class="material-icons right">arrow_drop_down</i></a></li>
			     	<li><a class="itens-resize itens-width" href="<c:url value ='/administrador/salas.html'/>">Salas</a></li>
			      	<li><a class="itens-resize itens-width" href="<c:url value ='/administrador/turmas.html'/>">Turmas</a></li>
			      	<li><a class="itens-resize logout-width" href="<c:url value ='../logout.html'/>">Sair</a></li>
			    </ul>
			    <!-- Menu para Tables e Dispositivos Móveis -->
			    <ul id="menu-mobile" class="side-nav">
			      	<li><a href="<c:url value ='/administrador/inicio.html'/>">Início</a></li>
			      	<!-- Dropdown Trigger para Tablets e dispositivos Móveis-->
		      		<li class="active" ><a class="dropdown-button" href="" data-activates="dropdown2">Alocação
		      		<i class="material-icons right">arrow_drop_down</i></a></li>
			     	<li><a  href="<c:url value ='/administrador/salas.html'/>">Salas</a></li>
			      	<li><a  href="<c:url value ='/administrador/turmas.html'/>">Turmas</a></li>
			      	<li><a  href="<c:url value ='../logout.html'/>">Sair</a></li>
			    </ul>
			</div>
		</nav>
	</header>
		<main>
			<!-- Breadcrumb -->
			<nav class="transparent-bg">
			    <div class="row margin10">
			      	<div class="col s12">
				        <a href="#!" class="breadcrumb green-darken-6">Alocação</a>
				        <a href="#!" class="breadcrumb green-darken-6">Alocação Manual</a>
			      	</div>
			    </div>
		  	</nav>
		  	<c:set var="msgSucess" value="${mensagens.msgSucess}" />
		  	<c:set var="msgError" value="${mensagens.msgError}" />
		  	<c:set var="msgStatus" value="${mensagens.msgStatus}" />
		  	
		  	
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
					<c:if test="${msgStatus != null}">
					<div style="margin-bottom: 10px;;" class="row">
				      	<div class="col s12 m8 offset-m2 l8 offset-l2">
				        	<div class="card-panel yellow darken-3 resize-alert center-align valign-wrapper">
					    		<span style="width: 100%;" class="white-text font-alert">
					         		<c:out value="${msgStatus}"/><br>
					       	 	</span>
				       		 </div>
				     	 </div>
				    </div>
				</c:if>
		  	<c:set var="msg1" value="${fn:toUpperCase('Nenhuma Turma disponível até o  momento')}"/>	
		  	<c:set var="msg2" value="${fn:toUpperCase('Nenhuma Sala disponível até o  momento')}"/>	
		  	<div class="row">
			  	<div class="container">
			  	<c:if test="${turmas.size() != 0 && salas.size() != 0}">
			  		<form action="/administrador/realocar-turma.html" method="POST">
			  		
					  	<div class="col s12">
					  		<div class="col s12 m3 offset-m2 l3 offset-l2">
					  		<!-- Seleção de turma -->
					  			<label class="col s12 dynamic-label">TURMA</label>
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
					  			
									<label class="col s12 dynamic-label">
										<marquee scrolldelay=100 >
											<c:out value="${fn:toUpperCase(turma.disciplina)}"></c:out>
											<input type="hidden" name="disciplina" value="<c:out value="${turma.disciplina}"/>" >
										</marquee>
									</label>
							    
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
					  		<!-- Seleção de Sala -->
					  			<label class="col s12 dynamic-label">SALA</label>
					  			<img class="responsive-img" src="/assets/img/sala.jpg">
					  			<select class="white-bg" name="numero">
							     	<c:forEach var="sala" items="${salas}">
							     		<option value="<c:out value="${sala.numero}"/>"> SALA <c:out value="${fn:toUpperCase(sala.numero)}"/></option>
							     	</c:forEach>	
					    		</select>  
					  		</div>
					  	</div>
					  	<div class="row">
					  		<div class="col s12">
						  		<div class="margin20 col s10 offset-s1 m4 offset-m4 l4 offset-l4">
						  			<button class="button-custom">Realocar</button>
						  		</div>
						  	</div>
					  	</div>
					</form>
					</c:if>
				</div>
				<c:if test="${turmas.size() == 0}">
				<label class="col s12 dynamic-label margin-top20">
					<c:out value="${msg1}"/>
				</label>
			</c:if>
			
			<c:if test="${salas.size() == 0}">
				<label class="col s12 dynamic-label margin-top20">
					<c:out value="${msg2}"/>
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
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
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