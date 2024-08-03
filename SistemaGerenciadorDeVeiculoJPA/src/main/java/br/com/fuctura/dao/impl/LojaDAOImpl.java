package br.com.fuctura.dao.impl;

import br.com.fuctura.dao.ILojaDAO;
import br.com.fuctura.entity.Loja;
import jakarta.persistence.EntityManager;

public class LojaDAOImpl implements ILojaDAO {
	
	private final EntityManager em;
	
	public LojaDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void persist(Loja loja) {
		em.getTransaction().begin();
		em.persist(loja);
		em.getTransaction().commit();
	}

}
