package br.com.projeto.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoUsuario {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/ECOLLUS_BD";
		String username = "root";
		String password = "MySQL@2022";

		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("Conexão bem-sucedida!");

			// Exemplo de execução de um comando SQL (consulta)
			String sql = "SELECT * FROM Usuario";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			// Processar o resultado da consulta
			while (resultSet.next()) {
				// Ler os valores das colunas
				int id_usuario = resultSet.getInt("id_usuario");
				String CNPJ = resultSet.getString("CNPJ");
				String nome = resultSet.getString("nome");
				String email = resultSet.getString("email");
				String senha = resultSet.getString("senha");
				


				// Fazer algo com os dados
				System.out.println("ID: " + id_usuario + ", nome: " + nome + ", email: "
						+ email + " senha: " + senha  + ", CNPJ: " + CNPJ);
			}

			// Fechar recursos
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
		}
	}

}
