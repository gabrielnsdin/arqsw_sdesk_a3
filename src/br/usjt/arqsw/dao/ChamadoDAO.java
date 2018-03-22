package br.usjt.arqsw.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

@Repository
public class ChamadoDAO {

	@PersistenceContext
	EntityManager manager;

	public List<Chamado> listarChamados(Fila fila) throws IOException {
		
		List<Chamado> lista = manager.createQuery("select c from Chamado c where c.fila.id = :id_fila", Chamado.class)
				.setParameter("id_fila", fila.getId())
				.getResultList(); 
		return lista;
	}

}
