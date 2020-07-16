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




@WebServlet("/ServletDirecionarAreaTarefas")
public class ServletDirecionarAreaTarefas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletDirecionarAreaTarefas() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();     
   		String idLogado = session.getAttribute("idUsuarioLogado").toString();
   		if(request.getParameter("idQuadro") != null) {
   			
   			String idQuadro = request.getParameter("idQuadro");   
   			session.setAttribute("idQuadroAcessado", idQuadro);
   			Tarefa t = new Tarefa();
   			ArrayList<Tarefa> listaTarefas = t.listarTarefas(idQuadro);
   			
   			request.setAttribute("listaDeTarefas", listaTarefas);
   			
   			request.getRequestDispatcher("menuTarefas.jsp").forward(request, response);
   			doGet(request, response);
   		}
       
   		String idQuadro = session.getAttribute("idQuadroAcessado").toString(); 
		
		Tarefa t = new Tarefa();
		ArrayList<Tarefa> listaTarefas = t.listarTarefas(idQuadro);
		
		request.setAttribute("listaDeTarefas", listaTarefas);
		
		request.getRequestDispatcher("menuTarefas.jsp").forward(request, response);
		doGet(request, response);
	}

}
