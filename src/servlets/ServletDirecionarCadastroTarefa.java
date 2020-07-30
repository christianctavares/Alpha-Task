package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controll.Quadros;
import controll.Usuario;


@WebServlet("/ServletDirecionarCadastroTarefa")
public class ServletDirecionarCadastroTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();     
   		String idLogado = session.getAttribute("idUsuarioLogado").toString();
   		String idQuadro = session.getAttribute("idQuadroAcessado").toString(); 
   		
   		Quadros q = new Quadros();
   		
   		List<Usuario> listaUsuarios = q.listarMembros(idQuadro, idLogado);
   		
   		
   		request.setAttribute("listaDeMembros", listaUsuarios);
		request.getRequestDispatcher("cadastroTarefa.jsp").forward(request, response);
	}

}
