package day2.prob2;

import java.util.function.Supplier;

public class OutputRandom2 {

	public static void main(String[] args) {
		Supplier<Double> s = ()-> Math.random();
		System.out.println(s.get());
	}

}
