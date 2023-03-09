<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar Emprestimo</title>
<link rel="icon" href="imagens/book1.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="menu">
App Biblioteca - Home - Cadastrar Empréstimo - Listar Empréstimo
</div>
	<h1>Editar Empréstimo</h1>
	<form name="frmEmprestimo" action="update">
		<table align="center">
			<tr align="center">
				<td>Codigo <input type="text" name="codigo"  readonly value="<% out.print(request.getAttribute("codigo")); %>"> </td>
			</tr>
			<tr>
				<td>Data <input type="text" name="data" value="<% out.print(request.getAttribute("data")); %>"></td>
			</tr>
			<tr>
				<td>Observacao <input type="text" name="observacao" value="<% out.print(request.getAttribute("observacao")); %>"></td>
			</tr>
			<tr>
				<td>Usuario <input type="text" name="usuario" value="<% out.print(request.getAttribute("usuario")); %>"></td>
			</tr>
			<tr>
				<td>Tipousuario <input type="text" name="tipousuario" value="<% out.print(request.getAttribute("tipousuario")); %>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao3" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>