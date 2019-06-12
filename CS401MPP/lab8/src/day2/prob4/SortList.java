package day2.prob4;

import java.util.Arrays;
import java.util.stream.Stream;

public class SortList {

	public static void main(String[] args) {
		String[] names = {"Alexis", "Tim", "Kyleen", "KRISTY"};
		Arrays.sort(names, String :: compareToIgnoreCase);
		
		Stream<String> a = Stream.of(names);
		a.forEach(System.out::println);
	}

}
