package br.com.fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.fuctura.dao.UsuarioDAO;
import br.com.fuctura.entidade.Usuario;

public class Aplicacao {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String usuario = "postgres";
		String password = "123";
		try {

			Connection conexao = DriverManager.getConnection(url, usuario, password);
			System.out.println("Conectado com sucesso!");

			String cpf = "789098765";
			int idade = 79;

			// usuário ter que digitar os dados

			UsuarioDAO dao = new UsuarioDAO();

			Usuario user = new Usuario();
			user.setCpf(cpf);
			user.setIdade(idade);

			dao.inserir(conexao, user);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
