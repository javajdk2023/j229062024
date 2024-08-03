package br.com.fuctura.dao.impl;

import java.util.List;

import br.com.fuctura.dao.IUsuarioDAO;
import br.com.fuctura.entity.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UsuarioDAOImpl implements IUsuarioDAO {

	private final EntityManager em;

	public UsuarioDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Usuario> findAll() {
		var comandoSQL = "select f from Usuario f";
		TypedQuery<Usuario> query = em.createQuery(comandoSQL, Usuario.class);

		List<Usuario> resultadoConsulta = query.getResultList();

		return resultadoConsulta;
	}

	@Override
	public List<Usuario> findByIdade(int idade) {
		var comandoSQL = "select f from Usuario f where idade = :idade";

		TypedQuery<Usuario> query = em.createQuery(comandoSQL, Usuario.class);

		query.setParameter("idade", idade);
		
		List<Usuario> resultadoConsulta = query.getResultList();

		return resultadoConsulta;
	}

}
