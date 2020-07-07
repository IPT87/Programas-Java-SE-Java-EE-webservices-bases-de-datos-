package principal;

public class Suma {

	public static void main(String[] args) {

		int suma = 0, cont = 0;

		while (suma < 1000) {
			cont++;
			suma += cont;
		}

		System.out.println("Se ha sumado hasta: " + cont);

	}

}
