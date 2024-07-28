package br.com.fuctura;

import br.com.fuctura.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FUCTURA-PU");

		EntityManager manager =  factory.createEntityManager();
		
		Usuario usuario = new Usuario();
		usuario.setNome("Fuctura");
		usuario.setIdade(90);
		usuario.setCpf("123456789");
		
		
		manager.getTransaction().begin();
		manager.persist(usuario); //insert
		manager.getTransaction().commit();
		
	}

}
