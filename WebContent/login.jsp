<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/login.css" />
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
            <a class="nav-link" href="index.html">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="sobre.html">Sobre</a>
          </li>

          <li class="nav-item ">
            <a class="nav-link" href="parceiros.html">Parceiros</a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="contato.html">Contato</a>
          </li>

          <li class="nav-item active">
            <a class="nav-link" href="login.html">Login</a>
          </li>
        </ul>
      </div>
    </nav>
    <div style="margin-bottom: 15%;   padding-left: 2%; padding-right: 2%;">
      <div class="bodyLogin">
        <form id="my-form" class="form-signin">
          <img
            class="mb-4"
            src="/docs/4.5/assets/brand/bootstrap-solid.svg"
            alt=""
            width="72"
            height="72"
          />
          <h1 style="color: #FFFFFF; text-align: center;" class="h3 mb-3 font-weight-normal">Login</h1>
          <label for="inputEmail" class="sr-only">Email:</label>
          <input
            type="email"
            id="inputEmail"
            class="form-control"
            placeholder="Email"
            name="emailm"
            required
            autofocus
          />
          <label for="inputPassword" class="sr-only">Senha</label>
          <input
            type="password"
            id="inputPassword"
            class="form-control"
            placeholder="Senha"
            name="senham"
            required
          />
          <div class="checkbox mb-3">
            <label style="color: #FFFFFF; opacity: 70%;">
              <input  type="checkbox" value="remember-me" /> Lembre-se de mim.
            </label>
          </div>
          <p style="color: #FFFFFF; opacity: 100%; text-align: center;"><%= request.getAttribute("msg") %></p>
          
         <div style="text-align: center;">
            <input class="btn btn-lg" style="background-color: #e45c34; color: #FFFFFF; border: none;" formaction="ServletLogin" formmethod="post" type="submit" id="btn" value="Login">
		</div>
          <p style="color: #FFFFFF; opacity: 80%; text-align: center;">
              Ainda nao tem cadastro?<a href="cadastro.html"> clique aqui!</a>
          </p>
          <p style="color: #FFFFFF; opacity: 80%; text-align: center;" class="mt-5 mb-3 text-muted">&copy; 2020-2022</p>
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
