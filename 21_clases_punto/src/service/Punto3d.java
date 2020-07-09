package service;

public class Punto3d extends Punto {

	private int z;

	public Punto3d(int z) {
		this.z = z;
	}
	
	public Punto3d(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	public Punto3d() {
		super(10, 5);
		this.z = 5;
	}
	
	@Override
	public void imprimir() {
		System.out.println(getX() + ":" + getY() + ":" + z);
	}
	
	@Override
	public void desplazar(int v) {
		super.desplazar(v);
		this.z += v;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
}
