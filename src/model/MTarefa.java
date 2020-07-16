package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import controll.Quadros;
import controll.Tarefa;
import controll.Usuario;

public class MTarefa {

	public String msg = null;

	public boolean cadastrarTarefa(Tarefa tarefa, String idQuadro) {
		
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		
		Quadros qAux = new Quadros();
		
		Quadros q = qAux.localizarQuadro(idQuadro);
			
		q.getListaTarefas().add(tarefa);
			
		session.update(q);
		session.getTransaction().commit();
		session.close();
		
		return false;
	}

	public ArrayList<Tarefa> listarTarefas(String idQuadroAcessado) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		
		String sql = "SELECT * FROM tarefas WHERE id_quadro = " + idQuadroAcessado;
		ArrayList<Tarefa> listaTarefas = (ArrayList<Tarefa>) session.createSQLQuery(sql).addEntity(Tarefa.class).list();
		session.getTransaction().commit();
		session.close();
		return listaTarefas;
	}

	public Tarefa localizarTarefa(String id, String idQuadroAcessado) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		
		Quadros qAux = new Quadros();
		Quadros q = qAux.localizarQuadro(idQuadroAcessado);
		
		if(q != null) {
			for (Tarefa tarefa : q.listaTarefas) {
				String idTarefa =String.valueOf(tarefa.getId());
				if(idTarefa.equals(id)) {
					return tarefa;
				}
			}
		}else {
			return null;
		}
		return null;
		
		
	}

	public boolean atualizarDados(Tarefa tEscolhida, String idQuadroAcessado) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		
		Quadros qAux = new Quadros();
		Quadros q = qAux.localizarQuadro(idQuadroAcessado);
		
		if(q != null) {
			for (Tarefa tarefa : q.listaTarefas) {
				String idTarefa =String.valueOf(tarefa.getId());
				if(idTarefa.equals(String.valueOf(tEscolhida.getId()))) {
					tarefa.setNomeTarefa(tEscolhida.getNomeTarefa());
					tarefa.setDescricao(tEscolhida.getDescricao());
					tarefa.setDataCriacao(tEscolhida.getDataCriacao());
					tarefa.setEstimativa(tEscolhida.getEstimativa());
					tarefa.setPrioridade(tEscolhida.getPrioridade());
					tarefa.setStatus(tEscolhida.getStatus());
					
					session.update(q);
					session.getTransaction().commit();
					session.close();
					return true;
				}
			}
		}else {
			return false;
		}
		return false;
	}

	public boolean excluirTarefa(Tarefa tEscolhida, String idQuadroAcessado ) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		
		Quadros qAux = new Quadros();
		Quadros q = qAux.localizarQuadro(idQuadroAcessado);
		
		if(q != null) {
			for (Tarefa tarefa : q.listaTarefas) {
				String idTarefa =String.valueOf(tarefa.getId());
				if(idTarefa.equals(String.valueOf(tEscolhida.getId()))) {
					q.getListaTarefas().remove(tarefa);
					
					session.update(q);
					session.getTransaction().commit();
					session.close();
					return true;
				}
			}
		}else {
			return false;
		}
		return false;
		
	}

}
