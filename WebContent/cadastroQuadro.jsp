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
        <h1 style="color: #FFFFFF; text-align: center; padding-bottom: 3%;" >Cadastro de Quadro</h1>
        <form class="login">
            <div class="form-row">
              <div class="form-group col-md-12">
                <label style="color: #FFFFFF; text-align: center;" for="inputEmail4">Nome do Quadro</label>
                <input type="text" class="form-control" id="inputNome" placeholder="Nome" name="nomem" required="required">
              </div>
            </div>
            <div class="row">
              <div class="col-md-12">
                <div class="md-form">
                  <label style="color: #FFFFFF; text-align: center;" for="inputEmail4">Descri��o</label>
                  <textarea
                    type="text"
                    id="message"
                    name="descricaom"
                    rows="2"
                    class="form-control md-textarea"
                    required="required"
                  ></textarea>
                  
                </div>
              </div>
            </div>

              <input class="btn btn-lg btn-primary btn-block" style="margin-left: auto; margin-right: auto; width: 50%; margin-top: 2%;  background-color: #e45c34; color: #FFFFFF; border: none;" type="submit" value="Cadastrar Quadro" id="iCadastrar" formaction="ServletCadastroQuadro" formmethod="post" />

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