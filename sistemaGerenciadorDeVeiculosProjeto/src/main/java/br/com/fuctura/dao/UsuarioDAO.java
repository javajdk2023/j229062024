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
	} // chave do consultar todos

	//
	public List<Usuario> findIdadeBetween(Connection conn, int min, int max) throws SQLException {
		String comandoSQL = "select * from usuario where idade between ? and ?";

		PreparedStatement pstm = conn.prepareStatement(comandoSQL); // modularizar

		pstm.setInt(1, min);
		pstm.setInt(2, max);

		ResultSet resultadoConsulta = pstm.executeQuery(); // modularizar

		List<Usuario> usuarios = mapper(resultadoConsulta);
		
		return usuarios;
	}
	
	public List<Usuario> findNomeLike(Connection conn, String like) throws SQLException{
		String coringa = like + "%";
		
		String comandoSQL = "select * from usuario where nome like ?";

		PreparedStatement pstm = conn.prepareStatement(comandoSQL); // modularizar

		pstm.setString(1, coringa);

		ResultSet resultadoConsulta = pstm.executeQuery(); // modularizar

		List<Usuario> usuarios = mapper(resultadoConsulta);
		
		return usuarios;
	}
	
	private List<Usuario> mapper(ResultSet resultadoConsulta) throws SQLException {

		List<Usuario> usuarios = new ArrayList<Usuario>();

		while (resultadoConsulta.next()) {
			String cpf = resultadoConsulta.getString("cpf");
			int idade = resultadoConsulta.getInt("idade");
			int codigo = resultadoConsulta.getInt("codigo");

			Usuario u = new Usuario();
			u.setCodigo(codigo);
			u.setCpf(cpf);
			u.setIdade(idade);

			usuarios.add(u);
		}

		return usuarios;

	}

}
