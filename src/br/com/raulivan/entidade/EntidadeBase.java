package br.com.raulivan.entidade;


/**
 * Classe base para geração de entidades, 
 * com os atributos comum a todas as entidades
 * 
 * @author Raulivan
 * @version 1.0
 */
public class EntidadeBase {

	private int id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public EntidadeBase() {
		
	}

	public EntidadeBase(int id) {
		super();
		this.id = id;
	}
}
