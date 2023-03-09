

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
	@ SuppressWarnings ("unchecked")
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("emprestimos");

%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Lista de Emprestimos</title>
<link rel="icon" href="imagens/book1.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="menu">
App Biblioteca - Home - Cadastrar Empréstimo - Listar Empréstimo
</div>
	<h1>Lista de Emprestimos Cadastrados</h1>
	<a href="novo.html" class="Botao1">Novo Empréstimo</a>
	<a href="report" class="Botao3">Relatório</a>
	<table id="tabela" align="center">
		<thead>
			<tr align="center">
				<th>Código</th>
				<th>Data</th>
				<th>Observação</th>
				<th>Usuário</th>
				<th>Tipo de usuário</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < lista.size(); i++) {
			%>
			<tr align="center">
				<td><%=lista.get(i).getCodigo()%></td>
				<td><%=lista.get(i).getData()%></td>
				<td><%=lista.get(i).getObservacao()%></td>
				<td><%=lista.get(i).getUsuario()%></td>
				<td><%=lista.get(i).getTipoUsuario()%></td>
				<td>
					<a href="select?idcon=<%=lista.get(i).getCodigo()%>"
					class="Botao1">Editar</a>
					<a href="javascript: confirmar(<%=lista.get(i).getCodigo() %>)"
					class="Botao2">Excluir</a>
					<a href=""
					class="Botao3">Adicionar Livro</a>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>