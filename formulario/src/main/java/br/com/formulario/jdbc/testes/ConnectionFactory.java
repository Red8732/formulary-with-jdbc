package br.com.formulario.jdbc.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/formulario", "postgres", "8732");
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
