package ec.edu.ups.ppw.demo;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.ppw.modelo.Persona;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class PersonaDao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert (Persona persona) {
		
		em.persist(persona);
	}
	
	public void update (Persona persona) {
		
		em.merge(persona);
	}
	
	public Persona read(int id_Persona) {
		Persona p = em.find(Persona.class, id_Persona);
		return p;
		
	}
	
	public void delete (String cedula) {
		
		Persona p = em.find(Persona.class, cedula);
		em.remove(p);
				
	}

	public List<Persona> getAll(){
		String jpql = "SELECT p FROM Persona p";
		Query q = em.createQuery(jpql);
		return q.getResultList();		
	}
}