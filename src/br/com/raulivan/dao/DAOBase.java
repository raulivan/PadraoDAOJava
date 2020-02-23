package br.com.raulivan.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.raulivan.entidade.EntidadeBase;
import br.com.raulivan.util.JConnectionfactory;
import br.com.raulivan.util.TipoSGBD;

public abstract class DAOBase<T extends EntidadeBase> implements IDAO<T>{
	
	protected Connection conexao;
	
	public DAOBase() throws SQLException, Exception {
		conexao = JConnectionfactory.getConnection(TipoSGBD.MSSQL);
	}
}
