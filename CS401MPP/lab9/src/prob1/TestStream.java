package prob1;

import java.util.stream.Stream;

public class TestStream {

	public static void main(String[] args) {
		System.out.println(Stream.of(new String[] { "Bill", "Thomas", "Mary" }).reduce((a, b) -> a + ", " + b).get());
	}

}
