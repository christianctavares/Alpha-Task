package controll;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import model.MTarefa;

@DynamicUpdate(value = true)      // informada update dinamico. so exita o que foi alterado
@SelectBeforeUpdate(value = true)  // verifica antes de atualizar, 
@DynamicInsert(value = true)
@Entity 
@Table(name = "tarefas")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected int idDoCriador;
	@Column
	protected String nomeTarefa;
	protected String status;
	protected String prioridade;
	protected String estimativa;
	protected String descricao;
	protected String dataCriacao;
	
	@ManyToOne
	@JoinColumn(name = "id_quadro", nullable = true)
	public Quadros quadro;
	
	
	@Transient
	public String msg;
	
	public Tarefa() {}

	public Tarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}


	public Tarefa(int id,int idDoCriador, String nomeTarefa, String status, String prioridade, String estimativa,String descricao, 
			String dataCriacao) {
		this.id = id;
		this.idDoCriador = idDoCriador;
		this.nomeTarefa = nomeTarefa;
		this.status = status;
		this.prioridade = prioridade;
		this.estimativa = estimativa;	
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
	}
	
	public Tarefa(int idDoCriador, String nomeTarefa, String status, String prioridade, String estimativa,String descricao,
			String dataCriacao) {
		this.idDoCriador = idDoCriador;
		this.nomeTarefa = nomeTarefa;
		this.status = status;
		this.prioridade = prioridade;
		this.estimativa = estimativa;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDoCriador() {
		return idDoCriador;
	}

	public void setIdDoCriador(int idDoCriador) {
		this.idDoCriador = idDoCriador;
	}

	public String getNomeTarefa() {
		return nomeTarefa;
	}

	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getEstimativa() {
		return estimativa;
	}

	public void setEstimativa(String estimativa) {
		this.estimativa = estimativa;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public Quadros getQuadro() {
		return quadro;
	}

	public void setQuadro(Quadros quadro) {
		this.quadro = quadro;
	}

	public boolean cadastrarTarefa(String idLogado) {

		MTarefa t = new MTarefa();

		if (t.cadastrarTarefa(this, idLogado)) {
			return true;

		} else {
			msg = ("Erro " + t.msg);
			return false;

		}
	}

	public ArrayList<Tarefa> listarTarefas(String idQuadroAcessado) {
		MTarefa t = new MTarefa();
		ArrayList<Tarefa> tAux = t.listarTarefas(idQuadroAcessado);
		if(tAux != null) {
			return tAux;
		}
		return null;
	}
	
	public Tarefa localizarTarefa(String id, String idQuadroAcessado) {
		MTarefa t = new MTarefa();
		
		Tarefa tarefaAux = t.localizarTarefa(id, idQuadroAcessado);
		if(tarefaAux != null) {
			return tarefaAux;
		}else {
			return null;
		}
	}
	
	public boolean editarTarefa(Tarefa tEscolhido, String idQuadroAcessado) {
		MTarefa t = new MTarefa();
		
		boolean tarefaAux = t.atualizarDados(tEscolhido, idQuadroAcessado);
		if(tarefaAux) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean excluirTarefa(Tarefa tEscolhido, String idQuadro) {
		MTarefa t = new MTarefa();
		
		boolean tarefaAux = t.excluirTarefa(tEscolhido,idQuadro);
		if(tarefaAux) {
			return true;
		}else {
			return false;
		}
	}
	
}
