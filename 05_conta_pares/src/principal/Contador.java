package principal;

public class Contador {

	public static void main(String[] args) {
		int n1 = 17;
		int n2 = 5;
		int pares = 0;
		
		int desde = (n1 > n2) ? n2 : n1;
		int hasta = (n1 > n2) ? n1 : n2;
		
		for (; desde <= hasta; desde++) {
			if (desde % 2 == 0) {
				pares++;
			}
		}
		
		System.out.println(pares);

	}

}
