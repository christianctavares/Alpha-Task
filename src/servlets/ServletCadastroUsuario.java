package servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controll.Usuario;


@WebServlet("/ServletCadastroUsuario")
public class ServletCadastroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public ServletCadastroUsuario() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nome = request.getParameter("nomem");
		String email = request.getParameter("emailm");
		String senha = request.getParameter("senham");
		String cpf = request.getParameter("cpfm");
		String profissao = request.getParameter("profissaom");
		String dataNascimento = request.getParameter("dataNascimentom");
		
		if(nome == null || email == null || senha == null || cpf == null || profissao == null || dataNascimento == null) {
			request.setAttribute("msg", "campo vazio");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			Usuario u = new Usuario(nome, email, senha, cpf, profissao, dataNascimento);
			u.cadastrarUsuario();
			request.setAttribute("msg", "cadastro realizado");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
