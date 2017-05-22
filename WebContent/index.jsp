<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- Usamos a marcação <%@ %> para fazer configuraçoes na página, como importar classes --%>
<%@ page import="biblioteca.LivroDAO" %>
<%@ page import="biblioteca.Livro" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Considere colocar essa página como index -->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="css/index.css" />
		<title>Biblioteca</title>
	</head>

	<body>
		<h1>Acervo</h1>
		<!-- Inicio do menu de navegação -->
		<nav>
			<ul>
				<li><a href="adicionarLivro.html" id="adicionar">Adicionar</a></li>
				<li><a href="#">Buscar</a></li>
				<li><a href="#">Remover</a></li>
			</ul>
		</nav>
		<!-- Fim do menu de navegação-->
		<!-- Criamos uma tabela com as informações geradas pelo for -->
		<%-- utilizamos <%= %> para passar dados --%>
			<table>
				<th>Título</th>
				<th>Autor</th>
				<th>Gênero</th>
				<th>Editora</th>
				<th>Ano</th>
				<th>ISBN</th>
				<% LivroDAO dao = new LivroDAO();
					Collection<Livro> livros = dao.getLista();
					for (Livro livro : livros) {
				%>
				<tr>
					<td>
						<%=livro.getTitulo() %>
					</td>
					<td>
						<%=livro.getAutor() %>
					</td>
					<td>
						<%=livro.getGenero() %>
					</td>
					<td>
						<%=livro.getEditora() %>
					</td>
					<td>
						<%=livro.getAno() %>
					</td>
					<td>
						<%=livro.getISBN() %>
					</td>
				</tr>
					<% } %>
			</table>
		</body>
</html>