package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Usuario;

public class UsuarioDAO {

	// Comando de:
	// inserir, consultar, excluir e alterar
	// usuario

	public void inserir(Connection conexao, Usuario usu) throws SQLException {

		String comandoSQL = "insert into usuario (cpf, idade) values (?, ?)";
		PreparedStatement pstm = conexao.prepareStatement(comandoSQL);
		pstm.setString(1, usu.getCpf());
		pstm.setInt(2, usu.getIdade());
		pstm.execute();
	}

	public void excluir(Connection conexao, int codigo) throws SQLException {
		String comandoSQL = "delete from usuario where codigo = ?";
		PreparedStatement pstm = conexao.prepareStatement(comandoSQL);
		pstm.setInt(1, codigo);
		pstm.execute();
	}

	public List<Usuario> consultarTodos(Connection conexao) throws SQLException {
		String comandoSQL = "select * from usuario";
		PreparedStatement pstm = conexao.prepareStatement(comandoSQL);

		ResultSet resultadoConsulta = pstm.executeQuery();

		List<Usuario> usuarios = new ArrayList<Usuario>();

		while (resultadoConsulta.next()) {
			String cpf = resultadoConsulta.getString("cpf");
			int idade = resultadoConsulta.getInt("idade");
			int codigo = resultadoConsulta.getInt("codigo");

			Usuario usu = new Usuario();
			usu.setCodigo(codigo);
			usu.setCpf(cpf);
			usu.setIdade(idade);

			usuarios.add(usu);
		}

		return usuarios;
	}

}
