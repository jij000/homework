package prob3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestStream {
	public static long countWords(List<String> words, char c, char d, int len) {
		return words.stream()
				.filter(x -> x.contains(String.valueOf(c)))
				.filter(x -> !x.contains(String.valueOf(d)))
				.filter(x -> x.length() == len).count();
	}
	public static void main(String[] args) {
		List<String> words = new ArrayList<String>(Arrays.asList(
				"abce",
				"abcd",
				"abde"
				,"cd"
				,"abec"
				,"abcde"
				,"acd"));
		System.out.println(countWords(words, 'c', 'd', 4));
	}

}
