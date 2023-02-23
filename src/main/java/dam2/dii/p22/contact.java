package dam2.dii.p22;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dam2.dii.p22.model.Contacto;
import dam2.dii.p22.service.Agenda;

@Path("contact")
public class contact {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Contacto> getListaContactos() {
    	ArrayList<Contacto> listaContactos = Agenda.getListaContactos(); 	
        return listaContactos;  
    }
    
    @GET
    @Path("size")
    @Produces(MediaType.TEXT_PLAIN)
    public int getTotalContactos() {
        int tam = Agenda.listaSize();
        return tam;
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String addContacto(@QueryParam("nombre") String nombre,
    		@QueryParam("apellido") String apellido,
    		@QueryParam("apellido2") String apellido2,
    		@QueryParam("email") String email,
    		@QueryParam("telefono") String telefono,
    		@QueryParam("comentario") String comentario) {
    	Contacto contacto = new Contacto(nombre, apellido, apellido2, email, telefono, comentario);
    	
    	HashMap<String,String> mensaje = Agenda.agregarContacto(contacto); 	
    	if (mensaje.containsKey("error_email")) {
    		return mensaje.get("error_email");
		} else {
			return mensaje.get("mensaje_exito");
		}
	}
    
	@PUT//  Actualizar un contacto  put
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarContacto(@QueryParam("id") String id,
			@QueryParam("nombre") String nombre,
    		@QueryParam("apellido") String apellido,
    		@QueryParam("apellido2") String apellido2,
    		@QueryParam("email") String email,
    		@QueryParam("telefono") String telefono,
    		@QueryParam("comentario") String comentario) {
    	Contacto contacto = new Contacto(id, nombre, apellido, apellido2, email, telefono, comentario);
    	
    	HashMap<String,String> mensaje = Agenda.editarContacto(contacto);
    	if (mensaje.containsKey("error_email")) {
    		return mensaje.get("error_email");
		} else {
			return mensaje.get("mensaje_exito");
		}
	}
    
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String eliminarContacto(@QueryParam("id") String id) {
    	HashMap<String,String> mensaje = Agenda.eliminarContacto(id);
    	if (mensaje.containsKey("mensaje_exito")) {
    		return mensaje.get("mensaje_exito");
		} else {
			return mensaje.get("mensaje_error");
		}
    }
//    @DELETE
//    @Path("{codigo}")
//    @Produces(MediaType.TEXT_PLAIN)
//    public void eliminarContacto(@PathParam("codigo") String id) {
//    	HashMap<String,String> mensaje = Agenda.eliminarContacto(id);
//		if (mensaje.containsKey("mensaje_exito")) {
//			return mensaje.get("mensaje_exito");
//		} else {
//			return mensaje.get("mensaje_error");
//		}
//    }   
}
