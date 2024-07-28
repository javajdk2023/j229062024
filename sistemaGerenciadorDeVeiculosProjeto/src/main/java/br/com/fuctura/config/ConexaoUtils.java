package br.com.fuctura.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtils {

	String url = "jdbc:postgresql://localhost:5432/postgres";
	String usuario = "postgres";
	String password = "123";
	
	public Connection getConnection() throws SQLException {
		Connection conexao = DriverManager.getConnection(url, usuario, password);
		System.out.println("Conectado com sucesso!");
		return conexao;
	}
	
}
