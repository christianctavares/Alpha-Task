package model;

import java.util.List;

import org.hibernate.Session;

import controll.Quadros;

public class MAdmin {
	
	
	public List<Quadros> listarQuadros() {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		String sql = "SELECT * FROM quadros";
		List<Quadros> listaQuadros = session.createSQLQuery(sql).addEntity(Quadros.class).list();
		session.getTransaction().commit();
		session.close();
		return listaQuadros;
	}


}
