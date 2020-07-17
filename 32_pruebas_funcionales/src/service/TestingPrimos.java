package service;

import java.util.function.Predicate;

public class TestingPrimos implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {
		for ( int i = 2; i < t; i++) {
			if (t % i == 0) {
				return false;
			}
		}
		return true;
	}

}
