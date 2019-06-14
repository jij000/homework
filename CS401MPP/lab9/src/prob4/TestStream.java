package prob4;

import java.util.stream.IntStream;

public class TestStream {

	public static void printSquares(int num) {

		IntStream.iterate(1, x -> {
				x = (int) Math.sqrt(x) + 1;
				return x * x;
			})
			.limit(num)
			.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		printSquares(4);
	}

}
