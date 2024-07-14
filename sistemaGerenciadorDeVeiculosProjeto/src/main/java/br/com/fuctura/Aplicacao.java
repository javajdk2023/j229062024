package br.com.fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

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

			UsuarioDAO dao = new UsuarioDAO();

			Scanner scan = new Scanner(System.in);
			
			System.out.println("Escolha uma das opções abaixo:");
			System.out.println("1-Inserir\n2-Excluir\n3-Listar Todos");
			System.out.println("Digite:");
			
			int opcao = scan.nextInt();
			
			scan.close();
			
			if (opcao == 1) {
				// usuário ter que digitar os dados
				String cpf = "789098765";
				int idade = 79;
				Usuario user = new Usuario();
				user.setCpf(cpf);
				user.setIdade(idade);

				dao.inserir(conexao, user);
			} else if (opcao == 2) {
				Scanner cod = new Scanner(System.in);
				listarTodos(conexao);
				System.out.println("Digite o código: ");
				int codigo = cod.nextInt();
				cod.close();
				dao.excluir(conexao, codigo);
			}

			else if (opcao == 3) {
				listarTodos(conexao);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
