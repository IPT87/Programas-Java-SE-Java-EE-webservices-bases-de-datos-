package principal;

import java.util.stream.Stream;

public class TestParallel {

	public static void main(String[] args) {
		Stream<Integer> st = Stream.of(3, 25, 8, 11, 4, 27, 15, 36, 55, 92, 87, 72, 71, 60, 19, 55, 34, 90, 114, 567, 320, 681, 194, 18, 75);
		st
		 .parallel()
		 .filter(n -> n % 2 == 0)
		 .forEach(n -> System.out.println(n));
		
		Stream<Integer> st1 = Stream.of(3, 25, 8, 11, 4, 27, 15, 36, 55, 92, 87, 72, 71, 60, 19, 55, 34, 90, 114, 567, 320, 681, 194, 18, 75);
		st1
		 .filter(n -> n % 2 == 0)
		 .forEach(n -> System.out.println(n));
	}

}
