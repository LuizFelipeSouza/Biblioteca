<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%-- Usamos a marcação <%@ %> para fazer as importações necessárias  --%>
<%@page import="biblioteca.LivroDAO"%>
 <%@ page import="biblioteca.Livro" %>
 <%@ page import="java.util.Collection" %>
 <%@ page import="java.util.List" %>
 <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Considere colocar essa página como index -->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Biblioteca</title>
	</head>
	
	<body>
		<!-- Criamos uma tabela com as informações geradas pelo for -->
		<table>
			<%-- Tá ocorrendo exceção na linha 21 --%>
			<% LivroDAO dao = new LivroDAO();
				List<Livro> livros = dao.getLista();
				for (Livro livro: livros){
			%>
			<tr>
				<td><%livro.getTitulo(); %></td>
				<td><%livro.getAutor(); %></td>
				<td><%livro.getGenero(); %></td>
				<td><%livro.getEditora(); %></td>
				<td><%livro.getAno(); %></td>
				<td><%livro.getISBN(); %></td>
		</tr>
				<% } %>
		</table>
	</body>
</html>