package ec.edu.ups.ppw.demo;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.ppw.modelo.DetalleTicket;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class DetalleTicketDao implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(DetalleTicket detalle) {
		em.persist(detalle);
	}
	
	public void update(DetalleTicket detalle) {
		em.merge(detalle);
	}
	
	public DetalleTicket read(int id_ticket) {
		DetalleTicket p = em.find(DetalleTicket.class, id_ticket);
		return p;
	}
	
	public void delete(int id_ticket) {
		DetalleTicket p = em.find(DetalleTicket.class, id_ticket);
		em.remove(p);
	}
	
	public List<DetalleTicket> getAll(){
		String jpql = "SELECT p FROM DetalleTicket p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}