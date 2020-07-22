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

@WebServlet("/ServletDirecionarGerenciadorQuadro")
public class ServletDirecionarGerenciadorQuadro extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();     
   		String idLogado = session.getAttribute("idUsuarioLogado").toString(); 
   		
   		Usuario u = new Usuario();
		Usuario aux = u.localizarUsuario(idLogado);
		request.setAttribute("nomeu", aux.getNome());

		if(aux.email.equals("admin@admin.com")) {
			Admin a = new Admin();
			request.setAttribute("listaQuadros", a.listarQuadros());
			request.setAttribute("nomeu", aux.getNome());
			request.setAttribute("idu", idLogado);
			
			request.getRequestDispatcher("menuGerenciaDeQuadros.jsp").forward(request, response);

		}

		request.setAttribute("listaQuadros", aux.getListaQuadros());
		
		request.getRequestDispatcher("menuGerenciaDeQuadros.jsp").forward(request, response);
		doGet(request, response);
	}
		

}
