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

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("emailm");
		String senha = request.getParameter("senham");

		if ((email.isEmpty() || senha.isEmpty())) {

			
			response.sendRedirect("login.html");

		} else {
			Usuario u = new Usuario();
			Usuario aux = u.logar(email, senha);
			if(aux != null) {
				/*
				 * Quadros q = new Quadros();
				 * List<Quadros> listaQuadros = q.listarQuadros();
				 */
				
				request.setAttribute("nomeu", aux.getNome());
				
				HttpSession session  = request.getSession(true);     
	            session.setAttribute ("idUsuarioLogado", aux.getId());
	            
				//request.setAttribute("idu", aux.getId());
	            
				request.setAttribute("listaDeQuadros", aux.getListaQuadros());
				//instacia a classe quadros e chama o metodo retornar lista de quadros passando o id do usuario como argumento
				//e com essa lista seto nos atributos do request
				//request.setAttribute("listaQuadros", q.getLista(u.getId()));

				request.getRequestDispatcher("menuQuadros.jsp").forward(request, response);
				
			}else {
				request.setAttribute("msg", "Dados invalidos ou usuario nao cadastrado");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}
}
