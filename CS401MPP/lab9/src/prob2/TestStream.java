package prob2;

import java.util.function.Function;
import java.util.stream.IntStream;

public class TestStream {

	private static final Function<int[], IntStream> myIntStream = (a) -> IntStream.of(a);

	public static void main(String[] args) {
		int[] testArray = { 3, 4, 8, 0, 1, 2, 3, 4, 5, 6 };
		System.out.println(myIntStream.apply(testArray).max().getAsInt());
		System.out.println(myIntStream.apply(testArray).min().getAsInt());
	}

}
