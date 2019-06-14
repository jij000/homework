package prob6;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {

	public static Set<String> union(List<Set<String>> sets) {
		return sets.stream()
				.flatMap(n -> n.stream())
				.collect(Collectors.toSet());
	}
	
	public static void main(String[] args) {
		List<Set<String>> sets = new ArrayList<Set<String>>();
		sets.add(Stream.of(new String[] {"A", "B"}).collect(Collectors.toSet()));
		sets.add(Stream.of(new String[] {"D"}).collect(Collectors.toSet()));
		sets.add(Stream.of(new String[] {"1", "3", "5"}).collect(Collectors.toSet()));
		union(sets).forEach(System.out::println); 
	}

}
