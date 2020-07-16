package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controll.Tarefa;
import controll.Usuario;

/**
 * Servlet implementation class ServletDirecionarEdicaoTarefa
 */
@WebServlet("/ServletDirecionarEdicaoTarefa")
public class ServletDirecionarEdicaoTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();     
   		String idLogado = session.getAttribute("idUsuarioLogado").toString(); 
   		String idTarefa = request.getParameter("idTarefa");
   		session.setAttribute("idTarefa", idTarefa);
   		
   		String idQuadroAcessado = session.getAttribute("idQuadroAcessado").toString(); 
   		Tarefa t = new Tarefa();
   		Tarefa tAux = t.localizarTarefa(idTarefa, idQuadroAcessado);
   		
   		int idCriador = tAux.getIdDoCriador();
   		Usuario u = new Usuario();
   		Usuario aux = u.localizarUsuario(String.valueOf(idCriador));
   		
   		request.setAttribute("nomeCriadorTarefau", aux.nome);
   		request.setAttribute("nomeTarefau", tAux.getNomeTarefa());
   		request.setAttribute("statusTarefau", tAux.getStatus());
   		request.setAttribute("prioridadeTarefau", tAux.getPrioridade());
   		request.setAttribute("estimativaTarefau", tAux.getEstimativa());
   		request.setAttribute("descricaoTarefau", tAux.getDescricao());
   		request.setAttribute("dataCriacaoTarefau", tAux.getDataCriacao());

   		request.getRequestDispatcher("editarTarefa.jsp").forward(request, response);

	}

}
