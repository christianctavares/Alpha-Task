package controll;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import model.MContato;

@DynamicUpdate(value = true)      // informada update dinamico. so exita o que foi alterado
@SelectBeforeUpdate(value = true)  // verifica antes de atualizar, 
@DynamicInsert(value = true)
@Entity
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	private String email;
	private String assunto;
	private String texto;
	
	@Transient
	public String msg;
	
	public Contato() {
		
	}

	public Contato(String nome, String email, String assunto, String texto) {
		this.nome = nome;
		this.email = email;
		this.assunto = assunto;
		this.texto = texto;
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

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public boolean enviarMsg() {

		MContato c = new MContato();

		if (c.enviarMsg(this)) {
			return true;

		} else {
			msg = ("Erro " + c.msg);
			return false;

		}
	}
	
	
}
