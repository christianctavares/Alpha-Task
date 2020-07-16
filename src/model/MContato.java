package model;

import org.hibernate.Session;

import controll.Contato;


public class MContato {

	public static final String msg = null;

	public boolean enviarMsg(Contato contato) {
		
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		session.save(contato);
		session.getTransaction().commit();
		session.close();
		
		return false;
	}
	
}
