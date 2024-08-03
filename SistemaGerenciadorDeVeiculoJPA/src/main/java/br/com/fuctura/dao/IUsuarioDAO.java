package br.com.fuctura.dao;

import java.util.List;

import br.com.fuctura.entity.Usuario;

public interface IUsuarioDAO {

	List<Usuario> findAll();
	List<Usuario> findByIdade(int idade);
	
}
