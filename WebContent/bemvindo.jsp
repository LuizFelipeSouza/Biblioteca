<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Bem vindo</title>
	</head>

	<body>
		<%--A tecnologia JSP permite que utilizemos o HTML e o Java --%>
		<% String mensagem = "Bem vindo à Biblioteca Nevice"; %>
		<%-- O JSP já vem com a variável out do tipo JspWriter que permite imprimir para o respose através do println() --%>
		<% out.println(mensagem); %>
		<% String desenvolvido = "Desenvolvido por Luiz Nevice I"; %>
		<%-- Atalho para imprimir o conteúdo de variáveis --%>
		<%= desenvolvido %><br />

		<% System.out.println("Executado com êxito"); %>

</body>
</html>