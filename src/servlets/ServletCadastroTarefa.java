package servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controll.Tarefa;
import controll.Usuario;


@WebServlet("/ServletCadastroTarefa")
public class ServletCadastroTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeTarefa = request.getParameter("nomem");
		String statusTarefa = request.getParameter("statusm");
		String prioridadeTarefa = request.getParameter("prioridadem");
		String estimativaTarefa = request.getParameter("estimativam");
		String descricaoTarefa = request.getParameter("descricaom");
		
		HttpSession session  = request.getSession();     
   		String idLogado = session.getAttribute("idUsuarioLogado").toString(); 
   		
   		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
   	    LocalDateTime now = LocalDateTime.now();  
		String dataCriacao = dtf.format(now).toString();
		
		if(nomeTarefa == null || statusTarefa == null) {
			request.setAttribute("erro", "campo vazio");
			request.getRequestDispatcher("cadastroQuadro.jsp").forward(request, response);
		}else {

			Usuario u = new Usuario();
			Usuario aux = u.localizarUsuario(idLogado);
        	int idCriador = Integer.parseInt(idLogado);
        	
       		String idQuadroAcessado = session.getAttribute("idQuadroAcessado").toString(); 
        	
			Tarefa t = new Tarefa(idCriador,nomeTarefa, statusTarefa, prioridadeTarefa, estimativaTarefa, descricaoTarefa, dataCriacao);
			t.cadastrarTarefa(idQuadroAcessado);
			
			String idQuadro = session.getAttribute("idQuadroAcessado").toString(); 
			ArrayList<Tarefa> listaTarefas = t.listarTarefas(idQuadro);
			
			request.setAttribute("nomeu", aux.getNome());
			request.setAttribute("listaDeTarefas", listaTarefas);
			request.setAttribute("idu", idLogado);
			
			request.getRequestDispatcher("menuTarefas.jsp").forward(request, response);
		}	
	}

}
