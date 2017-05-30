<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:useBean id="prof" class="br.com.fametro.model.entity.Professor"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Início</title>
</head>
<body>
		<c:set var="prof" value="${requestScope['profAutenticado']}" />
		
		<h2> <c:out value="${prof.nome}"/> </h2>
		<h2> <c:out value="${prof.email}"/> </h2>
		<h2> <c:out value="${prof.senha}"/> </h2>
	 
	<a href="<c:url value ='/administrador/alocacao-automatica.html'/>">Alocacao Automatica</a>
</body>
</html>