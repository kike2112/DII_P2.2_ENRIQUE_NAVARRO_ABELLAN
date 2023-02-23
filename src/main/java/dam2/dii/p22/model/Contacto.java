package dam2.dii.p22.model;

public class Contacto {
	private String id_contact;
	private String nombre;
	private String apellido;
	private String apellido2;
	private String email;
	private String telefono;
	private String comentario;
	
	public Contacto() {
		super();
	}
	public Contacto(String nombre, String apellido, String apellido2, String email, String telefono,
			String comentario) {
		super();
        if (nombre == null) {
        	nombre = "";
		}
        if (apellido == null) {
        	apellido = "";
        }
        if (apellido2 == null) {
        	apellido2 = "";
        }
        if (email == null) {
        	email = "";
        }
        if (telefono == null) {
        	telefono = "";
        }
        if (comentario == null) {
        	comentario = "";
        }
		this.nombre = nombre;
		this.apellido = apellido;
		this.apellido2 = apellido2;
		this.email = email;
		this.telefono = telefono;
		this.comentario = comentario;
	}
	public Contacto(String id_contact, String nombre, String apellido, String apellido2, String email, String telefono,
			String comentario) {
		super();
		this.id_contact = id_contact;
		this.nombre = nombre;
		this.apellido = apellido;
		this.apellido2 = apellido2;
		this.email = email;
		this.telefono = telefono;
		this.comentario = comentario;
	}
	
	public String getId() {
		return id_contact;
	}
	public void setId(String id_contact) {
		this.id_contact = id_contact;
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
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
