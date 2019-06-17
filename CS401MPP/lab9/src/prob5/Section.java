package prob5;

import java.util.Arrays;
import java.util.stream.Stream;

public class Section {
	public static Stream<String> streamSection(Stream<String> stream, int m, int n) {
// Implement the code
		return stream.skip(m).limit(n - m + 1);
	}

	public static void main(String[] args) {
// Make three calls for the streamSection() method with different inputs
// use nextStream() method to supply the Stream input as a first argument in streamSection() method
		streamSection(nextStream(), 0, 999).forEach(System.out::println);
		System.out.println("--------------------");
		streamSection(nextStream(), 1, 3).forEach(System.out::println);
		System.out.println("--------------------");
		streamSection(nextStream(), 5, 5).forEach(System.out::println);
	}

//support method for the main method -- for testing
	private static Stream<String> nextStream() {
		return Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh", "iii").stream();
	}
}
