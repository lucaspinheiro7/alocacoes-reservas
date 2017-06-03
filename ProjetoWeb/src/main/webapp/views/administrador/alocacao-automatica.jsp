<%@page import="br.com.fametro.model.entity.Administrador"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title> Alocação Automatica | Administrador</title>
	<!-- Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!-- Compiled and minified CSS -->
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
    <!-- Custom CSS -->
    <link type="text/css" rel="stylesheet" href="/assets/css/custom-page.css"  media="screen,projection"/>
    <style>
		.font-alert{ font-size: 15px; font-weight: bold;}
		.resize-alert{ width: 100%; height: 50px; line-height: 50px; }
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
		  	<li ><a href="<c:url value ='/administrador/alocacao-automatica.html'/>">Alocação Automática</a></li>
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
			      	<li ><a href="<c:url value ='/administrador/inicio.html'/>">Início</a></li>
			      	<!-- Dropdown Trigger para Tablets e dispositivos Móveis-->
		      		<li class="active"><a class="dropdown-button" href="" data-activates="dropdown2">Alocação
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
			      	</div>
			    </div>
		  	</nav>
		  	
		  	<c:set var="msgSucess" value="${msgSucess}" />
		  	<c:set var="msgError" value="${msgError}" />
		  	<c:set var="msgStatus1" value="${msgStatus1}" />
			<c:set var="msgStatus2" value="${msgStatus2}" />
		  	
		  	<div class="row">
				<div class="container">
			  	
			  
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
				
				<c:if test="${msgStatus1 != null}">
					<div style="margin-bottom: 10px;;" class="row">
				      	<div class="col s12 m8 offset-m2 l8 offset-l2">
				        	<div class="card-panel yellow darken-3 resize-alert center-align valign-wrapper">
					    		<span style="width: 100%;" class="white-text font-alert">
					         		<c:out value="${msgStatus1}"/><br>
					       	 	</span>
				       		 </div>
				     	 </div>
				    </div>
				</c:if>
				<c:if test="${msgStatus2 != null}">
					<div style="margin-bottom: 10px;;" class="row">
				      	<div class="col s12 m8 offset-m2 l8 offset-l2">
				        	<div class="card-panel yellow darken-3 resize-alert center-align valign-wrapper">
					    		<span style="width: 100%;" class="white-text font-alert">
					         		<c:out value="${msgStatus2}"/><br>
					       	 	</span>
				       		 </div>
				     	 </div>
				    </div>
				</c:if>
				
					
	
					
			  		<form action="/administrador/alocar-automaticamente.html" method="POST">
			  		
					  	<div class="col s12">
					  		<div class="col s12 m8 offset-m2 l8 offset-l2">
					  			<div class="card-panel grey lighten-custom z-depth-5 remove-margin flatten">
					  			<!-- Mensagem de aviso para alocação automátiva -->
						  			<div class="card-panel green darken-5 z-depth-4 remove-margin flatten">
										<p class="center-align warning"> 
											AVISO
										</p>
						  			</div>
				  				<p class="center-align message margin20"> 
									Na alocação automática, todas as turmas disponíveis serão alocadas<br>
									nas salas disponíveis que tenham o mesmo tamanho da turma.<br>
									Não serão alocadas turmas pequenas em salas médias,<br>
									nem turmas médias ou pequenas em salas grandes.<br>
									Caso deseje, isso poderá ser feito na alocação manual.<br>
									Para que a alocação automática seja iniciada,<br>
									clique no botão "Alocar".
								</p>
					  			</div>
					  		</div>
					  	</div>
					  	<div class="row">
					  		<div class="col s12 margin-top40">
						  		<div class="margin0 col s10 offset-s1 m4 offset-m4 l4 offset-l4">
						  			<button class="button-custom">Alocar</button>
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
</body>
</html>