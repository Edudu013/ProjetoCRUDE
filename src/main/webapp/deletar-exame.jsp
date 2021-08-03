<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deletar Exame</title>
<link rel="stylesheet" href="css/materialize.css">
</head>
<body>
	<s:hidden name="nomeExameNulo"/>
	<s:hidden name="dataAtual"/>
	<s:hidden name="nomeDuplicado"/>
	<s:hidden name="erroGeral"/>
	<s:form action="deletarExames" theme="simple">
		<h3>Deseja excluir o exame?</h3>
		<s:hidden val="id" name="exame.idExame" />
		<p>Nome do exame: <s:property value="exame.nomeExame"></s:property></p>
  		<br/>
  		<s:submit value="Deletar exame" />
  		
  		<p><a href="<s:url action='index'/>">Voltar</a></p>
	<script>
  		<s:if test="erroGeral">
  			<script>
  				alert("Erro desconhecido ");
  			</script>
  		</s:if>
  		<s:if test="sucesso">
  			<script>
  				alert("Excluido com sucesso");
  			</script>
  		</s:if>
	</s:form>
	<script src="js/materialize.js"></script>
</body>
</html>