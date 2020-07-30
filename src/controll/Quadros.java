package controll;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import javax.persistence.ForeignKey;

import model.MQuadro;


@DynamicUpdate(value = true)      // informada update dinamico. so exita o que foi alterado
@SelectBeforeUpdate(value = true)  // verifica antes de atualizar, 
@DynamicInsert(value = true)
@Entity
public class Quadros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	@Column
	private String nome;
	private String descricao;
	private String criador;
	
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
	@JoinColumn(name = "id_quadro", nullable = true, foreignKey = @ForeignKey(name = "fk_Quadro_Tarefa"))
	public List<Tarefa> listaTarefas;

	@ManyToMany (mappedBy="listaQuadros")
	private List<Usuario> listaUsuarios;
	
	@Transient
	public String msg;

	public Quadros() {
	}
	
	public Quadros( String nome, String descricao, String idCriador) {
		this.nome = nome;
		this.descricao = descricao;
		this.criador = idCriador;
	}

	public Quadros( String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getCriador() {
		return criador;
	}

	public void setCriador(String criador) {
		this.criador = criador;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<Tarefa> getListaTarefas() {
		if(listaTarefas == null) {
			listaTarefas = new ArrayList<Tarefa>();
		}
		return listaTarefas;
	}

	public void setListaTarefas(List<Tarefa> listaTarefas) {
		this.listaTarefas = listaTarefas;
	}

	public boolean cadastrarQuadro(String idLogado) {

		MQuadro q = new MQuadro();

		if (q.cadastrarQuadro(this, idLogado)) {
			return true;

		} else {
			msg = ("Erro " + q.msg);
			return false;
		}
	}
	
	public List<Quadros> listarQuadros(){
		MQuadro q = new MQuadro();
		List<Quadros> qAux = q.listarQuadros();
		if(qAux != null) {
			return qAux;
		}
		return null;
	}
	
	public boolean excluirQuadro(Quadros qEscolhido,  String idLogado) {
		MQuadro q = new MQuadro();
		
		boolean quadroAux = q.excluirQuadro(qEscolhido,idLogado);
		if(quadroAux) {
			return true;
		}else {
			return false;
		}
	}
	
	public Quadros localizarQuadro(String id) {
		MQuadro q = new MQuadro();

		Quadros quadroAux = q.localizarQuadro(id);
		if (quadroAux != null) {
			return quadroAux;
		} else {
			return null;
		}
	}
	
	public boolean editarQuadro(Quadros qEscolhido, String idQuadroAcessado) {
		MQuadro q = new MQuadro();

		
		boolean quadroAux = q.editarQuadro(qEscolhido, idQuadroAcessado);
		if(quadroAux) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<Usuario> listarMembros(String idQuadro, String idLogado) {
		MQuadro q = new MQuadro();
		List<Usuario> qAux = q.listarMembros(idQuadro);
		if(qAux != null) {
			return qAux;
		}
		return null;
	}

}
