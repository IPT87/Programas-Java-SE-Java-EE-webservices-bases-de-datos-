package model;

public class Cliente {
	private int idCliente;
	private String nombre;
	private String email;
	private String password;
	private int telefono;
	
	
	public Cliente(int idCliente, String nombre, String email, String password, int telefono) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
	}
	
	public Cliente(String nombre, String email, String password, int telefono) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", email: " + email + ", telefono: " + telefono;
	}
	
}
