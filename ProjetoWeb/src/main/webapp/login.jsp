<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
</head>
<body>
	<div class="container positioner">
		<div class="row">
			<div class="col s12 m8 offset-m2 l8 offset-l2">
				<div class="card-panel grey lighten-custom z-depth-4 ">
					<div class="row">
						<form class="col s12" action="" method="POST">
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
									<br> <label for="email">Email</label> <input id="email"
										type="text" name=""> <label for="email">Senha</label>
									<input id="email" type="password" name="">
									<div class="margin20"></div>
									<label for="tipoDeUsuario">Tipo de usuário</label> <select
										class="white-bg">
										<option value="" disabled selected>Tipo de Usuário</option>
										<option value="1">Administrador</option>
										<option value="2">Professor</option>
									</select>
								</div>
								
								<!-- Divisão da Direita -->
								<div class="col s12 m6 l6">
									<!-- Imagem para Tablets e Desktops -->
									<img class="responsive-img hide-on-small-only"
										src="assets/img/logo-fametro2.png">
									<div class="margin25"></div>
									<div class="container">
										<button class="button-custom" type="submit" name="action">Acessar</button>
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
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<!-- Compiled and minified JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('select').material_select();
		});
	</script>
</body>
</html>