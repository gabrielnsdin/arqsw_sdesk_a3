package br.usjt.arqsw.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author asbonato
 *
 */
@Repository
public class FilaDAO {
	
	@PersistenceContext
	EntityManager manager;

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public List<Fila> listarFilas() throws IOException {
		List<Fila> lista = manager.createQuery("select f from Fila f", Fila.class).getResultList(); 
		System.out.println(lista.toString());
		return lista;
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws IOException
	 */
	public Fila carregar(int id) throws IOException {
		Fila fila = manager.find(Fila.class, id);
		return fila;
	}

}
