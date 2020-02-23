package br.com.raulivan.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Raulivan
 * @version 1.0
 * 
 * Classe de conex�o com o banco de dados
 *
 */
public class JConnectionfactory {

	/**
	 * V�riavel que armazena a conex�o
	 */
	private static Connection _connection;
	
	/**
	 * M�todo que retorna uma conex�o com o banco de dados
	 * @param sgbd - Tipo de Banco de Dados
	 * @return Conex�o com o Banco de dados
	 * @throws SQLException
	 * @throws Exception
	 * 
	 */
	public static Connection getConnection(TipoSGBD sgbd)  throws SQLException, Exception {
		
		if(_connection != null)
			return _connection;
		
		switch (sgbd) {
			case  MSSQL :
				return conectarSQLServer();
			case  MYSQL :
				return conectarMySQL();
			default:
				throw new Exception("Tipo de SGBD inv�lido");
			}
	}
	 

	/**
	 * M�to de conex�o com o banco de dados Sql Server
	 * @return Conex�o
	 * @throws SQLException
	 * @throws Exception
	 */
   private static Connection conectarSQLServer() throws SQLException, Exception{  
	   
	   String banco = "AGENDA_JAVA";  
	   String usuario = "sa";
	   String senha = "123456";
	   String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
	   String servidor = "DESKTOP-F75NQ86\\SQLEXPRESS";  
	   Class.forName(driver);   
	   _connection = DriverManager.getConnection("jdbc:sqlserver://" 
			   + servidor + ";databaseName=" + banco, usuario, senha);  
     return _connection;  
   }  
   
   /**
    * M�todo que retorna uma conex�o com o banco de dados My Sql
    * @return
    * @throws SQLException
    * @throws ClassNotFoundException
    */
   private static Connection conectarMySQL() throws SQLException, ClassNotFoundException {  
       String banco = "AGENDA_JAVA"; 
       String usuario = "root";  
       String senha = "root"; 
       String driver = "com.mysql.jdbc.Driver";  
       String servidor = "localhost";  
       Connection conn;  
       Class.forName(driver);  
       conn = DriverManager.getConnection("jdbc:mysql://" 
    		   + servidor + ":3306/" + banco, usuario, senha);  
	   return conn;  
   }  
   
   /**
    * Fecha a conex�o com o banco de dados
    * @throws SQLException
    */
   public static void fecharConexao() throws SQLException {
	   _connection.close();
   }
   
}





