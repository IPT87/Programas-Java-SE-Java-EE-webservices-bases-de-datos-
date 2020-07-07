package principal;

public class DatosTemperatura {

	public static void main(String[] args) {
		
		String temps = "24.3,26.7,31.4,22.9,10.3,17.8";
		String[] datosTemp = temps.split(",");
		double media = 0;
		
		for (String element : datosTemp) {
			media += Double.parseDouble(element);
		}
		
		System.out.printf("La temperatura media es: %.2f", media / datosTemp.length);

	}

}
