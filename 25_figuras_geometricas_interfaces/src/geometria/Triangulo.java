package geometria;

public class Triangulo extends Figura {

	private int base, altura;
	
	public Triangulo(String color, int base, int altura) {
		super(color);
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double superficie() {
		return (base * altura) / 2;
	}
	
}
