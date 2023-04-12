package br.com.formulario.jdbc.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class JDBC_Insere {
	
	protected static void main(String[] args) throws SQLException {
		
		// Conectando:
		Connection connection = new ConnectionFactory().getConnection();
		
		// Cria um preparedStatement:
		String sql = "INSERT INTO contatos" + 
				" (nome,email,endereco,dataNascimento)" +
				" values (?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		// Preenche os dados/valores:
		stmt.setString(1, "Marcos");
		stmt.setString(2, "marcos.galvao@ucsal.edu.br");
		stmt.setString(3, "Rua Vicente Batalha");
		stmt.setDate(4, new java.sql.Date(
				Calendar.getInstance().getTimeInMillis()));
		
		// Executa:
		stmt.execute();
		stmt.close();
		
		System.out.println("Contato registrado com sucesso!");
		
		connection.close();
	}
}
