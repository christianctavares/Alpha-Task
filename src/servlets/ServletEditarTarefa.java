package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import controll.Tarefa;

@WebServlet("/ServletEditarTarefa")
public class ServletEditarTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session  = request.getSession();     
   		String idLogado = session.getAttribute("idUsuarioLogado").toString(); 
   		
   		String idTarefa = session.getAttribute("idTarefa").toString(); 
   		String nomeTarefa = request.getParameter("nomem");
   		String status = request.getParameter("statusm");
   		String prioridade = request.getParameter("prioridadem");
   		String estimativa = request.getParameter("estimativam");
   		String descricao = request.getParameter("descricaom");

   		String idQuadroAcessado = session.getAttribute("idQuadroAcessado").toString(); 
   		Tarefa t = new Tarefa();
   		Tarefa tAux = t.localizarTarefa(idTarefa, idQuadroAcessado);
   		
   		tAux.setNomeTarefa(nomeTarefa);
   		tAux.setStatus(status);
   		tAux.setPrioridade(prioridade);
   		tAux.setEstimativa(estimativa);
   		tAux.setDescricao(descricao);
   		tAux.setId(Integer.parseInt(idTarefa));
   		
		

		
   		if(t.editarTarefa(tAux, idQuadroAcessado)) {
   			String idQuadro = session.getAttribute("idQuadroAcessado").toString(); 
   			ArrayList<Tarefa> listaTarefas = t.listarTarefas(idQuadro);
   			request.setAttribute("listaDeTarefas", listaTarefas);
   			request.setAttribute("sucesso", tAux.msg);
			request.getRequestDispatcher("menuTarefas.jsp").forward(request, response);
   		}else {
   			request.setAttribute("erro ao editar", tAux.msg);
   			request.getRequestDispatcher("editarTarefa.jsp").forward(request, response);
   		}
	}

}
