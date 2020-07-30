package model;

import java.util.List;

import org.hibernate.Session;

import controll.Quadros;
import controll.Usuario;

public class MQuadro {

	public String msg = null;

	public boolean cadastrarQuadro(Quadros quadro, String idUsuarioLogado) {
		
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		
		Usuario uAux = new Usuario();
		
		Usuario u = uAux.localizarUsuario(idUsuarioLogado);
			
		u.getListaQuadros().add(quadro);
			
		session.update(u);
		session.getTransaction().commit();
		session.close();
		
		return true;
	}

	public List<Quadros> listarQuadros() {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		String sql = "SELECT * FROM quadros";
		List<Quadros> listaQuadros = session.createSQLQuery(sql).addEntity(Quadros.class).list();
		session.getTransaction().commit();
		session.close();
		return listaQuadros;
	}

	public boolean excluirQuadro(Quadros qEscolhido, String idUsuarioLogado) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		
		Usuario uAux = new Usuario();
		
		Usuario u = uAux.localizarUsuario(idUsuarioLogado);
		
		for (Quadros quadro : u.getListaQuadros()) {
			if(quadro.id == qEscolhido.id) {
				u.getListaQuadros().remove(quadro);
				session.remove(quadro);
				session.update(u);
				
				session.getTransaction().commit();
				session.close();
				
				return true;
			}
		}	

			
		return false;
		
	}
	
	public boolean excluirQuadroTESTE(Quadros qEscolhido, String idUsuarioLogado) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		
		session.delete(qEscolhido);
		session.getTransaction().commit();
		session.close();
			
		return true;	
	}
	
	public boolean editarQuadro(Quadros qEscolhido, String idUsuarioLogado) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		
		Usuario uAux = new Usuario();
		
		Usuario u = uAux.localizarUsuario(idUsuarioLogado);
		
		for (Quadros quadro : u.getListaQuadros()) {
			if(quadro.id == qEscolhido.id) {
				quadro.setNome(qEscolhido.getNome());
				quadro.setDescricao(qEscolhido.getDescricao());
				session.update(quadro);
				
				session.getTransaction().commit();
				session.close();
				
				return true;
			}
		}	

			
		return false;
		
	}
	
	public Quadros localizarQuadro(String id) {
		Quadros q = new Quadros();
		q.id = Integer.parseInt(id);
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		q = session.find(Quadros.class, q.id);
		session.getTransaction().commit();
		session.close();
		if(q != null) {
			
			return q;
		}
		return null;
	}

	public boolean cadastrarMembro(String idLogado, String emailMembro) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
	
		Usuario uAux = new Usuario();

		session.getTransaction().commit();
		session.close();
		
		return true;
	}
	
	public List<Usuario> listarMembros(String id) {

		Session session = HibernateUtil.abrirSession();

		session.beginTransaction();

		Quadros q = new Quadros();
		q.id = Integer.parseInt(id);
		Quadros qAux = session.find(Quadros.class, q.id);

		q = session.find(Quadros.class, q.id);

		List<Usuario> lista = qAux.getListaUsuarios();
		session.getTransaction().commit();
		session.close();
		if (q != null) {

			return lista;
		}

		return null;
	}

}
