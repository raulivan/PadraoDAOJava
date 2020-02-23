package br.com.raulivan.entidade;

/**
 * Classe de contato
 * @author Raulivan
 * @version 1.0
 */
public class Contato extends EntidadeBase{

	
	private String nome;
	private String telefone;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Contato() {
		
	}
	
	public Contato(int id, String nome, String telefone) {
		super(id);
		this.nome = nome;
		this.telefone = telefone;
	}
}
