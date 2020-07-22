<%@page import="controll.Quadros"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AlphaPlanning</title>
    <link
    rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
    crossorigin="anonymous"
  />
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/menuTarefas.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
    <style>.ellipsis { text-overflow: ellipsis; }</style>
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
  
        <div class="collapse navbar-collapse" id="navbarSupportedContent" >
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
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
    <div  style="margin-bottom: 15%;   padding-left: 2%; padding-right: 2%;">

        <main role="main">

            <div class="scroll">
              <div>
                <table id="tabela" class="table table-dark">
                	<thead>
					<tr>
					<th scope="col">Nome</th>
					<th scope="col">Descricao</th>
					<th scope="col"></th>
					</tr>
				</thead>
                <%
                List<Quadros> lista = (List<Quadros>) request.getAttribute("listaQuadros");
                if(!lista.isEmpty()){
      			 for (Quadros quadro : lista) {

					out.println("<tbody>");
					out.print("<form>");
					out.println("<tr>");
					out.println("<input type=\"hidden\" name=\"idQuadro\" value= " + quadro.getId() + ">");
					out.println("<td>" + quadro.getNome() + "</td>");
					out.println("<td>" + quadro.getDescricao() + "</td>");
					out.println("<td>");
					out.println("<input style=\"background-color: #ffcd05; color: #303030; font-weight: bold; border: none;\" formaction=\"ServletDetalharQuadro\" formmethod=\"post\" type=\"submit\" id=\"btn\" value=\"Detalhar\" class=\"btn btn-secondary btn-sm\">");
					out.println("<input style=\"background-color: rgb(5, 160, 199); color: #303030; font-weight: bold; border: none;\" formaction=\"ServletDirecionarEdicaoQuadro\" formmethod=\"post\" type=\"submit\" id=\"btn\" value=\"Editar\" class=\"btn btn-secondary btn-sm\">");
					out.println("<input style=\"background-color: #d62237; color: #303030; font-weight: bold; border: none;\" formaction=\"ServletDirecionarExclusaoQuadro\" formmethod=\"post\" type=\"submit\" id=\"btn\" value=\"Excluir\" class=\"btn btn-secondary btn-sm\">");
					out.println("</td>");
					out.println("</tr>");
					out.print("</form>");
					out.println("</tbody>");
		

   					}
                }
   				%>  
                    
                  </table>
                  
              </div>

            </div>
           
           <%
                
                if(lista.isEmpty()){
                	out.println("<div style=\"margin-top:5%; text-align: center;\">");
                	out.println("<h3 style=\"color: #ffffff; text-align: center;\"> Voce nao possui quadros ainda. </h3>");
                	out.println("</div>");
                }
   			%> 
    
        </main>
        
    </div>
        <footer class="page-footer fixed-bottom font-small  darken-3">
            <nav class="navbar navbar-light" id="footerMaior" >
                <a class="navbar-brand" style="color: #FFFFFF; opacity: 70%;" href="https://alphaHospital.com/">  AlphaPlanning.com</a>
                <a> Copyright 2020-2022. All rights reserved.</a>
            </nav>
            <nav class="navbar navbar-dark" id="footerMenor"  >
                <p style="color: #FFFFFF; opacity: 70%;"> Designed by Christian Tavares</p>
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