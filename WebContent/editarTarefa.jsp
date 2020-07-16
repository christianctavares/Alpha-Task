<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/cadastro.css" />
    <link rel="stylesheet" href="css/parceiros.css" />

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
  </head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-dark" id="barraNav">
      <a class="navbar-brand" href="#">Alpha Planning</a>
      <button
        class="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="index.html">Sair</a>
          </li>
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
    <div style="margin-bottom: 15%;   padding-left: 2%; padding-right: 2%;">

      <div class="bodyLogin" >
        <h1 style="color: #FFFFFF; text-align: center; padding-bottom: 3%;" >Detalhes da Tarefa</h1>
        <form>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label style="color: #FFFFFF; text-align: center;" >Nome da Tarefa</label>
              <input type="text" class="form-control" id="inputNome" name="nomem" value="<%= request.getAttribute("nomeTarefau") %>" >
            </div>
            <div class="form-group col-md-6">
              <label style="color: #FFFFFF; text-align: center;" >Status</label>
                <select id="inputStatus" class="form-control" name="statusm">
                <option selected><%= request.getAttribute("statusTarefau") %></option>
                <option>Parado</option>
                <option>Fazendo</option>
                <option>Em teste</option>
                <option>Feito</option>
              </select>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputPrioridade" style="color: #FFFFFF; text-align: center;" >Prioridade</label>
	            <select id="inputPrioridade" class="form-control" name="prioridadem">
	                <option selected><%= request.getAttribute("prioridadeTarefau") %></option>
	                <option>Alta</option>
	                <option>Media</option>
	                <option>Alta</option>
	            </select>

            </div>
            <div class="form-group col-md-6">
              <label style="color: #FFFFFF; text-align: center;" >Estimativa (dias)</label>
              <input type="number" class="form-control" id="inputNome" name="estimativam" value="<%= request.getAttribute("estimativaTarefau") %>" >
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-12">
              <label style="color: #FFFFFF; text-align: center;" >Descricao Detalhada</label>
              <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="descricaom" > <%= request.getAttribute("descricaoTarefau") %></textarea>
            </div>
          </div>
          <div style="text-align: center;">
              <input style="margin-left: auto; margin-right: auto; width: 50%; margin-top: 2%;  background-color: #e45c34; color: #FFFFFF; border: none;" class="btn btn-lg btn-primary btn-block" type="submit" value="Salvar" id="iCadastrar" formaction="ServletEditarTarefa" formmethod="post" />
              <input style="margin-left: auto; margin-right: auto; width: 50%; margin-top: 2%;  background-color: #e45c34; color: #FFFFFF; border: none;" class="btn btn-sm" type="submit" value="Voltar" id="iCadastrar" formaction="ServletDirecionarAreaTarefas" formmethod="post" />
          </div>
        </form>

    </div>

    </div>
    
    <footer class="page-footer fixed-bottom font-small darken-3">
      <nav class="navbar navbar-light" id="footerMaior">
        <a
          class="navbar-brand"
          style="color: #ffffff; opacity: 70%;"
          href="https://alphaHospital.com/"
        >
          AlphaPlanning.com</a
        >
        <a> Copyright 2020-2022. All rights reserved.</a>
      </nav>
      <nav class="navbar navbar-dark" id="footerMenor">
        <p style="color: #ffffff; opacity: 70%;">
          Designed by Christian Tavares
        </p>
      </nav>
    </footer>

    <script
      src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
      integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
      integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
      integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
