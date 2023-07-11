package ec.edu.ups.ppw.modelo;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Empleado {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_empleado")
	int id_empleado;
	
	@OneToMany(mappedBy="empleado")
	private Set<Reporte> reportes;
	
	@OneToOne
	@JoinColumn(name="id_persona")
	private Persona persona;
	

	private String cedula;
	private String cargo;
    
    public Empleado() {
    }

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Empleado [reportes=" + reportes + ", id_empleado=" + id_empleado + ", cedula=" + cedula + ", cargo="
				+ cargo + "]";
	}
}