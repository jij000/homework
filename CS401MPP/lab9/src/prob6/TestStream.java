package prob6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestStream {

	public static Set<String> union(List<Set<String>> sets) {
		return sets.stream()
				.flatMap(n -> n.stream())
				.collect(Collectors.toSet());
	}
	
	public static void main(String[] args) {
		List<Set<String>> sets = new ArrayList<Set<String>>();
		sets.add(new HashSet<String>(Arrays.asList("A", "B")));
		sets.add(new HashSet<String>(Arrays.asList("D")));
		sets.add(new HashSet<String>(Arrays.asList("1", "3", "5")));
		union(sets).forEach(System.out::println); 
	}

}
