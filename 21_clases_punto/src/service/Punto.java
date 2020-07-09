package service;

public class Punto {

	private int x, y;
	
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Punto() {
		this.x = 5;
		this.y = 5;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void imprimir() {
		System.out.println(x + ":" + y);
	}
	
	public void desplazar (int v) {
		this.x += v;
		this.y += v;
	}
}
