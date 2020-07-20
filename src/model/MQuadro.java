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
		
		Quadros qAux = new Quadros();
		Quadros q = qAux.localizarQuadro(String.valueOf(qEscolhido.getId()));
		
		for (Quadros quadro : u.getListaQuadros()) {
			if(quadro.id == qEscolhido.id) {
				u.getListaQuadros().remove(quadro);
				session.update(u);
				session.update(q);
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

}
