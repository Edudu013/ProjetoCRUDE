<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Criar Exame</title>
<link rel="stylesheet" href="css/materialize.css">
</head>
<body>
	<s:hidden name="nomeExameNulo"/>
	<s:hidden name="dataAtual"/>
	<s:hidden name="nomeDuplicado"/>
	<s:hidden name="erroGeral"/>
	<s:form action="criarExame" theme="simple">
		<label>Nome Exame:</label>
  		<input name="exame.nomeExame" required="required"/>
  		<br/>
		<label>Nome Paciente:</label>
  		<input type="text" name="exame.paciente.nomePaciente" required="required" />
  		<br/>
		<label>Observacao do Exame:</label>
  		<s:textfield name="exame.observacaoExame" label="Observacao Exame" id="data" />
  		<br/>
  		<label>Data do Exame:</label>
  		<input type="date" name="dataExame" required="required" >
  		<br/>
  		<s:submit value="Salvar Exame" />
  		
  		<p><a href="<s:url action='index'/>">Voltar</a></p>
  		
  		<s:if test="nomeExameNulo">
  			<script>
  				alert("Nome do exame deve estar preenchido, para continuar");
  			</script>
  		</s:if>
  		<s:if test="dataAtual">
  			<script>
  				alert("Data do exame, so pode ser maior que a data atual ");
  			</script>
  		</s:if>
  		<s:if test="nomeDuplicado">
  			<script>
  				alert("Nome do paciente ja existe na base");
  			</script>
  		</s:if>
  		<s:if test="erroGeral">
  			<script>
  				alert("Erro desconhecido ");
  			</script>
  		</s:if>
  		<s:if test="sucesso">
  			<script>
  				alert("Incluido com sucesso");
  			</script>
  		</s:if>
	</s:form>
	<script src="js/materialize.js"></script>
</body>
</html>