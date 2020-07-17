package principal;

import java.util.ArrayList;

public class Test2 {

	public static void main(String[] args) {
		ArrayList<Integer> nums=new ArrayList<>();
		nums.add(300);nums.add(81);nums.add(80);
		nums.add(25);nums.add(267);nums.add(459);
		int limite=150;
		
		/*for(int i=0;i<nums.size();i++) {
			if(nums.get(i)>limite) {
				nums.remove(i);
			}
		}*/
		nums.removeIf(n->n>limite);
		nums.forEach(n->System.out.println(n));

	}

}
