package dam2.dii.p22.service;

import java.util.ArrayList;
import java.util.HashMap;

import dam2.dii.p22.dao.AgendaDAO;
import dam2.dii.p22.model.Contacto;

public class Agenda {
	
	public static ArrayList<Contacto> getListaContactos() {
		ArrayList<Contacto> listaContactosClon = new ArrayList<Contacto>();
		ArrayList<Contacto> listaContactos = AgendaDAO.getListaContactos();
		for (int i = 0; i < listaContactos.size(); i++) {
			listaContactosClon.add(clonaContacto(listaContactos.get(i)));
		}
		return listaContactosClon;
	}
	public static int listaSize() {
    	int tam = Agenda.getListaContactos().size();
        return tam;
	}
	public static HashMap<String,String> agregarContacto(Contacto contacto) {
		HashMap<String,String> mensaje = new HashMap<String,String>();
		if (exiteEmail(contacto.getEmail())) {
			mensaje.put("error_email", "Ese email ya ha sido utilizado");
		} else if (contacto.getEmail().length() == 0) {
			mensaje.put("error_email", "Debe rellenar este campo");
		} else {
			mensaje.put("mensaje_exito", "Contacto añadido correctamente");
			AgendaDAO.crearContacto(contacto);
		}
		return mensaje;
	}
	public static HashMap<String,String> eliminarContacto(String id_contact) {
		Contacto contacto = AgendaDAO.getContactobyId(id_contact);
		HashMap<String,String> mensaje = new HashMap<String,String>();
		if (AgendaDAO.borrarContacto(contacto)) {
			mensaje.put("mensaje_exito", "El contacto \"" + contacto.getNombre() + "\" con \"id" + contacto.getId() + "\" ha sido eliminado");
		} else {
			mensaje.put("mensaje_error", "ERROR - Este contacto no existe");
		}
		return mensaje;
	}
	public static HashMap<String,String> editarContacto(Contacto contacto) {
		boolean coincidencia = false;
		HashMap<String,String> mensaje = new HashMap<String,String>();
		for (int i = 0; i < AgendaDAO.getListaContactos().size(); i++) {
			if (contacto.getEmail().equals(AgendaDAO.getListaContactos().get(i).getEmail()) && !contacto.getId().equals(AgendaDAO.getListaContactos().get(i).getId())) {
				mensaje.put("error_email", "El email \"" + contacto.getEmail() + "\" ya existe en otro contacto");
				coincidencia = true;
			}
		}
		if (!coincidencia) {
			if (AgendaDAO.actualizarContacto(contacto)) {
				mensaje.put("mensaje_exito", "El contacto \"" + contacto.getNombre() + "\" con \"id" + contacto.getId() + "\" se ha editado correctamente");
			} else {
				mensaje.put("mensaje_exito", "No existe el contacto con \"id" + contacto.getId() + "\"");
			}
		}	
		return mensaje;
	}
	public static Contacto getContacto(String id_contact) {
		Contacto contacto = AgendaDAO.getContactobyId(id_contact);
		Contacto contactoClon = clonaContacto(contacto);
		return contactoClon;
	}
	public static boolean exiteEmail(String email) {
		boolean existe = false;
		for (int i = 0; i < AgendaDAO.getListaContactos().size(); i++) {
			if (AgendaDAO.getListaContactos().get(i).getEmail().equals(email) && email.length() > 0) {
				existe = true;
			}
		}
		return existe;
	}
	public static boolean exiteTelefono(String telefono) {
		boolean existe = false;
		for (int i = 0; i < AgendaDAO.getListaContactos().size(); i++) {
			if (AgendaDAO.getListaContactos().get(i).getTelefono().equals(telefono) && telefono.length() > 0) {
				existe = true;
			}
		}
		return existe;
	}
	public static Contacto getUsuarioVacio() {
		Contacto contacto = new Contacto("", "", "", "", "", "");
		return contacto;
	}
	private static Contacto clonaContacto(Contacto contacto) {
		Contacto contactoClon = new Contacto();
		contactoClon.setId(contacto.getId());
		contactoClon.setNombre(contacto.getNombre());
		contactoClon.setApellido(contacto.getApellido());
		contactoClon.setApellido2(contacto.getApellido2());
		contactoClon.setEmail(contacto.getEmail());
		contactoClon.setTelefono(contacto.getTelefono());
		contactoClon.setComentario(contacto.getComentario());
		return contactoClon;
	}
}
