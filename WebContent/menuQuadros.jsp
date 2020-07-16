<%@page import="java.util.List"%>
<%@page import="controll.Quadros"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AlphaPlanning</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/menuTarefas.cssA" />
<link rel="stylesheet" href="css/menuEquipes.css" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
<style>
.ellipsis {
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark" id="barraNav">
		<a class="navbar-brand" href="#">Alpha Planning</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="index.html">Sair</a></li>
				<li class="nav-item active">
					<form>


						<a class="nav-link"><input
							style="background: none; border: none; color: #FFFFFF;"
							formaction="ServletDirecionarAreaQuadros" formmethod="post"
							type="submit" value="Voltar"></a>

					</form>
				</li>
			</ul>
		</div>
	</nav>

	<main role="main">

		<div class="bodyLogin">
			<div class="container">
				<h1 class="display-3">Área de Quadros</h1>
				<form>

					<h3 class="display-5">
						Bem Vindo
						<%=request.getAttribute("nomeu")%>
					</h3>
					<p id="subLetras">This is a template for a simple marketing or
						informational website. It includes a large callout called a
						jumbotron and three supporting pieces of content. Use it as a
						starting point to create something more unique.</p>
					<p>
						<input
							style="background-color: #e45c34; color: #FFFFFF; border: none;"
							formaction="ServletDirecionarCadastroQuadro" formmethod="post"
							type="submit" id="btn" value="Cadastrar Quadro"
							class="btn btn-secondary btn-lg"> 
						<input
							style="background-color: #e45c34; color: #FFFFFF; border: none;"
							formaction="ServletDirecionarGerenciadorQuadro" formmethod="post"
							type="submit" id="btn" value="Gerenciar Quadros"
							class="btn btn-secondary btn-lg">
					</p>

				</form>
			</div>
		</div>

		<div style="padding-bottom: 15%; color: #ffffff" class="container">
			<div class="row" id="rowQuadros">

				<%
					List<Quadros> lista = (List<Quadros>) request.getAttribute("listaDeQuadros");
				if (!lista.isEmpty()) {

					for (Quadros quadro : lista) {

						out.println("<div class=\"col-md-4\" id=\"quadroCaixa\">");
						//form, setar um atributo e esse botao de link vai ser um submit
						out.println("<form>");
						out.println("<input type=\"hidden\" name=\"idQuadro\" value= " + quadro.getId() + ">");
						out.println("<h2>  " + quadro.getNome() + "</h2>");
						out.println(
						"<p style=\"overflow: hidden;display: -webkit-box;-webkit-line-clamp: 3;-webkit-box-orient: vertical;\" id=\"subLetras\"><label style=\"font-weight: bolder;\">Descrição:  </label>"
								+ " " + quadro.getDescricao() + " </p>");
						out.println("<div class=\"btn-group btn-group-toggle\" data-toggle=\"buttons\">");
						out.println("<label class=\"btn btn-secondary active\">");
						out.println(
						"<input style=\"background: none; border: none;color: #FFFFFF\" type=\"submit\" value=\"Acessar\" name=\"options\" id=\"option1\" autocomplete=\"off\" formaction=\"ServletDirecionarAreaTarefas\" formmethod=\"post\" type=\"submit\"> ");
						out.println("</label>");
						out.println("</div>");
						out.println("</form>");
						out.println("</div>");

					}
				}
				%>

			</div>



		</div>

	</main>



	<footer class="page-footer fixed-bottom font-small  darken-3">
		<nav class="navbar navbar-light" id="footerMaior">
			<a class="navbar-brand" style="color: #FFFFFF; opacity: 70%;"
				href="https://alphaHospital.com/"> AlphaPlanning.com</a> <a>
				Copyright 2020-2022. All rights reserved.</a>
		</nav>
		<nav class="navbar navbar-dark" id="footerMenor">
			<p style="color: #FFFFFF; opacity: 70%;">Designed by Christian
				Tavares</p>
		</nav>
	</footer>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>
