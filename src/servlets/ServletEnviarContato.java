package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controll.Contato;
import controll.Usuario;

@WebServlet("/ServletEnviarContato")
public class ServletEnviarContato extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nomem");
		String email = request.getParameter("emailm");
		String assunto = request.getParameter("assuntom");
		String msg = request.getParameter("msgm");
		
		
		if(nome == null || email == null || assunto == null || msg == null) {
			request.setAttribute("erro", "preencha todos os campos");
			request.getRequestDispatcher("contato.html").forward(request, response);
		}else {
			Contato c = new Contato(nome, email, assunto, msg);
			c.enviarMsg();
			request.setAttribute("sucesso", c.msg);
			request.getRequestDispatcher("sucessoAoEnviarMsg.html").forward(request, response);
		}
	}

}
