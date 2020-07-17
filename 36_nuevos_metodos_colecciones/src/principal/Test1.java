package principal;

import java.util.ArrayList;

public class Test1 {

	static double media;
	
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(300); nums.add(81); nums.add(80);
		nums.add(25); nums.add(267); nums.add(459);
		int limite = 150;
		
		// recorrer una coleccion de metodo tradicional
		// con for loop
		/* for (Integer n : nums) {
			System.out.println(n);
		} */
		
		// reemplaza cada numero con el mismo numero
		// al quadrado
		nums.replaceAll(n -> n * n);
		
		// elimina todos los numeros en la lista mayores
		// del limite
		nums.removeIf(n -> n > limite);
		
		// recorrer la coleccion con el nuevo metodo
		// forEach
		nums.forEach(n -> System.out.println(n));
		
		// solo se pueden usar atributos
		nums.forEach(n -> media += n);
		System.out.println("La media es " + (media / nums.size()));
		
	}

}
