package ec.edu.ups.ppw.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Reporte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_reporte")
    int id_Reporte;
    String descripcion;
    Date fecha;

    @ManyToOne
    @JoinColumn(name="id_empleado")
    private Empleado empleado;
    
    @OneToOne(mappedBy = "reporte")
    private Ticket ticket;

    
    public Reporte() {
    }

    public Reporte(int id_Reporte, String descripcion, Date fecha) {
        this.id_Reporte = id_Reporte;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getId_Reporte() {
        return id_Reporte;
    }

    public void setId_Reporte(int id_Reporte) {
        this.id_Reporte = id_Reporte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Reporte{" + "id_Reporte=" + id_Reporte + ", descripcion=" + descripcion + ", fecha=" + fecha + '}';
    }
}