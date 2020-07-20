package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controll.Quadros;
import controll.Tarefa;
import controll.Usuario;


@WebServlet("/ServletDirecionarExclusaoQuadro")
public class ServletDirecionarExclusaoQuadro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session  = request.getSession();     
   		String idLogado = session.getAttribute("idUsuarioLogado").toString(); 
   		String idQuadro = request.getParameter("idQuadro");
   		session.setAttribute("idQuadro", idQuadro);
		
		  Quadros q = new Quadros();
		  Quadros qAux = q.localizarQuadro(idQuadro);


		  request.setAttribute("nomeQuadrou", qAux.getNome());
		  request.setAttribute("descricaoQuadrou", qAux.getDescricao());
		  
		 
   		  request.getRequestDispatcher("excluirQuadro.jsp").forward(request, response);
	}

}
