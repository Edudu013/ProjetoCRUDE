<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exames</title>
<link rel="stylesheet" href="css/materialize.css">
</head>
<body>
	<h1>Exames</h1>
	<table>
		<tr>
			<th>Id</th>	
			<th>Nome Exame</th>	
			<th>Nome Paciente</th>	
			<th>Data do Exame</th>
			<th>Observacao Exame</th>
			<th>Comandos</th>
		</tr>
	<c:forEach items="${obterExames}" var="exame" >
		<tr>
			<td>${exame.idExame}</td>
			<td>${exame.nomeExame}</td>
			<td>${exame.paciente.nomePaciente}</td>
			<td class="data">${exame.dataExame}</td>
			<td>${exame.observacaoExame}</td>
			<td>
				<a href="atualizarExames.action?id=${exame.idExame}">Atualizar Exame</a>
				<a href="deletar.action?id=${exame.idExame}">Deletar Exame</a>
			</td>
		</tr>
	</c:forEach>
	</table>
	
	<p><a href="<s:url action='exames'/>">Criar Exame</a></p>
	<script src="js/materialize.js"></script>
	<script>
	 
	
	</script>
</body>
</html>