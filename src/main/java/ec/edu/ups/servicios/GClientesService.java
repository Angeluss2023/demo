package ec.edu.ups.servicios;

import java.util.List;

import ec.edu.ups.negocio.GestionClientes;
import ec.edu.ups.ppw.demo.PersonaDao;
import ec.edu.ups.ppw.demo.TicketDao;
import ec.edu.ups.ppw.demo.VehiculoDao;
import ec.edu.ups.ppw.modelo.Persona;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("clientes")
public class GClientesService {
	
	@Inject
	private GestionClientes gClientes;
	
	@Inject
    private PersonaDao daoPersona;
    
	@Inject
	private VehiculoDao daoVehiculo;
	
	@Inject
	private TicketDao daoTicket;
	
    
    /*/@GET
    @Path("personas")
    @Produces("application/json")
    public List<Persona> getPersonas() {
        return daoPersona.getAll();
    }/*/
	
	// tipo de solicitud al que responde
	
	@GET 
	@Path("saludo")
	public String saludo() {
		return "Hola Fredd";
	}
	
	@GET 
	@Path("suma")
	public String suma(@QueryParam("a") int a,
			@QueryParam("b") int b) {
		return "R = " + (a + b);
	}
	
	@GET 
	@Path("multiplicacion/{a}/{b}")
	public String multiplicacion(@PathParam("a") int a,
			@PathParam("b") int b) {
		return "R = " + (a * b);
	}
	
	@GET 
	@Path("misdatos")
	@Produces("application/json")
	public Persona misDatos() {
	
		Persona p = new Persona();
		p.setCedula("0106542");
		p.setNombre("Lisseth Padilla");
		
		return p; 
	}
	
	/*/@POST	
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarCliente(Persona persona) {
		try {
			gClientes.guardarClientes(persona);
			return Response.status(Response.Status.OK).entity(persona).build();
		}catch(Exception e){
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar: " +e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}*/
	
	@GET
	@Path("personas1")
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarPersona(Persona persona) {
	    try {
	        gClientes.guardarPersonas(persona);
	        List<Persona> personas = getPersonas(); 
	        return Response.status(Response.Status.OK).entity(personas).build();
	    } catch (Exception e) {
	        e.printStackTrace();
	        Error error = new Error();
	        error.setCodigo(99);
	        error.setMensaje("Error al guardar: " + e.getMessage());
	        return Response.status(Response.Status.OK).entity(error).build();
	    }
	}

	public List<Persona> getPersonas() {
	    return daoPersona.getAll();
	}

}