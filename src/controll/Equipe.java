package controll;

import java.sql.Date;
import java.util.List;


public class Equipe {

	private int idEquipe;
	private List<Usuario> ListaDeUsuarios;
	private List<Quadros> ListaDeQuadros;
	private Date dataCriacao;
	
	public Equipe() {}
	
	public Equipe(int idEquipe, Date dataCriacao) {	
		this.idEquipe = idEquipe;
		this.dataCriacao = dataCriacao;
	}
	
	public Equipe(int idEquipe) {	
		this.idEquipe = idEquipe;
		//Ir no banco e pegar a lista de usuarios da equipe. e seta a variavel lista de usuarios e fazer a msm coisa com
		//a lista de Quadros.
	}

	public int getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(int idEquipe) {
		this.idEquipe = idEquipe;
	}

	public List<Usuario> getListaDeUsuarios() {
		return ListaDeUsuarios;
	}

	public void setListaDeUsuarios(List<Usuario> listaDeUsuarios) {
		ListaDeUsuarios = listaDeUsuarios;
	}

	public List<Quadros> getListaDeQuadros() {
		return ListaDeQuadros;
	}

	public void setListaDeQuadros(List<Quadros> listaDeQuadros) {
		ListaDeQuadros = listaDeQuadros;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	
	
}