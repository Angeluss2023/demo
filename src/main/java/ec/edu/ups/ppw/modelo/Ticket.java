package ec.edu.ups.ppw.modelo;

import java.time.*;
import java.time.LocalDateTime;
import java.time.format.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity

public class Ticket  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ticket")
	
    int id_ticket;
    String hora_entrada;
    String hora_salida;

    @OneToOne
    @JoinColumn(name="id_tarifa")
    private Tarifa tarifa;
    
    @OneToOne
    @JoinColumn(name="id_vehiculo")
    private Vehiculo vehiculo;
    
    @OneToOne
    @JoinColumn(name="id_reporte")
    private Reporte reporte;
    
    @OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_ticket")
    private List<DetalleTicket> tickets;
    
    public Ticket() {
    }

 
    
    public Ticket(int id_ticket, String hora_entrada, String hora_salida, Tarifa tarifa,
			Vehiculo vehiculo, Reporte reporte, List<DetalleTicket> tickets) {
		super();
		this.id_ticket = id_ticket;
		this.hora_entrada = hora_entrada;
		this.hora_salida = hora_salida;
		this.tarifa = tarifa;
		this.vehiculo = vehiculo;
		this.reporte = reporte;
		this.tickets = tickets;
	}

	public int getId_ticket() {
		return id_ticket;
	}

	public void setId_ticket(int id_ticket) {
		this.id_ticket = id_ticket;
	}

	public String getHora_entrada() {
		return hora_entrada;
	}

	public void setHora_entrada(String hora_entrada) {
		this.hora_entrada = hora_entrada;
	}

	public String getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Reporte getReporte() {
		return reporte;
	}

	public void setReporte(Reporte reporte) {
		this.reporte = reporte;
	}
	
	public List<DetalleTicket> getTickets() {
		return tickets;
	}

	public void setTickets(List<DetalleTicket> tickets) {
		this.tickets = tickets;
	}



	public void addDetalle(DetalleTicket ticket) {
		if(tickets == null) {
			tickets = new ArrayList<DetalleTicket>();
		}
		tickets.add(ticket);
		
	}



	@Override
	public String toString() {
		return "Ticket [id_ticket=" + id_ticket + ", hora_entrada=" + hora_entrada + ", hora_salida=" + hora_salida
				+ ", tarifa=" + tarifa + ", vehiculo=" + vehiculo + ", reporte=" + reporte + ", tickets=" + tickets
				+ "]";
	}
}