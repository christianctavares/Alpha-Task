package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controll.Quadros;
import controll.Usuario;

/**
 * Servlet implementation class ServletCadastroQuadro
 */
@WebServlet("/ServletCadastroQuadro")
public class ServletCadastroQuadro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nomem");
		String descricao = request.getParameter("descricaom");
		
		HttpSession session  = request.getSession();     
   		String idLogado = session.getAttribute("idUsuarioLogado").toString(); 
   		
		if(nome == null || descricao == null) {
			request.setAttribute("erro", "campo vazio");
			request.getRequestDispatcher("cadastroQuadro.jsp").forward(request, response);
		}else {

			Usuario u = new Usuario();
			Usuario aux = u.localizarUsuario(idLogado); 
			
			Quadros q = new Quadros(nome, descricao, aux.getNome());			 
			q.cadastrarQuadro(idLogado);
			
			aux = u.localizarUsuario(idLogado); 
			
			request.setAttribute("nomeu", aux.getNome());
			request.setAttribute("listaDeQuadros", aux.getListaQuadros());
			request.setAttribute("idu", idLogado);
			
			request.getRequestDispatcher("menuQuadros.jsp").forward(request, response);
		}
	}

}
