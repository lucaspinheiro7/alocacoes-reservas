<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


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
		  	<div class="row">
			  	<div class="container">
			  		<form action="" method="">
					  	<div class="col s12">
					  		<div class="col s12 m3 offset-m2 l3 offset-l2">
					  		<!-- Seleção de turma -->
					  			<label class="col s12 dynamic-label">TURMA</label>
					  			<img class="responsive-img" src="/assets/img/curso-disciplina.jpg">
							    <select class="white-bg">
							     	<option value="" disabled selected>  CURSO - Disciplina </option>
							     	<option value="1"> ADS - Lógica Matemática</option>
							      	<option value="2"> ADS - Sistemas Operacionais</option>
					    		</select>  
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
					  			<select class="white-bg">
							     	<option value="" disabled selected>  SALA - Número </option>
							     	<option value="1"> SALA - 100</option>
							     	<option value="2"> SALA - 102</option>
							      	<option value="3"> LABORATÓRIO - 2</option>
					    		</select>  
					  		</div>
					  	</div>
					  	<div class="row">
					  		<div class="col s12">
						  		<div class="margin20 col s10 offset-s1 m4 offset-m4 l4 offset-l4">
						  			<button class="button-custom" type="submit" name="action">Alocar</button>
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