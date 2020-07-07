package model;

public class Ciudad {

	private String nombre;
	private double temperatura;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		
		if (!nombre.isEmpty()) {
			this.nombre = nombre;
		}
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {

		if (temperatura > -15 || temperatura < 50) {
			this.temperatura = temperatura;
		}
	}

}
