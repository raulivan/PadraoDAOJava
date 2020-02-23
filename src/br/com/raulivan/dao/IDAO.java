package br.com.raulivan.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.raulivan.entidade.EntidadeBase;

/**
 * Interface que define o comportamento padrão de uma classe DAO
 * @author Raulivan
 * @version 1.0
 * @param <T> Classes de entidade
 */
public interface IDAO<T extends EntidadeBase>  {

	/**
	 * Incluir registro no banco
	 * @param entidade
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean incluir(T entidade) throws SQLException, Exception;
	
	/**
	 * Alterar registro no banco
	 * @param entidade
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean alterar(T entidade) throws SQLException, Exception;
	
	/**
	 * Selecionar todos os registro do banco
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public List<T> selecionar() throws SQLException, Exception;
	
	/**
	 * Seleciona um registro do banc ode dados
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public T selecionar(int id) throws SQLException, Exception;
	
	/**
	 * Esxcluir um registro do banco de dados
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean excluir(int id) throws SQLException, Exception;
	
}
