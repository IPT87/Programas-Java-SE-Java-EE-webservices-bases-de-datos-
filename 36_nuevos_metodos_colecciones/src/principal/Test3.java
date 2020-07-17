package principal;

import java.util.ArrayList;

public class Test3 {

	public static void main(String[] args) {
		ArrayList<Integer> nums=new ArrayList<>();
		nums.add(300);nums.add(81);nums.add(80);
		nums.add(25);nums.add(267);nums.add(459);
		nums.replaceAll(n->n*n);

	}

}
