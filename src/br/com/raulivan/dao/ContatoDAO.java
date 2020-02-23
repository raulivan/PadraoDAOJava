package br.com.raulivan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.raulivan.entidade.Contato;

/**
 * Implementação do DAO da entidade Contato
 * @author Raulivan
 * @version 1.0
 *
 */
public class ContatoDAO extends DAOBase<Contato> {

	public ContatoDAO() throws SQLException, Exception {
		super();
	}

	@Override
	public boolean incluir(Contato entidade) throws SQLException, Exception {
		String sql = "INSERT INTO CONTATO values (?,?)";
		PreparedStatement pstm = conexao.prepareStatement(sql);
		
		pstm.setString(1, entidade.getNome());
		pstm.setString(2, entidade.getTelefone());
		
		pstm.execute();
		pstm.close();
		pstm = null;
		return true;
	}

	@Override
	public boolean alterar(Contato entidade) throws SQLException, Exception {
		String sql = "UPDATE CONTATO SET Nome = ?, Telefone = ? where Id = ?";
		PreparedStatement pstm = conexao.prepareStatement(sql);
		
		pstm.setString(1, entidade.getNome());
		pstm.setString(2, entidade.getTelefone());
		pstm.setInt(3, entidade.getId());
		
		pstm.execute();
		pstm.close();
		pstm = null;
		return true;
	}

	@Override
	public List<Contato> selecionar() throws SQLException, Exception {
		List<Contato> retorno = new ArrayList<Contato>();
		Statement stm = conexao.createStatement();
		
		ResultSet rs = stm.executeQuery("SELECT * FROM CONTATO ORDEBY NOME");
		
		while(rs.next()) {
			Contato c = new Contato();
			c.setId(rs.getInt(1));
			c.setNome(rs.getString(2));
			c.setTelefone(rs.getString(3));
			retorno.add(c);
		}
		rs.close();
		stm.close();
		stm = null;

		return retorno;
	}

	@Override
	public Contato selecionar(int id) throws SQLException, Exception {
		Contato contato = new Contato();
		String sql = "SELECT CONTATO where Id = ?";
		PreparedStatement pstm = conexao.prepareStatement(sql);
		pstm.setInt(1, id);
		
		ResultSet rs = pstm.executeQuery(sql);
		
		if(rs.next()) {
			contato.setId(rs.getInt(1));
			contato.setNome(rs.getString(2));
			contato.setTelefone(rs.getString(3));
		}
		rs.close();
		pstm.close();
		pstm = null;

		return contato;
	}

	@Override
	public boolean excluir(int id) throws SQLException, Exception {
		String sql = "DELETE CONTATO  where Id = ?";
		PreparedStatement pstm = conexao.prepareStatement(sql);
		
		pstm.setInt(1, id);
		
		pstm.execute();
		pstm.close();
		pstm = null;
		return true;
	}
}
