package model;

public class Pedido {
	private int numero;
	private String producto;
	private double precio;

	public Pedido(int numero, String producto, double precio) {
		this.numero = numero;
		this.producto = producto;
		this.precio = precio;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Pedido))
			return false;
		Pedido other = (Pedido) obj;
		if (numero != other.numero) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [numero=" + numero + ", producto=" + producto + ", precio=" + precio + "]";
	}

}
