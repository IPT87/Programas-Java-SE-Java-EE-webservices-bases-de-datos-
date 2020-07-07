package principal;

public class TestArray {

	public static void main(String[] args) {
		int [] nums = {5, 8, 2, 4, 7, 8, 9};
		int cont = 0;
		
		// normal for loop
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				cont++;
			}
		}
		
		// enhanced for
		for (int num : nums) {
			if (num % 2 == 0) {
				cont++;
			}
		}
		System.out.println("Total de pares: " + cont);
	}

}
