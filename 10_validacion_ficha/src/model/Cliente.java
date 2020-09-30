package model;

public class Cliente {
	
	private String user;
	private int edad;
	private String email;
	
	
	public Cliente(String user, int edad, String email) {
		super();
		this.user = user;
		this.edad = edad;
		this.email = email;
	}
	
	public Cliente() {
		super();
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
