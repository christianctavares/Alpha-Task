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

import controll.Admin;
import controll.Quadros;
import controll.Usuario;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("emailm");
		String senha = request.getParameter("senham");

		if ((email.isEmpty() || senha.isEmpty())) {

			
			response.sendRedirect("login.html");

		} else if(email.equals("admin@admin.com") && senha.equals("123")){
			Usuario u = new Usuario();
			Usuario aux = u.logar(email, senha);
			Admin a = new Admin();
			
			HttpSession session  = request.getSession(true);     
			session.setAttribute ("idUsuarioLogado", aux.getId());
			request.setAttribute("nomeu", aux.getNome());
			request.setAttribute("listaDeQuadros", a.listarQuadros());
			request.getRequestDispatcher("menuQuadros.jsp").forward(request, response);
			
		}else {
			Usuario u = new Usuario();
			Usuario aux = u.logar(email, senha);
			if(aux != null) {
				
				request.setAttribute("nomeu", aux.getNome());
				
				HttpSession session  = request.getSession(true);     
	            session.setAttribute ("idUsuarioLogado", aux.getId());
	            

	            
				request.setAttribute("listaDeQuadros", aux.getListaQuadros());


				request.getRequestDispatcher("menuQuadros.jsp").forward(request, response);
				
			}else {
				request.setAttribute("msg", "Dados invalidos ou usuario nao cadastrado");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}
}
