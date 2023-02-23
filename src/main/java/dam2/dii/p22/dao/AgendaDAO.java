package dam2.dii.p22.dao;

import java.util.ArrayList;
import dam2.dii.p22.model.Contacto;

public class AgendaDAO {
	private static final ArrayList<Contacto> listaContactos = new ArrayList<Contacto>();
	
	private static ArrayList<Contacto> crearListaContactos() {
		listaContactos.add(new Contacto("1", "Aaron", "Blasco", "Cano", "angel@blasco.es", "111111111", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptates expedita nihil vero aliquid ut rem in accusantium!"));
		listaContactos.add(new Contacto("2", "Beatriz", "Cano", "Domingo", "beatriz@cano.es", "222222222", "Lorem ipsum dolor ducimus ut blanditiis possimus quis non laborum sed est tenetur incidunt facilis provident sapiente similique laudantium! Ratione, culpa numquam? Accusamus!"));
		listaContactos.add(new Contacto("3", "Carlos", "Domingo", "Egido", "carlos@domingo.es", "333333333", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptates expedita nihil vero aliquid ut rem in accusantium voluptatibus dolore! Quidem, repellendus, obcaecati eveniet necessitatibus illo pariatur excepturi enim ea doloremque "));
		listaContactos.add(new Contacto("4", "Diego", "Egido", "Floren", "diego@egido.es", "444444444", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptates expedita nihil vero aliquid ut rem in accusantium voluptatibus dolore!"));
		listaContactos.add(new Contacto("5", "Eric", "Floren", "Guilabert", "eric@floren.es", "555555555", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptates expedita nihil vero aliquid ut rem in accusantium voluptatibus dolore! Quidem, repellendus, obcaecati eveniet necessitatibus illo pariatur excepturi enim ea doloremque ducimus ut blanditiis possimus quis non laborum sed est tenetur incidunt facilis provident sapiente similique laudantium! Ratione, culpa numquam? Accusamus! Voluptates expedita nihil vero aliquid ut rem in accusantium voluptatibus dolore! Quidem, repellendus, obcaecati eveniet necessitatibus illo pariatur excepturi enim ea doloremque ducimus ut blanditiis possimus quis non laborum sed est tenetur incidunt facilis provident sapiente similique laudantium! Ratione, culpa numquam? Accusamus!"));
		listaContactos.add(new Contacto("6", "Francisco", "Guilabert", "Huerta", "fran@guilabert.es", "666666666", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptates expedita nihil vero aliquid ut rem in accusantium voluptatibus dolore! Quidem, repellendus, obcaecati eveniet necessitatibus illo pariatur excepturi enim ea doloremque ducimus ut blanditiis possimus quis non laborum sed"));
		return listaContactos;
	}
	public static ArrayList<Contacto> getListaContactos() {
		if (listaContactos.size() < 1) {
			crearListaContactos();
		}
		return listaContactos;
	}
	public static Contacto getContactobyId(String id) {
		Contacto contacto = new Contacto();
		contacto.setId("0");
		for (int i = 0; i < listaContactos.size(); i++) {
			if (listaContactos.get(i).getId().equals(id)) {
				contacto = listaContactos.get(i);
			}
		}
		return contacto;	
	}
	public static boolean crearContacto(Contacto contacto) {
		contacto.setId(getNuevoId());
		listaContactos.add(contacto);
		return true;
	}
	public static boolean borrarContacto(Contacto contacto) {
		boolean exito = false;
		for (int i = 0; i < listaContactos.size(); i++) {
			if (listaContactos.get(i).getId().equals(contacto.getId())) {
				listaContactos.remove(listaContactos.get(i));
				exito = true;
			}
		}
		return exito;
	}
	public static boolean actualizarContacto(Contacto contacto) {
		boolean exito = false;
		for (int i = 0; i < listaContactos.size(); i++) {
			if (listaContactos.get(i).getId().equals(contacto.getId())) {
				listaContactos.get(i).setNombre(contacto.getNombre());
				listaContactos.get(i).setApellido(contacto.getApellido());
				listaContactos.get(i).setApellido2(contacto.getApellido2());
				listaContactos.get(i).setEmail(contacto.getEmail());
				listaContactos.get(i).setTelefono(contacto.getTelefono());
				listaContactos.get(i).setComentario(contacto.getComentario());
				exito = true;
			}
		}
		return exito;
	}
	public static String getNuevoId() {
		int id = 0;
		for (int i = 0; i < listaContactos.size(); i++) {
			if (Integer.parseInt(listaContactos.get(i).getId()) > id) {
				id = Integer.parseInt(listaContactos.get(i).getId());
			}
		}
		id++;
		return String.valueOf(id);
	}
}
