package prob4;

import java.util.stream.IntStream;

public class TestStream {

	public static void printSquares(int num) {

		IntStream.iterate(1, x -> x + 1)
			.limit(num)
			.map(x -> x * x)
			.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		printSquares(4);
	}

}
