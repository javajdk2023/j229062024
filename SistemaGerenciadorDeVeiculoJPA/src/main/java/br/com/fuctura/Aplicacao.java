package br.com.fuctura;

import java.util.ArrayList;

import br.com.fuctura.dao.ILojaDAO;
import br.com.fuctura.dao.IUsuarioDAO;
import br.com.fuctura.dao.impl.LojaDAOImpl;
import br.com.fuctura.dao.impl.UsuarioDAOImpl;
import br.com.fuctura.entity.Endereco;
import br.com.fuctura.entity.Loja;
import br.com.fuctura.entity.Usuario;
import br.com.fuctura.entity.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FUCTURA-PU");

		EntityManager manager = factory.createEntityManager();

		Usuario usuario = new Usuario();
		usuario.setNome("Fuctura");
		usuario.setIdade(90);
		usuario.setCpf("123456789");

		manager.getTransaction().begin();
		manager.persist(usuario); // insert
		manager.getTransaction().commit();

		IUsuarioDAO dao = new UsuarioDAOImpl(manager);

		var resultadoConsulta = dao.findAll();

		for (Usuario u : resultadoConsulta) {
			System.out.println(u);
		}

		resultadoConsulta = dao.findByIdade(90);

		for (Usuario u : resultadoConsulta) {
			System.out.println(u);
		}
		
		//Quero salvar uma loja
		var endereco = new Endereco();
		endereco.setCep("852963");
		
		var loja = new Loja();
		loja.setCnpj("87690");
		
		loja.setEndereco(endereco);
		
		//Invocar o DAO
		ILojaDAO lojaDao = new LojaDAOImpl(manager);
		lojaDao.persist(loja);

		var veiculo1  = new Veiculo();
		veiculo1.setPlaca("KJX-7654");
		
		var veiculo2 = new Veiculo();
		veiculo2.setPlaca("TRC-741");
		
		var veiculos = new ArrayList<Veiculo>();
		
		veiculos.add(veiculo1);
		veiculos.add(veiculo2);

		var loja2 = new Loja();
		loja2.setCnpj("741852");
		
		loja2.setVeiculos( veiculos );
		
		lojaDao.persist(loja2);
	}

}
