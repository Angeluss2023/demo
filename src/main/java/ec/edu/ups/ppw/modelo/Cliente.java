package ec.edu.ups.ppw.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Cliente {
	
	@Id
	@Column(name="id_cliente")
    int idCliente;
	String cedula;
    String nombre;
    String apellido;

    @OneToOne
	@JoinColumn(name="id_persona")
	private Persona persona;
    
    
    public Cliente() {
    }


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



//	@Override
	//	public String toString() {
	//return "Cliente [idCliente=" + idCliente + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido="
	//		+ apellido + ", persona=" + persona + "]";
	//}
}