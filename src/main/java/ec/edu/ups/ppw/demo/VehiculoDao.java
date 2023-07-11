package ec.edu.ups.ppw.demo;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.ppw.modelo.Persona;
import ec.edu.ups.ppw.modelo.Vehiculo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class VehiculoDao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert (Vehiculo vehiculo) {
		
		em.persist(vehiculo);
	}
	
	public void update (Vehiculo vehiculo) {
		
		em.merge(vehiculo);
	}
	    
	public Vehiculo read(int  id_vehiculo) {
		Vehiculo v = em.find(Vehiculo.class, id_vehiculo);
		return v;
		
	}
	
	public void delete (int id_vehiculo) {
		
		Vehiculo v = em.find(Vehiculo.class, id_vehiculo);
		em.remove(v);
				
	}
	
	// metodo de lista
	
	public List<Vehiculo> getAll(){
		String jpql = "SELECT v FROM Vehiculo v";
		Query q = em.createQuery(jpql);
		return q.getResultList();		
	}
	
}