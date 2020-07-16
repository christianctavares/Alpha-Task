package model;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import controll.Usuario;

public class MUsuario {

	public String msg = null;

	public boolean cadastrarUsuario(Usuario u) {
		try {

			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();
			session.save(u);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			msg = ("Erro: " + e.toString());
			return false;
		}

	}

	public Usuario logar(String email, String senha) {
		try {
			Usuario u = new Usuario();
			u.email = email;
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();
			Query query = session.createQuery("from usuarios where email = :email AND senha = :senha");
			query.setParameter("email", email);
			query.setParameter("senha", senha);
			query.setMaxResults(1);
			Usuario usuario = (Usuario) query.uniqueResult();
			if (usuario == null) {
				return null;
			} else {

				u = session.find(Usuario.class, usuario.id);
				if (u != null) {
					session.close();
					return u;
				} else {
					return null;
				}

			}
		} catch (HibernateException e) {
			System.out.println("Erro: " + e.toString());
		}

		return null;
	}

	public Usuario localizarUsuario(String id) {
		Usuario u = new Usuario();
		u.id = Integer.parseInt(id);
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		u = session.find(Usuario.class, u.id);
		session.getTransaction().commit();
		session.close();
		if(u != null) {
			
			return u;
		}
		return null;
	}

}
