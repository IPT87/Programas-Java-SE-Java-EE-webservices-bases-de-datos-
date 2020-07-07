package principal;

public class LanzarDado {

	public static void main(String[] args) {

		int dado = 0;
		double[] numeros = new double[6];
		
		for (int i = 0; i < 10_000; i++) {
			
			dado = (int) (Math.random() * 6 + 1);
			
			numeros[dado - 1]++;
		}
		
		
		
		System.out.println("Porcentaje 1: " + (numeros[0] / 100) + " %");
		System.out.println("Porcentaje 2: " + (numeros[1] / 100) + " %");
		System.out.println("Porcentaje 3: " + (numeros[2] / 100) + " %");
		System.out.println("Porcentaje 4: " + (numeros[3] / 100) + " %");
		System.out.println("Porcentaje 5: " + (numeros[4] / 100) + " %");
		System.out.println("Porcentaje 6: " + (numeros[5] / 100) + " %");

	}

}
