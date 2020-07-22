package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controll.Quadros;
import controll.Usuario;


@WebServlet("/ServletEditarQuadro")
public class ServletEditarQuadro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();     
   		String idLogado = session.getAttribute("idUsuarioLogado").toString(); 
   		String idQuadroAcessado = session.getAttribute("idQuadro").toString(); 
   		
   		Quadros qAux = new Quadros();
   		Quadros q = qAux.localizarQuadro(idQuadroAcessado);
   		
   		q.setNome(request.getParameter("nomem"));
   		q.setDescricao(request.getParameter("descricaom"));
   		
   		
   		if(q.editarQuadro(q, idLogado)) {
   			
   			Usuario u = new Usuario();
   			Usuario uAux = u.localizarUsuario(idLogado);
   			request.setAttribute("nomeu", uAux.getNome());
   			request.setAttribute("listaQuadros", uAux.getListaQuadros());
   			request.setAttribute("sucesso", q.msg);
			request.getRequestDispatcher("menuGerenciaDeQuadros.jsp").forward(request, response);
   		}else {
   			request.setAttribute("msg", "erro ao excluir");
   			request.getRequestDispatcher("excluirQuadro.jsp").forward(request, response);
   		}
	}

}
