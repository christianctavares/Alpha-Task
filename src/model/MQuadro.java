package model;

import java.util.List;

import org.hibernate.Session;

import controll.Quadros;
import controll.Usuario;

public class MQuadro {

	public String msg = null;

	public boolean cadastrarQuadro(Quadros quadros, String idUsuarioLogado) {
		
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		
		Usuario uAux = new Usuario();
		
		Usuario u = uAux.localizarUsuario(idUsuarioLogado);
			
		u.getListaQuadros().add(quadros);
			
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

	public boolean excluirQuadro(Quadros qEscolhido) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		qEscolhido = session.find(Quadros.class, qEscolhido.getId());
		session.delete(qEscolhido);
		session.getTransaction().commit();
		session.close();
		if(qEscolhido != null) {
			return true;
		}else {
			return false;
		}
		
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
