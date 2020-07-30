package controll;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import model.MUsuario;

@DynamicUpdate(value = true)      // informada update dinamico. so exita o que foi alterado
@SelectBeforeUpdate(value = true)  // verifica antes de atualizar, 
@DynamicInsert(value = true)
@Entity(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(nullable = false)
	public String nome;
	@Column(nullable = false, unique = true)
	public String email;
	@Column(nullable = false)
	public String senha;
	@Column(nullable = false, length = 14, unique = true)
	public String cpf;
	@Column(nullable = false)
	public String profissao;
	@Column(nullable = false)
	public String dataNascimento;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "quadro_usuario", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_quadro"))
	private List<Quadros> listaQuadros;
	
	@Transient
	public String msg;


	public Usuario() {
	}

	public Usuario(int id, String nome, String email, String senha, String cpf, String profissao,
			String dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.profissao = profissao;
		this.dataNascimento = dataNascimento;
	}

	public Usuario(String nome, String email, String senha, String cpf, String profissao, String dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.profissao = profissao;
		this.dataNascimento = dataNascimento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean cadastrarUsuario() {

		MUsuario u = new MUsuario();

		if (u.cadastrarUsuario(this)) {

			return true;

		} else {
			msg = ("Erro " + u.msg);
			return false;

		}
	}

	public Usuario logar(String email, String senha) {
		MUsuario u = new MUsuario();

		// vou no model, entro no metodo logar(), no qual ele faz um select na pessoa q
		// possue esse email e senha, se existir
		// ele retorna o objeto inteiro(com id), porem se nao achar retorna false.
		Usuario usuarioAux = u.logar(email, senha);
		if (usuarioAux != null) {
			return usuarioAux;
		} else {
			return null;
		}

	}

	public Usuario localizarUsuario(String id) {
		MUsuario u = new MUsuario();

		Usuario usuarioAux = u.localizarUsuario(id);
		if (usuarioAux != null) {
			return usuarioAux;
		} else {
			return null;
		}
	}

	public List<Quadros> getListaQuadros() {
		if(listaQuadros == null) {
			listaQuadros = new ArrayList<Quadros>();
		}
		return listaQuadros;
	}

	public void setListaQuadros(List<Quadros> listaQuadros) {
		this.listaQuadros = listaQuadros;
	}

}
